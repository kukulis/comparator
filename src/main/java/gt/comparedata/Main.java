package gt.comparedata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import gt.comparedata.algorithm.DataComparator;
import gt.comparedata.model.DataLoader;
import gt.comparedata.model.Diff;

public class Main {
	public final static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("must be 2 parameters: two files to compare");
			System.exit(-1);
		}

		String fileA = args[0];
		String fileB = args[1];

		DataLoader loader = new DataLoader();

		List<String> a, b;
		try {
			try {
				a = loader.loadData(new FileReader(new File(fileA)));
			} catch (FileNotFoundException e) {
				System.err.println("File " + fileA + " Not found");
				System.exit(-1);
				return;
			}

			try {
				b = loader.loadData(new FileReader(new File(fileB)));
			} catch (FileNotFoundException e) {
				System.err.println("File " + fileB + " Not found");
				System.exit(-1);
				return;
			}
		} catch (IOException e) {
			System.err.println("Errors  reading some of the input files " + e.getMessage());
			System.exit(-1);
			return;
		}

		DataComparator comparator = new DataComparator();

		Diff diff = comparator.compare(a, b);

		diff.print(System.out);
	}
}
