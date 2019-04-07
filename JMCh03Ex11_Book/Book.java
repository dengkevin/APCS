/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what
 *       abstraction it represents, and how to use it.
 *
 *  @author  TODO Kevin Deng
 *  @version TODO Aug. 29
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: TODO list collaborators
 */
public class Book
{
    private int numPages;
    private int currentPage;
    public Book(int pages) {
        numPages = pages;
        currentPage = 1;
    }
    
    public int getNumPages() {
        return numPages;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }

    public void nextPage() {
        if (currentPage < numPages) {
            currentPage++;
        }
    }
}
//TODO implement data fields

// TODO implement constructor

// TODO implement methods
