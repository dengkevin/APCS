/*** TODO Part (a) ***/
// TODO complete documentation

public class SubstringChecker implements Checker
{
    private String t;
    
    public SubstringChecker(String t)
    {
        this.t = t;
    }
    public boolean accept(String text)
    {
        if (text.contains(this.t))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
