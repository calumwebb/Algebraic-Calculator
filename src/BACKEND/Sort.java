package BACKEND;

import java.lang.reflect.Array;

public class Sort {

	public static void main(String[] args) {
		BubbleSortA("79	36	27	66	86	73	92	84	72	34	50	53	14	41	36	67	58	60	38	47	75	33	46	51	8	48	87	79	36	16	72	16	57	43	92	89	99	5	72	60	68	83	39	88	91	39	60	59	43	26	32	38	49	96	12	41	41	20	9	18	91	6	9	15	44	59	17	1	6	1	51	90	77	94	4	49	6	72	63	54	47	34	25	50	96	3	75	25	1	87	12	27	63	13	76	85	95	46	100	51");
		BubbleSortD("79	36	27	66	86	73	92	84	72	34	50	53	14	41	36	67	58	60	38	47	75	33	46	51	8	48	87	79	36	16	72	16	57	43	92	89	99	5	72	60	68	83	39	88	91	39	60	59	43	26	32	38	49	96	12	41	41	20	9	18	91	6	9	15	44	59	17	1	6	1	51	90	77	94	4	49	6	72	63	54	47	34	25	50	96	3	75	25	1	87	12	27	63	13	76	85	95	46	100	51");
	}
	// Turns textarea string into the number array lists
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
		public static void BubbleSortA(String s) {
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
			System.out.println("Bubble sort in ascending order: ");
			for (int i = 0; i < numList.length; i++ ) {
				System.out.print(numList[i] + " " );
			}
			System.out.println(" ");
		}
		
		// BUBBLE SORT IN ASCENDING ORDER
		public static void BubbleSortD(String s) {
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
			System.out.println("Bubble sort in descending order: ");
			for (int i = 0; i < numList.length ; i++ ) {
				System.out.print(numList[i] + " " );
			}
			
		}
}

