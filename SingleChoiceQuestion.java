import java.util.ArrayList;

public class SingleChoiceQuestion extends Question
{
    private ArrayList<String> allAnswers;
    private ArrayList<String> correctAnswerIndex = new ArrayList<String>(1);

    //constructor for SingleChoiceQuestion object
    public SingleChoiceQuestion(String question, int allAnswersSize)
    {
        super(question);
        allAnswers = new ArrayList<String>(allAnswersSize);
    }

    //return array of all the answers
    public ArrayList<String> getAllAnswers()
    {
        if(!allAnswers.isEmpty())
            return allAnswers;
        else
            throw new IllegalStateException("allAnswers array list is empty.");
    }

    public void addAnswer(String answer)
    {
        allAnswers.add(answer);
    }

    public void removeAnswer(int index)
    {
        allAnswers.remove(index);
    }

    public void overwriteAnswer(String answer, int index)
    {
        allAnswers.set(index, answer);
    }

    //gets the correct answer
    public ArrayList<String> getCorrectAnswers()
    {
        if(!correctAnswerIndex.isEmpty())
            return correctAnswerIndex;
        else
            throw new IllegalStateException("correctAnswerIndex array list is empty");
    }

    //set correct answer
    public void addCorrectAnswer(int index)
    {
        correctAnswerIndex.set(1, String.valueOf(index));
    }

    //set incorrect answer
    //**NOTE: method does not make use of parameter
    public void removeCorrectAnswer(int index)
    {
        correctAnswerIndex.remove(1);
    }
}
