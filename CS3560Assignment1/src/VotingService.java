import java.util.ArrayList;

public class VotingService {

    private ArrayList<Student> studentList;
    private ArrayList<Question> questionList;
    private ArrayList<String> answersList; 

    //create lists for participating students, questions, and answersList
    public VotingService() {
        studentList = new ArrayList<>();
        questionList = new ArrayList<>();
        answersList = new ArrayList<>();
    }

    //adds a new student into the studentList
    public void addStudent(){
        studentList.add(new Student());
    }
    
  //getter for retrieving students' IDs
    public String getStudentID(int i) {
        return studentList.get(i).getID();
    }

    //adds a single choice question into the questionList
    public void addSingleQuestion(String q, ArrayList<String> choices) {
        questionList.add(new SingleChoice(q, choices));
    }

    //adds a multiple choice question into the questionList
    public void addMultiQuestion(String q, ArrayList<String> choices) {
        questionList.add(new MultipleChoice(q, choices));
    }

    //prints the student's ID and answer choice
    public void submitAnswer(String id, String answer, int num){
        {
            System.out.println("Student ID: " + id + " submitted " + answer);
        }

        //prints when student resubmits their answer
        for(Student student: studentList) {
            if(student.getID().equals(id)) {
                if(student.getRepeat()) {
                    System.out.println("Student ID: " + id  + " resubmitted their answer");
                }
                student.setAnswer(answer);
                
                //sets boolean to true to indicate that the student has resubmitted their answer, to prevent recounts
                student.setRepeat(true);
            }
        }
    }

    //prints the results of the question (the students answersList
    public void printResults(int num){
    	for(Student student: studentList) {
            if(student.getAnswer() != null) {
            	
            	//adds the students answersList to the list of answersList
                answersList.add(student.getAnswer());
            }
        }
        questionList.get(num).printChoices(answersList);
    }

    //clears the student's answers assigned to them as well as the answers in answersList
    public void clear() {
        for(Student student: studentList) {
            student.setAnswer(null);
            
            //resets boolean for students' resubmissions
            student.setRepeat(false);
        }
        answersList.clear();
    }
}