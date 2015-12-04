package com.muddworks.adventOfCode.day3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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
 */
public class Day3 {

    private static Logger logger = LoggerFactory.getLogger(Day3.class);

    //going to abuse the fact that we don't really need to maintain a coordinate system, we just want to know
    //the coordinates that were visited.
    private Map<Coordinate, Integer> coordinateMap = new HashMap<>();
    private Coordinate startCoordinate = new Coordinate(0, 0);


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

        //populate the coordinate map with houses visited (and number of times each was visited)
        Coordinate previousCoordinate = startCoordinate;
        updateCoordinateMap(previousCoordinate);
        for(Character character : inputString.toCharArray()) {
            Coordinate newCoordinate = previousCoordinate.move(character);
            updateCoordinateMap(newCoordinate);
            previousCoordinate = newCoordinate;
        }

        //figure out how many houses were visited.
        return new Day3Result(coordinateMap.size());
    }

    private void updateCoordinateMap(Coordinate coordinate) {
        Integer temp = coordinateMap.get(coordinate);
        if(temp == null) {
            temp = 0;
        }
        coordinateMap.put(coordinate, temp+1);
    }
}
