/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Gabe Snyder
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String s = Integer.toString(n);
		return commaHelper(s, "", 0);

	}

	private String commaHelper(String s, String ret, int pos) {
		if (s.length() == 0) {
			return ret;
		} else if (pos == 2) {
			if (s.length() == 1) {
				ret = s.charAt(s.length() - 1) + ret;
				return commaHelper(s.substring(0, s.length() - 1), ret, 0);
			}
			ret = "," + s.charAt(s.length() - 1) + ret;
			return commaHelper(s.substring(0, s.length() - 1), ret, 0);
		} else {
			ret = s.charAt(s.length() - 1) + ret;
			return commaHelper(s.substring(0, s.length() - 1), ret, pos + 1);

		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.
		len = len - 1;
		if (index == len || len < index) {
			return;
		} else {
			int hold = x[index];
			x[index] = x[len];
			x[len] = hold;
			reverseArray(x, index + 1, len);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return rangeHelper(0, a[0], a[0], a);
	}

	private int rangeHelper(int pos, int min, int max, int[] a) {
		if (pos == a.length - 1) {
			max = Math.max(a[pos], max);
			min = Math.min(a[pos], min);
			return max - min;
		} else {
			max = Math.max(a[pos], max);
			min = Math.min(a[pos], min);
			return rangeHelper(pos + 1, min, max, a);
		}
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length == 1 || nums.length == 0) {
			return true;
		} else {
			return sortedHelper(0, nums);
		}
	}

	private boolean sortedHelper(int i, int[] nums) {
		if (i == nums.length - 2) {
			return nums[i] <= nums[i + 1];
		} else {
			return nums[i] <= nums[i + 1] && sortedHelper(i + 1, nums);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return foundHelper(search, strs, 0);
	}

	private boolean foundHelper(String search, String[] strs, int i) {
		if (i == strs.length) {
			return false;
		}
		if (strs[i].equals(search)) {
			return true;
		}
		return foundHelper(search, strs, i + 1);
	}
}
