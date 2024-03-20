package Entity;

public class Cuadrado extends AArea {
    private Double lado;

    public Double getLado(){
        return this.lado;
    }

    public void setLado(Double lado){
        this.lado = lado;
    }

    @Override
    public void Calcular() {
        this.setArea(this.getLado() * this.getLado());
        System.out.printf("El área del cuadrado es: %.2f\n", this.getArea());
    }

}
