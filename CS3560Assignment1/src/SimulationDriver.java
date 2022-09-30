import java.util.ArrayList;
import java.util.Random;

public class SimulationDriver {

    public static void main(String[] args) {
    	
        //creates an ArrayList, holding the question's answer options A-F for a single choice question
        ArrayList<String> singleChoice = new ArrayList<>();
        singleChoice.add("A");
        singleChoice.add("B");
        singleChoice.add("C");
        singleChoice.add("D");
        singleChoice.add("E");
        singleChoice.add("F");

        //creates an ArrayList, holding the question's answer options A-F for a multiple choice question
        ArrayList<String> multiChoice = new ArrayList<>();
        multiChoice.add("A");
        multiChoice.add("B");
        multiChoice.add("C");
        multiChoice.add("D");
        multiChoice.add("E");
        multiChoice.add("F");
        
        //creates an ArrayList, holding the question's answer options A-B for true or false
        ArrayList<String> trueFalse = new ArrayList<>();
        trueFalse.add("A");
        trueFalse.add("B");

        //create VotingService implementation
        VotingService votingSim = new VotingService();

        //create an array of all multiple choice options
        String multipleChoice[] = new String [31];
        multipleChoice[0] = "A B";
        multipleChoice[1] = "A B C";
        multipleChoice[2] = "A B D";
        multipleChoice[3] = "A B D E";
        multipleChoice[4] = "A B D E F";
        multipleChoice[5] = "A C";
        multipleChoice[6] = "A C D";
        multipleChoice[7] = "A C D E";
        multipleChoice[8] = "A C D E F";
        multipleChoice[9] = "A D";
        multipleChoice[10] = "A D E";
        multipleChoice[11] = "A D E F";
        multipleChoice[12] = "A E";
        multipleChoice[13] = "A E F";
        multipleChoice[14] = "A F";
        multipleChoice[15] = "B C";
        multipleChoice[16] = "B C D";
        multipleChoice[17] = "B C D E";
        multipleChoice[18] = "B C D E F";
        multipleChoice[19] = "C D";
        multipleChoice[20] = "C D E";
        multipleChoice[21] = "C D E F";
        multipleChoice[22] = "D E";
        multipleChoice[23] = "D E F";
        multipleChoice[24] = "E F";
        multipleChoice[25] = "A";
        multipleChoice[26] = "B";
        multipleChoice[27] = "C";
        multipleChoice[28] = "D";
        multipleChoice[29] = "E";
        multipleChoice[30] = "F";
        
        //create amount of students participating
        for(int i = 0; i < 30; i++) {
        	votingSim.addStudent();
        }

        //randomize answers for each question category
        String[] arrS = Student.getRandomAnswers();
        String[] arrTF = Student.getRandomTFAnswers();

        //print single choice output
        System.out.println("-------------------Single Choice Question-------------------");
        
        //add a single choice question to generate answer choices given by singleChoice ArrayList
        votingSim.addSingleQuestion("-----------------------------------Results------------------------------------", singleChoice);
        
        //loop through each student, taking a temporary variable to hold the String value of their answer
        //and submit their answer to the voting service
        for(int i = 0; i < 30; i++) {
        	String temp = arrS[i];
        	votingSim.submitAnswer(votingSim.getStudentID(i), temp, 0);
        }
        
        //randomize amount of resubmissions
        Random randS1 = new Random();
        int numSingleResubmissions = randS1.nextInt(30);
        
        //loop through the amount of resubmissions, creating new random answers
        for(int n = 0; n < numSingleResubmissions; n++) {
        	Random randS2 = new Random();
        	int numStudents = randS2.nextInt(30);
        	
        	Random randS3 = new Random();
        	int randIndex = randS3.nextInt(30);
        	
        	String index = arrS[randIndex];
        	votingSim.submitAnswer(votingSim.getStudentID(numStudents), index, 0);
        }
        
        //print the results of the student's answers for the single choice question
        votingSim.printResults(0);

        //clears all of the student's answers, as well as the list of answers and repeated submissions
        votingSim.clear();
        
        //print multiple choice output
        System.out.println("------------------Multiple Choice Question------------------");
        
        //add a multiple choice question to generate answer choices given by multipleChoice ArrayList
        votingSim.addMultiQuestion("-----------------------------------Results------------------------------------", multiChoice);
        
        //loop through each student, taking a temporary variable to hold the String value of their answer
        //and submit their answer to the voting service
        for(int i = 0; i < 30; i++) {
        	Random rand = new Random();
        	int j = rand.nextInt(30);
        	
        	String temp = multipleChoice[j];
        	votingSim.submitAnswer(votingSim.getStudentID(i), temp, 1);
        	
        }
        
        //randomize amount of resubmissions
        Random randMC1 = new Random();
    	int numResubmissions = randMC1.nextInt(30);
    	
    	//loop through the amount of resubmissions, creating new random answers
        for(int i = 0; i < numResubmissions; i++) {
    		Random randMC2 = new Random();
    		int numStudents = randMC2.nextInt(30);
    		
    		Random randMC3 = new Random();
    		int randIndex = randMC3.nextInt(30);
    		
    		String index = multipleChoice[randIndex];
    		votingSim.submitAnswer(votingSim.getStudentID(numStudents), index, 1);
    	}
        
        //print the results of the student's answers for the multiple choice question
        votingSim.printResults(1);
        
        //clears all of the student's answers, as well as the list of answers and repeated submissions
        votingSim.clear();
        
        //print true or false output
        System.out.println("------------------True or False Question------------------");
        
        //add a single choice question to generate answer choices given by trueFalse ArrayList with A being true and B being false
        votingSim.addSingleQuestion("-----------------------------------Results------------------------------------", trueFalse);
        
        //loop through each student, taking a temporary variable to hold the String value of their answer
        //and submit their answer to the voting service
        for(int i = 0; i < 30; i++) {
        	String temp = arrTF[i];
        	votingSim.submitAnswer(votingSim.getStudentID(i), temp, 2);
        }
        
        //randomize amount of resubmissions
        Random randTF1 = new Random();
        int numTFResubmissions = randTF1.nextInt(30);
        
        //loop through the amount of resubmissions, creating new random answers
        for(int i = 0; i < numTFResubmissions; i++) {
        	Random randTF2 = new Random();
        	int numStudents = randTF2.nextInt(30);
        	
        	Random randTF3 = new Random();
        	int randIndex = randTF3.nextInt(30);
        	
        	String index = arrTF[randIndex];
        	votingSim.submitAnswer(votingSim.getStudentID(numStudents), index, 2);
        }
        
        //print the results of the student's answers for the true or false question
        votingSim.printResults(2);
    }
}