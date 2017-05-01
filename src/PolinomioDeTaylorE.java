import java.util.Scanner;

public class PolinomioDeTaylorE {
	static Scanner leitor = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Digite o valor de X para o somatorio");
		double x = leitor.nextDouble();
		System.out.println(calcularSomatorio(x));

		System.out.println("Digite o valor de X para o Polinomio");
		x = leitor.nextDouble();
		System.out.println(calcularSomatorio(x));
	}

	private static double calcularSomatorio(double x) {
		double resultado = 0;
		System.out.println("Digite o valor de K: ");
		int k = leitor.nextInt();
		for (int i = 0; i <= k; i++) {
			resultado += Math.pow(x, i) / fat(i);
		}
		return resultado;
	}

	private static double calcularPolinomio(double x) {
		double resultado = 0;
		System.out.println("Digite o valor de K: ");
		int k = leitor.nextInt();
		System.out.println("Digite o valor de X0: ");
		double x0 = leitor.nextDouble();
		for (int i = 0; i <= k; i++) {
			resultado += Math.pow(x - x0, i) / fat(i);
		}
		return resultado;
	}

	public static int fat (int n){
		int resultado = 1;
	for (int i = 0; i <= n; i++) {
		if(i == 0){
			int aux = 1;
		}
		else {
			
			 resultado = resultado*i;
		}
	}
	
	return resultado;
}
}
