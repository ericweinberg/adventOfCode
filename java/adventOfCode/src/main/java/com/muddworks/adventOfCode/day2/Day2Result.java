package com.muddworks.adventOfCode.day2;

public class Day2Result {

    int wrappingPaperAmount;
    int ribbonAmount;

    public Day2Result(int wrappingPaperAmount, int ribbonAmount) {
        this.wrappingPaperAmount = wrappingPaperAmount;
        this.ribbonAmount = ribbonAmount;
    }

    public int getWrappingPaperAmount() {
        return wrappingPaperAmount;
    }

    public int getRibbonAmount() {
        return ribbonAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day2Result that = (Day2Result) o;

        if (wrappingPaperAmount != that.wrappingPaperAmount) return false;
        return ribbonAmount == that.ribbonAmount;

    }

    @Override
    public int hashCode() {
        int result = wrappingPaperAmount;
        result = 31 * result + ribbonAmount;
        return result;
    }

    @Override
    public String toString() {
        return "Day2Result{" +
                "wrappingPaperAmount=" + wrappingPaperAmount +
                ", ribbonAmount=" + ribbonAmount +
                '}';
    }
}

