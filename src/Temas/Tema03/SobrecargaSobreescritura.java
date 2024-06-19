package Temas.Tema03;

/**
 * Ejemplo de sobrecarga de métodos, sobreescritura de métodos de la misma clase
 * OVERLOADING
 */

class Calculadora {
    public int sumar (int a, int b) {
        return a+b;
    }
    public int sumar (int a, int b, int c) {
        return a + b + c;
    }

    public float sumar (float a, float b) {
        return a + b;
    }
}

/**
 * La clase CalculadoraMensajes sobreescribe y también sobrecarga métodos:
 */
class CalculadoraMensajes extends Calculadora {
    @Override
    public float sumar(float a, float b) {
        // Sobreescribimos el método: float sumar (float a, float b).
        float resultado = super.sumar(a, b); // Podemos llamar al método en la clase padre
        System.out.println(String.format("%f + %f = %f", a, b, resultado));
        return resultado;
    }

    public float sumar(float a, float b, float c) {
        float resultado = a + b + c; // Podemos llamar al método en la clase padre
        System.out.println(String.format("%f + %f + %f = %f", a, b, c, resultado));
        return resultado;
    }
}
public class SobrecargaSobreescritura {
    /**
     * La clase Calculadora1 tiene el método "sumar" sobrecargado.
     * El método tiene 3 formas diferentes
     */


    public static void main(String[] args) {
        CalculadoraMensajes calc = new CalculadoraMensajes();
        calc.sumar(6.2f, 9.7f);
        calc.sumar(1.5f, 3.2f, 4.8f);
    }
}
