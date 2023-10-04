import java.util.ArrayList;

public class oldMultiQuestion extends Question
{
    private final int maxListSize = 10;
    private ArrayList<String> totalAnswers;
    private int[] correctAnswerIndex;

    //constructor
    public MultiChoiceQuestion(String question)
    {
        super(question);
        this.totalAnswers = new ArrayList<String>(maxListSize);
        correctAnswerIndex = new int[maxListSize];
        for(int i = 0; i < correctAnswerIndex.length; i++)
        correctAnswerIndex[i] = -1;
    }

    //return array of all the answers
    public ArrayList<String> getAnswers()
    {
        return totalAnswers;
    }

    //gets the correct answer based on its corresponding index
    public String getCorrectAnswer()
    {
        final ArrayList<String> correctAnswers = new ArrayList<String>(maxListSize);
        if(correctAnswerIndex[i] < 0)
            throw new IllegalStateException("Correct answer has not be set");
        else
            return totalAnswers.get(correctAnswerIndex[i]);
    }

    //set answer for corresponding index
    public void setAnswer(String answer, int index)
    {
        if(index > totalAnswers.size()-1)
            throw new IllegalStateException("Attempt to use index that is"
                                            + "the total number of answers");
        else
            totalAnswers.get(index).equals(answer);
    }
}
