import java.util.ArrayList;
import java.util.HashMap;

public class MultiChoiceQuestion extends Question
{
    private HashMap<Integer, Boolean> answers;
    private static HashMap<Integer, Integer> answerCounts;

    //constructor
    public MultiChoiceQuestion(String question, int answerCapacity)
    {
        super(question, "multi");
        answers = new HashMap<Integer, Boolean>(answerCapacity);
        answerCounts = new HashMap<Integer, Integer>(answerCapacity);
    }

    //return set of all the possible answers
    public ArrayList<Integer> getAllAnswers()
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int answer: answers.keySet())
            list.add(answer);
        return list;
    }

    //return list of the correct answers
    public ArrayList<Integer> getCorrectAnswers()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer answer: getAllAnswers())
        {
            //find if answer correct value is 'true'
            if(answers.get(answer) == true)
            {
                list.add(answer);
            }
        }
        return list;
    }

    //add answer (key) and its correct value into the hashmap
    public void addAnswer(int answer, boolean correct)
    {
        answers.put(answer, correct); 
        //add the answer to be counted
        answerCounts.put(answer, 0);
    }

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
