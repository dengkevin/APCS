/*** Part (b) ***/
// TODO complete documentation

public class AndChecker implements Checker
{
    private Checker t1;
    private Checker t2;
    
    public AndChecker(Checker t1, Checker t2)
    {
        this.t1 = t1;
        this.t2 = t2;
    }
    
    public boolean accept(String text)
    {
        if (t1.accept(text) && t2.accept(text))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
