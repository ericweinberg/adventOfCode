package com.muddworks.adventOfCode.day3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class Day3Test {

    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                {">", new Day3Result(2)},
                {"^>v<", new Day3Result(4)},
                {"^v^v^v^v^v", new Day3Result(2)}
        });
    }

    private Day3Result expectedResult;
    private String input;

    public Day3Test(String input, Day3Result expectedResult) {

        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSolve() {
        Day3 day3 = new Day3();
        Day3Result actualResult = day3.calculateHousesVisited(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }
}
