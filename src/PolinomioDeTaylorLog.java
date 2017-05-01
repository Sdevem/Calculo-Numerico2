import java.util.Scanner;

public class PolinomioDeTaylorLog {

	public static void main (String [] args){
		Scanner leitor = new Scanner (System.in);
		System.out.println("Digite o valor de X");
		int x = leitor.nextInt();
		
		System.out.println("Digite o valor de X0");
		int x0 = leitor.nextInt();
		
		System.out.println("Digite o grau do polinomio");
		int grau = leitor.nextInt();
		
		double formula = Math.log10(x0);
		int multiplicadoX = 1;
		double constante = Math.pow(Math.log(10), -1);
		
		for (int i = 0; i < grau; i++) {
			if(i != 0){
				multiplicadoX*= -i;
			}
			formula+=(multiplicadoX * Math.pow(x0, -i-1) * constante * (Math.pow((x-x0), i+1) / fat(i+1)));
		}
		
		System.out.println("resultado estimado :" + formula);
		System.out.println("resultado real: " + Math.log10(x));
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
