package com.muddworks.adventOfCode.day8;

public class Day8Result {
    private int numberOfCodeCharacters = 0;
    private int numberOfMemoryCharacters = 0;

    public Day8Result(int numberOfCodeCharacters, int numberOfMemoryCharacters) {
        this.numberOfCodeCharacters = numberOfCodeCharacters;
        this.numberOfMemoryCharacters = numberOfMemoryCharacters;
    }

    public int getNumberOfCodeCharacters() {
        return numberOfCodeCharacters;
    }

    public int getNumberOfMemoryCharacters() {
        return numberOfMemoryCharacters;
    }

    @Override
    public String toString() {
        return "Day8Result{" +
                "numberOfCodeCharacters=" + numberOfCodeCharacters +
                ", numberOfMemoryCharacters=" + numberOfMemoryCharacters +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day8Result that = (Day8Result) o;

        if (numberOfCodeCharacters != that.numberOfCodeCharacters) return false;
        if (numberOfMemoryCharacters != that.numberOfMemoryCharacters) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberOfCodeCharacters;
        result = 31 * result + numberOfMemoryCharacters;
        return result;
    }
}
