package com.muddworks.adventOfCode.day6;

import java.util.Arrays;

public class LightGrid {


    private final boolean[][] grid;

    public LightGrid(int maxX, int maxY) {
        grid = new boolean[maxX+1][maxY+1];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                grid[i][j] = false;
            }
        }
    }

    public int getLitCount() {
        int count = 0;
        for (boolean[] aGrid : grid) {
            for (boolean anAGrid : aGrid) {
                if (anAGrid) {
                    count++;
                }
            }
        }
        return count;
    }

    public void toggle(int startX, int startY, int stopX, int stopY) {
        for(int i=startX;i<=stopX;i++) {
            for(int j=startY;j<=stopY;j++) {
                grid[i][j] = !grid[i][j];
            }
        }
    }

    public void turnOff(int startX, int startY, int stopX, int stopY) {
        for(int i=startX;i<=stopX;i++) {
            for(int j=startY;j<=stopY;j++) {
                grid[i][j] = false;
            }
        }
    }

    public void turnOn(int startX, int startY, int stopX, int stopY) {
        for(int i=startX;i<=stopX;i++) {
            for(int j=startY;j<=stopY;j++) {
                grid[i][j] = true;
            }
        }
    }

    public void runInstruction(InstructionDetail instructionDetails) {
        if(instructionDetails.getInstruction().equalsIgnoreCase("turn off")) {
            turnOff(instructionDetails.getStartX(), instructionDetails.getStartY(),
                    instructionDetails.getStopX(), instructionDetails.getStopY());
        } else if(instructionDetails.getInstruction().equalsIgnoreCase("turn on")) {
            turnOn(instructionDetails.getStartX(), instructionDetails.getStartY(),
                    instructionDetails.getStopX(), instructionDetails.getStopY());
        }
        else if(instructionDetails.getInstruction().equalsIgnoreCase("toggle")) {
            toggle(instructionDetails.getStartX(), instructionDetails.getStartY(),
                    instructionDetails.getStopX(), instructionDetails.getStopY());
        }
    }
}
