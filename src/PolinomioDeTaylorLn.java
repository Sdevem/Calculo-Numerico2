import java.util.Scanner;

public class PolinomioDeTaylorLn {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int x, x0, grau;

		System.out.println("Digite o valor de X: ");
		x = leitor.nextInt();
		System.out.println("Digite o valor de X0: ");
		x0 = leitor.nextInt();
		System.out.println("Digite o valor do grau ");
		grau = leitor.nextInt();

		int multiplicarFuncao = 1;
		double polinomioT = Math.log(x0);

		for (int i = 0; i < grau; i++) {
			if (i != 0)
				multiplicarFuncao *= i;
			polinomioT += (multiplicarFuncao * Math.pow(x0, -i - 1) * Math.pow(x - x0, i + 1)/fat(i + 1));
		}

		System.out.println("Resultado estimado: " + polinomioT);
		System.out.println("Resultado Real: " + Math.log(x));
		System.out.println("erro absoluto: " + Math.abs(Math.pow(Math.E, x) - polinomioT));
	}

	public static int fat(int n) {
		int resultado = 1;
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				int aux = 1;
			} else {

				resultado = resultado * i;
			}
		}

		return resultado;
	}
}
