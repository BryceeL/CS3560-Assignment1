import java.util.ArrayList;

public interface QuestionInterface 
{
    /** Get the question
	 * @return String question
	 */
    public String getQuestion();
    
    /** Get a list of all possible choices to the question
     * @return a String ArrayList of the answers
     */
    public abstract ArrayList<String> getAllAnswers();

    /** Adds an answer to the list of possible choices for the question
     * @param answer The answer to add
     */
    public abstract void addAnswer(String answer);

    /** Get the correct answer(s) to the question
     * @return a ArrayList of the indices for the correct answer(s)
     */
    public abstract ArrayList<Integer> getCorrectAnswers();

    /** Add the index to a list of indices of correct answers
     * @param index The index that corresponds to the answer that will be marked as correct
     */
    public abstract void addCorrectAnswer(int index);
    
}