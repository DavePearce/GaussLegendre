package gl.core;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * <p>
 * A straightforward implementation of GaussLegendre using IEEE754 double
 * floating point. See <a href=
 * "https://en.wikipedia.org/wiki/Gauss%E2%80%93Legendre_algorithm">Wikipedia
 * Page</a> for more details of the algorithm.
 * </p>
 *
 * @author djp
 *
 */
public strictfp class DecimalGaussLegendre {
	/**
	 * Constant required for initial state of algorithm. Observe the use of a
	 * constant here rather than trying to compute it, as this appears problematic
	 * with BigDecimal.
	 */
	public static final BigDecimal ONE_OVER_ROOT_2 = BigDecimal.ONE.divide(new BigDecimal("1.4142135623730950488"),
			MathContext.DECIMAL128);
	/**
	 * Useful constant to save recreating it on every iteration of the loop.
	 */
	public static final BigDecimal TWO = BigDecimal.valueOf(2);
	/**
	 * Useful constant to make things more readable.
	 */
	public static final BigDecimal FOUR = BigDecimal.valueOf(4);
	/**
	 * Run the GaussLegendre Algorithm for <code>n</code> iterations.
	 *
	 * @param n The number of iterations to run the algorithm for.
	 * @return
	 */
	public static BigDecimal run(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("At least one iteration required!");
		}
		BigDecimal a_n = BigDecimal.ONE;
		BigDecimal b_n = ONE_OVER_ROOT_2;
		BigDecimal t_n = BigDecimal.valueOf(0.25);
		BigDecimal p_n = BigDecimal.ONE;
		// Perform n iterations of the algorithm
		for (int i = 0; i < n; ++i) {
			// Calculate values for next iteration
			BigDecimal a_np1 = a_n.add(b_n).divide(TWO);
			BigDecimal b_np1 = a_n.multiply(b_n).sqrt(MathContext.DECIMAL128);
			BigDecimal t_np1 = t_n.subtract(p_n.multiply(a_n.subtract(a_np1).pow(2)));
			BigDecimal p_np1 = TWO.multiply(p_n);
			// Copy over new values
			a_n = a_np1;
			b_n = b_np1;
			t_n = t_np1;
			p_n = p_np1;
		}
		// Compute approximation
		//BigDecimal pi = Math.pow(a_n + b_n, 2) / (4.0d * t_n);
		BigDecimal pi = a_n.add(b_n).pow(2).divide(FOUR.multiply(t_n), MathContext.DECIMAL128);
		// Done;
		return pi;
	}
}
