/**
 * ObstacleCourse: A type that represents an obstacle course from which to
 * escape. This does not find the shorted path. Because of this, we must always
 * assume there is only one exit.
 */
public class ObstacleCourse {

	// Instance variables
	protected char[][] course;
	private int sRow;
	private int sCol;
	private int foundRow;
	private int foundCol;

	// Constants (or you could use 'O' and '.' directly)
	private static final char PART_OF_PATH = 'O';
	private static final char TRIED = '.';

	/**
	 * Initializes the 2d char array course.
	 */
	public ObstacleCourse(int sRow, int sCol, char[][] course) {
		this.sRow = sRow;
		this.sCol = sCol;
		this.course = course;

		// The default values in case there is no exit.
		foundRow = -1;
		foundCol = -1;
	}

	// Returns the start column in the array
	public int getStartColumn() {
		return sCol;
	}

	// Returns the starting row in the array
	public int getStartRow() {
		return sRow;
	}

	// Return the column of the solution
	public int getExitColumn() {
		return foundCol;
	}

	// Return the row of the solution
	public int getExitRow() {
		return foundRow;
	}

	// Returns a string representation of the array
	public String toString() {
		String result = "";
		for (int i = 0; i < course.length; i++) {
			for (int j = 0; j < course[0].length; j++) {
				result += course[i][j];
			}
			result += "\n";
		}
		return result;
	}

	// This method is called by the user to begin the search for the one exit.
	public void findTheExit() {
		findExit(sRow, sCol);
	}

	/**
	 * Finds the exit from the 2-D array. This method also must record the row and
	 * col where the exit was found
	 */
	private boolean findExit(int row, int col) {
		boolean escaped = false;
		if (course[row][col] == ' ') {
			// System.out.println("is open");
			course[row][col] = TRIED;

			if (isBorder(row, col)) {

				escaped = true;

			} else {
				// System.out.println("else");
				escaped = findExit(row + 1, col);
				// System.out.println("below");
				if (!escaped) {
					// System.out.println("right");
					escaped = findExit(row, col + 1);
				}
				if (!escaped) {
					// System.out.println("up");
					escaped = findExit(row - 1, col);
				}
				if (!escaped) {
					// System.out.println("left");
					escaped = findExit(row, col - 1);
				}
			}
			if (escaped) {
				if (foundRow == -1) {
					foundRow = row;
					foundCol = col;
				}
			}
		}
		return escaped;
	}

	private boolean isBorder(int row, int col) {
		// TODO Auto-generated method stub
		if (row == 0 || row == course.length - 1) {
			return true;
		}
		if (col == 0 || col == course[0].length - 1) {
			return true;
		}
		return false;
	}

}