import java.util.*;

/**
   TODO Simulates a farm and has different animals. 
   TODO The Farm class will print out the animals and the sounds they make in
   the farm. On top of that, objects like NamedCow will print out the name of 
   the cow.
  
   @author  TODO Kevin Deng
   @version TODO 10/27

   Period - TODO 3
   Assignment - A29.1 Old MacDonald

   Sources - TODO list collaborators
 */
public class Farm
{
   private Animal[] a = new Animal[3];

/**
 * constructs a Farm
 */
   public Farm()
   {      
      //a[0] = new Cow("cow","moo");
      a[0] = new NamedCow("cow", "Elsie", "moo");
      //a[1] = new Chick("chick","cluck");
      a[1] = new Chick("chick", "cluck", "cheep");
      a[2] = new Pig("pig","oink");
   }

/**
 * 
 * TODO loops through the Animal array and prints out the animals and sounds
 * they make.
 */
   public void animalSounds()
   {
      for (int i = 0; i < a.length; i++)
      {
         System.out.println(a[i].getType() + " goes " + a[i].getSound());
      }
      NamedCow named = (NamedCow)a[0];
      System.out.println( named.getType() + " is named " + named.getName() );
   }
}

