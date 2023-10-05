import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SingleChoiceQuestion extends Question
{
    private HashMap<String, Boolean> answers;
    boolean correctAnswerPresent = false;

    //constructor
    public SingleChoiceQuestion(String question, int answerCapacity)
    {
        super(question);
        answers = new HashMap<String, Boolean>(answerCapacity);
    }

    //return set of all the possible answers
    public Set<String> getAllAnswers()
    {
        return answers.keySet();
    }

    public Set<String> getCorrectAnswers()
    {
        Set<String> set = new HashSet<String>();
        for(String answer: getAllAnswers())
        {
            if(answers.get(answer) == true)
            {
                set.add(answer);
            }
        }
        return set;
    }

    //add answer (key) and its correct value to the hashmap
    public void addAnswer(String answer, boolean correct)
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
    }
}
