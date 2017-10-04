package search;

public class LinearSearch {
	public boolean search(int[] values, int value) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] == value)
				return true;
		}
		return false;
	}
}
