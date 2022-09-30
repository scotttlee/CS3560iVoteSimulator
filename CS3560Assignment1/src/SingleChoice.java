import java.util.ArrayList;

public class SingleChoice extends Question {
	
    private ArrayList<String> choices;

    //creates the question with the answer choices to this question
    public SingleChoice(String question, ArrayList<String> o) {
        super(question);
        choices = o;
    }

    //prints all the choices to the single answer question
    public void printChoices(ArrayList<String> answers) {
    	
        int[] count = new int[choices.size()];
        
        //loop around the amount of choices, if a student's answer is equal to the question choice,
        //increment the counter of that choice
        for(int i = 0; i < choices.size(); i++) {
            for (String answer : answers) {
                if (choices.get(i).equals(answer)) {
                    count[i]++;
                }
            }
        }
        
        //loop around the amount of choices, printing out each choice with their corresponding count of students
        //who answered specific choice
        for(int i = 0; i < choices.size(); i++) {
            System.out.println(choices.get(i) + ": " + count[i] + "  ");
        }
    }
}