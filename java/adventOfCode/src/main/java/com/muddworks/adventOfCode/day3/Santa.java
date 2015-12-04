package com.muddworks.adventOfCode.day3;

import java.util.HashMap;
import java.util.Map;

public class Santa {

    //going to abuse the fact that we don't really need to maintain a coordinate system, we just want to know
    //the coordinates that were visited.

    private Coordinate currentCoordinate;
    private Map<Coordinate, Integer> coordinateMap = new HashMap<>();

    public Santa() {
        this.currentCoordinate = new Coordinate(0,0);
        updateCoordinateMap(currentCoordinate);
    }

    public void moveSanta(char character) {
        //populate the coordinate map with houses visited (and number of times each was visited)
        Coordinate newCoordinate = currentCoordinate.move(character);
        updateCoordinateMap(newCoordinate);
        currentCoordinate = newCoordinate;
    }
    private void updateCoordinateMap(Coordinate coordinate) {
        Integer temp = coordinateMap.get(coordinate);
        if(temp == null) {
            temp = 0;
        }
        coordinateMap.put(coordinate, temp + 1);
    }

    public Map<Coordinate, Integer> getCoordinateMap() {
        return coordinateMap;
    }
}
