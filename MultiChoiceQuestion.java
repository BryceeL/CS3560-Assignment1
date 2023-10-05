import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MultiChoiceQuestion extends Question
{
    private HashMap<String, Boolean> answers;

    //constructor
    public MultiChoiceQuestion(String question, int answerCapacity)
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

    //add answer (key) and its correct value into the hashmap
    public void addAnswer(String answer, boolean correct)
    {
        answers.put(answer, correct); 
    }

    
}
