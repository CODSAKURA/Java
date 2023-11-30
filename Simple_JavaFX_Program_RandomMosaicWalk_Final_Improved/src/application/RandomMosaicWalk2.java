package application;

public class RandomMosaicWalk2 {

    final static int ROWS = 20;        // Number of rows in mosaic.
    final static int COLUMNS = 30;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 15; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing the disturbance.
 
    public static void main(String[] args) {
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        fillWithRandomColors();
        currentRow = ROWS / 2;   // start at center of window
        currentColumn = COLUMNS / 2;
        while ( true ) {
            changeToRandomColor(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(5);
        }
    }  // end main

    static void fillWithRandomColors() {
         for (int row=0; row < ROWS; row++) {
            for (int column=0; column < COLUMNS; column++) {
                changeToRandomColor(row, column);  
            }
         }
    }  // end fillWithRandomColors
 
    static void changeToRandomColor(int rowNum, int colNum) {
         int red = (int)(256*Math.random());    // Choose random levels in range
         int green = (int)(256*Math.random());  //     0 to 255 for red, green, 
         int blue = (int)(256*Math.random());   //     and blue color components.
         Mosaic.setColor(rowNum,colNum,red,green,blue);  
     }  // end changeToRandomColor
 
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
               currentRow++;
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