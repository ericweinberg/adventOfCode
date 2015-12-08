package com.muddworks.adventOfCode.day6;

public class Day6Result {
    private int litLights;
    private int unlitLights;

    public Day6Result(int litLights) {
        this.litLights = litLights;
    }

    public int getLitLights() {
        return litLights;
    }

    public int getUnlitLights() {
        return unlitLights;
    }

    @Override
    public String toString() {
        return "Day6Result{" +
                "litLights=" + litLights +
                ", unlitLights=" + unlitLights +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day6Result that = (Day6Result) o;

        if (litLights != that.litLights) return false;
        return unlitLights == that.unlitLights;

    }

    @Override
    public int hashCode() {
        int result = litLights;
        result = 31 * result + unlitLights;
        return result;
    }
}
