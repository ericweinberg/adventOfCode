package com.muddworks.adventOfCode.day6;

public class Day6Result {
    private int litLights;
    private int brightness;

    public Day6Result(int litLights, int brightness) {
        this.litLights = litLights;
        this.brightness = brightness;
    }

    public int getLitLights() {
        return litLights;
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public String toString() {
        return "Day6Result{" +
                "litLights=" + litLights +
                ", brightness=" + brightness +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day6Result that = (Day6Result) o;

        if (litLights != that.litLights) return false;
        return brightness == that.brightness;

    }

    @Override
    public int hashCode() {
        int result = litLights;
        result = 31 * result + brightness;
        return result;
    }
}
