package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 * MosaicDraw is a JavaFX Application whose scene includes a MosaicCanvas and a
 * MenuBar.  The mosaic is made up of rows and columns of squares.  The user 
 * can click-and-drag the mouse to color the squares.  A menu bar with some 
 * options is shown at the top of the window. 
 * 
 * Note that this class depends on MosaicCanvas.java.
 */
public class MosaicDraw extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    //----------------------------------------------------------------------------------
    
    private final static int ROWS = 40;        // rows in the mosaic
    private final static int COLUMNS = 40;     // columns in the mosaic
    private final static int SQUARE_SIZE = 15; // size of each square

    private final static int DRAW_TOOL = 0;      // possible values for currentTool
    private final static int ERASE_TOOL = 1;
    private final static int DRAW_3x3_TOOL = 2;
    private final static int ERASE_3x3_TOOL = 3;

    private int currentTool;  // The current tool; this is changed when the
                              // user makes a selection from the Tools menu.

    private int currentRed, currentGreen, currentBlue;  // The current color.
                    // These change when the user selects from the Color menu
                    // They are used whenever a square is painted.  (NOTE:
                    // I am using three integers to represent the color, rather
                    // than a variable of type Color, to make it easier to add
                    // in the random color variation.)

    private MosaicCanvas mosaic;     // The panel where the drawing takes place.

    private CheckMenuItem useRandomness;  // If selected, then a small random variation is
                                          // added to the current color whenever a 
                                          // square is painted.  This menu item is added
                                          // to the Control menu in createMenuBar().
    
    private CheckMenuItem useSymmetry;  // If selected, then whenever a square is painted
                                        // or erased, the three symmetrical squares
                                        // obtained by reflecting the square vertically
                                        // and horizontally are also painted or erased.
                                        // This menu item is added to the Control menu
                                        // in createMenuBar().

    /**
     * Create the canvas and menu bar and add them to the window.
     * Set up mouse handling on the canvas.
     */
    public void start(Stage stage) {
        
        mosaic = new MosaicCanvas(ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE);		//Creating a Mosaic Canvas with 40 rows and 40 columns.
        																		//Each point like(Row0, Column0) the square size is 15*15.
        mosaic.setOnMousePressed( e -> doMouse(e));
        mosaic.setOnMouseDragged( e -> doMouse(e));
        mosaic.clear();
        currentRed = 255;
        currentGreen = 0;
        currentBlue = 0;

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        
        root.setCenter(mosaic);
        root.setTop( createMenuBar() );
        
        stage.setTitle("Mosaic Draw");
        stage.setScene(scene);
        stage.setResizable(false);
        
        stage.setX(150);  // Show this program window on your screen position(150,100).
        stage.setY(100);
        
        stage.show();
    }    
    

    /**
     * Creates and returns a menu bar that contains options that affect the
     * drawing that is done on the MosaicCanvas.
     */
    private MenuBar createMenuBar() {
        
        MenuBar menuBar = new MenuBar();

        /*Creating the Control Menu*/
        Menu controlMenu = new Menu("Control");       
        
        /*Creating and Adding a menuItem in Control menu which is Fill*/
        MenuItem fill = new MenuItem("Fill");
        controlMenu.getItems().add(fill);
        fill.setOnAction(e -> doFill());
        
        /*Creating and Adding a menuItem in Control menu which is Clear*/
        MenuItem clear = new MenuItem("Clear");
        controlMenu.getItems().add(clear);
        clear.setOnAction(e -> mosaic.clear());
        
        /*Creating and adding a separator in Control Menu*/
        controlMenu.getItems().add(new SeparatorMenuItem());
        
        /*Creating and adding three menuItems in Control menu which are Use Randomness; Use Symmetry; Use Grouting.
         *
         *For Use Randomness and Use Symmetry, there is not event handler for each one of them, because the things you have drawn on the
         *canvas before will not be affected. They will still be there as what they were before. Therefore, only using isSelected method 
         *rather than even handler to make these changes is faster.
         *
         *For Use Grouting, Inside the doUseGrouting method, this program used a method called setGroutingColor in MosaicCanvas class that 
         *can achieve this. However, the declaration of this method in MosaicCanvas has a line of code called forceredraw() which will cause 
         *the redraw happen.Therefore, the previous drawing on the screen will be affected. So, we have to add an event listener to it.
         */
        useRandomness = new CheckMenuItem("Use Randomness");
        useRandomness.setSelected(true);	//Making the default selection of use Randomness is true.
        useSymmetry = new CheckMenuItem("Use Symmetry");
        CheckMenuItem useGrouting = new CheckMenuItem("Use Grouting");
        mosaic.setGroutingColor(null);  // turn off grouting to match state of menu item
        useGrouting.setOnAction( e -> doUseGrouting(useGrouting.isSelected()));
        controlMenu.getItems().addAll(useRandomness, useSymmetry, useGrouting);
        
        /*
         *For Color and Tools menu, both using the toggle group and radio menu item. It shows two ways of adding the event handle. Both ways are acceptable.
         * 
         *Color menu: adding an event handler for each color.
         *Tools menu: adding an event handler on toggle group.
         */
        Menu colorMenu = new Menu("Color");        
        String[] colorNames = { "Red", "Green", "Blue", "Cyan", "Magenta", "Yellow", "Gray" };
        ToggleGroup colorGroup = new ToggleGroup();
        for (int i = 0; i < colorNames.length; i++) {
            String colorName = colorNames[i];
            RadioMenuItem item = new RadioMenuItem(colorName);
            item.setOnAction( e -> doColorChoice(colorName) );
            item.setToggleGroup(colorGroup);
            colorMenu.getItems().add(item);
            if (i == 0)
                item.setSelected(true);
        }
        
        Menu toolMenu = new Menu("Tools");
        ToggleGroup toolGroup = new ToggleGroup();
        toolGroup.selectedToggleProperty().addListener( e -> doToolChoice(toolGroup.getSelectedToggle()) );
        addRadioMenuItem(toolMenu,"Draw",toolGroup, true);
        addRadioMenuItem(toolMenu,"Erase",toolGroup, false);
        addRadioMenuItem(toolMenu,"Draw 3x3",toolGroup, false);
        addRadioMenuItem(toolMenu,"Erase 3x3",toolGroup, false);
        
        menuBar.getMenus().addAll(controlMenu,colorMenu,toolMenu);
        return menuBar;
        
    }  // end createMenuBar()

    
    /**
     * Utility method to create a radio menu item, add it to a ToggleGroup, and add it to a menu.
     */
    private void addRadioMenuItem(Menu menu, String command, ToggleGroup group, boolean selected) {
        RadioMenuItem menuItem = new RadioMenuItem(command);
        menuItem.setToggleGroup(group);
        menu.getItems().add(menuItem);
        if (selected) {
            menuItem.setSelected(true);
        }
    }

    
    /**
     * Changes the current drawing color when the user clicks one of the
     * colors in the Color menu.  A handler to call this method is added
     * to each color menu item in the createMenuBar() method.  (Note that
     * this method will be called even if the user picks the color that
     * is already selected, but that is harmless.)
     */
    private void doColorChoice( String colorName ) {
        if (colorName.equals("Red")) { 
            currentRed = 255;
            currentGreen = 0;
            currentBlue = 0;
        }
        else if (colorName.equals("Green")) {
            currentRed = 0;
            currentGreen = 180;
            currentBlue = 0;
        }
        else if (colorName.equals("Blue")) {
            currentRed = 0;
            currentGreen = 0;
            currentBlue = 255;
        }
        else if (colorName.equals("Cyan")) {
            currentRed = 0;
            currentGreen = 255;
            currentBlue = 255;
        }
        else if (colorName.equals("Magenta")) {
            currentRed = 255;
            currentGreen = 0;
            currentBlue = 255;
        }
        else if (colorName.equals("Yellow")) {
            currentRed = 255;
            currentGreen = 255;
            currentBlue = 0;
        }
        else if (colorName.equals("Gray")) {
            currentRed = 180;
            currentGreen = 180;
            currentBlue = 180;
        }
    }

    
    /**
     * This method is called when the selected item in the
     * Tools menu is changed for any reason.  The handler
     * is added to the ToggleGroup that controls the menu
     * items.  Apparently, it is called twice when the user
     * changes the selection, once when the current item is
     * deselected (with parameter value null) and once
     * when the new item is selected.  The current tool is only
     * changed when the parameter is non-null.
     */
    private void doToolChoice( Toggle toggle ) {
    	
    	/*If statement is for the user deselected. However, I have check this case by adding the print statement inside,
    	 *the situation does not happen.So, this if statement is in case the user deselected.
    	 */
    	if (toggle == null)
            return;
        
    	String toolName = ((RadioMenuItem)toggle).getText();
        if (toolName.equals("Draw"))
            currentTool = DRAW_TOOL;
        else if (toolName.equals("Erase"))
            currentTool = ERASE_TOOL;
        else if (toolName.equals("Draw 3x3"))
            currentTool = DRAW_3x3_TOOL;
        else if (toolName.equals("Erase 3x3"))
            currentTool = ERASE_3x3_TOOL;
    }
    
    
    /**
     * Apply the current tool to the square that contains the mouse pointer.
     * This method is called in response to both MousePressed and MouseDragged
     * event.  The mouse handlers that called it are added to the mosaic
     * in the start() method.
     */
    private void doMouse(MouseEvent evt) {
        int row = mosaic.yCoordToRowNumber((int)evt.getY());
        int col = mosaic.xCoordToColumnNumber((int)evt.getX());
        if (row >= 0 && row < mosaic.getRowCount() && col >= 0 && col < mosaic.getColumnCount()) {
               // (the test in this if statement will be false if the user drags the
               //  mouse outside the canvas after pressing the mouse on the canvas)
            applyCurrentTool(row,col);
        }
    }

  
    /**
     * Erases the square in a specified row and column.  If symmetry is turned
     * on, the three symmetrical squares are also erased.
     */
    private void eraseSquare(int row, int col) {
        mosaic.setColor(row, col, null); //null will be set that square to default color
        
        if (useSymmetry.isSelected()) {
        	/*
        	 * Why -1: Because the row and column start from 0. So, in order to get actual row and column 
        	 * number you need to -1 from getRowCount() and gerColumnCount().
        	 */
            mosaic.setColor(mosaic.getRowCount() - 1 - row, col, null);		//The left bottom corner 
            mosaic.setColor(row, mosaic.getColumnCount() - 1 - col, null);		//The right top corner
            mosaic.setColor(mosaic.getRowCount() - 1 - row, mosaic.getColumnCount() - 1 - col, null);	//The right bottom corner
        }
    }
    

    /**
     * Applies the current drawing color to the square in a given row and column.
     * If randomness is turned on, a random amount is added to the red, green, and 
     * blue components of the drawing color.  If symmetry is turned on, then the
     * three symmetrical squares are also painted.
     */
    private void paintSquare(int row, int col) {
        int r = currentRed;
        int g = currentGreen;
        int b = currentBlue;
        
        /*
         * If value is less than 60, then change this value to a random number from 0-60.
         * 
         * If value is greater than 195, then change this value to a random number from 195-255.
         * 
         * If value is between 60-195 or equal 60/195, then change this value to 30-225.
         * 
         * Use Randomness only make a small changes to a color. So if a color r is very big, g is middle, b is small, then this
         * if statement can make sure each component's value make only a small changes.
         */
        if (useRandomness.isSelected()) {
            if (r < 60)
                r = (int)(60*Math.random());
            else if (r > 255-60)
                r = 255 - (int)(60*Math.random());
            else
                r = r + (int)(60*Math.random() - 30);
            if (g < 60)
                g = (int)(60*Math.random());
            else if (g > 255-60)
                g = 255 - (int)(60*Math.random());
            else
                g = g + (int)(60*Math.random() - 30);
            if (b < 60)
                b = (int)(60*Math.random());
            else if (b > 255-60)
                b = 255 - (int)(60*Math.random());
            else
                b = b + (int)(60*Math.random() - 30);
        }
        Color color = Color.rgb(r,g,b);
        mosaic.setColor(row, col, color);
        if (useSymmetry.isSelected()) {
            mosaic.setColor(mosaic.getRowCount() - 1 - row, col, color);	//The left bottom corner
            mosaic.setColor(row, mosaic.getColumnCount() - 1 - col, color);		//The right top corner
            mosaic.setColor(mosaic.getRowCount() - 1 - row, mosaic.getColumnCount() - 1 - col, color);	//The right bottom corner
        }
    }

    
    /**
     * This method is called when the user clicks the mouse or drags it over the
     * square in the specified row and column.  It takes the appropriate action,
     * depending on which drawing tool is currently selected.
     */
    private void applyCurrentTool(int row, int col) {
        int minrow, mincol, maxrow, maxcol;
        switch (currentTool) {
        case DRAW_TOOL:
            paintSquare(row,col);
            break;
        case ERASE_TOOL:
            eraseSquare(row,col);
            break;
        case DRAW_3x3_TOOL:       	
        	/*
        	 *This part is to draw a 3*3 square which is around the small square that the mouse has clicked.  
        	 *
        	 *minrow and mincol are finding the left top corner point of 3*3 square. Math.max method is finding the maximum number between two numbers.
        	 *maxrow and maxcol are finding the right bottom corner point of 3*3 square. Math.min method is finding the minimum number between two numbers.
        	 *
        	 *For example, the point(2,2), (minrow,mincol) will be (1,1); (maxrow,maxcol) will be (3,3).
        	 *Therefore, a 3*3 square is created around the point(2,2): (1,1) (1,2), (1,3) 
        	 *															(2,1) (2,2), (2,3) 
        	 *															(3,1) (3,2), (3,3)
        	 *
        	 *CAUTION: Math.max and Math.min also consider the extreme situations. If the left top corner point of 3*3 square is less than 0 which is outside the screen, 
        	 *Math.max will set the row and column to 0; If the right bottom corner point of 3*3 square is more than getRowCount -1 and getColumnCount -1, Math.min will
        	 *set the row and column to getRowCount -1 and getColumnCount -1.
        	 */
            minrow = Math.max(0, row-1);
            mincol = Math.max(0, col-1);            
            maxrow = Math.min(mosaic.getRowCount()-1, row+1);            
            maxcol = Math.min(mosaic.getColumnCount()-1, col+1);
            
            for (int i = minrow; i <= maxrow; i++)
                for (int j = mincol; j <= maxcol; j++)
                    paintSquare(i,j);
            break;
        case ERASE_3x3_TOOL:
            minrow = Math.max(0, row-1);
            mincol = Math.max(0, col-1);
            maxrow = Math.min(mosaic.getRowCount()-1, row+1);            
            maxcol = Math.min(mosaic.getColumnCount()-1, col+1);
            for (int i = minrow; i <= maxrow; i++)
                for (int j = mincol; j <= maxcol; j++)
                    eraseSquare(i,j);
            break;
        }
    }
        
    
    /**
     * This method is called when the user clicks the "Use Grouting"
     * command in the Control menu.  The parameter tells whether
     * the CheckMenuItem is checked.  The handler that calls this
     * method is added to the menu item in the createMenuBar() method.
     */
    public void doUseGrouting(boolean use) {
        if (use)
            mosaic.setGroutingColor(Color.GRAY);
        else
            mosaic.setGroutingColor(null);  // Turns grouting off.
    }
    
    
    /**
     * Fill the mosaic with squares of the current drawing color.
     * (If symmetry is on, each square actually has its color set
     * four times, so efficiency could be improved!)
     */
    private void doFill() {
        /*
         *Why turn off setAutopaint method because this lets all the squares be draws without inserting any delays; 
         *In MosaicCanvas class, the default autopaint is on. When it is on, there is a one millisecond delay for 
         *each square drawn.However, false argument will let autopaint false.
         */ 
    	mosaic.setAutopaint(false); 
    	
    	/*
    	 *After setting autopaint to false, the following code will be read. However, following codes will only make the changes on the canvas.
    	 *the changes will not show on the screen. Because as autopaint is false, the drawing system of the MosaicCanvas will not 
    	 *working. For example, drawSquare(row, column) method in MosaicCanvas class. 
 
    	 */
        for (int row = 0; row < mosaic.getRowCount(); row++)
            for (int col = 0; col < mosaic.getColumnCount(); col++)
                paintSquare(row,col);
        
        /*
         *Therefore, we need to set autopaint to true, so that we can use forceRedraw method in MosaicCanvas class which can show all the changes that 
         *have been made to the mosaic as there is an if statement says if autopaint is true then do forceRedraw method and also making the drawing 
         *system working. 
         *
         *It is correct that we can directly call forceRedraw() method to show all the changes. However, as the autopaint is still false, the drawing system
         *will not working which means any changes will not be shown. It is so complex to call forceRedraw() many times in this program once user have made changes .
         *Therefore, setAutopaint will be a faster way of doing this.
         */
        mosaic.setAutopaint(true);
        System.out.print(mosaic.xCoordToColumnNumber(0.0));
    }

    

} // end MosaicDraw