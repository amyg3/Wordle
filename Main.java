import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
        File txt = new File("archive.txt");
        Scanner scanner = new Scanner(txt);
        ArrayList<String> archive = new ArrayList<String>();
        while(scanner.hasNextLine())
        {
            archive.add(scanner.nextLine());
        }

        int rand = (int)(Math.random()*archive.size());
        String line = archive.get(rand);
        String word = line.substring(line.length()-5);

        File text = new File("words.txt");
	      Scanner scnr = new Scanner(text);
	      Wordle x = new Wordle(word);
	      String guess = "     ";
	      Scanner input = new Scanner(System.in);
	      String[][] grid = x.getGrid();
	      int index = 0;

        printWordle(grid);
	      while(x.getCorrectWord().equalsIgnoreCase(guess) == false && index<6)
	      {
	        System.out.println("Enter word: ");
	        guess = input.nextLine();
	        
	        if(guess.length()<5)
	        	System.out.println("Not enough letters");
           else if(guess.length()>5)
	        	System.out.println("Too many letters");
	        else
	        {
	        	x.addWord(guess);
		        if(x.canAddWord(guess)==true)
		            index++;
	        }
	        printWordle(grid);     
	      }
	        
        if(x.getCorrectWord().equalsIgnoreCase(guess) == true)
	      { 
            System.out.println("You win!");    
        }   
	      else if(index==6)
	          System.out.println("You lose!");
        System.out.println("The word was: "+line);
	  }

	public static void printWordle(String[][] grid)
	{
	    for(int r=0; r<grid.length; r++)
	    {
	        for(int c=0; c<grid[0].length; c++)
	        {
	            System.out.print(grid[r][c]+" ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	}

}
