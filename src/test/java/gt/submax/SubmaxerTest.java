package gt.submax;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubmaxerTest {

	private void testSubmaxer(Integer[] data, int interval, Integer[] expected) {

		Submaxer submaxer = new Submaxer();
		List<Integer> result = submaxer.findSubmaxes(Arrays.asList(data), interval);

		String msg = result.stream().map(e -> e.toString()).collect(Collectors.joining(","));

		Assert.assertArrayEquals(msg, expected, result.toArray());
	}

	@Test
	public void test1Simple() {
		testSubmaxer(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }, 4,
				new Integer[] { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 });
	}

	@Test
	public void test2Descending() {
		testSubmaxer(new Integer[] { 14, 13, 12, 11, 10, 8, 7, 6, 5, 4, 3, 2, 1 }, 4,
				new Integer[] { 14, 13, 12, 11, 10, 8, 7, 6, 5, 4 });

	}

	@Test
	public void test3Peeks() {
		testSubmaxer(new Integer[] { 14, 0, 0, 0, 10, 0, 0, 0, 5, 0, 0, 0, 1 }, 4,
				new Integer[] { 14, 10, 10, 10, 10, 5, 5, 5, 5, 1 });

	}

	@Test
	public void test4Holes() {
		testSubmaxer(new Integer[] { 14, 13, 0, 11, 10, 8, 0, 6, 5, 4, 0, 2, 1 }, 4,
				new Integer[] { 14, 13, 11, 11, 10, 8, 6, 6, 5, 4 });
	}

	@Test
	public void test5Hill() {
		testSubmaxer(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1 }, 4,
				new Integer[] { 4, 5, 6, 7, 7, 7, 7, 6, 5, 4 });
	}

	@Test
	public void test6BigHole() {
		testSubmaxer(new Integer[] { 10, 9, 8, 7, 6, 5, 6, 7, 8, 9, 10, 11, 12 }, 4,
				new Integer[] { 10, 9, 8, 7, 7, 8, 9, 10, 11, 12 });
	}

	@Test
	public void test7DistantPeeks() {
		testSubmaxer(new Integer[] { 14, 0, 0, 0, 0, 9, 0, 0, 0, 0, 1, 0 }, 4,
				new Integer[] { 14, 0, 9, 9, 9, 9, 0, 1, 1 });

	}

	@Test
	public void test8Empty() {
		testSubmaxer(new Integer[] {}, 4, new Integer[] {});

	}

	@Test
	public void test9Short() {
		testSubmaxer(new Integer[] { 1, 2, 3 }, 4, new Integer[] {});

	}
}
