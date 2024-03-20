package Entity;

public class Circulo extends AArea{
    private Double radio;

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public void Calcular() {
        this.setArea(Math.PI * Math.pow(this.getRadio(), 2));
        System.out.printf("El área del círculo es: %.2f\n", this.getArea());
    }
}
