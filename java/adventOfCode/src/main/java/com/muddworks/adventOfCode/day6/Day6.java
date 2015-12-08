package com.muddworks.adventOfCode.day6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static com.muddworks.adventOfCode.Utils.getInputString;

/**
 --- Day 6: Probably a Fire Hazard ---

 Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to deploy one million lights in a 1000x1000 grid.

 Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the ideal lighting configuration.

 Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.

 To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.
 */
public class Day6 {

    private static Logger logger = LoggerFactory.getLogger(Day6.class);

    public static void main(String[] args) {
        String fileName = "Day6Input.txt";
        String inputString = getInputString(fileName);
        Day6 day6 = new Day6();
        Day6Result result = day6.runInstructions(Arrays.asList(inputString.split("\r\n")));
        logger.info("The number of lit lights is {} and the number of turned out lights is {} ",
                result.getLitLights(), result.getUnlitLights());
    }

    public Day6Result runInstructions(List<String> inputStrings) {
        LightGrid grid = new LightGrid(999,999);

        for(String input : inputStrings) {
            InstructionDetail instructionDetails = parseInstructions(input);
            grid.runInstruction(instructionDetails);
        }

        return new Day6Result( grid.getLitCount() );
    }

    private InstructionDetail parseInstructions(String input) {
        String[] halves = input.split("through");
        String[] stopNumbers = halves[1].trim().split(",");
        String[] firstHalf = halves[0].split(" ");
        String[] startNumber = firstHalf[firstHalf.length-1].split(",");
        String instruction ="";
        for(int i=0;i<firstHalf.length-1;i++) {
            instruction+=" "+firstHalf[i];
        }

        InstructionDetail detail = new InstructionDetail();
        detail.setStopX(Integer.parseInt(stopNumbers[0]));
        detail.setStopY(Integer.parseInt(stopNumbers[1]));
        detail.setStartX(Integer.parseInt(startNumber[0]));
        detail.setStartY(Integer.parseInt(startNumber[1]));
        detail.setInstruction(instruction.trim());
        return detail;
    }


}
