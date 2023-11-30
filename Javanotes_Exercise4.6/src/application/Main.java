package application;

/**
 * This program opens a window full of default black colour.  A "disturbance"
 * moves randomly around in the window, randomly adding 25 to green colour of each
 * square that it visits.  The program runs until the user closes the window.
 */
public class Main {

    final static int ROWS = 80;        // Number of rows in mosaic.
    final static int COLUMNS = 80;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 5; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.

    /**
     * The main program creates the window, and then moves the 
     * disturbances in a random walk around the window to add 25 to a green colour 
     * of each square as long as the window is open.
     */
    public static void main(String[] args) {
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        Mosaic.setUse3DEffect(false);
        currentRow = ROWS / 2;   // start at center of window
        currentColumn = COLUMNS / 2;
        while (true) {
        	brighterGreen(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(5);
        }
    }  // end main

    /**
     * Add 25 to a square's green colour to make its green colour brighter.
     * Precondition:   The specified rowNum and colNum are in the valid range
     *                 of row and column numbers.
     * Postcondition:  The square in the specified row and column has
     *                 been added 25 to its green colour.However, it will not make
     *                 a square green colour more than 255.
     * @param rowNum the row number of the square, counting rows down
     *      from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *      from 0 at the left
     */
    static void brighterGreen(int rowNum, int colNum) {
    	
    	if(Mosaic.getGreen(rowNum, colNum) < 255)
    	{
    		Mosaic.setColor(rowNum,colNum,0,Mosaic.getGreen(rowNum, colNum) + 25,0);
    	}
    	else
    	{
    		Mosaic.setColor(rowNum,colNum,0,255,0);
    	}
    }// end changeToRandomColor

    /**
     * Move the disturbance.
     * Precondition:   The global variables currentRow and currentColumn
     *                 are within the legal range of row and column numbers.
     * Postcondition:  currentRow or currentColumn is changed to one of the
     *                 neighboring positions in the grid -- up, down, left, or
     *                 right from the current position.  If this moves the
     *                 position outside of the grid, then it is moved to the
     *                 opposite edge of the grid.
     */
    static void randomMove() {
        int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
        directionNum = (int)(4*Math.random());
        switch (directionNum) {
            case 0 -> {  // move up 
                currentRow--;
                if (currentRow < 0)
                    currentRow = ROWS - 1;
            }
            case 1 -> {  // move right
                currentColumn++;
                if (currentColumn >= COLUMNS)
                    currentColumn = 0;
            } 
            case 2 -> {  // move down
                currentRow ++;
                if (currentRow >= ROWS)
                    currentRow = 0;
            }
            case 3 -> {  // move left  
                currentColumn--;
                if (currentColumn < 0)
                    currentColumn = COLUMNS - 1;
            } 
        }
    }  // end randomMove

} // end class RandomMosaicWalk2