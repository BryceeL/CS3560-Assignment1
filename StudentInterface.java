// Allow students to submit answers. Every student has a unique ID (String), and can
// submit an answer to the iVote service.
import java.util.Set;
import java.util.UUID;

public interface StudentInterface
{
    /** Get the student's ID
     * @return Student's ID
     */
    public UUID getID();

    /** Get the student's one answer
     * @return a set with just the student's one answer
     */
    public String getAnswer();

    /** Get the student's answers
     * @return a set of the student's answers
     */
    public Set<String> getAnswers();

    /** Adds an answer as the student's for the single choice question
     * @param answer The answer to add
     */
    public void submitAnswer(String answer);

    /** Adds set of answer as the student's for the multiple choice question
     * @param answer The answer to add
     */
    public void submitAnswer(Set<String> answer);
}
