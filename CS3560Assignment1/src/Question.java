import java.util.ArrayList;

public abstract class Question{
    private String question;

    public Question() {}

    //set question
    public Question(String q) {
        question = q;
    }
    
    //get question
    public String getQuestion() {
        return question;
    }

    //method to print all choices of the given question
    public abstract void printChoices(ArrayList<String> answers);
}