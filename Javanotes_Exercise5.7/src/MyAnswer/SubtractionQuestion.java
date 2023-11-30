package MyAnswer;

public class SubtractionQuestion implements IntQuestion{
    
	private int a, b, c, d;  // The numbers in the problem.

    public SubtractionQuestion() { // constructor
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
        
        if(a < b)
        {
        	c = b;
        	d = a;
        }
        else
        {
        	c = a;
        	d = b;
        }
    }

    public String getQuestion() {
        return "What is " + c + " - " + d + " ?";
    }

    public int getCorrectAnswer() {
        return c - d;
    }
}
