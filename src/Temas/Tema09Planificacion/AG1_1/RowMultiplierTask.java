package Temas.Tema09Planificacion.AG1_1;

public class RowMultiplierTask implements Runnable {
	private final double[][] result;
	private final double[][] matrix1;
	private final double[][] matrix2;
	private final int row;
	private final int n;	// Número de columnas de matrix1 y también filas de matrix2
	private final int p; 	// Número de columnas de matrix2

	public RowMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int i) {
		this.result = result;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.row = i;
		this.n = matrix1[row].length;
		this.p = matrix2[0].length;
	}

	public void run() {
		for (int j = 0; j < p; j++) {
			// para cada elemento de la fila...
			result[row][j] = 0;
			for (int k = 0; k < n; k++) {
				result[row][j] += matrix1[row][k] * matrix2[k][j];
			}
		}
	}
}
