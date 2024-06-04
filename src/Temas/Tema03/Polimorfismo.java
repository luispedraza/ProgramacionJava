package Temas.Tema03;

abstract class Forma {
    abstract float getArea();
}

class Cuadrado extends Forma {
    float lado;
    public Cuadrado (float lado) {
        this.lado = lado;
    }

    @Override
    float getArea() {
        return lado * lado;
    }
}

class Triangulo extends Forma {
    float base;
    float altura;
    public Triangulo (float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    float getArea() {
        return base * altura;
    }
}


public class Polimorfismo {
    public static void main(String[] args) {
        Forma figuras[] = new Forma[2];
        figuras [0] = new Triangulo(2, 3);
        figuras [1] = new Cuadrado(5);
        for (int i = 0; i < figuras.length; i++) {
            System.out.println(String.format("Area de la figura %d: %.1f", i, figuras[i].getArea()));
        }
    }
}
