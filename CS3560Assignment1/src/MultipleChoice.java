import java.util.ArrayList;

public class MultipleChoice extends Question {
	
    private ArrayList<String> choices;

    //creates the question with the answer choices to this question
    public MultipleChoice(String question, ArrayList<String> choice) {
        super(question);
        choices = choice;
    }

    //prints all the choices to the multiple choice answer question
    public void printChoices(ArrayList<String> answers) {
    	
    	int[] count = new int[choices.size()];
            
    	//loop around the amount of choices, if a student's answer is equal to the question choice,
    	//increment the counter of that choice
    	for(int i = 0; i < choices.size(); i++) {
    		for (int j = 0; j < answers.size(); j++) {
    			for(int k = 0; k < answers.get(j).length(); k++){
    				if (choices.get(i).charAt(0) == answers.get(j).charAt(k)) {
    					count[i]++;
                    }
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