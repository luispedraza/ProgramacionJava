package Temas.Tema09Planificacion.AG1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelRowMultiplier {
	public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
		int m = matrix1.length;	// Número de filas de matrix1 y también de result

		ExecutorService executor = Executors.newFixedThreadPool(10);
		// ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < m; i++) {
			RowMultiplierTask task = new RowMultiplierTask(result, matrix1, matrix2, i);
			executor.execute(task);
		}
		executor.shutdown();
		try {
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}