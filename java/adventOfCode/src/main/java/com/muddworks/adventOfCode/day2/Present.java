package com.muddworks.adventOfCode.day2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Present {
    private int length;
    private int width;
    private int height;
    private List<Integer> areas;

    public Present(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        init();
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void init() {
        areas = Arrays.asList(length * width,
                width * height,
                height * length);
        Collections.sort(areas);
    }

    public int getSmallestArea() {
        return areas.get(0);
    }
    public int getCube() {
        return length*width*height;
    }
    public int getNeededWrappingPaperAmount() {
        int result = areas.stream().mapToInt(area -> 2*area).sum();
        result = result + getSmallestArea();
        return result;
    }

    public int getNeededRibbonAmount() {
        //inverse sort, then skip the max item.
        int result = Arrays.asList(length, height, width).stream()
                .sorted(Comparator.<Integer>reverseOrder())
                .skip(1)
                .mapToInt(side -> side * 2)
                .sum();
        result = result + getCube();
        return result;
    }
}
