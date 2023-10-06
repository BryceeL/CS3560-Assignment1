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

    /** Simulates students answering the question
     * @param question Question object
     * @param studentList list of students
     * @return list of string outputs for VotingService to print
     */
    public ArrayList<String> simulateAnswers(Question question, ArrayList<Student> studentList);

    /** Creates results including the count of each answer that was submited and how many students were correct
     * @param question Question object
     * @param studentList list of students
     * @return ist of string outputs for VotingService to print
     */
    public ArrayList<String> createResults(Question question, ArrayList<Student> studentList);

   

    
}