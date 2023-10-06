import java.util.ArrayList;

public class Student implements StudentInterface
{
    private int ID;
    private int singleAnswer = -1;
    private ArrayList<Integer> multiAnswers = new ArrayList<>();

    //constructor
    public Student(int ID)
    {
        this.ID = ID;
    }

    //get id
    public int getID()
    {
        return ID;
    }

    //get Student's single answer
    public int getAnswer()
    {
        return singleAnswer;
    }

    //get Student's multiple answers
    public ArrayList<Integer> getAnswers()
    {
        return multiAnswers;
    }

    //change the Student's single answer
    public void submitAnswer(int answer)
    {
        singleAnswer = answer;
    }

    //change the Student's multiple answers
    public void submitAnswers(ArrayList<Integer> answers)
    {
        multiAnswers.clear();
        for(int i: answers)
        {
            multiAnswers.add(i);
        }
    }
}
