import java.util.ArrayList;

public interface QuestionInterface 
{
    /** Get the question
	 * @return question
	 */
    public String getQuestion();
    
    /** Get all of the possible answers to the question
     * @return a set of the answers
     */
    public abstract ArrayList<Integer> getAllAnswers();

    /** Get all of the correct answer(s) to the question
     * @return a set of the answers
     */
    public abstract ArrayList<Integer> getCorrectAnswers();

    /** Adds the answer to question's answer set as a key and value
     * @param answer Key: int answer
     * @param correct Value: True if the answer is correct
     */
    public abstract void addAnswer(int answer, boolean correct);

    
}