//Michael Livingston 
//CMSC256
//Pokedex
//Pokedex project to do stuff with pokemon file and provide  menu of taks 

import java.io.*;
import java.util.*;
public class Pokedex {
  
  private static void printHeading(){
    
    System.out.println("Michael Livingston");
    System.out.println("CMSC 256");
    System.out.println("Pokemon"); 
    System.out.println(" The purpose of this project is to read in a file of pokemon from the command line and providea menu of tasks that user can choose from \n"); 
  }
  
  
  public static void main(String[] args) 
  {
    printHeading();
    
    //intiliazes variables
    String evenLine = null;
    String oddString= null;
    String [] evenArray = new String[0];
    String [] oddArray = new String[1];
    String name= null;
    String ability = null;
    String type = null;
    String weakness = null;
    int number = 0; 
    double height =0.0;
    double weight = 0.0;
    String category = null;
    int hp = 0;
    int cp = 0;
    


     
    Scanner fileScanner = null; 
    File file = null;
    String f = null;
    boolean fileFound = false;
    
    try{ //try catch statement for to read in file name through command line
      while(!fileFound){
     if(args.length > 0)
     {
       file = new File(args[0]);
       fileScanner = new Scanner(file);
       if(fileScanner.nextLine().equals("pokedex.txt"))
            {
       fileFound = true;
       }

     }
      else if(args.length<0)
      {
        f= fileScanner.nextLine();
      //  throw new ArrayIndexOutOfBoundsException();
      }
      
      else if(fileScanner ==null || file ==null)
      {
                f= fileScanner.nextLine();
       // throw new NullPointerException();
      }
     
    }
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Sorry file not found");
           // System.exit(0);
    }
     catch(ArrayIndexOutOfBoundsException e)
    {
      System.out.println("Sorry invalid arguments");
            System.exit(0);
    }
      catch(NullPointerException e)
    {
      System.out.println("Sorry invalid input");
      System.exit(0);
      
    }

    
 
    
    
    //Scanner fileScanner = new Scanner(new File(args[0]));
    
    int lineNum = 0;
    int pokeArr = 0;
    ArrayList<Pokemon> pokemonArr = new  ArrayList<Pokemon>(); //intialize arrayList with pokemon type
    
    while(fileScanner.hasNextLine()) //iterates through file while has next line
    {
      
      oddString = fileScanner.nextLine(); //stores contents as string
      
      oddString = oddString.replaceAll("\\s+",""); //gets rid of all spaces
      oddArray   = oddString.split(":"); //
      
      //stores the respective data into each variable 
      name = oddArray[0];
      number = Integer.parseInt(oddArray[1]); 
      height = Double.parseDouble(oddArray[2]);
      weight = Double.parseDouble(oddArray[3]);
      category = oddArray[4];
      hp = Integer.parseInt(oddArray[5]);
      cp = Integer.parseInt(oddArray[6]);
      
      evenLine = fileScanner.nextLine();
      evenLine= evenLine.replaceAll("\\s+"," "); 
      evenArray = evenLine.split(":");
      ability = evenArray[0];
      type = evenArray[1];
      weakness = evenArray[2];
      
      //create new pokemon object 
      Pokemon pokemon = new Pokemon(name,type, category, ability, weakness, number, hp, cp,  weight, height);
      
      //add the pokemon object to my pokemon array
      pokemonArr.add(pokemon);
      
      
    }
    

    
    
    
    
    boolean pokeBool = false;
    //while userinput !5
    while(pokeBool ==false)
    {
      System.out.println("\nSelect a number 1-5\n");
      System.out.println("1. Search the playlist by Pokémon name\n2. Search the playlist by Pokémon number\n3. Display all the Pokémon sorted by health points ordered from highest to lowest\n4. Display all the Pokémon sorted by combat power ordered from highest to lowest\n5. Quit");
      Scanner user = new Scanner(System.in);
      String userInput = user.nextLine();
      
      
      boolean nameBool = false;
      boolean numberBool = false;
      boolean hpBool = false;
      boolean cpBool = false;
      if(userInput.equals("1") && nameBool == false)
      {
        System.out.println("Input a pokemon name");
        String user1 = user.nextLine();
        
        for(int x =0; x <pokemonArr.size(); x++)
        {
          
          String pokeName1 = pokemonArr.get(x).getName().trim();
          
          if(pokeName1.equalsIgnoreCase(user1)) //sees if the two are equal regardless of case 
          {
            
            System.out.println(pokemonArr.get(x));
            nameBool = true;
            
          }
          if(x == pokemonArr.size()-1 && nameBool ==false)
          {
            System.out.println("Could not find that Pokemon");
            nameBool = true;
          }
          
          
        }
        
      }
      
      else if(userInput.equals("2") && numberBool == false )
      {
        try{ 
          System.out.println("Input a pokemon number");
          int userInt = user.nextInt();
          
          for(int x =0; x <pokemonArr.size(); x++)
          {
            if(pokemonArr.get(x).getNumber() == userInt)
            {
              System.out.println(pokemonArr.get(x));
              numberBool = true;
            }
            if(x == pokemonArr.size()-1 && numberBool == false)
            {
              System.out.println("Could not find that Pokemon");
              numberBool= true;
            }
            
          }
        }
        catch(InputMismatchException e){
          System.out.println("Invalid input");
        }
        
      }
      
      else if(userInput.equals("3") && hpBool == false)
      {
        
        System.out.println("Sorted pokemon by HP");
        
        Collections.sort(pokemonArr);
        
        System.out.println(pokemonArr);
        
        hpBool= true;
      }
      
      else if(userInput.equals("4") && cpBool == false)
      {
        System.out.println("Sorted pokemon by CP");
        
        Collections.sort(pokemonArr, new PokemonCp()); //sorts pokemon using different class that implements comparator 
        
        System.out.println(pokemonArr);
        
        cpBool= true;
      }
      
      else if (userInput.equals("5"))
      {
        System.out.println("Thank you");
        pokeBool = true; //exits the loop
      }
      
      else
      {
        System.out.println("Wrong input");
      }
      
      
      
      
      
      
      
    }
    fileScanner.close();
  }
}





