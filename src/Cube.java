import java.util.Arrays;

public class Cube {
	private Side[] sides = new Side[6];
	private int[] seq = {6, 3, 0, 7, 4, 1, 8, 5, 2};
	private int[] bot = {6, 7, 8};
	private int[] left = {0, 3, 6};
	private int[] top = {0, 1, 2};
	private int[] right = {2, 5, 8};
	private int[][] seq2 = {bot, left, top, right};

	Cube() {
		System.out.println("Creating a new Cube!");
		createCube();
	}

	private Side[] createCube() {
		for (int i = 0; i < 5; i++) {
			sides[i] = new Side(i);
		}
		sides[5] = new Side(new int[] {0, 2, 2, 4, 5, 2, 2, 6, 5});
		return sides;
	}

	public void turnRight(boolean cw, int sideNum) {
		int[] adjSides = getAdjSides(sideNum);
		sides[sideNum] = rotate(sideNum);
		System.out.println(Arrays.toString(adjSides));
	}

	public int[] getAdjSides(int sideNum) {
		switch (sideNum) {
			case 0:
				return new int[] {1, 3, 2, 4};
			case 3:
				return new int[] {1, 5, 2, 0};
			case 5:
				return new int[] {1, 4, 2, 3};
			case 4:
				return new int[] {1, 0, 2, 5};
		}
		return null;
	}

	public Side rotate(int sideNum) {
		int[] adjSides = getAdjSides(sideNum);
		printSide(sideNum);
		int[] array = sides[sideNum].getState();
		int[] copy = array.clone();
		for (int i = 0; i < 9; i++) {
			array[i] = copy[seq[i]];
		}
		printSide(sideNum);
		System.out.println(Arrays.toString(adjSides));
		return new Side(array);
	}

//	public Side rotateAdj(int sideNum) {
//		int[] adjSides = getAdjSides(sideNum);
//		for (int i = 0; i < adjSides.length; i++) {
//			adjSides[i]
//		}
//	}

	private void printSide(int sideNum) {
		int[] arr = sides[sideNum].getState();
		for (int i = 0; i < arr.length; i++) {
			if (i % 3 == 0) { System.out.println(""); }
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		System.out.print("-----------");
	}
}
