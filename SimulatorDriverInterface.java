// You need a SimulationDriver to automatically simulate the whole process. Basically,
// the driver will 1) create a question type and configure the answers; 2) configure the
// question for iVote Service; 3) randomly generate a number students and the answers; 4)
// submit all the students’ answers to iVote Service; 5) call the Voting Service output
// function to display the result
import java.util.ArrayList;

public interface SimulatorDriverInterface
{
    /** Add answer to Question's answer list
     * @param question Question object
     * @param answer The answer to add
     */
    public void addAnswer(Question question, String answer);

    /** Add the index to the Question's list of indices of correct answers
     * @param question Question object
     * @param index The index that corresponds to the answer that will be marked as correct
     */
    public void addCorrectAnswer(Question question, int index);

    /** Generates a random number that will be used for a Student array
     * @param max The number at most it could generate
     * @return A random number
     */
    public int generateRandomStudentSize(int max);

    /** Generates a random number that will be used for a Answer list
     * @param max The number at most it could generate
     * @return A random number
     */
    public int generateRandomAnswerSize(int max);

    /** Gets all the student's single answer
     * @param student List of Student objects
     */
    public ArrayList<String> getSingleAnswer(ArrayList<Student> student);

    /** Gets all the student's multiple answers
     * @param student List of Student objects
     */
    public ArrayList<ArrayList<String>> getMultiAnswers(ArrayList<Student> student);

}