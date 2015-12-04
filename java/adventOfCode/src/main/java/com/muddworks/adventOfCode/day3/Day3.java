package com.muddworks.adventOfCode.day3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.muddworks.adventOfCode.Utils.getInputString;

/**
 --- Day 3: Perfectly Spherical Houses in a Vacuum ---

 Santa is delivering presents to an infinite two-dimensional grid of houses.

 He begins by delivering a present to the house at his starting location, and then an elf at the North Pole
 calls him via radio and tells him where to move next. Moves are always exactly one house to the
 north (^), south (v), east (>), or west (<). After each move, he delivers another present to the house at his new
 location.

 However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off,
 and Santa ends up visiting some houses more than once. How many houses receive at least one present?

 --- Part Two ---

 The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents
 with him.

 Santa and Robo-Santa start at the same location (delivering two presents to the same starting house),
 then take turns moving based on instructions from the elf, who is eggnoggedly reading
 from the same script as the previous year.

 This year, how many houses receive at least one present?
 */
public class Day3 {

    private static Logger logger = LoggerFactory.getLogger(Day3.class);

    public static void main(String[] args) {
        String fileName = "Day3Input.txt";
        String inputString = getInputString(fileName);
        Day3 day3 = new Day3();
        Day3Result result = day3.calculateHousesVisited(inputString);
        logger.info("The number of houses that receive one present is {}", result);
    }

    public Day3Result calculateHousesVisited(String inputString) {

        if(inputString == null || inputString.trim().isEmpty())
            return new Day3Result(-1);
        Santa santa = new Santa();
        Santa roboSanta = new Santa();

        for(int i=0; i<inputString.length();i++)  {
            char character = inputString.charAt(i);

            if(i%2 == 0) { //move santa
                santa.moveSanta(character);
            }
            else{
                roboSanta.moveSanta(character);
            }
        }
        //merge the two maps together. Since we don't care how many presents were delivered to each house,
        //we're not going merge the values
        santa.getCoordinateMap().putAll(roboSanta.getCoordinateMap());
        //figure out how many houses were visited.
        return new Day3Result(santa.getCoordinateMap().size());
    }

}
