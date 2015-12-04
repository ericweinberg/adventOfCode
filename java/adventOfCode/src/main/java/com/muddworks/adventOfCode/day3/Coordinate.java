package com.muddworks.adventOfCode.day3;

public class Coordinate {
    private int x;
    private int y;

    private final static int UP = '^';
    private final static int LEFT = '<';
    private final static int RIGHT = '>';
    private final static int DOWN = 'v';

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public Coordinate move(int character) {
        switch (character) {
            case DOWN:
                return new Coordinate(x, y-1);
            case UP:
                return new Coordinate(x, y+1);
            case LEFT:
                return new Coordinate(x-1, y);
            case RIGHT:
                return new Coordinate(x+1, y);
            default:
                throw new RuntimeException("Unknown charachter");
        }
    }
}
