package cdm1.SamuelAlonso;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Esta clase Main sirve para realizar operaciones con matrices.
 * 
 * @author Samuel Alonso
 *
 */

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean salir = false;
		boolean realizado = false;
		
		do {
			
			System.out.println("Selecciona una de las siguientes opciones:");
			System.out.println("1. Suma de dos matrices.");
			System.out.println("2. Producto de un escalar por una matriz.");
			System.out.println("3. Producto de dos matrices.");
			System.out.println("4. Transponer una matriz.");
			System.out.println("5. Diagonal principal de una matriz.");
			System.out.println("6. Comprobar si una matriz es simétrica.");
			System.out.println("7. Potencia de una matriz cuadrada.");
			System.out.println("8. Resta de dos matrices.");
			System.out.println("9. Salir.");
			
			int op = sc.nextInt();
			switch(op) {
				case 1:
					while(!realizado) {
						System.out.println("Crea la primera matriz: ");
						int[][] m1 = crearMatriz();
					
						System.out.println("Crea la segunda matriz: ");
						int[][] m2 = crearMatriz();
						
						//Comprueba que la suma se puede realizar, sino, imprime un mensaje de error.
						if(m1.length == m2.length && m1[0].length == m2[0].length) {
							
							int[][] resultado = suma(m1, m2);
							System.out.println("El resultado de la suma es: ");
							visualizar(resultado);
							realizado = true;
							
						}else {
							System.out.println("Las matrices deben tener el mismo numero de columnas y de filas\n");
						}
					}
					
					realizado = false;
					break;
							
				case 2:
					
					int[][] m3 = crearMatriz();
					
					System.out.println();
					System.out.println("Introduce el numero por el que quieres multiplicar la matriz.");
					//Inicializa n con el numero introducido
					int n = sc.nextInt();
					
					int[][] resultadoEscalar = productoEscalar(m3, n);
					
					System.out.println("El resultado del escalar es: ");
					visualizar(resultadoEscalar);
					
					break;
							
				case 3:
					System.out.println("Crea la primera matriz: ");
					int[][] m4 = crearMatriz();
					
					System.out.println("Crea la segunda matriz: ");
					int[][] m5 = crearMatriz();
					
					//Comprueba que el tamaño de columnas de la primera matriz es igual al tamaño de filas de la segunda matriz.
					if (m4[0].length == m5.length) {
						
						int[][] resultado = productoDosMatrices(m4, m5);
						
						System.out.println("El resultado del producto es: ");
						
						visualizar(resultado);
						
					}else {
						System.out.println("Las columnas de la primera matriz debe tener el mismo tamaño que las filas de la segunda matriz");
					}
					
					break;
							
				case 4:
					int[][] m6 = crearMatriz();
					
					int[][] transpuesta = transponer(m6);
					
					System.out.println("La matriz transpuesta es: ");
					visualizar(transpuesta);
					break;
							
				case 5:
					while(!realizado) {
						int[][] m7 = crearMatriz();
					
						if(esCuadrada(m7)) {
							int[][] diagonalPrincipal = diagonal(m7);
							System.out.println("La diagonal principal de la matriz es: ");
							for(int i = 0; i < diagonalPrincipal.length; i++) {
								System.out.print(diagonalPrincipal[i][i] + " ");
							}
							System.out.println();
							realizado = true;
						}else {
							System.out.println("La matriz introducida debe ser cuadrada.\n");
						}
					}
					
					realizado = false;
					break;
							
				case 6:
					
					while(!realizado) {
						int[][] m8 = crearMatriz();
						
						if(esCuadrada(m8)) {
							if(esSimetrica(m8)) {
								System.out.println("La matriz introducida es simetrica.\n");
							}else {
								System.out.println("La matriz introducida no es simetrica.\n");
							}
							realizado = true;
						}else {
							System.out.println("La matriz introducida debe ser cuadrada.\n");
						}
					}
					realizado = false;
					break;
							
				case 7:
					while(!realizado) {
						System.out.println("Crea la matriz:");
						int[][] m9 = crearMatriz();
						
						if(esCuadrada(m9)) {
							
							System.out.println("Introduce el numero por el que quieres elevar la matriz.");
							int numero = sc.nextInt();
							
							int[][] resultado = potencia(m9, numero);
							
							System.out.println("La matriz elevada a " + numero + " da la siguiente matriz:");
							visualizar(resultado);
							
							realizado = true;
							
						}else {
							System.out.println("La matriz introducida debe ser cuadrada.\n");
						}
					}
					realizado = false;
					break;
							
				case 8:
					while(!realizado) {
						System.out.println("Crea la primera matriz: ");
						int[][] m10 = crearMatriz();
					
						System.out.println("Crea la segunda matriz: ");
						int[][] m11 = crearMatriz();
						
						//Comprueba que la resta se puede realizar, sino, imprime un mensaje de error.
						if(m10.length == m11.length && m10[0].length == m11[0].length) {
							
							int[][] resultado = resta(m10, m11);
							System.out.println("El resultado de la resta es: ");
							System.out.println();
							visualizar(resultado);
							realizado = true;
							
						}else {
							System.out.println("Las matrices deben tener el mismo numero de columnas y de filas\n");
						}
					}
					
					realizado = false;
					break;
							
				case 9:
					salir = true;
					break;
							
				default:
					System.out.println("Selecciona una opción del 1 al 9.");
			}
			
		}while (!salir);
		
	}
	
	/**
	 * Método para crear una matriz.
	 */
	private static int[][] crearMatriz() {
		
		System.out.println("Introduce el número de filas de la matriz");
		int numFil = sc.nextInt();
		
		System.out.println("Introduce el número de columnas de la matriz");
		int numCol = sc.nextInt();
		
		int[][] matriz = new int[numFil][numCol];
		
		System.out.println();
		System.out.println("Introduce los valores: ");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println("Fila " + i + ": ");
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}
		return matriz;
	}
	
	/**
	 * Método para visualizar una matriz.
	 * @param matriz Matriz a mostrar por pantalla.
	 */
	public static void visualizar(int[][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean esCuadrada(int[][] matriz) {
		
		boolean cuadrada = false;
		if(matriz.length == matriz[0].length) {
			cuadrada = true;
		}
		
		return cuadrada;
	}
	
	/**
	 * Método para realizar una suma de matrices.
	 */
	public static int[][] suma(int[][] matriz, int[][] matriz2) {
		
		int[][] resultado = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				resultado[i][j] = matriz[i][j] + matriz2[i][j];
			}
		}
		return resultado;
	}
	
	/**
	 * Método para multiplicar una matriz por un escalar.
	 */
	public static int[][] productoEscalar(int[][] matriz, int n) {
		
		int[][] resultado = new int[matriz.length][matriz[0].length];
		
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				resultado[i][j] = n * matriz[i][j];
			}
		}
		
		return resultado;
	}
	
	/**
	 * Método para realizar un producto de dos matrices.
	 */
	public static int[][] productoDosMatrices(int[][] matriz, int[][] matriz2) {
		
			
			int[][] resultado = new int[matriz.length][matriz2[0].length];
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz2[i].length; j++) {
					for (int k = 0; k < matriz[0].length; k++) {
						resultado[i][j] += matriz[i][k] * matriz2[k][j];
					}
				}
			}
			
		return resultado;
	}
	
	/**
	 * Método para transponer una matriz.
	 */
	public static int[][] transponer(int[][] matriz) {
		
		//Inicializa la matriz resultado
		int[][] resultado = new int[matriz[0].length][matriz.length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				resultado[j][i] = matriz[i][j];
			}
		}
			
		return resultado;
	}
	
	/**
	 * Método para saber la diagonal principal de una matriz.
	 */
	public static int[][] diagonal(int[][] matriz) {
		
		int[][] resultado = new int[matriz.length][matriz[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			resultado[i][i] = matriz[i][i];
		}
		return resultado;
	}
	
	/**
	 * Método para saber si una matriz es simetrica o no.
	 */
	public static boolean esSimetrica(int[][] matriz) {
		
		boolean simetrica = false;
		
		int[][] matriz2 = transponer(matriz);
		
		if(Arrays.deepEquals(matriz, matriz2)) {
			simetrica = true;
		}
		
		return simetrica;
	}
	
	/**
	 * Método para elevar una matriz a una potencia.
	 */
	public static int[][] potencia(int[][] matriz, int n) {
		
		int[][] resultado = matriz;
			
		//Bucle que eleva a n la matriz introducida.
		for(int c = 0; c < n - 1; c++) {
			resultado = productoDosMatrices(resultado, matriz);
		}
		
		return resultado;
	}
	
	/**
	 * Método para realizar una resta de matrices.
	 */
	public static int[][] resta(int[][] matriz, int[][] matriz2) {
		
		int[][] resultado = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				resultado[i][j] = matriz[i][j] - matriz2[i][j];
			}
		}
		return resultado;
	}
}