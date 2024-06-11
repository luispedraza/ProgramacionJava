package Temas.Tema09Planificacion.AG1_1;

import java.util.Random;


/**
 * Esta clase se encarga de generar matrices con valores aleatorios
 * de un tamaño dado:
 * rows: número de filas
 * columns: número de columnas
 */
public class MatrixGenerator {
	public static double[][] generate(int rows, int columns) {
		double[][] ret = new double[rows][columns];
		Random random = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				ret[i][j] = random.nextDouble() * 10;
			}
		}
		return ret;
	}
	public static double[][] generateIdentity(int rows, int columns) {
		double[][] ret = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				ret[i][j] = (i==j) ? 1 : 0;
			}
		}
		return ret;
	}
}