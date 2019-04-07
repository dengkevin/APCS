/**
 * 
 * TODO Creates a NamedCow object. TODO This class extends the Cow class, and
 * does the same thing except for the fact that the NamedCow class will return a
 * name of the cow.
 *
 * @author kevindeng
 * @version Oct 27, 2018
 * @author Period: TODO
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: TODO
 */
class NamedCow extends Cow
{
    private String cowName;


    /**
     * Constructs a NamedCow
     * 
     * @param type
     *            the type of the cow
     * @param name
     *            the name of the cow
     * @param sound
     *            the sound that the cow makes
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        cowName = name;
    }


    /**
     * Constructs a NamedCow with no name.
     * 
     * @param type
     *            the type of the cow
     * @param sound
     *            the sound that the cow makes
     */
    public NamedCow( String type, String sound )
    {
        super( type, sound );
    }


    /**
     * 
     * TODO Returns the name of the cow.
     * 
     * @return cowName
     */
    public String getName()
    {
        return cowName;
    }
}
