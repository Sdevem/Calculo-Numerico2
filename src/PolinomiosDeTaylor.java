import java.util.Scanner;

public class PolinomiosDeTaylor {
	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		int x = 0;
		int n = 0;
		int x0 = 0;
		double sen = 0;
		double cos = 0;
		double tang = 0;
		do {
			System.out.println("digite um numero entre 0 e 90");
			x = leitor.nextInt();
		} while (x < 0 && x > 90);

		do {
			System.out.println("digite um numero entre 2 e 4");
			n = leitor.nextInt();
		} while (x > 4 && x < 2);

		if (x <= 37 && x >= 0) {
			x0 = 30;
			sen = 0.5;
			cos = Math.sqrt(3) / 2;
			tang = Math.sqrt(3) / 3;
		} else if (x <= 52) {
			x0 = 45;
			sen = Math.sqrt(2) / 2;
			cos = Math.sqrt(2) / 2;
			tang = 1;
		} else if (x <= 75) {
			x0 = 60;
			sen = Math.sqrt(3) / 2;
			cos = 0.5;
			tang = Math.sqrt(3);
		} else {
			x0 = 90;
			sen = 1;
			cos = 0;
			tang = Double.POSITIVE_INFINITY;
		}
		
		double radX = (x * Math.PI) / 180;
		double radX0 = (x0 * Math.PI) / 180;
		double formula = 0;
		int n1 = 1;
		int n2 = 2;
		double res = n1 / n2;

		System.out.println("Resultado estimado: " + formulaTang(n, sen, cos, tang, radX, radX0));
		System.out.println("Resultado Real: " + Math.tan(radX));

	}

	public static double formulaTang(int n, double sen, double cos, double tang, double radX, double radX0) {
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
}
