 import java.util.*;

/**
 * Represents various States and their respective cities.
 *
 * @author TODO Kevin Deng
 * @version TODO 4/8/19
 * @author Period - TODO 3
 *
 * @author Assignment - TestSem2CollectionsStates
 *
 * @author Sources - TODO none
 */
public class States
{
    private Map<String, Set<String>> theMap;

    public States()
    {
        theMap = new TreeMap<String, Set<String>>();
    }

    // postcondition: Information from theCity
    // has been added to theMap
    public void addCityToMap(CityInfo theCity)
    {
        if (!(theMap.containsKey(theCity.state())))
        {
            theMap.put(theCity.state(), new HashSet<String>());
        }
        theMap.get(theCity.state()).add(theCity.city());
    }

    public void printOneState(String theState)
    {
        // not allowed since output is specified without the "[...]"
        // System.out.println(theState + " " + theMap.get(theState));

        System.out.print(theState + " ");
        for (String s : theMap.get(theState))
        {
            System.out.print(s + " ");
        }
    }

    public void printAllStates()
    {
        for (String s : theMap.keySet())
        {
            printOneState(s);
            System.out.println();
        }
    }

    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, Set<String>> getTheMap()
    {
        return theMap;
    }
}
