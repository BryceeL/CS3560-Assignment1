import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SimulationDriver implements SimulatorDriverInterface
{
    public void addAnswer(Question question, String answer)
    {
        question.addAnswer(answer);
    }

    public void addCorrectAnswer(Question question, int index)
    {
        question.addCorrectAnswer(index);
    }

   public int generateRandomStudentSize(int max)
   {
        return ThreadLocalRandom.current().nextInt(10, max + 1);
   }

   public int generateRandomAnswerSize(int max)
   {
        return ThreadLocalRandom.current().nextInt(2, max + 1);
   }

   public ArrayList<String> getSingleAnswer(ArrayList<Student> student)
   {
        ArrayList<String> list = new ArrayList<String>(student.size());
        for(int i = 0; i < list.size(); i++)
        {
            list.add(student.get(i).getAnswer());
        }
        return list;
   }
    
   public ArrayList<ArrayList<String>> getMultiAnswers(ArrayList<Student> student)
   {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>(student.size());
        for(int i = 0; i < list.size(); i++)
        {
            ArrayList<String> sublist = new ArrayList<String>(student.get(i).getAnswers().size());
            for(int j = 0; j < sublist.size(); j++)
            {
                sublist.add(student.get(i).getAnswers().get(j));
            }
        }
        return list;
   }
}