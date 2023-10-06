import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class SimulationDriver implements SimulatorDriverInterface
{
    ArrayList<Integer> singleStatistics;
    ArrayList<Integer> multiStatistics;
    //creates a question that ask for the correct product
    public Question createSingleQuestion()
    {   
        int answerCapacity = genRandomNumber(3, 5);
        int op1 = genRandomNumber(1, 9);
        int op2 = genRandomNumber(1, 9);
        String questionStr = String.format("What is the product of %d and %d?", op1, op2);

        Question question = new SingleChoiceQuestion(questionStr, answerCapacity);
        singleStatistics = new ArrayList<>(answerCapacity);
        for(int i = 0; i < answerCapacity; i++)
            singleStatistics.add(0);

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
        int answerCapacity = genRandomNumber(3, 5);
        String questionStr = String.format("Which of these numbers are even?");
        boolean evenNumber = false;

        Question question = new MultiChoiceQuestion(questionStr, answerCapacity);
        multiStatistics = new ArrayList<>(answerCapacity);
        for(int i = 0; i < answerCapacity; i++)
            multiStatistics.add(0);

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

    public ArrayList<String> simulateSingleAnswers(Question question, ArrayList<Student> studentList)
    {
        ArrayList<String> output = new ArrayList<>();
        for(Student student : studentList)
        {
            //random chance that student's answer will be any
            int highestIndex = question.getAllAnswers().size()-1;
            int randomIndex = genRandomNumber(0, highestIndex);
            int answer = question.getAllAnswers().get(randomIndex);

            singleStatistics.set(randomIndex, singleStatistics.get(randomIndex)+1);
           

            student.submitAnswer(answer);
            output.add(String.format("Student #%d picked %d", student.getID(), answer)); 
        }
        return output;
    }

    public ArrayList<String> simulateMultiAnswers(Question question, ArrayList<Student> studentList)
    {
        ArrayList<String> output = new ArrayList<>();
        for(Student student : studentList)
        {
            ArrayList<Integer> answers = new ArrayList<>();
            int highestIndex = question.getAllAnswers().size()-1;   
            int randomChoices = genRandomNumber(1, highestIndex);
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
                multiStatistics.set(randomIndex, multiStatistics.get(randomIndex)+1);
                answers.add(answer);
            }
            student.submitAnswers(answers);

            String answerString = "Student #" + student.getID() + " picked:";
            for(int i : student.getAnswers())
                answerString += " " + i;
            output.add(answerString);     
        }
        return output;
    }

    //results have how much of each choice was chosen for a single choice question
    public ArrayList<String> createSingleResults(Question question, ArrayList<Student> studentList)
    {
        ArrayList<String> output = new ArrayList<>();
        output.add("Results for Single Choice Question:");
        int i = 0;
        for(int answer : question.getAllAnswers())
        {
            output.add(String.format("%d: %d", answer, singleStatistics.get(i)));
            i++;
        }
        return output;
    }

    //results have how much of each choice was chosen for a multi choice question
    public ArrayList<String> createMultiResults(Question question, ArrayList<Student> studentList)
    {
        ArrayList<String> output = new ArrayList<>();
        output.add("Results for Multiple Choice Question:");
        int j = 0;
        for(int answer : question.getAllAnswers())
        {
            output.add(String.format("%d: %d", answer, multiStatistics.get(j)));
            j++;
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