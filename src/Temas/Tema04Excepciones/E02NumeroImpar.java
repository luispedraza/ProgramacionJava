/**
 * https://www.w3resource.com/java-exercises/exception/java-exception-exercise-1.php
 * Escribe un programa en java que contenga un método que tome un parámetro entero
 * y lance una excepción si el número es impar
 */
package Temas.Tema04Excepciones;

public class E02NumeroImpar {
    public static void main(String[] args) {
        int n = 7;
        try {
            comprobarNumero(n);
            System.out.println(n + " es par.");
        } catch (
                IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void comprobarNumero(int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException(n + " es impar.");
        }
    }
}
