package week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[][] sites;
    private final int n;
    private final int top = 0;
    private final int bottom;
    private int openSitesNum = 0;

    private final WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(final int n) {
        validateSitesCount(n);
        this.n = n;
        this.bottom = n * n + 1;
        this.sites = new boolean[n][n];
        this.weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);
    }

    private void validateSitesCount(final int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n must be >= 0");
    }

    public int numberOfOpenSites() {
        return this.openSitesNum;
    }

    public void open(final int row, final int col) {
        validate(row, col);
        this.sites[row - 1][col - 1] = true;
        this.openSitesNum++;
        if (row == 1)
            this.weightedQuickUnionUF.union(getQFIndex(row, col), this.top);
        if (row == this.n)
            this.weightedQuickUnionUF.union(getQFIndex(row, col), this.bottom);

        if (col > 1 && isOpen(row, col - 1)) {
            this.weightedQuickUnionUF.union(getQFIndex(row, col), getQFIndex(row, col - 1));
        }
        if (col < this.n && isOpen(row, col + 1)) {
            this.weightedQuickUnionUF.union(getQFIndex(row, col), getQFIndex(row, col + 1));
        }
        if (row > 1 && isOpen(row - 1, col)) {
            this.weightedQuickUnionUF.union(getQFIndex(row, col), getQFIndex(row - 1, col));
        }
        if (row < this.n && isOpen(row + 1, col)) {
            this.weightedQuickUnionUF.union(getQFIndex(row, col), getQFIndex(row + 1, col));
        }
    }


    public boolean isOpen(final int row, final int col) {
        validate(row, col);
        return this.sites[row - 1][col - 1];
    }

    public boolean isFull(final int row, final int col) {
        validate(row, col);
        return this.weightedQuickUnionUF.connected(this.top, getQFIndex(row, col));
    }


    public boolean percolates() {
        return this.weightedQuickUnionUF.connected(this.top, this.bottom);
    }

    private void validate(final int row, final int col) {
        if (row > this.n || row < 1 || col > this.n || col < 1) {
            throw new IllegalArgumentException(String.format("Illegal row or col %s or %s. It'g greater than sites count %s", row, col, this.n));
        }
    }


    private int getQFIndex(final int i, final int j) {
        return this.n * (i - 1) + j;
    }
}