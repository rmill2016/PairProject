import java.util.Random;
import java.util.Scanner;

public class gameBase {
	
	public static void main(String[] args) {
		
		Character player = new Character("Rafael", "fighter", 14, 18, 6, 25, 12, 16);
		Character enemy = new Character("Soldier", "fighter", 12, 14, 6, 11, 4, 0);
		int[] testCharStats = player.getStats();
		displayCharacter(player);
		
		
		System.out.println("Hello, you have been summoned to a world different than your own.");
		System.out.println("Type 'help' for more information");
		boolean endState = false;
		
		Scanner scan = new Scanner(System.in);	//Scanner should go outside loop or else we create too many scanners.
		Random rand = new Random();
		
		//everything in game start can go here
		while(!endState)
		{
			System.out.println("What would you like to do? \n" +"  attack  |  item  |  run  |  stats  |  exit");
			String choice = scan.next();
			
			int damage = 0;
			
			switch (choice)
			{
				case "help":
					
					break;
				
				case "attack":
					damage = attack(enemy.getDEX(), player.getSTR());
					
					if(damage > 0)
					{
						System.out.println("You dealt " + damage + " to " + enemy.getName());
						//this returns true if damage dealt KOs enemy
						if(enemy.hitRecord(damage))
						{
							System.out.println(enemy.getName() + " has been defeated!");
							endState = true;
							break;
						}
						System.out.println(enemy.getName() + " has " + enemy.getHP() + " HP remaining.");
					}
					else
					{
						System.out.println("You missed!");
					}
					
					damage = attack(player.getDEX(), enemy.getSTR());
					
					if(damage > 0)
					{
						System.out.println("You took " + damage + ".");
						if(player.hitRecord(damage))
						{
							System.out.println("You were defeated...");
							exit();
						}
						System.out.println("You have " + player.getHP() + " HP remaining");
					}
					else
						System.out.println(enemy.getName() + " missed.");
					
					break;
					
				case "item":
					damage = attack(player.getDEX(), enemy.getSTR());
					
					if(damage > 0)
					{
						System.out.println("You took " + damage + ".");
						if(player.hitRecord(damage))
						{
							System.out.println("You were defeated...");
							exit();
						}
						System.out.println("You have " + player.getHP() + " HP remaining");
					}
					else
						System.out.println(enemy.getName() + " missed.");
					
				case "run":
					if(rand.nextDouble() < .33)
					{
						System.out.println("You got away safely.");
						player.heal(2);
						
					} else {
						System.out.println("You couldn't get away!");
					damage = attack(player.getDEX(), enemy.getSTR());
				if (damage >0) {
					if (player.hitRecord(damage))
						endState = true;
						System.out.println("You have taken " + (enemy.getSTR()) + " damage!");
						System.out.println("You have " + player.getHP() + " health left!");
				} else {
					System.out.println("You dodged the attack!");
				}
					}
					
					break;
					
				case "exit":
					exit();
					
				case "stats":
					displayCharacter(player);
					
				default:;
			}
			//enemy's turn they just attack
			
			//System.out.println("Does not display in cases of error");
		}
		
		//close scanner before ending 
		scan.close();
		exit();
		
		//gameStart();
		
	}
	
	private static void exit() {
		System.out.println("See you next time!");
		System.exit(0);
	}

	private static void run() {
		/*
		 *  See attack comment for information 
		 *
		Character player = new Character("Rafael", "fighter", 14, 18, 6, 25, 12, 16);
		Character enemy = new Character("Soldier", "fighter", 12, 14, 6, 11, 4, 0);
		System.out.println("You have a 25% chance to run successfully");
		double runStat = 0.25;
		Random rand = new Random();
		Double runChance = rand.nextDouble();
		if (runChance >= runStat)
		{
			System.out.println("You got away safely!");
			player.heal(2);
			//gameStart();
			
		} else
			{
			System.out.println("Escape attempt failed!");
			player.hitRecord(enemy.getSTR());
			//gameStart();
			}
		*/
	}

	private static void item() {
		
		
		
		
	}

	public static int attack(int dex, int str) {
		/*
		 * The reason this does not work is because the characters are being
		 * recreated here.  The HP is being always max HP since the character
		 * being acted upon is created every time.
		 * 
		 *  Proposed solutions: 1. import the character(s) being interacted with
		 *
		 *                      2. return the damage as an integer value
		 *                      	Note: you may have to take in the defending character's AP and attacking character's attack roll as inputs
		 *      				3. return a boolean hit value and calculate damage in other function.                  
		 *                      
		Character enemy = new Character("Soldier", "fighter", 12, 14, 6, 11, 4, 0);
		Character player = new Character("Rafael", "fighter", 14, 18, 6, 25, 12, 16);
		System.out.println("You dealt " + (player.getSTR() + " damage to the enemy!"));
		enemy.hitRecord((player.getSTR()));
		System.out.println("The enemy has " + (enemy.getHP() + " left!"));
		System.out.println("You took " + (enemy.getSTR()) + " damage from the enemy!");
		player.hitRecord((enemy.getSTR()));
		System.out.println("You have " + (player.getHP() + " left!"));
	while ((player.getHP() > 0) && (enemy.getHP() > 0)) {
		gameStart();
	}
		if (player.getHP() < 1) System.out.println("You lost!");
		{
			exit();
		}
		if (enemy.getHP() < 1) System.out.println(" You win!");
		{
			exit();
		}
		*/
		
		int damage = 0;
		Random rand = new Random();
		
		if(rand.nextInt(20)+1 >= dex +5)
		{
			damage += str;		//we shouldn't use strength by itself since it can be negative
		}
		return damage;
		
	}

	
	//suggest moving all this into main.  It would make everything easier
	/*
	public static void gameStart()
	
	{
		
		System.out.println("What would you like to do?");
		Scanner scan = new Scanner(System.in);
		String helpCheck = scan.next();
		if ("help".contentEquals(helpCheck))
		{
			help();
		} else if ("attack".contentEquals(helpCheck))
		{
			attack();
		} else if ("item".contentEquals(helpCheck))
		{
			item();
		} else if ("run".contentEquals(helpCheck))
		{
			run();
		} else if ("exit".contentEquals(helpCheck))
		{
			exit();
		} else 
		{
			System.out.println("You did not enter a valid command! Try again!");
			gameStart();
		}
	
	}
	*/
	/*public static void help()
	{
		
		
			System.out.println("Here is a list of commands you can enter!");
			System.out.println("attack");
			System.out.println("item");
			System.out.println("run");
			System.out.println("exit");
			//gameStart();
		
	}
	*/
	
	
	public static void displayCharacter(Character display)
	{
		String returnString = new String();
		//int[] statDisplay = display.getStats();
		returnString += "Name: " + display.getName() + "\n";
		returnString += "STR: " + display.getSTR() + "(" + ((display.getSTR() +5) * 2) + ")" + "\n";
		returnString += "DEX: " + display.getDEX() + "(" + ((display.getDEX() +5) * 2) + ")" + "\n";
		returnString += "CON: " + display.getCON() + "(" + ((display.getCON() +5) * 2) + ")" + "\n";
		returnString += "INT: " + display.getINT() + "(" + ((display.getINT() +5) * 2) + ")" + "\n";
		returnString += "WIS: " + display.getWIS() + "(" + ((display.getWIS() +5) * 2) + ")" + "\n";
		returnString += "CHA: " + display.getCHA() + "(" + ((display.getCHA() +5) * 2) + ")" + "\n";
		returnString += "HP: " + display.getHP();
		System.out.println(returnString);
	}
}

	
