import java.util.ArrayList;

public interface SimulatorDriverInterface
{   
    /** Creates a question that asks for a product of two random numbers
     * @return question with set of one answer
     */
    public Question createSingleQuestion();

    /** Creates a question that asks for even numbers
     * @return question with set of multiple answers
     */
    public Question createMultiQuestion();

    /** Creates a set of random amount of students
     * @return set of random amount of students
     */
    public ArrayList<Student> createStudentList();

    /** Simulates students answering the question with single choice
     * @param question singleChoiceQuestion object
     * @param studentList list of students
     * @return results as strings for VotingService to print
     */
    public ArrayList<String> simulateSingleAnswers(Question question, ArrayList<Student> studentList);

    /** Simulates students answering the question
     * @param question MultiChoiceQuestion object
     * @param studentList list of students
     * @return list of strings that tell what answers student chose
     */
    public ArrayList<String> simulateMultiAnswers(Question question, ArrayList<Student> studentList);

    
}