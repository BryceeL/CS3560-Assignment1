// The Voting Service can be first configured with a given question type and candidate
// answers. Then, it can start accepting submissions from students. The important thing to
// keep in mind about accepting submissions is that each student can only submit one
// answer. If multiple submissions are received from the same student, only the last
// submission will be counted.
// 4) The Voting Service can also output the statistics of the submission results. You don’t
// have to use the graphical interface. Simply use the standard output (System.out) to
// print out the count for each answer. For example, “A : 5, B : 12”, or “1. Right :
// 15, 2. Wrong : 20”. Feel free to customize the format for your output
import java.util.Set;
import java.util.UUID;

public class VotingService 
{
    public static void main(String[] args)
    {
        SimulationDriver Driver = new SimulationDriver();
        
        //Configure question with single answer
        int operand1 = Driver.genRandomNumber(1,10);
        int operand2 = Driver.genRandomNumber(2, 10);
        int numWrongAnswers = Driver.genRandomNumber(1,3);
        String question = String.format("What is %d * %d?", operand1, operand2);
        Question singleQuestion =  new SingleChoiceQuestion(question,4);
        
        for(int i = 0; i < numWrongAnswers; i++)
        {
            int ranNum = Driver.genRandomNumber(1,100);
            Driver.addAnswer(singleQuestion, Integer.toString(ranNum), false);
        }
        Driver.addAnswer(singleQuestion, "60", true);
    
        System.out.print(Driver.getQuestion(singleQuestion));
        // System.out.println(Driver.getQuestionAnswers(singleQuestion));
        // System.out.println(Driver.getCorrectAnswers(singleQuestion));

        //Configure question with multiple answers
        


        //Create list with random amount of students and randomize their answers

        // int studentListSize = Driver.generateRandomStudentSize(50);
        // ArrayList<Student> studentList = new ArrayList<Student>(studentListSize);
        // for(int i = 0; i < studentListSize; i++)
        // {
        //     Student student = new Student(UUID.randomUUID());
        // }
    }
}
