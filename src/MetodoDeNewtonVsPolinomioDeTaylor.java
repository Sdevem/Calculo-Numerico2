import java.util.Scanner;

public class MetodoDeNewtonVsPolinomioDeTaylor {

	public static double primeiraDerivada(double x) {
		return 1 / 2 * Math.pow(x, 1 / 2 - 1);
	}

	public static double primeiraDerivadaNM(double x) {
		return 2 * x;
	}

	public static double segundaDerivada(double x) {
		return -1 / 4*Math.pow(x, 3/2);
	}

	public static double terceiraDerivada(double x) {
		return 3/8*Math.pow(x,5/2);
	}

	public static double quartaDerivada(double x) {
		
		return -15/16*Math.pow(x, 7/2);
		
	}

	public static double quintaDerivada(double x) {
		return 105/32*Math.pow(x, 9/2);
	}

	public static double formulaOriginal(double x) {
		return Math.pow(x, 2) + 80;
	}

	public static double MetodoDeNewton(double x) {
		int contador = 0;
		double novaImagem = x;
		double novoIntervalo = 0;
		while (contador != 5) {
			novoIntervalo = (formulaOriginal(novaImagem) / primeiraDerivadaNM(novaImagem));
			System.out.println("original: " + formulaOriginal(novaImagem));
			System.out.println("derivada: " + primeiraDerivadaNM(novaImagem));
			System.out.println("novo intervalo: " + novoIntervalo);
			System.out.println("\nNovo Intervalo: " + novoIntervalo);
			System.out.println("Função Original: " + formulaOriginal(novoIntervalo));
			System.out.println("1ª Derivada: " + primeiraDerivadaNM(novoIntervalo));
			novaImagem = novoIntervalo;
			contador++;
		}

		return novoIntervalo;

	}

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		double x0 = 81;

		System.out.println("escolha o x para o polinomio de Taylor:");
		
		double x = leitor.nextDouble();

		double x0MN = 9;

		System.out.println("o resultado do polinomio de Taylor é:");
		System.out.println(Math.pow(x0, 1 / 2) + (primeiraDerivada(x) * x - x0) + (segundaDerivada(x) * Math.pow((x - x0),2)/2)
				+ (terceiraDerivada(x) * Math.pow((x - x0),3)/6) + (quartaDerivada(x) * Math.pow((x - x0),4)/24) + (quintaDerivada(x) * Math.pow((x - x0),5)/120));
		System.out.println("PARTE 1: " + Math.pow(81, 1/2.0));
		System.out.println("PARTE 2: " + (primeiraDerivada(x0) * (x - x0)));
		System.out.println("PARTE 3: " +  (segundaDerivada(x0) * Math.pow((x - x0),2)/2));
		System.out.println("PARTE 4: " + (terceiraDerivada(x0) * Math.pow((x - x0),3)/6));
		System.out.println("PARTE 5: " + (quartaDerivada(x0) * Math.pow((x - x0),4)/24));
		System.out.println("PARTE 6: " + (quintaDerivada(x0) * Math.pow((x - x0),5)/120));
		
		
		System.out.println("o resultado do Metodo de Newton é:");
		System.out.println(MetodoDeNewton(x0MN));

	}

}
