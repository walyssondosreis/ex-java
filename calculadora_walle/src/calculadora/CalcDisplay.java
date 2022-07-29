package calculadora;

import static calculadora.JFrameCalc.jTextFieldVisor1;

public class CalcDisplay extends CalcManip {

    private static final int DIGITOS_CALCULADORA = 16; // VALOR ORIGINAL 16

    public void alternarFonte() {

        
        if (getVisor1().length() >= 14) { //VALOR ORIGINAL 14
            jTextFieldVisor1.setFont(jTextFieldVisor1.getFont().deriveFont(40f));
        } else {
            jTextFieldVisor1.setFont(jTextFieldVisor1.getFont().deriveFont(48f));
        }
    }
     public void alternarFonte(int x) {

        System.out.println(getVisor1());
        if (getVisor1().length() >= 15) { //VALOR ORIGINAL 14
            jTextFieldVisor1.setFont(jTextFieldVisor1.getFont().deriveFont(34f));
        } else {
            jTextFieldVisor1.setFont(jTextFieldVisor1.getFont().deriveFont(48f));
        }
    }
    public boolean verificarDisplay() {
        if (getVisor1().length() < DIGITOS_CALCULADORA)  return true;
        else  return false;
        
    }

}
