package com.muddworks.adventOfCode.day5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import static com.muddworks.adventOfCode.Utils.getInputString;

/**
 --- Day 5: Doesn't He Have Intern-Elves For This? ---

 Santa needs help figuring out which strings in his text file are naughty or nice.

 A nice string is one with all of the following properties:

 It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
 It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
 It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.

 */
public class Day5 {

    private static Logger logger = LoggerFactory.getLogger(Day5.class);

    public static void main(String[] args) {
        String fileName = "Day5Input.txt";
        String inputString = getInputString(fileName);
        Day5 day5 = new Day5();
        Day5Result result = day5.classifyStrings(Arrays.asList(inputString.split("\r\n")));
        logger.info("The number of naughty strings was {} and the number of nice strings was {} ",
                result.getNaughtyCount(), result.getNiceCount());
    }

     public Day5Result classifyStrings(List<String> strings) {

         int niceCount = 0;
         int naughtyCount = 0;
         for(String string : strings) {
             if(!containsInvalidString(string) &&
                     hasDoubleCharacter(string) &&
                     hasThreeVowels(string)) {
                niceCount++;
             }else {
                 naughtyCount++;
             }
         }
         return new Day5Result(niceCount, naughtyCount);
    }

    private boolean hasThreeVowels(String string) {
        int vowelsFound = 0;

        vowelsFound+=string.chars().filter( character -> character=='a').count();
        vowelsFound+=string.chars().filter( character -> character=='e').count();
        vowelsFound+=string.chars().filter( character -> character=='i').count();
        vowelsFound+=string.chars().filter( character -> character=='o').count();
        vowelsFound+=string.chars().filter( character -> character=='u').count();

        return vowelsFound >=3;
    }

    private boolean hasDoubleCharacter(String string) {
        for(int i=0;i<string.length();i++) {
            char character = string.charAt(i);
            if(i+1 < string.length()) {
                char nextChar = string.charAt(i+1);
                if(character == nextChar)
                    return true;
            }
            else {
                //no next character, if we haven't returned true by now, then there is no match.
                return false;
            }
        }
        return false;
    }

    private boolean containsInvalidString(String string) {
        return string.contains("ab") || string.contains("cd") || string.contains("pq") || string.contains("xy");
    }


}
