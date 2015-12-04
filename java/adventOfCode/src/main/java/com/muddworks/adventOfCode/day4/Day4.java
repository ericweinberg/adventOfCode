package com.muddworks.adventOfCode.day4;

import com.muddworks.adventOfCode.day3.Day3Result;
import com.muddworks.adventOfCode.day3.Santa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.muddworks.adventOfCode.Utils.getInputString;

/**
 --- Day 4: The Ideal Stocking Stuffer ---

 Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the
 economically forward-thinking little girls and boys.

 To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes.
 The input to the MD5 hash is some secret key (your puzzle input, given below) followed by a number in decimal.
 To mine AdventCoins, you must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...)
 that produces such a hash.
 */
public class Day4 {

    private static Logger logger = LoggerFactory.getLogger(Day4.class);
    private int zeroPadding;
    public static void main(String[] args) {
        Day4 day4 = new Day4(6);
        Day4Result result = day4.mineBitCoins("yzbqklnj");
        logger.info("The key was {}, the lowest number was {}, and the hash was {}, ",
                result.getKey(), result.getNumber(), result.getMd5Hash());
    }

    public Day4(int zeroPadding) {
        this.zeroPadding = zeroPadding;
    }

    public Day4Result mineBitCoins(String key) {
        long start = System.currentTimeMillis();
        Long counter = 1L;
        String hash = "";
        String paddedString = getPaddedString(zeroPadding);
        while(!hash.startsWith(paddedString)) {

            hash = md5Calculator(key+counter);
            counter++;
        }

        Day4Result result = new Day4Result(key, counter-1, hash);

        logger.info("Done calculating in {}, result is {}", System.currentTimeMillis()-start, result);
        return result;
    }

    private String getPaddedString(int zeroPadding) {
        StringBuilder builder = new StringBuilder(zeroPadding);
        for(int i=0;i<zeroPadding;i++) {
            builder.append("0");
        }
        return builder.toString();
    }

    private String md5Calculator(String inputString) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] digest = m.digest(inputString.getBytes());
            String unpaddedString = new BigInteger(1, digest).toString(16);
            while(unpaddedString.length() < 32 ){
                unpaddedString = "0"+unpaddedString;
            }
            return unpaddedString;

        } catch (NoSuchAlgorithmException e) {
            logger.error("No reason this should be checked", e);
            throw new RuntimeException("Couldn't find the md5 message digest");
        }

    }
}
