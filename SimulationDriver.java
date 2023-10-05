import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class SimulationDriver implements SimulatorDriverInterface
{
    public int genRandomNumber(int min, int max)
    {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getQuestion(Question question)
    {
        return question.getQuestion();
    }
   
    //add answer and its correct value to the question
    public void addAnswer(Question question, String answer, boolean correct)
    {
        question.addAnswer(answer, correct);
    }

    //get all the answers for a question
    public Set<String> getQuestionAnswers(Question question)
    {
        return question.getAllAnswers();
    }

    //get the correct answer(s) for a question
    public Set<String> getCorrectAnswers(Question question)
    {
        return question.getCorrectAnswers();
    }

    //submit student's single answer
    public void submitStudentSingleAnswer(Student student, String answer)
    {
        student.submitAnswer(answer);
    }

    //submit student's multiple answers
    public void submitStudentMultiAnswer(Student student, Set<String> answer)
    {
        student.submitAnswers(answer);
    }

    //get the student's answer to the single choice question
    public String getStudentSingleAnswer(Student student)
    {
        return student.getAnswer(); 
    }
    
    //get the student's answers to the multiple choice question
    public Set<String> getStudentMultiAnswers(Student student)
    {
        return student.getAnswers();
    }
}