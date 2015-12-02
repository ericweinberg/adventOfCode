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
                {Arrays.asList("2x3x4"), new Day2Result(58, 34)},
                {Arrays.asList("1x1x10"), new Day2Result(43, 14)},
                {Arrays.asList("2x3x4", "1x1x10"), new Day2Result(101, 48)}
        });
    }

    private Day2Result expectedResult;
    private List<String> input;

    public Day2Test(List<String> input, Day2Result expectedResult) {

        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSolve() {
        Day2 day2 = new Day2();
        Day2Result actualResult = day2.calculateSquareFootage(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }
}
