/*** Part (c) ***/
// TODO complete documentation

public class NotChecker implements Checker
{
    private Checker t;
    
    public NotChecker(Checker t)
    {
        this.t = t;
    }
    
    public boolean accept(String text)
    {
        if (t.accept(text))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
