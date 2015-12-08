package com.muddworks.adventOfCode.day6;

public class LightGrid {


    private final int[][] grid;

    public LightGrid(int maxX, int maxY) {
        grid = new int[maxX+1][maxY+1];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                grid[i][j] = 0;
            }
        }
    }

    public int getLitCount() {
        int count = 0;
        for (int[] aGrid : grid) {
            for (int anAGrid : aGrid) {
                if (anAGrid > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getTotalBrightness() {
        int totalBrightness = 0;
        for (int[] aGrid : grid) {
            for (int anAGrid : aGrid) {
                totalBrightness += anAGrid;
            }
        }
        return totalBrightness;
    }

    public void toggle(int startX, int startY, int stopX, int stopY) {
        for(int i=startX;i<=stopX;i++) {
            for(int j=startY;j<=stopY;j++) {
                grid[i][j] = grid[i][j]+2;
            }
        }
    }

    public void turnOff(int startX, int startY, int stopX, int stopY) {
        for(int i=startX;i<=stopX;i++) {
            for(int j=startY;j<=stopY;j++) {
                grid[i][j] = grid[i][j]-1;
                if(grid[i][j] < 0) {
                    grid[i][j] = 0;
                }
            }
        }
    }

    public void turnOn(int startX, int startY, int stopX, int stopY) {
        for(int i=startX;i<=stopX;i++) {
            for(int j=startY;j<=stopY;j++) {
                grid[i][j] = grid[i][j]+1;
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
