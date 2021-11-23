package week1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final int n;
    private final int trials;
    private final double[] openSites;

    public PercolationStats(final int n, final int trials) {
        validate(n, trials);
        this.n = n;
        this.trials = trials;
        this.openSites = new double[trials];
        for (int i = 0; i < trials; i++) {
            this.openSites[i] = (double) monteCarloSimulation() / (n * n);
        }
    }

    /***
     *
     * @return number of open sites
     */
    private int monteCarloSimulation() {
        final Percolation percolation = new Percolation(this.n);
        while (!percolation.percolates()) {
            final int row = StdRandom.uniform(1, this.n + 1);
            final int col = StdRandom.uniform(1, this.n + 1);
            if (!percolation.isOpen(row, col)) {
                percolation.open(row, col);
            }
        }

        return percolation.numberOfOpenSites();
    }

    private void validate(final int n, final int trials) {
        if (n <= 0)
            throw new IllegalArgumentException(String.format("Illegal number of n: %s", n));
        if (trials <= 0)
            throw new IllegalArgumentException(String.format("Illegal number of trials: %s", trials));
    }


    public double mean() {
        return StdStats.mean(this.openSites);
    }

    public double stddev() {
        return StdStats.stddev(this.openSites);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(this.trials));
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(this.trials));
    }

    public static void main(final String[] args) {
        final int n = Integer.valueOf(args[0]);
        final int trials = Integer.valueOf(args[1]);
        final PercolationStats percolationStats = new PercolationStats(n, trials);
        StdOut.println(String.format("mean = %f", percolationStats.mean()));
        StdOut.println(String.format("stddev = %f", percolationStats.stddev()));
        StdOut.println(String.format("95%% confidence interval = [%f, %f]", percolationStats.confidenceLo(), percolationStats.confidenceHi()));
    }
}