package Temas.Tema01.cuaderno01;


class Circle {
    // atributos de clase
    private double radius;
    private String color;

    /**
     * Construye una instancia círculo con los valores de color y radio por defecto
     */
    public Circle() { // constructor por defecto
        radius = 1.0;
        color = "red";
    }

    /**
     * Construye una instancia círculo con el valor de radio dado por parámetro
     */
    public Circle(double r) { // constructor
        radius = r;
        color = "red";
    }

    /**
     * Devuelve el valor de radio
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Devuelve el valor del área
     */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // 3. Sobrecargar el constructor para que admita como parámetro radio y color
    public Circle(double r, String c) {
        radius = r;
        color = c;
    }

    // 4. Añadir un método para que sea posible obtener el color de un círculo.
    public String getColor() {
        return color;
    }
}

public class Ejercicio07 {


    public static void main(String[] args) {
        // 1. Crear un círculo de radio 5
        Circle circleR5 = new Circle(5);
        // 2. Obtener el área del círculo anterior e imprimirla por pantalla
        System.out.println(circleR5.getArea());
        // 3 y 4: comprobación:
        Circle circle2 = new Circle(5, "green");
        System.out.println(circle2.getColor());

    }
}
