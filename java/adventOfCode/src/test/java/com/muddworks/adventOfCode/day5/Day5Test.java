package com.muddworks.adventOfCode.day5;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class Day5Test {

    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("qjhvhtzxzqqjkmpb"), new Day5Result(1, 0)},
                {Arrays.asList("xxyxx"), new Day5Result(1, 0)},
                {Arrays.asList("uurcxstgmygtbstg"), new Day5Result(0, 1)},
                {Arrays.asList("ieodomkazucvgmuy"), new Day5Result(0, 1)},
                {Arrays.asList("qjhvhtzxzqqjkmpb", "xxyxx", "uurcxstgmygtbstg", "ieodomkazucvgmuy"), new Day5Result(2,2)},

        });
    }

    private Day5Result expectedResult;
    private List<String> input;

    public Day5Test(List<String> input, Day5Result expectedResult) {

        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSolve() {
        Day5 day5 = new Day5();
        Day5Result actualResult = day5.classifyStrings(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }
}
