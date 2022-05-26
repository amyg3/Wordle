import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wordle
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private String[][] grid;
    private String correctWord;
    private int currentRow;

    public Wordle(String cd)
    {
        correctWord = cd;
        grid = new String[6][5];
        for(int r = 0; r < grid.length; r++)
        {
            for(int c = 0; c < grid[0].length; c++)
            {
                grid[r][c] = "☐";
            }
        }
        currentRow = 0;
    }

    public void addWord(String word) throws FileNotFoundException
    {
        if(canAddWord(word) && canAddWordLen(word))
        {
            Word newWord = new Word(word, correctWord);
            ArrayList<String> charList = newWord.getWordList();
            for(int i=0; i<5; i++)
            {
                if(charList.get(i).substring(0,1).equals("g"))
                    grid[currentRow][i] = ANSI_GREEN + charList.get(i).substring(1,2) + ANSI_RESET;
                else if(charList.get(i).substring(0,1).equals("y"))
                    grid[currentRow][i] = ANSI_YELLOW + charList.get(i).substring(1,2) + ANSI_RESET;
                else if(charList.get(i).substring(0,1).equals("b"))
                    grid[currentRow][i] = ANSI_WHITE + charList.get(i).substring(1,2) + ANSI_RESET;
                
            }
            currentRow++;
        }
        else {
            System.out.println("Not in word list");
        }
    }

    public boolean canAddWord(String word) throws FileNotFoundException
    {
        File text = new File("words.txt");
        Scanner scnr = new Scanner(text);

        while(scnr.hasNextLine())
        {
            if(word.equals(scnr.nextLine()))
            {
                return true;
            }
        }

        return false;
    }

    public boolean canAddWordLen(String word)
    {
        if(word.length()!=5)
        {
            System.out.println("not long enough");
            return false;
        }
        return true;
    }

    public String[][] getGrid()
    {
        return grid;
    }

    public String getCorrectWord()
    {
        return correctWord;
    }
    
}
