package application;

/**This program generate a mosaic window which rows' number is 20 
 * and columns' number is 20. Inside mosaic window, there are a lots of
 * squares which is size 10. And then, signing different colours to the squares.
 * Then, the program will randomly pick a square called A and change a square called B 
 * which is up to or next to or down to or right to square A in the same colour of square A.
 * Finally, the program will repeatedly do that step until whole mosaic window change into one colour until
 * the user close the program. This program is depended on non-standard class (Mosaic class and MosaicCanvas class)
 * */
public class Main {

    final static int ROWS = 20;        // Number of rows in mosaic.
    final static int COLUMNS = 20;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 10; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing the disturbance.
 
    /**The main subroutine will open a mosaic window with lots of squares inside the 
     * window and fill all the squares with random colours. And then repeatedly do this: randomly 
     * pick a square called A and change a square called B which is up to or next to or down to or 
     * right to square A in the same colour of square A. It will end when the user close the program.
     * */
    public static void main(String[] args) {
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        Mosaic.setUse3DEffect(false);
        fillWithRandomColors();
        currentRow = ROWS / 2;   // start at center of window
        currentColumn = COLUMNS / 2;      
        while(true)
        {
        	int randomRow = (int)(ROWS*Math.random()); //Random Value Range from: 0-19
        	int randomColumn = (int)(COLUMNS*Math.random()); //Random Value Range from: 0-19
        	changeNearSqaureToSameColor(randomRow, randomColumn);
        	Mosaic.delay(1);
        }          
    }  // end main

    /**The subroutine fill a square with a random colour.*/
    static void fillWithRandomColors() {
         for (int row=0; row < ROWS; row++) {
            for (int column=0; column < COLUMNS; column++) {
                int red = (int)(256*Math.random());    // Choose random levels in range
                int green = (int)(256*Math.random());  //     0 to 255 for red, green, 
                int blue = (int)(256*Math.random());   //     and blue color components.
                Mosaic.setColor(row,column,red,green,blue);   
            }
         }
    }  // end fillWithRandomColors
     
    /**This subroutine will change a square which is up to or next to or down to or 
     * right to that square this is decided by four cases to the same colour of
     * the current square which row number and column number is decided by parameter.
     * @param rowNum the row number of the current square
     * @param colNum the column number of the current square
     * */
    static void changeNearSqaureToSameColor(int rowNum, int colNum) {
    	
    	/*Getting the red value. green value and blue value of the current square*/
    	int currentSquareRed = Mosaic.getRed(rowNum, colNum);
    	int currentSquareGreen = Mosaic.getGreen(rowNum, colNum);
    	int currentSquareBlue = Mosaic.getBlue(rowNum, colNum);
    	
    	/*Getting a random case from case 0 to 3*/
    	int differentSituations = (int)(4*Math.random());   	
    	switch (differentSituations) {
    		
    		/*Moving Up Situation:
    		 * After deleting 1 value from current square row number which is rowNum, three cases need to deal with: 
    		 * 1. if it is on the row number 0, then change the colour of the BELOW square which row number is rowNum + 1.
    		 * 2. if it is less then row number 0, then change the colour of the square which row number is 19(ROWS - 1)
    		 * 3. if it is on the range of row numbers which is 0-19, then change the colour of the square which row number is deleted by 1
    		 * */
    		case 0 -> {	   			
    			if(rowNum - 1 == 0)
    				Mosaic.setColor(rowNum + 1, colNum, currentSquareRed, currentSquareGreen, currentSquareBlue);
    			else if(rowNum - 1 < 0)
    				Mosaic.setColor(ROWS - 1, colNum, currentSquareRed, currentSquareGreen, currentSquareBlue);
    			else
    				Mosaic.setColor(rowNum - 1, colNum, currentSquareRed, currentSquareGreen, currentSquareBlue);
    		}
    		
    		/*Moving Right Situation:
    		 * After adding 1 value from current square column number which is colNum, three cases need to deal with: 
    		 * 1. if it is on the column number 19, then change the colour of the LEFT square which column number is colNum - 1.
    		 * 2. if it is greater than row number 19, then change the colour of the square which column number is 0.
    		 * 3. if it is on the range of column numbers which is 0-19, then change the colour of the square which column number is added by 1
    		 * */   		
    		case 1 -> {	
    			if(colNum + 1 == COLUMNS)
    				Mosaic.setColor(rowNum, colNum - 1, currentSquareRed, currentSquareGreen, currentSquareBlue);
    			else if(colNum + 1 > COLUMNS)
    				Mosaic.setColor(rowNum, 0, currentSquareRed, currentSquareGreen, currentSquareBlue);
    			else
    				Mosaic.setColor(rowNum, colNum + 1, currentSquareRed, currentSquareGreen, currentSquareBlue);
    		}
    		
    		/*Moving Down Situation:
    		 * After adding 1 value from current square row number which is rowNum, three cases need to deal with: 
    		 * 1. if it is on the row number 19, then change the colour of the UP square which row number is rowNum - 1.
    		 * 2. if it is greater than row number 19, then change the colour of the square which row number is 0.
    		 * 3. if it is on the range of row numbers which is 0-19, then change the colour of the square which row number is added by 1
    		 * */
    		case 2 -> {	
    			if(rowNum + 1 == ROWS)
    				Mosaic.setColor(rowNum - 1, colNum, currentSquareRed, currentSquareGreen, currentSquareBlue);
    			else if(rowNum + 1 > ROWS)
    				Mosaic.setColor(0, colNum, currentSquareRed, currentSquareGreen, currentSquareBlue);
    			else
    				Mosaic.setColor(rowNum + 1, colNum, currentSquareRed, currentSquareGreen, currentSquareBlue);
    		}
    		
    		/*Moving left Situation:
    		 * After deleting 1 value from current square column number which is colNum, three cases need to deal with: 
    		 * 1. if it is on the column number 0, then change the colour of the RIGHT square which column number is colNum + 1.
    		 * 2. if it is less than column number 0, then change the colour of the square which column number is 19(COLUMNS - 1).
    		 * 3. if it is on the range of column numbers which is 0-19, then change the colour of the square which column number is deleted by 1
    		 * */  
    		case 3 -> {	
    			if(colNum - 1 == 0)
    				Mosaic.setColor(rowNum, colNum + 1, currentSquareRed, currentSquareGreen, currentSquareBlue);
    			else if(colNum - 1 < 0)
    				Mosaic.setColor(rowNum, COLUMNS - 1, currentSquareRed, currentSquareGreen, currentSquareBlue);   				
    			else
    				Mosaic.setColor(rowNum, colNum - 1, currentSquareRed, currentSquareGreen, currentSquareBlue);   		
    		}
    	}    	
     }  // end changeNearSqaureToSameColor
 
} // end class Main