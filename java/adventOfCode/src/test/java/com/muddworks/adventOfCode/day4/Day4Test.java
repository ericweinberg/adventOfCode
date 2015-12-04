package com.muddworks.adventOfCode.day4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class Day4Test {
    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                {"abcdef", new Day4Result("abcdef", 609043L, null)},
                {"pqrstuv", new Day4Result("pqrstuv", 1048970L, null)}
        });
    }

    private Day4Result expectedResult;
    private String input;

    public Day4Test(String input, Day4Result expectedResult) {

        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSolve() {
        Day4 day4 = new Day4(5);
        Day4Result actualResult = day4.mineBitCoins(this.input);
        assertThat(actualResult.getKey(), is(this.expectedResult.getKey()));
        assertThat(actualResult.getNumber(), is(this.expectedResult.getNumber()));
    }
}
