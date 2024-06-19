package Temas.Tema03;

class FormaGenerica {
    private double x, y;    // La posición de la forma
    FormaGenerica (double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getArea() {
        return 0;
    }
    public void imprimeArea() {
        System.out.println("Esta forma no tiene área");
    }

    public void imprimePosicion() {
        System.out.println(String.format("La forma está en x = %f, y = %f", x, y));
    }
}

class FormaTriangulo extends FormaGenerica {
    private double base, altura;
    FormaTriangulo(double x, double y, double base, double altura) {
        super(x, y);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return (base * altura) / 2;
    }
    @Override
    public void imprimeArea() {
        System.out.println(String.format("El área de este triángulo es: %f", getArea()));
    }
}
public class Overriding {
    public static void main(String[] args) {
        FormaGenerica forma = new FormaGenerica(3, 4);
        forma.imprimeArea();
        forma.imprimePosicion();
        FormaTriangulo triangulo = new FormaTriangulo(1, 4, 4, 2);
        triangulo.imprimeArea();
        triangulo.imprimePosicion();
    }

}
