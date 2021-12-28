package gt.comparedata.model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

public class Diff {

	private List<Pair<DiffType, Integer>> result = new ArrayList<>();
	private List<String> a;
	private List<String> b;
	
	public Diff(List<String> a, List<String> b) {
		this.a = a;
		this.b = b;
	}

	// TODO T instead of String
	public void print( PrintStream printStream) {
		for (Pair<DiffType, Integer> pair : this.result) {
			DiffType diffType = pair.getValue0();
			Integer index = pair.getValue1();

			switch (diffType) {
			case SAME:
				printStream.println("  " + a.get(index));
				break;
			case ADDED:
				printStream.println("+ " + b.get(index));
				break;
			case REMOVED:
				printStream.println("- " + a.get(index));
				break;
			}
		}
	}

	public List<Pair<DiffType, Integer>> getResult() {
		return result;
	}
	
	public void addSame(Integer i ) {
		result.add(new Pair<DiffType, Integer>(DiffType.SAME, i));
	}
	public void addAdded(Integer i ) {
		result.add(new Pair<DiffType, Integer>(DiffType.ADDED, i));
	}
	public void addRemoved(Integer i ) {
		result.add(new Pair<DiffType, Integer>(DiffType.REMOVED, i));
	}
	
	public List<String> getLongestSubsequence() {
		List<String> result = new ArrayList<String>();
		
		// TODO
		
		return result;
	}

}
