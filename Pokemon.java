//Michael Livingston 
//CMSC256 Spring
//Pokemon
//Pokedex project to do stuff with pokemon file and provide  menu of taks 

import java.io.*;
import java.util.*;

public class Pokemon implements Comparable<Pokemon>
{
  //intialize private variables
  private String name;
  private String type;
  private String category;
  private String ability;
  private String weakness;
  private int number;
  private int cp;
  private int hp;
  private double weight;
  private double height;
  
  public Pokemon() //default constructor
  {
  name = "";
  type= "";
  category= "";
  ability= "";
  weakness ="";
  number = 0;
  cp=0;
   hp=0;
  weight=0;
  height=0;
  }
  
  public Pokemon(String name, String type, String category, String ability, String weakness, 
                 int number, int hp, int cp, double weight, double height)
  {
    //sets incoming variables
    setName(name);
    setType(type);
    setCategory(category);
    setAbility(ability);
    setWeakness(weakness);
    setNumber(number);
    setCP(cp);
    setHP(hp);
    setWeight(weight);
    setHeight(height);
    
  }
  
  //setters and getters
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name + " ";
  }
  
  public void setType(String type)
  {
    
      this.type = type;
    
  }
  
  public String getType()
  {    
    return type;
        
  }
  
  public void setCategory(String category)
  {
    this.category = category;
  }
  
  public String getCategory()
  {
    return category;
  }
  
  public void setAbility(String ability)
  {
    this.ability = ability;
  }
  
  public String getAbility()
  {
    return ability;
  }
  
  public void setWeakness(String weakness)
  {
    this.weakness = weakness;
  }
  
  public String getWeakness()
  {
    return weakness;
  }
  
  public void setNumber(int number)
  {
    if(number<=0)
    {
    System.out.println(this.getName()+" has Invalid number");

    }
    else
    {
    this.number = number;
    }
  }
  
  public int getNumber()
  {
   
    return number;
  }
  
  public void setHP(int hp)
  {
    if(hp <=0)
    {
      System.out.println(this.getName()+" has an invalid HP");
    }
    else
    {
          this.hp = hp;
  }
  }
  
  public int getHP()
  {
    return hp;
  }
  
  public void setCP(int cp)
  {
    if(cp<=0)
    {
      System.out.println(this.getCP()+"has an invalid CP");
    }
    else
    {
    this.cp = cp;
    }
  }
  
  public int getCP()
  {
    return cp;
  }
  
  public void setWeight(double weight)
  {
    if(weight <=0)
    {
      System.out.println(this.getName()+"Invalid Weight");
    }
    else
    {
    this.weight = weight;
    }
  }
  
  public double getWeight()
  {
    return weight;
  }
  public void setHeight(double height)
  {
    if(height <=0)
    {
      System.out.println(this.getName()+"Invalid height");
    }
    else
    {
    this.height = height;
    }
  }
  
  public double getHeight()
  {
    return height;
  }
  
  public boolean equals(Pokemon poke) //equals to method
  {
    if(poke == null)
    {
      return false;
    }
    else if(this.getName()==poke.getName())
    {
      return true;
    }
    else if(this.getNumber()==poke.getNumber())
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public int compareTo(Pokemon other)
  {
    
      return other.getHP() - this.getHP() ;

    
  }
  
  
  
  public String toString() //toString method to return pokemon information 
  {
    
    return "\nName: " + getName()+ "Type:" + getType() + "Category: " +getCategory()+" Ability: "+getAbility()+ "Weakness:"+getWeakness()+ " Number: "+getNumber()+" HP: "+getHP() +" CP: "+getCP()+" Weight: "+getWeight()+ " Heigth: "+ getHeight();
    
  }
}
