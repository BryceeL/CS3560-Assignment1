// You need a SimulationDriver to automatically simulate the whole process. Basically,
// the driver will 1) create a question type and configure the answers; 2) configure the
// question for iVote Service; 3) randomly generate a number students and the answers; 4)
// submit all the students’ answers to iVote Service; 5) call the Voting Service output
// function to display the result
import java.util.Set;

public interface SimulatorDriverInterface
{
    /** Generates a random number between 1-100 for a given answer
     * @param max The number at most it could generate
     * @return A random number
     */
    public int genRandomNumber(int min, int max);

    /** Get the question
	 * @return question
	 */
    public String getQuestion(Question question);

    /** Add answer to question's answer set
     * @param question Question object
     * @param answer The answer to add
     * @param correct True if the answer is correct
     */
    public void addAnswer(Question question, String answer, boolean correct);

    /**Get all possible answers to the question
     * @param question Question object
     * @return The set of the possible answers
     */
    public Set<String> getQuestionAnswers(Question question);

    /** Get a set of answer(s) for the question
     * @param question Question object
     * @return the set of correct answer to the question
     */
    public Set<String> getCorrectAnswers(Question question);

    /** Submit the student's single answer
     * @param student
     */
    public void submitStudentSingleAnswer(Student student, String answer);

    /** Submit the student's multiple answer
     * @param student
     */
    public void submitStudentMultiAnswer(Student student, Set<String> answer);

    /** Get a student's single answer
     * @param student Student object
     * @return single answer
     */
    public String getStudentSingleAnswer(Student student);

    /** Gets a student's multiple answers
     * @param student Student answer
     */
    public Set<String> getStudentMultiAnswers(Student studen);

    
}