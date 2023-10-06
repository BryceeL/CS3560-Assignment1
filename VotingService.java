import java.util.ArrayList;

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

        //create outputs to be printed
        ArrayList<String> output1 = Driver.simulateAnswers(singleQuestion, studentSet);
        ArrayList<String> output2 = Driver.simulateAnswers(multiQuestion, studentSet);
        ArrayList<String> singleQuestionResult = Driver.createResults(singleQuestion, studentSet);
        ArrayList<String> multiQuestionResult = Driver.createResults(multiQuestion, studentSet); 

        printStringArray(output1);
        printStringArray(singleQuestionResult);

        printStringArray(output2);
        printStringArray(multiQuestionResult);       
    }

    public static void printStringArray(ArrayList<String> strList)
        {
            for(String str : strList)
            {
                System.out.println(str);
            }
        }

    
}
