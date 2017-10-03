package search;

public class BinarySearch {
	public boolean search(int[] values, int value) {
		int index = values.length / 2;
		int low = 0;
		int high = values.length - 1;
		while (low <= high) {
			if (value < values[index])
				high = index - 1;
			else if (value > values[index])
				low = index + 1;
			else
				return true;

			index = low + ((high - low) / 2);
		}

		return false;
	}
}
