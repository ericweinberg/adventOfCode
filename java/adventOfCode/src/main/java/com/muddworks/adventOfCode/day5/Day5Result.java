package com.muddworks.adventOfCode.day5;

public class Day5Result {
    private int niceCount = 0;
    private int naughtyCount = 0;

    public Day5Result(int niceCount, int naughtyCount) {
        this.niceCount = niceCount;
        this.naughtyCount = naughtyCount;
    }

    public int getNiceCount() {
        return niceCount;
    }

    public int getNaughtyCount() {
        return naughtyCount;
    }

    @Override
    public String toString() {
        return "Day5Result{" +
                "niceCount=" + niceCount +
                ", naughtyCount=" + naughtyCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day5Result that = (Day5Result) o;

        if (niceCount != that.niceCount) return false;
        if (naughtyCount != that.naughtyCount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = niceCount;
        result = 31 * result + naughtyCount;
        return result;
    }
}
