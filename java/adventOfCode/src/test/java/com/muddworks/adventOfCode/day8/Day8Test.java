package com.muddworks.adventOfCode.day8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class Day8Test {

    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("\"\""), new Day8Result(2, 6)},
                {Arrays.asList("\"abc\""), new Day8Result(5, 9)},
                {Arrays.asList("\"aaa\\\"aaa\""), new Day8Result(10,16)},
                {Arrays.asList("\"\\x27\""), new Day8Result(6, 11)},
                {Arrays.asList("\"\"", "\"abc\"", "\"aaa\\\"aaa\"", "\"\\x27\"" ), new Day8Result(23, 42)},

                {Arrays.asList("\"\\xa8br\\x8bjr\\\"\"" ), new Day8Result(16, 24)},
                {Arrays.asList("\"daz\\\\zyyxddpwk\"" ), new Day8Result(16, 22)},
                {Arrays.asList("\"u\\\"ptk\"" ), new Day8Result(8, 14)},
                {Arrays.asList("\"nbydghkfvmq\\\\\\xe0\\\"lfsrsvlsj\\\"i\\x61liif\"" ), new Day8Result(41, 53)},
                {Arrays.asList("\"qludrkkvljljd\\\\xvdeum\\x4e\"" ), new Day8Result(27, 34)},

                });
    }

    private Day8Result expectedResult;
    private List<String> input;

    public Day8Test(List<String> input, Day8Result expectedResult) {

        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testSolve() {
        Day8 day8 = new Day8();
        Day8Result actualResult = day8.escapeCharacters(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }
}
