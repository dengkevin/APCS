import java.util.*;


/**
 * TODO Simulates a MailServer, sending messages to subscribers TODO This class
 * signs up actors to the subscriber list, and sends messages accordingly.
 * 
 * @author TODO Kevin Deng
 * @version TODO 1/23/19
 * 
 * @author Period - TODO 3
 * @author Assignment - TODO ActorsWorld
 * 
 * @author Sources - TODO
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;


    /**
     * Constructs a MailServer
     */
    public MailServer()
    {

        actors = new TreeSet<Actor>();
    }


    /**
     * 
     * TODO Adds actor to the Set
     * 
     * @param actor
     *            the actor to be added
     */
    public void signUp( Actor actor )
    {

        actors.add( actor );
    }


    /**
     * 
     * TODO Sends a specific actor a message. However, if msg.getRecipient is
     * equal to null, then it sends it to everyone but the sender.
     * 
     * @param msg
     *            the message to be sent to the actors
     */
    public void dispatch( Message msg )
    {

        if ( msg.getRecipient() == null )
        {
            for ( Actor a : actors )
            {
                if ( !( msg.getSender().equals( a ) ) )
                {
                    a.receive( msg );
                }
            }
        }
        else
        {
            msg.getRecipient().receive( msg );
        }
    }


    /**
     * 
     * TODO For testing purposes
     * 
     * @return Set<Actor> all actors
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
