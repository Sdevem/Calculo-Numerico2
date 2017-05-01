import java.util.Scanner;

public class PolinomioDeTaylorSeno {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		double x = 0;
		double x0 = 0;
		int n = 0;
		int escolha = 0;
		
		do{System.out.println("escolha para utilizar o teorema de taylor \n1- para seno \n2- para cosseno  \n3- pra tangente");
		escolha = leitor.nextInt();}while(escolha < 1 || escolha > 3);
		
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
		switch(escolha){
		case 1:
			System.out.println("resultado estimado" + formulaSeno(x, x0, n, radX0, radX));
			System.out.println("resultado real" + Math.sin(radX));
			System.out.println("erro absoluto: " + Math.abs(Math.sin(radX) - formulaSeno(x, x0, n, radX0, radX)));
			break;
		case 2:
			System.out.println("Resultado estimado: " + formulaCosseno(x, x0, n, radX0, radX));
			System.out.println("Resultado real: " + Math.cos(radX));
			System.out.println("erro absoluto: " + Math.abs(Math.cos(radX) - formulaCosseno(x, x0, n, radX0, radX)));
			break;
		case 3:
			do{System.out.println("digite um numero para a potencia que deseja elevear o polinomio de Taylor de 2 a 4");
			n = leitor.nextInt();}while(n < 2 || n > 4);
			System.out.println("Resultado estimado: " + formulaTang(n,radX, radX0));
			System.out.println("Resultado Real: " + Math.tan(radX));
			System.out.println("erro absoluto: " + Math.abs(Math.tan(radX) - formulaTang(n,radX0, radX)));
			break;
		}
		
		
	}

	public static double formulaSeno(double x, double x0, int n, double radX0, double radX) {
		double[] vetor = new double[n];
		double cos = Math.cos(radX0);
		double sen = Math.sin(radX0);
		double resultado = 0;
		
		for (int i = 0; i < vetor.length; i++) {
			if (i == 0) {
				vetor[i] = sen + cos * (radX - radX0);
			} else if (i % 2 == 1) {
				sen = sen * (-1);
				vetor[i] = (sen * Math.pow((radX - radX0), i+1) / fat(i+1));
			} else {
				cos = cos * (-1);
				vetor[i] = cos * (Math.pow((radX - radX0), i+1) / fat(i+1));
			}
			
			resultado = resultado + (vetor[i]);
		}
		return resultado;
	}
	
	public static double formulaCosseno(double x, double x0, int n, double radX0, double radX) {
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
	
	public static double formulaTang(int n, double radX, double radX0) {
		double formula = 0;
		switch (n) {

		case 2:
			formula = (Math.tan(radX0)) + ((Math.pow(1 / Math.cos(radX0), 2)) * (radX - radX0))
					+ ((2 * Math.tan(radX0) * Math.pow(1 / Math.cos(radX0), 2)) * (Math.pow(radX - radX0, 2) / 2));
			break;
		case 3:
			formula = (Math.tan(radX0)) + ((Math.pow(1 / Math.cos(radX0), 2)) * (radX - radX0))
					+ ((2 * Math.tan(radX0) * Math.pow(1 / Math.cos(radX0), 2)) * (Math.pow(radX - radX0, 2) / 2))
					+ ((2 * Math.pow(1 / Math.cos(radX0), 4) + 4 * Math.pow(Math.tan(radX0), 2) * Math.pow(1 / Math.cos(radX0), 2))
							* (Math.pow(radX - radX0, 3) / 6));
			break;
		case 4:
			formula = (Math.tan(radX0)) + ((Math.pow(1 / Math.cos(radX0), 2)) * (radX - radX0))
					+ ((2 * Math.tan(radX0) * Math.pow(1 / Math.cos(radX0), 2)) * (Math.pow(radX - radX0, 2) / 2))
					+ ((2 * Math.pow(1 / Math.cos(radX0), 4) + 4 * Math.pow(Math.tan(radX0), 2) * Math.pow(1 / Math.cos(radX0), 2))
							* (Math.pow(radX - radX0, 3) / 6))
					- (8 * Math.pow(1 / Math.cos(radX0), 2) * Math.tan(radX0))
					+ ((24 * Math.pow(1 / Math.cos(radX0), 4) * Math.tan(radX0)) * (Math.pow(radX - radX0, 4) / 24));
			break;
		}

		return formula;
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
