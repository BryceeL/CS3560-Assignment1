import java.util.HashMap;
import java.util.ArrayList;

public class SingleChoiceQuestion extends Question
{
    private HashMap<Integer, Boolean> answers;
    private static HashMap<Integer, Integer> answerCounts;
    boolean correctAnswerPresent = false;

    //constructor
    public SingleChoiceQuestion(String question, int answerCapacity)
    {
        super(question, "single");
        answers = new HashMap<Integer, Boolean>(answerCapacity);
        answerCounts = new HashMap<Integer, Integer>(answerCapacity);
    }

    //return list of all the possible answers
    public ArrayList<Integer> getAllAnswers()
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int answer: answers.keySet())
            list.add(answer);
        return list;
    }

    //return list of the only correct answer
    public ArrayList<Integer> getCorrectAnswers()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer answer: getAllAnswers())
        {
            //find if answer correct value is 'true'
            if(answers.get(answer) == true)
            {
                list.add(answer);
                break;
            }
        }
        return list;
    }

    //add answer (key) and its correct value to the hashmap
    public void addAnswer(int answer, boolean correct)
    {
        if(correct == true)
        {
            if(correctAnswerPresent == false)
            {
                correctAnswerPresent = true;
                answers.put(answer, correct);
            }
            else
                throw new IllegalStateException("Cannot add answer because there is a correct one already.");
        }
        else
            answers.put(answer, correct);
        //add the answer to be counted
        answerCounts.put(answer, 0);
    }

    //count an answer
    public void count(int answer)
    {
        for(int key: answerCounts.keySet())
        {
            if(key == answer)
                answerCounts.put(key, answerCounts.get(key) + 1);
        }
    }

    //return count of an answer
    public int getCount(int answer)
    {
        return answerCounts.get(answer);
    }
}
