/**
 * https://www.w3resource.com/java-exercises/exception/java-exception-exercise-1.php
 * Escribe un programa en java que contenga un método que divida dos números enteros
 * y lance una excepción si el denominador es cero
 */
package Temas.Tema04Excepciones;

public class E01TryCatch {

    public static void main(String[] args) {
        try {
            int result = dividirNumeros(5, 0);
            System.out.println("Resultado: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int dividirNumeros(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir un numero entre 0!");
        }
        return dividend / divisor;
    }
}
