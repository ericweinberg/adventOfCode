package com.muddworks.adventOfCode.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static com.muddworks.adventOfCode.Utils.getInputString;
import static java.util.stream.Collectors.toList;

/**
 --- Day 2: I Was Told There Would Be No Math ---

 The elves are running low on wrapping paper, and so they need to submit an order for more. They have a list of the dimensions (length l, width w, and height h) of each present, and only want to order exactly as much as they need.

 Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l. The elves also need a little extra paper for each present: the area of the smallest side.

 For example:

 A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper plus 6 square feet of slack, for a total of 58 square feet.
 A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper plus 1 square foot of slack, for a total of 43 square feet.

 All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?

 */
public class Day2 {

    private static Logger logger = LoggerFactory.getLogger(Day2.class);

    public static void main(String[] args) {
        String fileName = "Day2Input.txt";
        String inputString = getInputString(fileName);
        Day2 day1 = new Day2();
        List<String> dimensionStrings = Arrays.asList(inputString.split("\r\n"));
        int result = day1.calculateSquareFootage(dimensionStrings);

        logger.info("The number of square feet of wrapping paper is: {}", result);
    }


    public int calculateSquareFootage(List<String> dimensionStrings) {

        List<Dimension> dimensions = dimensionStrings.stream().map(string -> {
            String[] parts = string.split("x");
            return new Dimension(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        }).collect(toList());

        return calculateSquareFootageHelper(dimensions);
    }

    private int calculateSquareFootageHelper(List<Dimension> dimensions ) {
        return dimensions.stream().mapToInt(Dimension::getNeededSquareFeet).sum();
    }
}
