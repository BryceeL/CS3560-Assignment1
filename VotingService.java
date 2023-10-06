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
