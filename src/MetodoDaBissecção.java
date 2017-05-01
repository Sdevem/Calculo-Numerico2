import java.util.Scanner;

public class MetodoDaBissecção {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

	
		double a = 0;
	
		double b = 0;
		int escolha = 0;
		double formulaA = 0;
		double formulaB = 0;
		double formula = 0;

		
		do{	
			System.out.println("Informe a questão:\n1- e^x - ln(x) - 1\n2- F(x) = xe^x + x^2 - 1\n3- F(x) = ((e^-x) - 1)/(x + 2)"
					+ "\n4- F(x) = ((e^-2x) - x)/(x + 2)\n5- F(x) = e^x - x^3 + 3x\n6- para sair ");
			escolha = leitor.nextInt();
			
			if(escolha != 6){
			System.out.println("Digete o valor de a.");
			a = leitor.nextDouble();
			System.out.println("digite o valor de b.");
			b = leitor.nextDouble();
		}
			
		if(escolha == 3){
			while(a == -2 || b == -2){
				System.out.println("Digete o valor de a diferente de - 2.");
				 a = leitor.nextDouble();
				System.out.println("digite o valor de b diferente de -2.");
				 b = leitor.nextDouble();}
		}else if(escolha == 4){
			while(a == -2 || b == -2){
				System.out.println("Digete o valor de a diferente de - 2.");
				 a = leitor.nextDouble();
				System.out.println("digite o valor de b diferente de -2.");
				 b = leitor.nextDouble();}
		}}while(escolha < 1 || escolha > 6 );
	
		if (calculate(a, escolha) * calculate(b, escolha) < 0){
		double erro = b - a;
		int k = (int) ((Math.log(b - a) - Math.log(0.001)) / Math.log(2));
		System.out.println("numero de iterações: " + (k + 1));

		System.out.println("resultado para o valor: " + a + ": " + calculate(a,escolha));

		System.out.println("resultado para o valor: " + b + ": " + calculate(a,escolha));

		for (int i = 0; i < k + 1; i++) {
			double novaInteracao = 0;
			if (calculate(a, escolha) > 0 && calculate((a + b) / 2, escolha) > 0) {
				System.out.print("Valor de a alterado de " + a + " para " + ((a + b) / 2));
				a = (a + b) / 2;
				novaInteracao = calculate(a, escolha);
			} else if (calculate(b, escolha) > 0 && calculate((a + b) / 2,escolha) > 0) {
				System.out.print("Valor de b alterado de " + b + " para " + ((a + b) / 2));
				b = (a + b) / 2;
				novaInteracao = calculate(b, escolha);
			} else if (calculate(a, escolha) < 0 && calculate((a + b) / 2, escolha) < 0) {
				System.out.print("Valor de a alterado de " + a + " para " + ((a + b) / 2));
				a = (a + b) / 2;
				novaInteracao = calculate(a, escolha);
			} else if (calculate(b, escolha) < 0 && calculate((a + b) / 2, escolha) < 0) {
				System.out.print("Valor de b alterado de " + b + " para " + ((a + b) / 2));
				b = (a + b) / 2;
				novaInteracao = calculate(b, escolha);
			}
			System.out.println(", F(x) = " + calculate(novaInteracao, escolha) +" "+ (b - a));
		}
		System.out.println("a: " + a + " b: " + b);
		erro = b - a;
		if(erro < 0.001){
			System.out.println("erro aceitavel " + erro);
		}else{
			System.out.println("erro inaceitavel " + erro);
		}
	} else if(escolha == 6){
		System.out.println("fim do programa obrigado por utiliza-lo");
		System.exit(0);
	}else {
		System.out.println("Não pode calcular utilizando o teorema de Bolzano-Weierstrass.");
	}
}

	static double calculate(double x, int resposta) {
		if (resposta == 1)
			return Math.pow(Math.E, x) - Math.log(x) - 1;
		if (resposta == 2)
			return (x * Math.pow(Math.E, x)) + Math.pow(x, 2) - 1;
		if (resposta == 3)
			return (Math.pow(Math.E, -x) - 1) / (x + 2);
		if (resposta == 4)
			return (Math.pow(Math.E, -2 * x) - x) / (x + 2);
		if (resposta == 5)
			return (Math.pow(Math.E, x)) - (Math.pow(x, 3)) + (3 * x);
		return 0;
	}

}
