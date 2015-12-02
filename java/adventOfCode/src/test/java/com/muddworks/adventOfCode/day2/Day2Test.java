package com.muddworks.adventOfCode.day2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class Day2Test {

    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("2x3x4"), 58},
                {Arrays.asList("1x1x10"), 43},
                {Arrays.asList("2x3x4", "1x1x10"), 101}
        });
    }

    private int expectedResult;
    private List<String> input;

    public Day2Test(List<String> input, int expectedResult) {

        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSolve() {
        Day2 day2 = new Day2();
        int actualResult = day2.calculateSquareFootage(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }
}
