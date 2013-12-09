package backend;

import java.lang.reflect.Array;

@SuppressWarnings("unused")
public class Sort {

	public static void main(String[] args) {
	}
	// Turns text area string into the number array lists
	private static int[] StringSeperator(String s) {
		String[] stringTemp = s.split("\\s+");
		int[] numList = new int[stringTemp.length];
		
		for (int i = 0; i < stringTemp.length; i ++ ) {
			try {
				numList[i] = Integer.parseInt(stringTemp[i]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("NFE issue");
			}
		}
		return numList;
	}
	
	// BUBBLE SORT IN ASCENDING ORDER
		public static int[] BubbleSortA(String s) {
			boolean running = true;
			int temp;
			
			int[] numList = StringSeperator(s);
			
			while (running) {
				running = false;
				for (int i = 0; i < numList.length -1; i++ ) {
					if (numList[i] > numList[i+1]) {
						running = true;
						temp = numList[i];
						numList[i] = numList[i+1];
						numList[i+1] = temp;
					}
				}
			}
			return numList;
		}
		
		// BUBBLE SORT IN ASCENDING ORDER
		public static int[] BubbleSortD(String s) {
			boolean running = true;
			int temp;
			
			int[] numList = StringSeperator(s);
			
			while (running) {
				running = false;
				for (int i = 0; i < numList.length -1; i++ ) {
					if (numList[i] < numList[i+1]) {
						running = true;
						temp = numList[i];
						numList[i] = numList[i+1];
						numList[i+1] = temp;
					}
				}
			}
			return numList;
			
		}
}

