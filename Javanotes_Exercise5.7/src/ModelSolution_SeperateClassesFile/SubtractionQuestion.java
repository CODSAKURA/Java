package ModelSolution_SeperateClassesFile;

public class SubtractionQuestion implements IntQuestion{
    
	private int a, b;  // The numbers in the problem.
    public SubtractionQuestion() { // constructor
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
        if (b > a) { // swap a and b so answer won't be negative
           int temp = a;
           a = b;
           b = temp;
        }
    }
    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";
    }
    public int getCorrectAnswer() {
        return a - b;
    }
}
