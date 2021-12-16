package gl.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.Test;

import gl.core.*;

/**
 * A collection of unit tests for the GaussLegendre Algorithm.
 *
 * @author djp
 *
 */
public class DecimalTests {
	/**
	 * Pi to twenty decimal places for reference.
	 */
	@SuppressWarnings("unused")
	final private String PI = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

	@Test
	public void test_valid_01() {
		BigDecimal pi = DecimalGaussLegendre.run(1);
		assertEquals(new BigDecimal("3.140579250522168248313058198309146"), pi);
	}
	@Test
	public void test_valid_02() {
		BigDecimal pi = DecimalGaussLegendre.run(2);
		assertEquals(new BigDecimal("3.141592646213542282151058622489904"), pi);
	}
	@Test
	public void test_valid_03() {
		BigDecimal pi = DecimalGaussLegendre.run(3);
		assertEquals(new BigDecimal("3.141592653589793238281226965114980"), pi);
	}
	@Test
	public void test_valid_04() {
		BigDecimal pi = DecimalGaussLegendre.run(4);
		assertEquals(new BigDecimal("3.141592653589793238464357573592619"), pi);
	}

	// ====================================================
	// Invalid tests
	// ====================================================
	@Test
	public void test_invalid_01() {
		try {
			DecimalGaussLegendre.run(0);
			fail("Should not be able to run algorithm with less than one iteration");
		} catch (IllegalArgumentException e) {

		}
	}
	@Test
	public void test_invalid_02() {
		try {
			DecimalGaussLegendre.run(-1);
			fail("Should not be able to run algorithm with less than one iteration");
		} catch (IllegalArgumentException e) {

		}
	}
}
