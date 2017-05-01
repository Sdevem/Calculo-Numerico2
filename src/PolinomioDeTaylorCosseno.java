import java.util.Scanner;

public class PolinomioDeTaylorCosseno {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		double x = 0;
		double x0 = 0;
		int n = 0;

		do {
			System.out.println("digite um numero entre 0 e 90 para graus");
			x = leitor.nextInt();
		} while (x < 0 && x > 90);

		System.out.println("digite um numero para a potencia que deseja elevear o polinomio de Taylor");
		n = leitor.nextInt();

		if (x <= 37 && x >= 0) {
			x0 = 30;
		} else if (x <= 52) {
			x0 = 45;
		} else if (x <= 75) {
			x0 = 60;
		} else {
			x0 = 90;
		}
		double radX0 = Math.toRadians(x0);
		double radX = Math.toRadians(x);

		System.out.println("Resultado estimado: " + formula(x, x0, n, radX0, radX));
		System.out.println("Resultado real: " + Math.cos(radX));
		System.out.println("erro absoluto: " + Math.abs(Math.sin(radX) - formula(x, x0, n, radX0, radX)));
	}

	public static double formula(double x, double x0, int n, double radX0, double radX) {
		double[] vetor = new double[n];
		double cos = Math.cos(radX0);
		double sen = Math.sin(radX0);
		double resultado = 0;

		for (int i = 0; i < vetor.length; i++) {
			if (i == 0) {
				vetor[i] = cos - sen * (radX - radX0);
			} else if (i % 2 == 1) {
				cos = cos * (-1);
				vetor[i] = cos * (Math.pow((radX - radX0), i+1) / fat(i+1));
			} else {
				sen = sen * (-1);
				vetor[i] = sen * (Math.pow((radX - radX0), i+1) / fat(i+1));
			}
			resultado = resultado + (vetor[i]);
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
