package backend;

import java.math.*;

public class QuadraticEquation {

	public static void main (String[] args) {
		
	}
	
	
	// positive quadratic equation
	public static String QuadPlus(double a, double b, double c) {

		double disc, quadPlus;
	
		disc = (b*b) - (4*a*c);
		quadPlus = ((-b) + Math.sqrt(disc))/(2*a);
		
		String root = String.valueOf(quadPlus);
		
		if (disc < 0) {
			return "There are no real roots";
		} else {
			return root + ", ";
		}
		
	}
	
	// positive quadratic equation
		public static String QuadNeg(double a, double b, double c) {

			double disc, quadPlus;
		
			disc = (b*b) - (4*a*c);
			quadPlus = ((-b) - Math.sqrt(disc))/(2*a);
			
			String root = String.valueOf(quadPlus);
			
			if (disc < 0) {
				return "";
			} else {
				return root;
			}
			
		}
	
}