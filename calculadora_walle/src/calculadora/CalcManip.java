package calculadora;

import static calculadora.JFrameCalc.jTextFieldVisor1;
import static calculadora.JFrameCalc.jTextFieldVisor2;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class CalcManip extends CalcOpera {

    public enum operacoesCalculadora {

        SOMA,
        SUBTRAI,
        MULTIPLICA,
        DIVIDI,
        RAIZ_QUADRADA,
        MENOS_UNITARIO,
        PORCENTO,
        INVERSO

    }

    private double resultado;
    private operacoesCalculadora operacao;
    private double acumulador;
    private double acumuladorComp; //AUXILIA NA EXIBIÇÂO OU NÃO DE CASAS DECIMAIS
    private Timer tempo; //CONTROLA O TEMPO DA MENSAGEM DE ERRO: "ERRO NA OPERAÇÃO"
    private String historicoVisor2; //ARMAZENA TEMPORARIAMENTE O HISTORICO DA CALCULADORA
    private static boolean estaErro = false;

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getAcumulador() {
        return acumulador;
    }

    public void setAcumulador(double acumulador) {
        this.acumulador = acumulador;
    }

    public double getAcumuladorComp() {
        return acumuladorComp;
    }

    public void setAcumuladorComp(double acumuladorComp) {
        this.acumuladorComp = acumuladorComp;
    }

    public String getOperacao() {
        return operacao.toString();
    }

    public void setOperacao(String caractere) {
        switch (caractere) {
            case "+":
                this.operacao = operacoesCalculadora.SOMA;
                this.setVisor2(this.getVisor2() + "+");
                break;
            case "SOMA":
                this.operacao = operacoesCalculadora.SOMA;
                this.setVisor2(this.getVisor2() + "+");
                break;

            case "-":
                this.operacao = operacoesCalculadora.SUBTRAI;
                this.setVisor2(this.getVisor2() + "-");
                break;
            case "SUBTRAI":
                this.operacao = operacoesCalculadora.SUBTRAI;
                this.setVisor2(this.getVisor2() + "-");
                break;

            case "*":
                this.operacao = operacoesCalculadora.MULTIPLICA;
                this.setVisor2(this.getVisor2() + "*");
                break;
            case "MULTIPLICA":
                this.operacao = operacoesCalculadora.MULTIPLICA;
                this.setVisor2(this.getVisor2() + "*");
                break;

            case "÷":
                this.operacao = operacoesCalculadora.DIVIDI;
                this.setVisor2(this.getVisor2() + "÷");
                break;
            case "DIVIDI":
                this.operacao = operacoesCalculadora.DIVIDI;
                this.setVisor2(this.getVisor2() + "÷");
                break;
            case "√":
                this.operacao = operacoesCalculadora.RAIZ_QUADRADA;
                this.setVisor2("√" + this.getVisor2());
                break;
            case "u":
                this.operacao = operacoesCalculadora.MENOS_UNITARIO;
                break;
            case "%":
                this.operacao = operacoesCalculadora.PORCENTO;
                this.setVisor2(this.getVisor2() + "% de ");
                break;
            case "i":
                this.operacao = operacoesCalculadora.INVERSO;
                break;

        }

    }

    public void setVisor1(String caractere) {
        jTextFieldVisor1.setText(caractere);

    }

    public void setVisor2(String caractere) {
        jTextFieldVisor2.setText(caractere);
    }

    public String getVisor1() {
        return jTextFieldVisor1.getText();
    }

    public String getVisor2() {
        return jTextFieldVisor2.getText();
    }

    public boolean eNumero(String caractere) {
        return "0123456789".indexOf(caractere) != -1;
    }

    public boolean eVirgula(String caractere) {
        return ",.".indexOf(caractere) != -1;
    }

    public boolean eLimparC(String cadeiaCaractere) {
        return cadeiaCaractere.equals("C");
    }

    public boolean eLimparCE(String cadeiaCaractere) {
        return cadeiaCaractere.equals("CE");
    }

    public boolean eIgual(String cadeiaCaractere) {
        return cadeiaCaractere.equals("=");
    }

    public boolean eBKS(String cadeiaCaractere) {
        return cadeiaCaractere.equals("<-");
    }

    public boolean eOperacao(String caractere) {
        return "+-*÷√u%i".indexOf(caractere) != -1;
    }

    public void backSpace() {
        if (!estaErro) {
            if (!this.getVisor1().equals("0")) {
                String textoV1 = this.getVisor1();
                String textoV2 = this.getVisor2();
                int contaVisor1 = textoV1.length();
                int contaVisor2 = textoV2.length();
                String novoTexto = textoV1.substring(0, contaVisor1 - 1);
                String novoTexto2 = textoV2.substring(0, contaVisor2 - 1);
                if (novoTexto.equals("")) {
                    textoV2 = this.getVisor2();
                    contaVisor2 = textoV2.length();
                    setVisor2(novoTexto2);
                    setVisor1("0");
                } else {
                    this.setVisor1(novoTexto);
                    this.setVisor2(novoTexto2);
                }
            }
        }
    }

    public void limparC() {
        if (!estaErro) {
            jTextFieldVisor1.setFont(jTextFieldVisor1.getFont().deriveFont(48f));
            jTextFieldVisor1.setText("0");
            jTextFieldVisor2.setText("");
        }
    }

    public void limparCE() {
        if (!estaErro) {
            jTextFieldVisor1.setFont(jTextFieldVisor1.getFont().deriveFont(48f));
            if (!getVisor2().equals("") && !getVisor1().equals("0")) {
                String textoV1 = this.getVisor1();
                String textoV2 = this.getVisor2();
                int contaVisor1 = textoV1.length();
                int contaVisor2 = textoV2.length();
                String novoTexto2 = textoV2.substring(0, (contaVisor2 - contaVisor1));
                setVisor2(novoTexto2);
            }
            jTextFieldVisor1.setText("0");
        }
    }

    public void calcular() {
        switch (this.operacao) {
            case MULTIPLICA:
                resultado = this.multiplicar(this.getAcumulador(),
                        Double.parseDouble(this.getVisor1()));
                break;
            case SUBTRAI:
                resultado = this.subtrair(this.getAcumulador(),
                        Double.parseDouble(this.getVisor1()));
                break;
            case SOMA:
                resultado = this.somar(this.getAcumulador(),
                        Double.parseDouble(this.getVisor1()));
                break;
            case DIVIDI:
                resultado = this.dividir(this.getAcumulador(),
                        Double.parseDouble(this.getVisor1()));
                break;
            case RAIZ_QUADRADA:
                resultado = this.raizQuadrada(Double.parseDouble(this.getVisor1()));
                break;
            case MENOS_UNITARIO:
                resultado = this.menosUnitario(Double.parseDouble(this.getVisor1()));
                break;
            case PORCENTO:
                resultado = this.porcentagem(this.getAcumulador(),
                        Double.parseDouble(this.getVisor1()));
                break;
            case INVERSO:
                resultado = this.inverso(Double.parseDouble(this.getVisor1()));
                break;
        }
    }

    public void calcular(int x) { //SOBRECARCA PARA OPERAÇÕES AUTOMATICAS DO IGUAL
        switch (this.operacao) {
            case MULTIPLICA:
                resultado = this.multiplicar(
                        Double.parseDouble(this.getVisor1()), this.getAcumulador());
                break;
            case SUBTRAI:
                resultado = this.subtrair(
                        Double.parseDouble(this.getVisor1()), this.getAcumulador());
                break;
            case SOMA:
                resultado = this.somar(this.getAcumulador(),
                        Double.parseDouble(this.getVisor1()));
                break;
            case DIVIDI:
                resultado = this.dividir(
                        Double.parseDouble(this.getVisor1()), this.getAcumulador());
                break;
        }
    }

    public void resultVisor() {

        this.setAcumulador(this.getResultado());
        //MOSTRANDO O RESULTADO NO VISOR 1
        this.setAcumuladorComp((int) this.getAcumulador());
        if ((this.getAcumulador() - this.getAcumuladorComp()) != 0) {
            this.setVisor1(Double.toString(this.getAcumulador()));

        } else {
            this.setVisor1(Integer.toString((int) this.getAcumuladorComp()));
        }

    }

    public void resultVisor2(double x) {

        if (x - (int) x != 0) {
            this.setVisor2(this.getVisor2() + x);

        } else {
            this.setVisor2(this.getVisor2() + (int) x);
        }

    }

    //FAZ COM QUE SEJA ESPERADO UM TEMPO ANTES DA EXECUÇÃO DO PROGRAMA
    class RemindTask extends TimerTask { //CLASSE INTERNA

        public void run() {
            jTextFieldVisor2.setBackground(Color.black);
            jTextFieldVisor2.setFont(jTextFieldVisor2.getFont().deriveFont(36f));
            setVisor2(historicoVisor2);
            tempo.cancel();
            estaErro = false;
            System.out.println("SAIU DO ERRO");

        }
    }

    public void erro(String erro) {
        tempo = new Timer();
        tempo.schedule(new RemindTask(), 1000);
        if (!getVisor2().equals(erro)) {
            historicoVisor2 = getVisor2();
        }
        jTextFieldVisor2.setBackground(new java.awt.Color(255, 255, 0));
        //ALTERA O TAMANHO DA FONTE DO JTEXFIELD VISOR 2
        jTextFieldVisor2.setFont(jTextFieldVisor2.getFont().deriveFont(25f));
        setVisor2(erro);
        estaErro = true;
        System.out.println("ENTROU EM ERRO");

    }
}
