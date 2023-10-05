import java.util.Set;
import java.util.UUID;

public class Student implements StudentInterface
{
    private UUID ID;
    private String singleAnswer;
    private Set<String> multiAnswers;

    //constructor
    public Student(UUID ID)
    {
        this.ID = ID;
    }

    //get id
    public UUID getID()
    {
        return ID;
    }

    //get Student's single answer
    public String getAnswer()
    {
        return singleAnswer;
    }

    //get Student's multiple answers
    public Set<String> getAnswers()
    {
        return multiAnswers;
    }

    //change the Student's single answer
    public void submitAnswer(String answer)
    {
        singleAnswer = answer;
    }

    //change the Student's multiple answers
    public void submitAnswer(Set<String> answers)
    {
        multiAnswers.clear();
        for(String i: answers)
        {
            multiAnswers.add(i);
        }
    }
}
