import java.util.Random;

/*
 *  Name: Character Class
 *  
 *  Description: This class contains data relevant to game characters
 *  both player characters and non player characters.  This class contains
 *  information such as:
 *  -Basic Stats (STRength, DEXterity, CONstitution, INTelligence, WISdom, and CHArisma)
 *  -An Inventory to track a character's items
 *  
 *  Fields:
 *  int- STR DEX CON INT WIS CHA - the basic stats
 *  
 *  inventory - an array of items(probably going to be another class)
 *  
 *  atkList - an array of attacks(another class)
 *  
 *  Methods:
 *  Character() - void - This function creates a random character
 *  Character(int STR, DEX, CON, INT, WIS, CHA,) - this creates a character with the given stats
 *  roll(int quant, size) - int - rolls (quant) number of dice of with (size) 
 *  	sides.  Returns the sum of the roll (ex.  roll(4, 6) returns the value of four rolls of a six sided die)
 *  
  */
public class Character {
	
	//name
	String name = new String();
	String classType = new String();
	//Stats are held as their ability bonus. (Ex.  if the stat is 12, the bonus is + 1)
	public int HP, maxHP, STR, DEX, CON, INT, WIS, CHA;
	
	//public int AP; 				//this stores the AP(armor points).  armor points will be used to check hits  TODO: set the AP in constructor, create getters and setters
	
	//dice roller
	Random die = new Random();
	
	//atkList
	//inventory
	
	public Character(String name, String classType, int STR, int DEX, int CON, int INT, int WIS, int CHA)
	{
		
		
		this.classType = classType;
		this.name = name;
		
		//ability scores
		//some of these score maybe negative since they are used to roll with bonuses or negatives
		
		this.STR = STR/2 - 5;
		//if(this.STR < 0) this.STR = 0;
		this.DEX = DEX/2 - 5;
		//if(this.DEX < 0) this.DEX = 0;
		this.CON = CON/2 - 5;
		//if(this.CON < 0) this.CON = 0;
		this.INT = INT/2 - 5;
		//if(this.INT < 0) this.INT = 0;
		this.WIS = WIS/2 - 5;
		//if(this.WIS < 0) this.WIS = 0;
		this.CHA = CHA/2 - 5;
		//if(this.CHA < 0) this.CHA = 0;
		
		
		//if cleric or rogue class
		if(classType == "cleric" || classType == "rogue")
			maxHP = 8;
		//fighter class
		else if(classType == "fighter")
			maxHP = 10;
		//wizard class
		else if(classType == "wizard")
			maxHP = 6;
		
		maxHP += this.CON;
		HP = maxHP;
	}
	
	public String getName()
	{
		return name;
	}	
	public int getSTR()
	{
		return STR;
	}
	public int getDEX()
	{
		return DEX;
	}
	public int getCON()
	{
		return CON;
	}
	public int getINT()
	{
		return INT;
	}
	public int getWIS()
	{
		return WIS;
	}
	public int getCHA()
	{
		return CHA;
	}
	public int getHP()
	{
		return HP;
	}
	public int[] getStats()
	{
		//order of stats: Strength, Dexterity, Constitution, Intelligence, Wisdom
		int[] statList = new int[6];
		statList[0] = STR;
		statList[1] = DEX;
		statList[2] = CON;
		statList[3] = INT;
		statList[4] = WIS;
		statList[5] = CHA;
		
		return statList;
	}

	//public boolean hitRecord:
	//this function records damage as a subtraction of a hit.
	//if character falls below zero HP,  function returns true.
	//this indicates a fallen character
	public boolean hitRecord(int damage)
	{
		HP -= damage;
		
		if(HP <= 0)
		{
			return true;
		}
		else
			return false;
	}
	//public void heal:
	//this function heals the character by adding the input to HP.
	public void heal(int healPts)
	{
		HP += healPts;
		
		if(HP > maxHP)
		{
			HP = maxHP;
		}
	}
	
	//for rolling
	public int roll(int size, int quant)
	{
		int sum = 0;
		
		for(int count = 0; count < quant; quant++)
		{
			sum += die.nextInt(size) + 1;
		}
		
		return sum;
	}
	public int roll(int size, int quant, int bonus)
	{
		int sum = 0;
		
		for(int count = 0; count < quant; quant++)
		{
			sum += die.nextInt(size) + 1;
		}
		
		sum += bonus;
		
		return sum;
	}
	
	
	
}
