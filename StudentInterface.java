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
     * @return a ArrayList of the student's answers
     */
    public String getAnswer();

    /** Get the student's answers
     * @return a ArrayList of the student's answers
     */
    public Set<String> getAnswers();

    /** Adds an answer to the student's answer for the single choice question
     * @param answer The answer to add
     */
    public void submitAnswer(String answer);

    /** Adds list of answer to the student's answers for the multiple choice question
     * @param answer The answer to add
     */
    public void submitAnswer(Set<String> answer);
}
