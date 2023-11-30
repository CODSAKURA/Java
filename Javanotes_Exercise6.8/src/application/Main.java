package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**This class will generate a GUI for user to input the text and then
 * output the text's number of lines, words and chars at the bottom of 
 * the GUI by pressing the center's button. After outputting the data,
 * the program will highlight all the text in text area which will allow
 * user to replace the text easily. Noticed that the number of lines are
 * the lines that contained characters. If the line does not contain 
 * character, it will not be counted. If there is a space in front of a string 
 * and a space in the end of the string, that string will be counted as word. 
 * Others, "that'" will be counted as a word, "'s"will be count as a word and
 * "that's" will be count as two words, above's measurement are used when facing 
 * the other's non-letter character. 
 * */
public class Main extends Application {
	private Label lineLabel, wordLabel, charLabel;	//Changing labels depending on the text in text field.
	private int numberOfLines, numberOfWords, numberOfChars;	//Recording the data of numbers of lines, words and characters
	
	/**The main method use to launch the program.
	 * @param args the command line arguments.
	 * */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**This method generate the default outlay of the window and then apply
	 * the changes when user press the button. If the user presses the button
	 * after writing the content on text area, the program will output the results
	 * by changing the content of the labels.
	 * @param stage the Stage object that represented the current stage.
	 * */
	public void start(Stage stage) {
		/*Creating the text area for user input*/
		TextArea textArea = new TextArea();
		textArea.setPrefHeight(225);
		textArea.setPrefWidth(365);
		
		/*Creating the button*/
		Button buttonForProcessText = new Button("Process the Text");
		buttonForProcessText.setDefaultButton(true);
		buttonForProcessText.setOnMousePressed(evt -> {
			calculateLines(textArea.getText());
			calculateWordsAndChars(textArea.getText());
			draw();
			textArea.requestFocus();
			textArea.selectAll();
			numberOfLines = 0;
			numberOfWords = 0;
			numberOfChars = 0;
		});
		
		/*Creating Default Label*/
		lineLabel = makeLabel("  Number of lines(Contain Words): " + numberOfLines);
		wordLabel = makeLabel("  Number of words: " + numberOfWords);
		charLabel = makeLabel("  Number of chars: " + numberOfChars);
		
		/*Container for those labels*/
		VBox containerForLabel = new VBox(lineLabel,wordLabel,charLabel);
		containerForLabel.setSpacing(3);
		
		/*Using BorderPane to contain all the nodes*/
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #000099; -fx-padding: 3px");
		root.setTop(textArea);
		root.setCenter(buttonForProcessText);
		BorderPane.setMargin(root.getCenter(), new Insets(3,0,3,0));
		root.setBottom(containerForLabel);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Line/Word/Char Counter");
		stage.show();
	}
	
	/**This method will set the general outlay of all label. It will
	 * create different labels depending on the parameter and return that
	 * label.
	 * @param labelContent the content of the label.
	 * @return label the label object that label variable will refer to.
	 * */
	private Label makeLabel(String labelContent) {
		Label label = new Label(labelContent);
		label.setPrefSize(365,30);
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		label.setStyle("-fx-background-color:white; -fx-font-weight: bold");
		return label;
	}
	
	/**This method will calculate the lines that parameter has contained and
	 * assign the result to the global variable called numberOfLines.
	 * Noticed that the number of lines are the lines that contained 
	 * characters. If the line does not contain character, it will not 
	 * be counted.
	 * @param input the input String that will be tested.
	 * */
	private void calculateLines(String input) {
		/*As we will add +1(last line) at the end of the function,
		 *we can not can not call this function even if the user has not inputed anything.
		 *So we need to check the input at the beginning.
		 **/
		if(input.isEmpty())		
		{
			return;
		}
		input = input.strip();
		int j = 0;
		for(int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == '\n' )
			{
				for(int w = 0; w < input.substring(j, i).length(); w++)
				{
					if(Character.isLetter(input.substring(j, i).charAt(w))) {
						numberOfLines++;
						break;
					}
				}
				j = i;
			}				
		}
		numberOfLines++;	//Because the function can not count the last line as last line does not have "\n" due to strip function
							//Therefore, we have to add +1(last line) at the end.
	}
	
	/**This method will calculate the number of Words and characters in a string and
	 * assign those results to the global variables called numberOfChars and numberOfWords.
	 * Noticed that: For words count, If there is a space in front of a string and a space 
	 * in the end of the string, that string will be counted as word. When facing non-letter 
	 * character, "that'" will be counted as a word, "'s"will be count as a word and "that's" 
	 * will be count as two words, above's measurement are used when facing the other's non-letter 
	 * character. 
	 * @param input the String object that will be tested
	 * */
	private void calculateWordsAndChars(String input) {
		if(input.isEmpty())
		{
			return;
		}
		input = input.strip();
		boolean didCR = true;	// Set to true if the previous output was a carriage return.
	       
		for ( int i = 0;  i < input.length();  i++ ) {
			char ch = input.charAt(i);
			if ( Character.isLetter(ch) ) {
				numberOfChars++;		
				didCR = false;
			}
			else {
				if ( didCR == false ) {
					numberOfWords++;
					didCR = true;
				}
			}
		}
		numberOfWords++;		//As there is no character behind the last word, we can not make it to the else statement.
								//So, it will not count the last word as there is no non-letter character existed behind 
								//the last character(such as '\n'). Therefore, we have to add 1 to the words' count.
		
								//By the way, the character counter(numberOfChars) will not happen the situation that 
								//counter for word and line has happened. Because the last character will not be effected 
								//by the existence of the non-letter character. Mostly, '\n' character.
	}
	
	/**This method will apply the changes to the labels by using setText
	 * function.
	 * */
	private void draw() {
		lineLabel.setText("  Number of lines(Contain Words): " + numberOfLines);
		wordLabel.setText("  Number of words: " + numberOfWords);
		charLabel.setText("  Number of chars: " + numberOfChars);
	}
}
