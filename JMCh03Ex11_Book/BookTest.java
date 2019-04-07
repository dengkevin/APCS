/**
 *  This is a class that tests the Book class.
 *
 *  @author  TODO Kevin Deng
 *  @version TODO Aug. 29
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: TODO list collaborators
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for
     * consistency.
     * @param args is not used.
     */
    public static void main( String[] args )
    {
        Book book = new Book(3);
        
        System.out.println(book.getNumPages());
        System.out.println(book.getCurrentPage());
        
        for (int i = 0; i < 3; i++) {
            book.nextPage();
            System.out.println(book.getCurrentPage());
        }
        
        /* TODO *** TO BE IMPLEMENTED *** */
    }
}
