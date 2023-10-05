import java.util.ArrayList;

public class MultiChoiceQuestion extends Question
{
    private ArrayList<String> allAnswers;
    private ArrayList<Integer> correctAnswersIndex;
    private int indexCount = 0;

    public MultiChoiceQuestion(String question, int allAnswersSize)
    {
        super(question);
        allAnswers = new ArrayList<String>(allAnswersSize);
        correctAnswersIndex = new ArrayList<Integer>(allAnswersSize);
    }

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

    public ArrayList<Integer> getCorrectAnswers()
    {
        if(!correctAnswersIndex.isEmpty())
            return correctAnswersIndex;
        else
            throw new IllegalStateException("There are no correct answer index in the array list.");
    }

    //set correct answer
    public void addCorrectAnswer(int index)
    {
        if(indexCount < correctAnswersIndex.size())
        {
            indexCount++;
            correctAnswersIndex.add(index);
        }
        else
            throw new IllegalStateException("Cannot add answer because the array list is full.");
    }
}
