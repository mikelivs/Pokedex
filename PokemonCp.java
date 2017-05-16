//Michael Livingston 
//CMSC256 Spring
//Pokemon
//PokemonCP is used to compare the CP and return the CP in order highest to lowest 

import java.util.*;

public class PokemonCp extends Pokemon implements Comparator <Pokemon> //write a new class to implement Comparator and extend the Pokemon class
{
  public int compare(Pokemon other, Pokemon np) //method to compare and get right order
  {
          return np.getCP()- other.getCP();
  }
}
  