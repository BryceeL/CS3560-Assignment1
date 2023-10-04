import java.util.ArrayList;

public class Student implements StudentInterface
{
    private String name;
    private String ID;
    private ArrayList<String> answers;

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

    public ArrayList<String> getAnswers()
    {
        return answers;
    }

    public void submitAnswer(String answer)
    {
        answers.add(answer);
    }

    public void removeAnswer(String answer)
    {
        answers.remove(answer);
    }
}
