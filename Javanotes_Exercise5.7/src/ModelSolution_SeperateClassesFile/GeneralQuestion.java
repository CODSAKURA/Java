package ModelSolution_SeperateClassesFile;

public class GeneralQuestion implements IntQuestion{
    private String question;
    private int answer;
    
    public GeneralQuestion( String question, int answer ) {
        this.question = question;
        this.answer = answer;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public int getCorrectAnswer() {
        return answer;
    }
}
