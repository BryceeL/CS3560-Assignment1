public abstract class Question implements QuestionInterface
{
    private String question;
    
    public Question(String question)
    {
        this.question = question;
    }

    public String getQuestion()
    {
        return question;
    }
}
