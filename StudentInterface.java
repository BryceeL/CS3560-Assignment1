// Allow students to submit answers. Every student has a unique ID (String), and can
// submit an answer to the iVote service.
import java.util.ArrayList;

public interface StudentInterface
{
    public String getName();
    public String getID();

    public ArrayList<String> getAnswers();
    public void submitAnswer(String answer);
    public void removeAnswer(int index);

}
