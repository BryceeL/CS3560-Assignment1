import java.util.ArrayList;

public interface StudentInterface
{
    /** Get the student's ID
     * @return Student's ID
     */
    public int getID();

    /** Get the student's one answer
     * @return the student's one answer
     */
    public int getAnswer();

    /** Get the student's answers
     * @return a list of the student's answers
     */
    public ArrayList<Integer> getAnswers();

    /** Adds an answer as the student's for the single choice question
     * @param answer The answer to add
     */
    public void submitAnswer(int answer);

    /** Adds set of answer as the student's for the multiple choice question
     * @param answer The answer to add
     */
    public void submitAnswers(ArrayList<Integer> answer);
}
