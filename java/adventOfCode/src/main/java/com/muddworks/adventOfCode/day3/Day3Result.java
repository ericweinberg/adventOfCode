package com.muddworks.adventOfCode.day3;

/**
 *Have been waiting for part 2 to do this, but end up always needing one, so doing it now.
 */
public class Day3Result {
    private int numberOfHouses = 0;

    public Day3Result(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    @Override
    public String toString() {
        return "Day3Result{" +
                "numberOfHouses=" + numberOfHouses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day3Result that = (Day3Result) o;

        return numberOfHouses == that.numberOfHouses;

    }

    @Override
    public int hashCode() {
        return numberOfHouses;
    }
}
