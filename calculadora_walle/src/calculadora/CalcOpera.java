
package calculadora;

public class CalcOpera {

    public double somar(double a, double b) {
        return  (a + b);
    }

    public double multiplicar(double a, double b) {
        return (a * b);
    }
    
    public double dividir(double a, double b) {
        return (a / b);
    }

    public double subtrair(double a, double b) {
        return (a - b);
    }
    public double raizQuadrada(double a){
        return Math.sqrt(a);
    }
    public double menosUnitario(double a){
        return a*(-1);
    }
    public double porcentagem(double a, double b){
        return (a/100)*b;
    }
    public double inverso(double a){
        return (1/a);
    }
            
}
