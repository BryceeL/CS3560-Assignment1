import java.util.ArrayList;

public class Student implements StudentInterface
{
    private String name;
    private String ID;
    private String singleAnswer;
    private ArrayList<String> multiAnswers;

    public Student(String name, String ID)
    {
        this.name = name;
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public String getID()
    {
        return ID;
    }

    public String getAnswer()
    {
        return singleAnswer;
    }

    public ArrayList<String> getAnswers()
    {
        return multiAnswers;
    }

    public void submitAnswer(String answer)
    {
        singleAnswer = answer;
    }

    public void submitAnswer(ArrayList<String> answers)
    {
       for(int i = 0; i < answers.size(); i++)
       {
            multiAnswers.set(i, answers.get(i));
       }
    }
}
