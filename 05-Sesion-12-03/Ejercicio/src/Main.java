import Entity.AArea;
import Entity.Circulo;
import Entity.Cuadrado;
import Entity.Trapecio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /*
        Cuadrado cuadrado = new Cuadrado();
        cuadrado.setLado(5.0);
        cuadrado.Calcular();
        */

        Circulo circulo = new Circulo();
        circulo.setRadio(5.0);
        circulo.Calcular();

        Trapecio trapecio = new Trapecio();
        trapecio.Calcular();
    }
}