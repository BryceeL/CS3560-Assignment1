public abstract class Question implements QuestionInterface
{
    private String question;
    
    //Constructor for Question Object
    public Question(String question)
    {
        this.question = question;
    }

    //get Question's string Question
    public String getQuestion()
    {
        return question;
    }

    //change Question's string Question
    public void overwriteQuestion(String question)
    {
        this.question = question;
    }
}
