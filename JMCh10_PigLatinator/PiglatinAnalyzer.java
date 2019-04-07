import java.util.Scanner;
/**
   TODO Translates english text into piglatin.
   TODO To use this class, pass a phrase that is in English into the class,
   and the program will return the piglatin version of the english text. This
   program is a translator.

   @author  TODO Kevin Deng
   @version TODO 10/18/18

   @author  Period - TODO 3
   @author  Assignment - TODO Piglatinator

   @author  Sources - TODO list collaborators
 */
public class PiglatinAnalyzer
{
    private String text;

    // Constructor: saves the text string
    public PiglatinAnalyzer(String text)
    {
        this.text = text;
    }

    /**
     * Converts a string to it piglatin form according to the following rules:
     *   a. If there are no vowels in englishWord, then pigLatinWord is just
     *      englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o',
     *      and 'u', and their uppercase counterparts.)
     *   b. Else, if englishWord begins with a vowel, then pigLatinWord is just
     *      englishWord + "yay".
     *   c. Otherwise (if englishWord has a vowel in it and yet doesn't start
     *      with a vowel), then pigLatinWord is end + start + "ay", where end
     *      and start are defined as follows:
     *        1. Let start be all of englishWord up to (but not including) its
     *           first vowel.
     *        2. Let end be all of englishWord from its first vowel on.
     *        3. But, if englishWord is capitalized, then capitalize end and
     *           "uncapitalize" start.
     *
     * @return   piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";

        for (int i = 0; i < phraseToTranslate.length(); i++)
        {
            if (Character.isLetter(phraseToTranslate.charAt(i)))
            {
                String word = extractWord(i);
                i += (word.length() - 1);
                translation += wordToPigLatin(word);
            }
            else
            {
                translation += phraseToTranslate.charAt(i);
            }
        }

        return translation;
    }

    /**
     *  Converts an "english" word to its piglatin form
     *
     * @param  englishWord  a string representing an english word
     * @return              piglatin form of the english word
     */
    public String wordToPigLatin(String englishWord)
    {
        String pigLatinWord = englishWord;
        String lowerEnglishWord = englishWord.toLowerCase();
        
        for (int i = 0; i < lowerEnglishWord.length(); i++)
        {
            if (lowerEnglishWord.charAt(i) == 'a' || 
                            lowerEnglishWord.charAt(i) == 'e' ||
                            lowerEnglishWord.charAt(i) == 'i' ||
                            lowerEnglishWord.charAt(i) == 'o' ||
                            lowerEnglishWord.charAt(i) == 'u')
            {
                if (i == 0)
                {
                    return pigLatinWord + "yay";
                }
                else
                {
                    if (Character.isUpperCase(pigLatinWord.charAt(0)))
                    {
                        return pigLatinWord.substring(i, i + 1).toUpperCase() + 
                                        pigLatinWord.substring(i + 1) + 
                                        pigLatinWord.substring(0, 1).toLowerCase() + 
                                        pigLatinWord.substring(1, i) + "ay";
                    }
                    else
                    {
                        return pigLatinWord.substring(i) + 
                                        pigLatinWord.substring(0, i) + "ay";
                    }
                }
            }
        }
        
        return pigLatinWord + "ay";
    }
    
/**
 * 
 * TODO Extracts the individual word given a position of a character.
 * @param pos index of the character used to "extract" the word
 * @return  the word that contains the character found at index pos
 */
    public String extractWord( int pos )
    {
        char letter = text.charAt( pos );
        int firstLetter = pos;
        int lastLetter = pos;

        if ( Character.isLetter( letter ) )
        {

            while ( firstLetter >= 0 && 
                            Character.isLetter( text.charAt( firstLetter ) ) )
            {
                firstLetter--;
            }
            while ( lastLetter < text.length() && 
                            Character.isLetter( text.charAt( lastLetter ) ) )
            {
                lastLetter++;
            }

        }

        return text.substring( firstLetter + 1, lastLetter );
    }

}
