package Temas.Tema09Planificacion.AG1_1;

import java.util.Date;

public class TestMain {
	private static final int SIZE = 1000;
	public static void main(String[] args) {

		double matrix1[][] = MatrixGenerator.generate(SIZE, SIZE);
		double matrix2[][] = MatrixGenerator.generateIdentity(SIZE, SIZE);
		
		
		double result[][] = new double[matrix1.length][matrix2[0].length];
		Date start = new Date();
		SerialMultiplier.multiply(matrix1, matrix2, result); // Multiplicación serie - sin concurrencia
		Date end = new Date();		
		System.out.printf("Algoritmo Serial :%d%n", end.getTime() - start.getTime());
		
		start = new Date();
		ParallelIndividualMultiplier.multiply(matrix1, matrix2, result);// Multiplicación con hilos independientes por cada posición
		end = new Date();
		System.out.printf("Algoritmo ParallelIndividual :%d%n", end.getTime() - start.getTime());
		
		start = new Date();
		ParallelRowMultiplier.multiply(matrix1, matrix2, result);// Multiplicación un hilo por cada fila
		end = new Date();
		System.out.printf("Algoritmo ParallelRow :%d%n", end.getTime() - start.getTime());
	}
}
