/**
 * 
 * TODO Constructs a Pig object. TODO The Pig class will construct a pig object
 * that will be a certain type and make a certain sound.
 *
 * @author Kevin Deng
 * @version Oct 27, 2018
 * @author Period: 3 TODO
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: TODO
 */
class Pig implements Animal
{
    private String myType;

    private String mySound;


    /**
     * Constructs a pig object
     * 
     * @param type
     *            the type of the pig
     * @param sound
     *            the sound that the pig makes
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Returns the sound that the pig makes
     * @return mySound
     */
    public String getSound()
    {
        return mySound;
    }


    /**
     * returns the type of the pig
     * @return myType
     */
    public String getType()
    {
        return myType;
    }
}