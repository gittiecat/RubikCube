public class Side {
	private int[] currentState;

	public Side(int c) {
		int[] side = new int[9];
		for (int i = 0; i < 9; i++) {
			side[i] = c;
		}
		currentState = side;
	}

	public Side(int[] i) {
		currentState = i;
	}

//	public static int[] createSide(int colour) {
//		int[] side = new int[9];
//		for (int i = 0; i < 9; i++) {
//			side[i] = colour;
//		}
//		return side;
//	}

	public int[] getState() {
		return currentState;
	}
}
