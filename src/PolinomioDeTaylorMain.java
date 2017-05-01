import java.util.Scanner;

public class PolinomioDeTaylorMain {
	public static void main (String [] args){
		Scanner leitor = new Scanner(System.in);
		int grau = 0;
		int n = 0;
		int x0 = 0;
		double sen = 0;
		double cos = 0;
		double tang = 0;
		do {
			System.out.println("digite um numero entre 0 e 90");
			grau = leitor.nextInt();
		} while (grau < 0 && grau > 90);

		do {
			System.out.println("digite um numero entre 2 e 4");
			n = leitor.nextInt();
		} while (grau > 4 && grau < 2);

		if (grau <= 37 && grau >= 0) {
			x0 = 30;
			
		} else if (grau <= 52) {
			x0 = 45;
			tang = 1;
		} else if (grau <= 75) {
			x0 = 60;
		} else {
			x0 = 90;
		}
	}
}
