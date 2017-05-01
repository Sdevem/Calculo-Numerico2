import java.util.Scanner;

public class MetodoDeNewton {

	public static double primeiraDerivada(double x) {
		double resultado = Math.pow(Math.E, x) - 12 * Math.pow(x, 2);
		return resultado;
	}

	public static double segundaDerivada(double x) {
		double resultado = Math.pow(Math.E, x) - 24 * x;
		return resultado;
	}
	
	public static double formulaOriginal(double x){
	return 	Math.pow(Math.E, x) - (4 * Math.pow(x, 3));
	}
	
	
	public static double melhorX(double a, double b) {

		if (Math.pow(a, 1 / 2) * segundaDerivada(a) > 0 && Math.pow(a, 1 / 2) * segundaDerivada(a) > 0) {
			double x1 = a - Math.pow(a, 1 / 2) + primeiraDerivada(a);
			double x2 = b - Math.pow(b, 1 / 2) + primeiraDerivada(b);

			if (x1 > a && x1 < b)
				return a;
			else
				return b;
		}

		else if (Math.pow(a, 1 / 2) * segundaDerivada(a) > 0)
			return a;

		else
			return b;

	}

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		double erro = 0.01;

		System.out.println("escolha o a para o Metodo de Newton:");
		double a = leitor.nextDouble();

		System.out.println("escolha o b para o Metodo de Newton:");
		double b = leitor.nextDouble();

		double novaImagem = melhorX(a, b);
		System.out.println(novaImagem);
		
		double novoIntervalo;
		
	do{
		novoIntervalo = novaImagem - formulaOriginal(novaImagem)/primeiraDerivada(novaImagem);
		System.out.println("novo intervalo: " + novoIntervalo);
		System.out.println("\nNovo Intervalo: " + novoIntervalo);
		System.out.println("Função Original: " + formulaOriginal(novoIntervalo));
		System.out.println("1ª Derivada: " + primeiraDerivada(novoIntervalo));
		novaImagem = novoIntervalo;
		
	}while(formulaOriginal(novaImagem)/primeiraDerivada(novaImagem) > erro);

		System.out.println("resultado: " + novaImagem);
	}

}