/**
 * 
 * TODO Tests everything. TODO The main method will create new animals and will
 * return their type and sound. It will also create a new farm and print
 * everything in the farm too.
 *
 * @author Kevin Deng
 * @version Oct 27, 2018
 * @author Period: 3 TODO
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: TODO
 */
class OldMacDonald
{
/**
 * 
 * TODO Tests by creating each animal and printing their type and sound.
 * @param args  not used
 */
    public static void main( String[] args )
    {
        Cow c = new Cow( "cow", "moo" );
        System.out.println( c.getType() + " goes " + c.getSound() );
        Chick ch = new Chick( "chick", "cluck" );
        System.out.println( ch.getType() + " goes " + ch.getSound() );
        Pig p = new Pig( "pig", "oink" );
        System.out.println( p.getType() + " goes " + p.getSound() );

        Farm f = new Farm();
        f.animalSounds();
    }
}
