import java.util.UUID;
import java.util.Random;
import java.util.Arrays;

public class Student {
	
    private String studentID;
    private String answer;
    private boolean repeatSubmission;


    //generate random ID's and assign them whenever a Student is created using the UUID import
    //also checks whether or not the student previously answered or not
    public Student() {
        studentID = UUID.randomUUID().toString();
        repeatSubmission = false;
    }

    //setter for the Student's answer
    public void setAnswer(String a) {
        answer = a;
    }

    //getter for the Student's answer
    public String getAnswer() {
        return answer;
    }

    //getter for the Student's ID
    public String getID() {
        return studentID;
    }

    //setter to check if a Student previously answered or not
    public void setRepeat(boolean h) {
    	repeatSubmission = h;
    }

    //getter to check if a Student previously answered or not
    public boolean getRepeat() {
        return repeatSubmission;
    }
    
    //create an array of random letters from A-F to assign to a random student out of 30 students
    //for single choice questions
    public static String[] getRandomAnswers() {
    	//create an array of size 30 to hold each answer A-F
        String answerArray[] = new String[30];
        
        //loop entire array assigning each answer to an index
        for(int i = 0; i < answerArray.length; i++) {
            Random rand = new Random();

            char randomizedChar = (char) (rand.nextInt(6) + 'A');
            String character = String.valueOf(randomizedChar);
            answerArray[i] = character;
        }
        return answerArray;
    }
    
    //create an array of random letters from A-F to assign to a random student out of 30 students 
    //for multiple choice questions
    public static String[] getRandomMCAnswers() {
    	//create an array of size 30 to hold each answer A-F
    	String answerArray[] = new String[30];
    	
    	//loop entire array assigning each answer to an index
        for(int i = 0; i < answerArray.length; i++) {
            Random rand = new Random();
            
            char randomizedChar = (char) (rand.nextInt(6) + 'A');
            String character = String.valueOf(randomizedChar);
            
            answerArray[i] = character;
        }
        return answerArray;
    }
    
    //create an array of random letters from A-B to assign to a random student out of 30 students 
    //for true or false questions (A = true ; B = false)
    public static String[] getRandomTFAnswers() {
    	//create an array of size 30 to hold each answer A-B
    	String answerArray[] = new String[30];
    	
    	//loop entire array assigning each answer to an index
        for(int i = 0; i < answerArray.length; i++) {
            Random rand = new Random();

            char randomizedChar = (char) (rand.nextInt(2) + 'A');
            String character = String.valueOf(randomizedChar);
            
            answerArray[i] = character;
        }
        return answerArray;
    }
}