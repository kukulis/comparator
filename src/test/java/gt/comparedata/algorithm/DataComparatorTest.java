package gt.comparedata.algorithm;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import gt.comparedata.model.Diff;

public class DataComparatorTest {
		
	@Test
	public void testCompare() {
		Assert.assertTrue(true);
		
		DataComparator comparator = new DataComparator();
		
		List<String> a = Arrays.asList("pienas", "vienas", "du", "trys", "papildomas");
		List<String> b = Arrays.asList( "du", "trys", "keturi", "papildomas");		
	    Diff diff = comparator.compare(a, b);

	    // may use file stream if want instead of System.out
	    diff.print(System.out);
	}
}
