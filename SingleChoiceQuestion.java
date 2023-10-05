import java.util.ArrayList;

public class SingleChoiceQuestion extends Question
{
    private ArrayList<String> allAnswers;
    private ArrayList<Integer> correctAnswerIndex = new ArrayList<Integer>(1);

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
            throw new IllegalStateException("There is not answers in the array list.");
    }

    public void addAnswer(String answer)
    {
        allAnswers.add(answer);
    }

    //gets the correct answer
    public ArrayList<Integer> getCorrectAnswers()
    {
        if(!correctAnswerIndex.isEmpty())
            return correctAnswerIndex;
        else
            throw new IllegalStateException("There are no correct answer index in the array list.");
    }

    //set correct answer
    public void addCorrectAnswer(int index)
    {
        if(correctAnswerIndex.isEmpty())
            correctAnswerIndex.add(index);
        else
            throw new IllegalStateException("Cannot add answer; there can only be one.");
    }
}
