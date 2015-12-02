package com.muddworks.adventOfCode.day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class Day1Test {

    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][] {
                {"(())", new Day1.Day1Result(0, -1)},
                {"()()", new Day1.Day1Result(0, -1)},
                {"(((", new Day1.Day1Result(3, -1)},
                {"(()(()(", new Day1.Day1Result(3, -1)},
                {"))(((((", new Day1.Day1Result(3, 1)},
                {"())", new Day1.Day1Result(-1, 3)},
                {"))(", new Day1.Day1Result(-1, 1)},
                {")))", new Day1.Day1Result(-3, 1)},
                {")())())", new Day1.Day1Result(-3, 1)},
                {"hello", new Day1.Day1Result(0, -1)},
                {"(((())))()((((((((())", new Day1.Day1Result(7, -1)}
        });
    }

    private Day1.Day1Result expectedResult;
    private String input;

    public Day1Test(String input, Day1.Day1Result expectedResult) {

        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSolve() {
        Day1 day1 = new Day1();
        Day1.Day1Result actualResult = day1.solve(this.input);
        assertThat(actualResult.getFloorNumber(), is(this.expectedResult.getFloorNumber()));
        assertThat(actualResult.getPosition(), is(this.expectedResult.getPosition()));
    }



}
