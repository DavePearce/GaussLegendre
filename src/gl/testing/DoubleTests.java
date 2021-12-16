package gl.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

import gl.core.DoubleGaussLegendre;

/**
 * A collection of unit tests for the GaussLegendre Algorithm.
 *
 * @author djp
 *
 */
public class DoubleTests {
	@Test
	public void test_valid_01() {
		double pi = DoubleGaussLegendre.run(1);
		assertEquals(3.14_05792505221686, pi);
	}
	@Test
	public void test_valid_02() {
		double pi = DoubleGaussLegendre.run(2);
		assertEquals(3.1415926_46213543, pi);
	}
	@Test
	public void test_valid_03() {
		double pi = DoubleGaussLegendre.run(3);
		assertEquals(3.14159265358979_4, pi);
	}

	// ====================================================
	// Invalid tests
	// ====================================================
	@Test
	public void test_invalid_01() {
		try {
			DoubleGaussLegendre.run(0);
			fail("Should not be able to run algorithm with less than one iteration");
		} catch (IllegalArgumentException e) {

		}
	}
	@Test
	public void test_invalid_02() {
		try {
			DoubleGaussLegendre.run(-1);
			fail("Should not be able to run algorithm with less than one iteration");
		} catch (IllegalArgumentException e) {

		}
	}
}
