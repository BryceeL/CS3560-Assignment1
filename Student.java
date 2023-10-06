import java.util.ArrayList;

public class Student implements StudentInterface
{
    private int ID;
    private ArrayList<Integer> singleAnswer = new ArrayList<>(1);
    private ArrayList<Integer> multiAnswers = new ArrayList<>();

    //constructor
    public Student(int ID)
    {
        this.ID = ID;
        singleAnswer.add(0);
    }

    //get id
    public int getID()
    {
        return ID;
    }

    //get Student's single answer
    public ArrayList<Integer> getAnswer()
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
        singleAnswer.set(0, answer);
    }

    //change the Student's multiple answers
    public void submitAnswers(ArrayList<Integer> answerList)
    {
        multiAnswers.clear();
        for(int answer: answerList)
        {
            multiAnswers.add(answer);
        }
    }
}
