package Temas.Tema09Planificacion.AG1_1;

public class SerialMultiplier {
	public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
		int m = matrix1.length;
		int n = matrix1[0].length;
		int p = matrix2[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				result[i][j] = 0;
				for (int k = 0; k < n; k++) {
					result[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}
	}
}
