// Configure the question types and candidate answers. It should support 2 types of
// questions: 1) multiple-choice question (more than one choice can be chosen including
// one choice); 2) single choice question (only one choice can be chosen). For each type,
// you can configure the candidate answers, such as “A”, “B”, “C”, “D”, or “1.
// Right”, “2. Wrong”, etc
import java.util.ArrayList;

public interface QuestionInterface 
{
    /** Get the question
	 * @return String question
	 */
    public String getQuestion();

    /** Overwrite the question
     * @param question The new question to overwrite with
     */
    public void overwriteQuestion(String question);
    
    /** Get a list of all possible choices to the question
     * @return a String ArrayList of the answers
     */
    public abstract ArrayList<String> getAllAnswers();

    /** Adds an answer to the list of possible choices for the question
     * @param answer The answer to add
     */
    public abstract void addAnswer(String answer);

    /** Remove the answer from the list of possible choices 
     * @param index The index that corresponds to the answer that would be removed
     */
    public abstract void removeAnswer(int index);

    /** Overwrite an answer from the list of possible choices 
     * @param answer The new answer to be overwritten with
     * @param index The index that corresponds to the answer that would be overwritten
     */
    public abstract void overwriteAnswer(String answer, int index);

    /** Get the correct answer(s) to the question
     * @return a String ArrayList of the indexes for the correct answer(s)
     */
    public abstract ArrayList<String> getCorrectAnswers();

    /** Add the index to a list of indexes of correct answers
     * @param index The index that corresponds the answer that will be marked as correct
     */
    public abstract void addCorrectAnswer(int index);

    /** Remove the index from a list of indexes of incorrect answers
     * @param index The index that corresponds the answer that will be unmarked as incorrect
     */
    public abstract void removeCorrectAnswer(int index);
    
}