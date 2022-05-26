import java.util.ArrayList;

public class Word
{
    private ArrayList<String> word;
    private String correctWord;

    public Word(String w, String cw)
    {
        correctWord = cw;

        word = new ArrayList<String>();
        for(int i = 0; i < w.length(); i++)
        {
            if((w.charAt(i)+"").equalsIgnoreCase(cw.charAt(i)+""))
            {
                word.add(new String("g"+w.charAt(i)));
            }
            else if(cw.indexOf(w.charAt(i)) >= 0 || cw.indexOf((int)w.charAt(i)+32) >= 0 
            || cw.indexOf((int)w.charAt(i)-32) >= 0)
            {
                word.add(new String("y"+w.charAt(i)));
            }
            else
            {
                word.add(new String("b"+w.charAt(i)));
            }
        }
    }

    public ArrayList<String> getWordList()
    {
        return word;
    }
 
}
