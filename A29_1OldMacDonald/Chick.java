/**
 * 
 * TODO Creates a Chick object. TODO The chick constructor takes a type and a
 * sound both of type string. The other constructor can take another sound that
 * the chick could make. The Chick class also has 2 more methods both returning
 * the sound and the type.
 *
 * @author Kevin Deng
 * @version Oct 27, 2018
 * @author Period: 3 TODO
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: TODO
 */
class Chick implements Animal
{
    private String myType;

    private String mySound;

    private String myOtherSound;


    /**
     * Constructs a chick object
     * 
     * @param type
     *            is chick
     * @param sound
     *            the sound that the chick makes
     */
    public Chick( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Constructs a chick object
     * 
     * @param type
     *            is chick
     * @param sound
     *            the sound that the chick makes
     * @param otherSound
     *            another sound that the chick makes
     */
    public Chick( String type, String sound, String otherSound )
    {
        myType = type;
        mySound = sound;
        myOtherSound = otherSound;
    }


    /**
     * returns the sound the chick makes. If there are two sounds, it randomly
     * returns one.
     * @return mySound, but if there is a myOtherSound, returns either one of 
     * them
     */
    public String getSound()
    {
        if ( myOtherSound == null )
        {
            return mySound;
        }
        else
        {
            int random = (int)( Math.random() * 2 );
            if ( random == 0 )
            {
                return mySound;
            }
            else
            {
                return myOtherSound;
            }
        }
    }


    /**
     * Returns the type.
     * @return myType
     */
    public String getType()
    {
        return myType;
    }
}