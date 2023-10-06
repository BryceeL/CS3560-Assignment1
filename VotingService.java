// The Voting Service can be first configured with a given question type and candidate
// answers. Then, it can start accepting submissions from students. The important thing to
// keep in mind about accepting submissions is that each student can only submit one
// answer. If multiple submissions are received from the same student, only the last
// submission will be counted.
// 4) The Voting Service can also output the statistics of the submission results. You don’t
// have to use the graphical interface. Simply use the standard output (System.out) to
// print out the count for each answer. For example, “A : 5, B : 12”, or “1. Right :
// 15, 2. Wrong : 20”. Feel free to customize the format for your output
import java.util.ArrayList;
import java.util.Set;

public class VotingService 
{
    public static void main(String[] args)
    {
        SimulationDriver Driver = new SimulationDriver();
        
        //Configure question with single answer
        Question singleQuestion = Driver.createSingleQuestion();
    
        //Configure question with multiple answers
        Question multiQuestion = Driver.createMultiQuestion();
        
        //Configure student sample
        ArrayList<Student> studentSet = Driver.createStudentList();

        //create outputs
        ArrayList<String> output1 = Driver.simulateSingleAnswers(singleQuestion, studentSet);
        ArrayList<String> output2 = Driver.simulateMultiAnswers(multiQuestion, studentSet);
        ArrayList<String> a = Driver.createSingleResults(singleQuestion, studentSet);
        ArrayList<String> b = Driver.createMultiResults(multiQuestion, studentSet); 

        System.out.println(singleQuestion.getQuestion());
        System.out.println("Possible Answers: " + singleQuestion.getAllAnswers());
        System.out.println("Correct Answers: " + singleQuestion.getCorrectAnswers());
        printStringArray(output1);
        printStringArray(a);

        System.out.println(multiQuestion.getQuestion());
        System.out.println("Possible Answers: " + multiQuestion.getAllAnswers());
        System.out.println("Correct Answers: " + multiQuestion.getCorrectAnswers());
        printStringArray(output2);
        printStringArray(b);       
    }

    public static void printStringArray(ArrayList<String> strList)
        {
            for(String str : strList)
            {
                System.out.println(str);
            }
        }

    
}
