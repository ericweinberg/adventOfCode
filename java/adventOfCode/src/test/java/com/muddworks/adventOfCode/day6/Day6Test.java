package com.muddworks.adventOfCode.day6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class Day6Test {

    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("turn on 0,0 through 999,999"), new Day6Result(1000000)},
                {Arrays.asList("toggle 0,0 through 999,0"), new Day6Result(1000)},
                {Arrays.asList("turn off 499,499 through 500,500"), new Day6Result(0)},
                {Arrays.asList("turn on 0,0 through 999,999","toggle 0,0 through 999,0",
                        "turn off 499,499 through 500,500" ), new Day6Result(998996)}
        });
    }

    private Day6Result expectedResult;
    private List<String> input;

    public Day6Test(List<String> input, Day6Result expectedResult) {

        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSolve() {
        Day6 day6 = new Day6();
        Day6Result actualResult = day6.runInstructions(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }
}
