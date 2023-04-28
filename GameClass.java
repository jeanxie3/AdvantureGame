package AdvantureGame;
import java.util.*;
import java.util.Random;
public class GameClass {

	public static void main(String[] args) {
		Scanner eingabe = new Scanner(System.in);
		
		Random r = new Random();

		String[] enemies = {"Skeleton", "Zombie", "Marrior", "Assasian"};
		int maxEnemyHealth = 70;
		int enemyAttackDamage = 30;
		
		int health = 100;
		int attackdamage = 25;
		int numHealthPotions = 4;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; //Prozent
		
		boolean running = true;
		System.out.print("WELCOME TO THE DUNGEON");
		
		GAME:
			while(running) {
				System.out.println("pp");	
				
				int enemyhealth = r.nextInt(maxEnemyHealth);
				String enemy = enemies[(r.nextInt(enemies.length))];
				System.out.print("\t<< "+ enemy+ " has appeared! >>\n");
				
				while(enemyhealth > 0) {
					System.out.println("Your HP is: " + health);
					System.out.println(enemy+"'s HP is: " + enemyhealth);
					System.out.println("What would you like to do? ");
					System.out.println("1 Attack\n2 Drink health portion\n3 RUN! ");
					
					int num = eingabe.nextInt();
					if(num==1) {
						int attackdamag = r.nextInt(attackdamage);
						int attackgot = r.nextInt(enemyAttackDamage);
						health -= attackgot;
						enemyhealth -= attackdamag;
						
						if(health<=0) {
							System.out.print("You dead.");
							break;
						}
					}else if (num==2) {
						if(numHealthPotions>0) {
							numHealthPotions --;
							health += healthPotionHealAmount;
							System.out.print("You used one health portion\n Your HP is now: " +health +"\n "
	+numHealthPotions+"left");
						}else {
							System.out.print("No health portion left!");
						}
					}else if (num==3) {
						System.out.print("You ran away from" + enemy);
						continue GAME;
					}else {
						System.out.print("invalid command");
					}
					
				}
				
				if(r.nextInt(100)< healthPotionDropChance) {
					numHealthPotions++;
					System.out.println("You got one health portion!\nNow you have "+ numHealthPotions+" health potions");
				}
				
				System.out.println("Continue the game?");
				int willing = eingabe.nextInt();
				if(willing ==1) {
					System.out.print("Next chanllenge!");
				}else if(willing==2) {
					System.out.print("See you next time!");
					break;
				}else {
					System.out.print("invalid command, try again");
					willing = eingabe.nextInt();
				}
				
				}
		
		System.out.print("Game ended.");
	}

}
