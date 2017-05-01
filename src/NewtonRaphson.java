
import java.math.BigDecimal;
import java.util.Scanner;

public class NewtonRaphson{
	public static void main (String[] args){
		//f(x) = e^x - 4x^3
		Scanner leitor = new Scanner(System.in);
		
		double novoIntervalo;
		
		System.out.println("Digite o valor de x1: ");
		double intervaloA = leitor.nextDouble();
		
		System.out.println("Digite o valor de x2: ");
		double intervaloB = leitor.nextDouble();
		
		double erro = 0.01; 
		
		if((primeiraDerivada(intervaloA)*segundaDerivada(intervaloA) > 0) && (primeiraDerivada(intervaloB)*segundaDerivada(intervaloB) > 0)){
			double novoIntervaloA = intervaloA - (funcaoOriginal(intervaloA)/primeiraDerivada(intervaloA));
			double novoIntervaloB = intervaloB - (funcaoOriginal(intervaloB)/primeiraDerivada(intervaloB));
			System.out.println("Intervalo A: " + novoIntervaloA);
			System.out.println("Intervalo B: " + novoIntervaloB);
			if(novoIntervaloA >= intervaloA && novoIntervaloA <= intervaloB || (novoIntervaloA <= intervaloA && novoIntervaloA >= intervaloB))
				novoIntervalo = calcular(intervaloA, erro);
			else
				novoIntervalo = calcular(intervaloB, erro);
			
		}else if((primeiraDerivada(intervaloA)*segundaDerivada(intervaloA) > 0)){
			System.out.println("Intervalo: " + intervaloA);
			System.out.println("1ª Derivada: " + primeiraDerivada(intervaloA));
			System.out.println("2ª Derivada: " + segundaDerivada(intervaloA));
			novoIntervalo = calcular(intervaloA, erro);
			
		}else{
			System.out.println("Intervalo: " + intervaloB);
			System.out.println("1ª Derivada: " + primeiraDerivada(intervaloB));
			System.out.println("2ª Derivada: " + segundaDerivada(intervaloB));
			novoIntervalo = calcular(intervaloB, erro);
		}
		leitor.close();
	}
	
	private static double calcular(double intervalo, double erro){
		double novaImagem = intervalo;
		double novoIntervalo;
		do{
			novoIntervalo = novaImagem - (funcaoOriginal(novaImagem)/primeiraDerivada(novaImagem));
			System.out.println("\nNovo Intervalo: " + novoIntervalo);
			System.out.println("Função Original: " + funcaoOriginal(novoIntervalo));
			System.out.println("1ª Derivada: " + primeiraDerivada(novoIntervalo));
			novaImagem = novoIntervalo;
		}while(Math.abs((funcaoOriginal(novaImagem)/primeiraDerivada(novaImagem))) > erro);
		double ultimoIntervalo = novoIntervalo = novaImagem - (funcaoOriginal(novaImagem)/primeiraDerivada(novaImagem));
		System.out.println("\nÚltimo Intervalo: " + ultimoIntervalo);
		System.out.println("Função Original: " + new BigDecimal(funcaoOriginal(ultimoIntervalo)));
		return novoIntervalo;
	}
	
	private static double funcaoOriginal(double x){
		return Math.pow(Math.E, x) - (4 * Math.pow(x, 3));
	}
	
	private static double primeiraDerivada(double x){
		return Math.pow(Math.E, x) - (12 * Math.pow(x, 2));
	}
	
	private static double segundaDerivada(double x){
		return Math.pow(Math.E, x) - (24 * x);
	}
}
