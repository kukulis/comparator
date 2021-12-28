package gt.comparedata.algorithm;

import java.util.List;

import gt.comparedata.model.Diff;

// TODO T instead of String
public class DataComparator {

	private int c[][] = null;
	private List<String> a = null;
	private List<String> b = null;

	private Diff diff;

	public Diff compare(List<String> a, List<String> b) {

		this.a = a;
		this.b = b;
		this.diff = new Diff(a, b );

		this.c = buildCompareMatrix(a, b);

		collectDiff(a.size(), b.size());

		return this.diff;
	}

	private void collectDiff(int i, int j) {
		if (i >= 1 && j >= 1 && a.get(i - 1).equals(b.get(j - 1))) {
			collectDiff(i - 1, j - 1);
			this.diff.addSame(i - 1);
		} else if (j > 0 && (i == 0 || c[i][j - 1] >= c[i - 1][j])) {
			collectDiff(i, j - 1);
			this.diff.addAdded(j - 1);
		} else if (i > 0 && (j == 0 || c[i][j - 1] < c[i - 1][j])) {
			collectDiff(i - 1, j);
			this.diff.addRemoved(i - 1);
		}
	}

	private int[][] buildCompareMatrix(List<String> a, List<String> b) {
		int[][] c = new int[a.size() + 1][b.size() + 1]; // (a, b).Length + 1
		for (int i = 0; i < a.size(); i++)
			c[i][0] = 0;
		for (int j = 0; j < b.size(); j++)
			c[0][j] = 0;
		for (int i = 1; i <= a.size(); i++)
			for (int j = 1; j <= b.size(); j++) {
				if (a.get(i - 1).equals(b.get(j - 1)))// i-1,j-1
					c[i][j] = c[i - 1][j - 1] + 1;
				else
					c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
			}
		return c;
	}
}
