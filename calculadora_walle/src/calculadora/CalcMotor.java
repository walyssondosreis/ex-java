package calculadora;

import static calculadora.JFrameCalc.jLabelLog1;
import static calculadora.JFrameCalc.jLabelLog2;
import java.text.DecimalFormat;

public class CalcMotor {

    private enum estadosDaCalculadora {

        INICIANDO,
        PRIMEIRA_DIGITACAO,
        EM_OPERACAO,
        NOVA_DIGITACAO,
        TOTALIZANDO,
        CONGELADO

    }

    private estadosDaCalculadora estado = estadosDaCalculadora.INICIANDO;
    private final CalcManip manipCalc = new CalcManip();
    private final CalcDisplay displayCalc = new CalcDisplay();
    private final String msgErro = "ERRO NA OPERACAO :x      ";
    private final String msgErro2 = "valor maximo atingido!      ";
    private int flag = 0;
    private int flagCongela = 0;
    private double operaTemp;

    public void operarConformeEstado(String caractereDigitado) {

        jLabelLog1.setForeground(new java.awt.Color(120, 120, 120));
        jLabelLog1.setText("  WALLE CALC");
        jLabelLog2.setText("by WALYSSON DOS REIS ");

//////////////////////////////////////////////////////////////////////////////// INICIANDO...         
        if (this.estado == estadosDaCalculadora.INICIANDO) {

            manipCalc.limparC();

            if (manipCalc.eNumero(caractereDigitado)) {
              //  if (caractereDigitado.equals("0")) {
              //      manipCalc.setVisor1("0");
            //    } else {
                    manipCalc.setVisor1(caractereDigitado);
                    manipCalc.setVisor2(manipCalc.getVisor2() + caractereDigitado);
                    displayCalc.alternarFonte();
                    this.estado = estadosDaCalculadora.PRIMEIRA_DIGITACAO;
             //   }
            } else if (manipCalc.eVirgula(caractereDigitado)) {
                manipCalc.setVisor1("0.");
                manipCalc.setVisor2(manipCalc.getVisor2() + "0.");
                this.estado = estadosDaCalculadora.PRIMEIRA_DIGITACAO;
            } else if (manipCalc.eOperacao(caractereDigitado) && !caractereDigitado.equals("u")) {
                if (caractereDigitado.equals("√")) {
                    manipCalc.setVisor2("√(0)");
                } else {
                    manipCalc.setAcumulador(0);
                    manipCalc.setVisor2("0");
                    manipCalc.setOperacao(caractereDigitado);
                    this.estado = estadosDaCalculadora.EM_OPERACAO;
                }

            } else if (manipCalc.eLimparC(caractereDigitado)) {
                manipCalc.limparC();
            } else if (manipCalc.eLimparCE(caractereDigitado)) {
                manipCalc.limparCE();
            } else if (manipCalc.eIgual(caractereDigitado)) {
                estado = estadosDaCalculadora.INICIANDO;
            } else {
                manipCalc.erro(msgErro);
            }
//////////////////////////////////////////////////////////////////////////////// EM OPERAÇÃO...
        } else if (this.estado == estadosDaCalculadora.EM_OPERACAO) {
            JFrameCalc.jTextFieldVisor1.setFont(JFrameCalc.jTextFieldVisor1.getFont().deriveFont(48f));

            if (manipCalc.eNumero(caractereDigitado)) {

                manipCalc.setVisor1(caractereDigitado);
                manipCalc.setVisor2(manipCalc.getVisor2() + caractereDigitado);
                this.estado = estadosDaCalculadora.NOVA_DIGITACAO;

            } else if (manipCalc.eVirgula(caractereDigitado)) {
                manipCalc.setVisor1("0.");
                manipCalc.setVisor2(manipCalc.getVisor2() + "0.");
                this.estado = estadosDaCalculadora.NOVA_DIGITACAO;

            } else if (manipCalc.eLimparC(caractereDigitado)) {
                manipCalc.limparC();
                manipCalc.setAcumulador(0);
                this.estado = estadosDaCalculadora.INICIANDO;
            } else if (manipCalc.eLimparCE(caractereDigitado)) {
                manipCalc.limparCE();
            } else {
                manipCalc.erro(msgErro);
            }
//////////////////////////////////////////////////////////////////////////////// TOTALIZANDO...
        } else if (this.estado == estadosDaCalculadora.TOTALIZANDO) {

            if (manipCalc.eOperacao(caractereDigitado)) {
                manipCalc.setOperacao(caractereDigitado);
                if (caractereDigitado.equals("√")) {
                    manipCalc.setVisor2(manipCalc.getVisor1());
                    if (manipCalc.getVisor1().indexOf("-") != -1) {
                        manipCalc.erro("WoW Num(-) :/   ");
                    } else {
                        manipCalc.setVisor2("√(" + manipCalc.getVisor1() + ")");
                        manipCalc.resultVisor();
                        displayCalc.alternarFonte();
                        if (!displayCalc.verificarDisplay()) {
                            manipCalc.erro(msgErro2);

                            estado = estadosDaCalculadora.INICIANDO;
                        } else {
                            estado = estadosDaCalculadora.TOTALIZANDO;
                        }
                    }
                } else if (caractereDigitado.equals("u") || caractereDigitado.equals("i")) {
                    if (caractereDigitado.equals("i")) {
                        manipCalc.setVisor2("(1/" + manipCalc.getVisor1() + ")");
                    }
                    manipCalc.calcular();
                    manipCalc.resultVisor();
                    displayCalc.alternarFonte(0);
                    if (!displayCalc.verificarDisplay()) {
                        manipCalc.erro(msgErro2);
                        estado = estadosDaCalculadora.CONGELADO;
                    } else {
                        estado = estadosDaCalculadora.TOTALIZANDO;
                    }
                } else {
                    if (caractereDigitado.equals("%")) {
                        manipCalc.setVisor2(manipCalc.getVisor1() + "% de ");
                    } else {
                        manipCalc.setVisor2(manipCalc.getVisor1() + caractereDigitado);
                    }
                    estado = estadosDaCalculadora.EM_OPERACAO;
                }
            } else if (manipCalc.eNumero(caractereDigitado)) {
                manipCalc.setVisor1(caractereDigitado);
                manipCalc.setVisor2(caractereDigitado);
                this.estado = estadosDaCalculadora.PRIMEIRA_DIGITACAO;
            } else if (manipCalc.eVirgula(caractereDigitado)) {
                manipCalc.setVisor1("0.");
                manipCalc.setVisor2("0.");
                this.estado = estadosDaCalculadora.PRIMEIRA_DIGITACAO;

            } else if (manipCalc.eLimparC(caractereDigitado)) {
                manipCalc.limparC();
                manipCalc.setAcumulador(0);
                this.estado = estadosDaCalculadora.INICIANDO;

            } else if (manipCalc.eIgual(caractereDigitado)) {

                if (!manipCalc.getOperacao().equals("RAIZQUADRADA") && !manipCalc.getOperacao().equals("MENOS_UNITARIO") && !manipCalc.getOperacao().equals("PORCENTO")) {
                    manipCalc.setVisor2("(" + manipCalc.getVisor1());
                    manipCalc.setOperacao(manipCalc.getOperacao());
                    manipCalc.resultVisor2(operaTemp);
                    manipCalc.setVisor2(manipCalc.getVisor2() + ")");

                    manipCalc.setAcumulador(operaTemp);
                    manipCalc.calcular(0);
                    manipCalc.resultVisor();
                    displayCalc.alternarFonte(0);
                    if (!displayCalc.verificarDisplay()) {
                        manipCalc.erro(msgErro2);
                        estado = estadosDaCalculadora.CONGELADO;
                    } else {
                        this.estado = estadosDaCalculadora.TOTALIZANDO;
                    }
                }
            } else {
                manipCalc.erro(msgErro);
            }
//////////////////////////////////////////////////////////////////////////////// NOVA DIGITAÇÃO...
        } else if (this.estado == estadosDaCalculadora.NOVA_DIGITACAO) {

            if (manipCalc.eNumero(caractereDigitado)) {
                if (manipCalc.getVisor1().equals("0")) {
                    manipCalc.setVisor1(caractereDigitado);
                    manipCalc.setVisor2(manipCalc.getVisor2() + caractereDigitado);

                } else if (displayCalc.verificarDisplay()) {
                    displayCalc.alternarFonte();
                    manipCalc.setVisor1(manipCalc.getVisor1() + caractereDigitado);
                    manipCalc.setVisor2(manipCalc.getVisor2() + caractereDigitado);
                } else {
                    manipCalc.erro(msgErro2);
                }

            } else if (manipCalc.eVirgula(caractereDigitado)) {
                if (manipCalc.getVisor1().indexOf(".") != -1) {
                    manipCalc.erro(msgErro);
                } else {
                    manipCalc.setVisor1(manipCalc.getVisor1() + ".");
                    manipCalc.setVisor2(manipCalc.getVisor2() + ".");
                }

            } else if (caractereDigitado.equals("u")) {
                if (manipCalc.getVisor1().indexOf("-") != -1) {
                    manipCalc.setVisor2(manipCalc.getVisor2().substring(0, manipCalc.getVisor2().length() - manipCalc.getVisor1().length() - 2));
                    manipCalc.setVisor1(manipCalc.getVisor1().substring(1, manipCalc.getVisor1().length()));
                    manipCalc.setVisor2(manipCalc.getVisor2() + "(+" + manipCalc.getVisor1() + ")");
                    flag = 1;
                } else if (flag == 1) {

                    manipCalc.setVisor2(manipCalc.getVisor2().substring(0, manipCalc.getVisor2().length() - manipCalc.getVisor1().length() - 3));
                    manipCalc.setVisor1("-" + manipCalc.getVisor1());
                    manipCalc.setVisor2(manipCalc.getVisor2() + "(" + manipCalc.getVisor1() + ")");

                } else {
                    manipCalc.setVisor2(manipCalc.getVisor2().substring(0, manipCalc.getVisor2().length() - manipCalc.getVisor1().length()));
                    manipCalc.setVisor1("-" + manipCalc.getVisor1());
                    manipCalc.setVisor2(manipCalc.getVisor2() + "(" + manipCalc.getVisor1() + ")");
                }
                estado = estadosDaCalculadora.NOVA_DIGITACAO;
            } else if (manipCalc.eLimparC(caractereDigitado)) {
                manipCalc.limparC();
                manipCalc.setAcumulador(0);
                this.estado = estadosDaCalculadora.INICIANDO;
            } else if (manipCalc.eLimparCE(caractereDigitado)) {
                manipCalc.limparCE();
            } else if (manipCalc.eBKS(caractereDigitado)) {

                manipCalc.backSpace();
                displayCalc.alternarFonte();
            } else if ((manipCalc.eIgual(caractereDigitado)) || (manipCalc.eOperacao(caractereDigitado)) && !caractereDigitado.equals("u")) {
                operaTemp = Double.parseDouble(manipCalc.getVisor1());
                flag = 0;
                manipCalc.calcular();
                manipCalc.resultVisor();
                displayCalc.alternarFonte(0);
                if (!displayCalc.verificarDisplay()) {
                    manipCalc.erro(msgErro2);
                    estado = estadosDaCalculadora.CONGELADO;
                } else if (manipCalc.eIgual(caractereDigitado)) {
                    manipCalc.setVisor2("( " + manipCalc.getVisor2() + " )");
                    this.estado = estadosDaCalculadora.TOTALIZANDO;
                } else {
                    manipCalc.setVisor2("( " + manipCalc.getVisor2() + " )");
                    manipCalc.setOperacao(caractereDigitado);
                    this.estado = estadosDaCalculadora.EM_OPERACAO;
                }

            } else {
                manipCalc.erro(msgErro);
            }
//////////////////////////////////////////////////////////////////////////////// PRIMEIRA DIGITAÇÃO...
        } else if (this.estado == estadosDaCalculadora.PRIMEIRA_DIGITACAO) {

            if (manipCalc.eNumero(caractereDigitado)) {

                if (manipCalc.getVisor1().equals("0")) {
                    manipCalc.setVisor1(caractereDigitado);
                    manipCalc.setVisor2(manipCalc.getVisor2() + caractereDigitado);

                } else if (displayCalc.verificarDisplay()) {
                    displayCalc.alternarFonte();
                    manipCalc.setVisor1(manipCalc.getVisor1() + caractereDigitado);
                    manipCalc.setVisor2(manipCalc.getVisor2() + caractereDigitado);
                } else {
                    manipCalc.erro(msgErro2);
                }

            } else if (manipCalc.eVirgula(caractereDigitado)) {
                if (manipCalc.getVisor1().indexOf(".") != -1) {
                    manipCalc.erro(msgErro);
                } else {
                    manipCalc.setVisor1(manipCalc.getVisor1() + ".");
                    manipCalc.setVisor2(manipCalc.getVisor2() + ".");
                }
            } else if (manipCalc.eLimparC(caractereDigitado)) {
                manipCalc.limparC();
                this.estado = estadosDaCalculadora.INICIANDO;
            } else if (manipCalc.eLimparCE(caractereDigitado)) {
                manipCalc.limparCE();
            } else if (manipCalc.eBKS(caractereDigitado)) {
                manipCalc.backSpace();
                displayCalc.alternarFonte();

            } else if (manipCalc.eOperacao(caractereDigitado)) {

                manipCalc.setOperacao(caractereDigitado);

                if (caractereDigitado.equals("√")) {

                    manipCalc.setVisor2(manipCalc.getVisor1());
                    if (manipCalc.getVisor1().indexOf("-") != -1) {
                        manipCalc.erro("WoW Num(-) :/   ");
                    } else {
                        manipCalc.setVisor2("√(" + manipCalc.getVisor1() + ")");
                        manipCalc.calcular();
                        manipCalc.resultVisor();
                        displayCalc.alternarFonte(0);
                        if (!displayCalc.verificarDisplay()) {
                            manipCalc.erro(msgErro2);

                            estado = estadosDaCalculadora.CONGELADO;
                        } else {
                            estado = estadosDaCalculadora.TOTALIZANDO;
                        }
                    }
                } else if (caractereDigitado.equals("u") || caractereDigitado.equals("i")) {
                    if (caractereDigitado.equals("i")) {
                        manipCalc.setVisor2("(1/" + manipCalc.getVisor1() + ")");
                    }
                    manipCalc.calcular();
                    manipCalc.resultVisor();
                    displayCalc.alternarFonte(0);
                    if (!displayCalc.verificarDisplay()) {
                        manipCalc.erro(msgErro2);

                        estado = estadosDaCalculadora.CONGELADO;
                    } else {
                        estado = estadosDaCalculadora.TOTALIZANDO;
                    }
                } else {

                    manipCalc.setAcumulador(Double.parseDouble(manipCalc.getVisor1()));
                    this.estado = estadosDaCalculadora.EM_OPERACAO;

                }
            } else {
                manipCalc.erro(msgErro);
            }
//////////////////////////////////////////////////////////////////////////////// CONGELADO            
        } else if (this.estado == estadosDaCalculadora.CONGELADO) {
           
            flagCongela++;
            if (flagCongela == 1) {
               // manipCalc.setVisor2("");
                manipCalc.erro("  ---REINICIANDO---     ");
                flagCongela++;
            }
            if (flagCongela == 2) {
                estado = estadosDaCalculadora.INICIANDO;
                flagCongela = 0;
            }
        
           

        }
////////////////////////////////////////////////////////////////////////////////
    }

}
