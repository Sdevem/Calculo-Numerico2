import java.util.Scanner;

public class PolinomioDeTaylorEuler {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int  x0, grau;
		double x;
		System.out.println("Digite o valor de X: ");
		x = leitor.nextDouble();
		System.out.println("Digite o valor de X0: ");
		x0 = leitor.nextInt();
	do{
		System.out.println("Digite o valor do grau ");
		grau = leitor.nextInt();
	}while(grau< 0 || grau > 10);
		double polinomioT = Math.log(x0);

		for (int i = 0; i < grau; i++) {
			if (i != 0)
			polinomioT += (Math.pow(Math.E, x0) * Math.pow(x - x0, i)/fat(i));
		}

		System.out.println("Resultado estimado: " + polinomioT);
		System.out.println("Resultado Real: " + Math.pow(Math.E, x));
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
