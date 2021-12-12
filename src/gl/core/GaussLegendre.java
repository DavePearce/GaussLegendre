package gl.core;

/**
 * <p>
 * A straightforward implementation of GaussLegendre using IEEE754 double
 * floating point. See <a href=
 * "https://en.wikipedia.org/wiki/Gauss%E2%80%93Legendre_algorithm">Wikipedia
 * Page</a> for more details of the algorithm.
 * </p>
 * <p>
 * <b>NOTE:</b> using double floating point precision means this algorithm is
 * not accurate beyond three iterations.
 * </p>
 *
 * @author djp
 *
 */
public strictfp class GaussLegendre {
	/**
	 * Constant required for initial state of algorithm.
	 */
	public static final double ONE_OVER_ROOT_2 = 1.0 / Math.sqrt(2.0);

	/**
	 * Run the GaussLegendre Algorithm for <code>n</code> iterations.
	 *
	 * @param n The number of iterations to run the algorithm for.
	 * @return
	 */
	public static double run(int n) {
		if(n < 1) {
			throw new IllegalArgumentException("At least one iteration required!");
		}
		double a_n = 1.0d;
		double b_n = ONE_OVER_ROOT_2;
		double t_n = 0.25;
		double p_n = 1.0;
		// Perform n iterations of the algorithm
		for (int i = 0; i < n; ++i) {
			// Calculate values for next iteration
			double a_np1 = (a_n+b_n) / 2;
			double b_np1 = Math.sqrt(a_n * b_n);
			double t_np1 = t_n - (p_n * Math.pow(a_n - a_np1, 2));
			double p_np1 = 2.0d * p_n;
			// Copy over new values
			a_n = a_np1;
			b_n = b_np1;
			t_n = t_np1;
			p_n = p_np1;
		}
		// Compute approximation
		double pi = Math.pow(a_n + b_n, 2) / (4.0d * t_n);
		// Done;
		return pi;
	}
}
