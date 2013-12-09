package backend;

import java.math.*;

@SuppressWarnings("unused")
public class TrigonometricFunctions {

	public static String aSineDeg(double d) {
		double answer = Math.asin(d);
		return Double.toString(Math.toDegrees(answer));
	}
	
	public static String aCosineDeg(double d) {
		double answer = Math.acos(d);
		return Double.toString(Math.toDegrees(answer));
	}
	
	public static String aTanDeg(double d) {
		double answer = Math.atan(d);
		return Double.toString(Math.toDegrees(answer));
	}
	
	public static String aSineRad(double d) {
		double answer = Math.asin(d);
		return Double.toString((answer));
	}

	public static String aCosineRad(double d) {
		double answer = Math.acos(d);
		return Double.toString((answer));
	}
	
	public static String aTanRad(double d) {
		double answer = Math.atan(d);
		return Double.toString((answer));
	}
	// -----
	public static String SineDeg(double degrees) {
		
		double radians = Math.toRadians(degrees);
		
		return Double.toString(Math.sin(radians));
	}

	public static String CosineDeg(double degrees) {
		
		double radians = Math.toRadians(degrees);
		
		return Double.toString(Math.cos(radians));
	}
	
	public static String TanDeg(double degrees) {
		
		double radians = Math.toRadians(degrees);
		
		return Double.toString(Math.tan(radians));
	}
	
	public static String SineRad(double radians) {
		return Double.toString(Math.sin(radians));
	}

	public static String CosineRad(double radians) {
		return Double.toString(Math.cos(radians));
	}
	
	public static String TanRad(double radians) {
		return Double.toString(Math.tan(radians));
	}

	
}
