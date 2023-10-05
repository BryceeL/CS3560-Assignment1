import java.util.Set;

public interface QuestionInterface 
{
    /** Get the question
	 * @return question
	 */
    public String getQuestion();
    
    /** Get a list of all possible choices to the question
     * @return a ArrayList of the answers
     */
    public abstract Set<String> getAllAnswers();

    /** Get a list of the correct answer(s) to the question
     * @return a ArrayList of the answers
     */
    public abstract Set<String> getCorrectAnswers();

    /** Adds the answer to the question as a key and value
     * @param answer Key: String answer
     * @param correct Value: True if the answer is correct
     */
    public abstract void addAnswer(String answer, boolean correct);

    
}