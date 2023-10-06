public abstract class Question implements QuestionInterface
{
    private String question;
    private String questionType;
    
    public Question(String question, String questionType)
    {
        this.question = question;
        this.questionType = questionType;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getQuestionType()
    {
        return questionType;
    }
}
