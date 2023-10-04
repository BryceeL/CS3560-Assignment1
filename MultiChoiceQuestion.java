import java.util.ArrayList;

public class MultiChoiceQuestion extends SingleChoiceQuestion
{
    private ArrayList<String> correctAnswersIndex;

    public MultiChoiceQuestion(String question, int allAnswersSize)
    {
        super(question, allAnswersSize);
        correctAnswersIndex = new ArrayList<String>(allAnswersSize);
    }

    public ArrayList<String> getCorrectAnswers()
    {
        if(!correctAnswersIndex.isEmpty())
            return correctAnswersIndex;
        else
            throw new IllegalStateException("correctAnswersIndex array list is empty");
    }

    //set correct answer
    public void addCorrectAnswer(int index)
    {
        correctAnswersIndex.add(String.valueOf(index));
    }

    //set incorrect answer
    public void removeCorrectAnswer(int index)
    {
        correctAnswersIndex.remove(index);
    }
}
