package com.muddworks.adventOfCode.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.muddworks.adventOfCode.Utils.getInputString;

/**
 * Santa is trying to deliver presents in a large apartment building, but he can't find the right floor - the directions
 * he got are a little confusing. He starts on the ground floor (floor 0) and then follows the
 * instructions one character at a time.
 * <p>
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go
 * down one floor.
 * <p>
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 * <p>
 * For example:
 * <p>
 * (()) and ()() both result in floor 0.
 * ((( and (()(()( both result in floor 3.
 * ))((((( also results in floor 3.
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3.
 */
public class Day1 {

    private static final char UP_FLOOR_CHAR = '(';
    private static final char DOWN_FLOOR_CHAR = ')';
    private static Logger logger = LoggerFactory.getLogger(Day1.class);

    public static void main(String[] args) {
        String fileName = "Day1Input.txt";
        String inputString = getInputString(fileName);
        Day1 day1 = new Day1();
        Day1Result result = day1.solve(inputString);
        logger.info("Floor number is: {}\nfirst went to the basement at position: {} ", result.getFloorNumber(), result.getPosition());
    }

    public Day1Result solve(String inputString) {
        long floorNumber = 0;
        char[] charArray = inputString.toCharArray();
        int position = -1;
        for(int i=1;i<=charArray.length;i++) {
            char thisCharacter = charArray[i-1];
            if(thisCharacter == UP_FLOOR_CHAR) {
                floorNumber+=1;
            }
            else if (thisCharacter == DOWN_FLOOR_CHAR) {
                floorNumber-=1;
            }
            //only two options

            if(floorNumber < 0) {
               if(position < 0 ) {
                   position = i;
               }
            }
        }

        return new Day1Result(floorNumber, position);
    }



    static class Day1Result {
        private long floorNumber;
        private long position;

        public Day1Result(long floorNumber, long position) {
            this.floorNumber = floorNumber;
            this.position = position;
        }

        public long getFloorNumber() {
            return floorNumber;
        }

        public long getPosition() {
            return position;
        }
    }
}
