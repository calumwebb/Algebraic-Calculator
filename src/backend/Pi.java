package backend;

import java.math.*;
import java.util.Scanner;

import static java.math.BigDecimal.*;

public class Pi {

	// creating static final variables
	private static final BigDecimal TWO = new BigDecimal(2);
	private static final BigDecimal FOUR = new BigDecimal(4);
	
	// square root algorithm
	public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
		
		BigDecimal x = new BigDecimal("0");
		BigDecimal y = new BigDecimal(Math.sqrt(A.doubleValue()));
		
		while (!x.equals(y)){
			x = y;
			y = A.divide(x, SCALE, ROUND_HALF_UP);
			y = y.add(x);
			y = y.divide(TWO, SCALE, ROUND_HALF_UP);		
		}
		return y;
	}
	
	
	
	// calculating pi algorithm
	public String piAlg(final int SCALE) {
		BigDecimal a = ONE;
		BigDecimal b = ONE.divide(sqrt(TWO, SCALE), SCALE, ROUND_HALF_UP);
		BigDecimal t = new BigDecimal(0.25);
		BigDecimal x = ONE;
		BigDecimal y;
		BigDecimal total;
		while (!a.equals(b)){
			y = a;
			a = a.add(b).divide(TWO, SCALE, ROUND_HALF_UP);
			b = sqrt(b.multiply(y), SCALE);
			t = t.subtract(x.multiply(y.subtract(a).multiply(y.subtract(a))));
			x = x.multiply(TWO);
		}
		total = a.add(b).multiply(a.add(b)).divide(t.multiply(FOUR), SCALE, ROUND_HALF_UP);	
		return total.toString();
	}
	
	// user input method
	public static int input() {
		Scanner input = new Scanner( System.in );
		int number;
		do {
			System.out.println("Please enter how many digits you require: ");
			while (!input.hasNextInt()) {
				System.out.println("That's not a number!");
				input.next();
			}
			number = input.nextInt();
		} while (number <= 0);
		return number;
	}
	
	
	public static void main(String args[]) {
	}
	
}



