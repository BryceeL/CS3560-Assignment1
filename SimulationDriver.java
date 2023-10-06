import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class SimulationDriver implements SimulatorDriverInterface
{
    //creates a question that ask for the correct product
    public Question createSingleQuestion()
    {   
        int answerCapacity = genRandomNumber(3, 5);
        int op1 = genRandomNumber(1, 9);
        int op2 = genRandomNumber(1, 9);
        String questionStr = String.format("What is the product of %d and %d?", op1, op2);

        Question question = new SingleChoiceQuestion(questionStr, answerCapacity);

        //correct answer
        question.addAnswer(op1 * op2, true);
        //incorrect answers
        for(int i = 0; i < answerCapacity-1; i++)
        {
            int randNum;
            do
                randNum = genRandomNumber(1,100);
            while(checkDuplicateInList(question.getAllAnswers(), randNum));

            question.addAnswer(randNum, false);
        }
        return question;
    }

    //creates question that ask for even answers
    public Question createMultiQuestion()
    {
        int answerCapacity = genRandomNumber(3, 4);
        String questionStr = "Which of these numbers are even?";
        boolean evenNumber = false;

        Question question = new MultiChoiceQuestion(questionStr, answerCapacity);

        for(int i = 0; i < answerCapacity; i++)
        {
            int randNum;
            do
                randNum = genRandomNumber(1,100);
            while(checkDuplicateInList(question.getAllAnswers(), randNum));

            if(randNum % 2 == 0)
            {
                evenNumber = true;
                question.addAnswer(randNum, true);
            }
            else
                question.addAnswer(randNum, false);
        }

        //if even number answder wasn't added, add one
        if(evenNumber == false)
        {
            question.addAnswer(genRandomEven(2, 100), true);
        }
        
        return question;
    }

    public ArrayList<Student> createStudentList()
    {
        int studentCapacity = genRandomNumber(5, 10);
        ArrayList<Student> set = new ArrayList<Student>(studentCapacity);

        for(int i = 0; i < studentCapacity; i++)
        {
            Student student = new Student(i+1);
            set.add(student);
        }
        return set;
    }

    public ArrayList<String> simulateAnswers(Question question, ArrayList<Student> studentList)
    {
        ArrayList<String> output = new ArrayList<>();
        output.add("----------------------------------");
        output.add("Simulating students answering the question: " + question.getQuestion());
        for(Student student : studentList)
        {
            if(question.getQuestionType().equals("single"))
            {
                //random chance that student's answer will be any
                int highestIndex = question.getAllAnswers().size()-1;
                int randomIndex = genRandomNumber(0, highestIndex);
                int answer = question.getAllAnswers().get(randomIndex);

                student.submitAnswer(answer);
                question.count(answer);

                output.add(String.format("Student #%d picked %d", student.getID(), answer)); 
            }
            else if(question.getQuestionType().equals("multi"))
            {
                ArrayList<Integer> answers = new ArrayList<>();
                int highestIndex = question.getAllAnswers().size()-1;   
                int randomChoices = genRandomNumber(1, highestIndex+1);
                for(int i = 0; i < randomChoices; i++)
                {
                    //cannot select the same answer twice
                    int answer;
                    int randomIndex;
                    do
                    {
                        randomIndex = genRandomNumber(0, highestIndex);
                        answer = question.getAllAnswers().get(randomIndex);  
                    } 
                    while(checkDuplicateInList(answers, answer));
                    
                    answers.add(answer);
                    question.count(answer);
                }
                student.submitAnswers(answers);

                String answerString = "Student #" + student.getID() + " picked:";
                for(int i : student.getAnswers())
                    answerString += " " + i;
                output.add(answerString); 
            }
        }
        return output;
    }

    //create arrays of strings to show count of a number and amount of students that are correct
    public ArrayList<String> createResults(Question question, ArrayList<Student> studentList)
    {
        int correctStudents = 0;
        ArrayList<String> output = new ArrayList<>();

        //string question, possible answers and correct answers
        output.add(question.getQuestion());
        output.add("Possible Answers: " + question.getAllAnswers());
        output.add("Correct Answers: " + question.getCorrectAnswers());

        
        if(question.getQuestionType().equals("single"))
        {
            output.add("Results for Single Choice Question:");
            //get count of how many times each answer was submited
            for(int answer: question.getAllAnswers())
                output.add(String.format("%d: %d", answer, question.getCount(answer))); 

            //check if student is correct for single answer
            for(Student student : studentList)
            {
                int studentAnswer = student.getAnswer().get(0);
                int correctAnswer = question.getCorrectAnswers().get(0);
                if(studentAnswer == correctAnswer)
                    correctStudents++;
            }
            output.add(String.format("Students that are correct: %d", correctStudents));
        }
        else if(question.getQuestionType().equals("multi"))
        {
            output.add("Results for Multi Choice Question:");
            //get count of how many times each answer was submited
            for(int answer: question.getAllAnswers())
                output.add(String.format("%d: %d", answer, question.getCount(answer)));

            //check if student is correct for multi answer
            for(Student student : studentList)
            {
                boolean isCorrect = true;
                //student doesn't have same amount of answers as correct ones
                if(student.getAnswers().size() != question.getCorrectAnswers().size())
                    isCorrect = false;
                else
                {
                    for(int answer : question.getCorrectAnswers())
                    {
                        //student does not have the answer
                        if(!student.getAnswers().contains(answer))
                            isCorrect = false;
                    }
                }
                if(isCorrect)
                    correctStudents++;
                
            }
            output.add(String.format("Students that are correct: %d", correctStudents));
        }

        return output;
    }

    //produce a random number between 'min' and 'max'
    private int genRandomNumber(int min, int max)
    {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private int genRandomEven(int min, int max)
    {
        boolean even = false;
        int randNum;
        do
        {
            randNum = genRandomNumber(min, max);
            if(randNum % 2 == 0)
                even = true;
        }
        while(!even);
        return randNum;
    }

    //check if answer is not a duplicate from the list
    private boolean checkDuplicateInList(ArrayList<Integer> list, int answer)
    {
        for(int i : list)
        {
            if (i == answer)
            {
                return true;
            }
        }
        return false;
    }
}