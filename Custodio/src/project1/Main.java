package project1;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//System objects
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		//Game variables
		String[] enemies = { "Goblins", "Orcs", "Minotaurs", "Cyclops" };
		int maxEnemyHealth = 100;
		int enemyAttackDamage = 15;
		
		//Player variables
		int playerHealth = 100;
		int playerAttackDamage = 20;
		int healPotions = 3;
		int healPotion_amount = 30;
		int healPotion_drop = 50; //Percentage chance an enemy will drop a potion
		int retreatChance = 50;
		
		boolean retreat = true; 
		
		System.out.println("Synchronizing");
		System.out.println(". . . . . .");
		System.out.println("You have been awakened!");
		System.out.println("Welcome to the Dungeon!");
		
		GAME:
		while(retreat) {
			System.out.println("======================================================\n");
			System.out.println("\tEnemy incoming");
			System.out.println("\t. . . . . .");
			System.out.println("\tEnemy found!\n");
			System.out.println("======================================================\n");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t===> A hoard of " + enemy + " has appeared! <===\n");
			
			while (enemyHealth > 0) {
				System.out.println("\tYour HP : " + playerHealth);
				System.out.println("\t" + enemy + "'s HP : " + enemyHealth); 
				System.out.println("\n\tWhat would you do?");
				System.out.println("\t1. Attack the enemy!");
				System.out.println("\t2. Use Health potion.");
				System.out.println("\t3. Retreat!");
				
				String input = scan.nextLine();
				
				if(input.equals("1")){ // chose "attack the enemy"
					int damageDealt = rand.nextInt(playerAttackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
				// subtract the damageDealt and Taken from enemy and player, respectively
					enemyHealth -= damageDealt;
					playerHealth -= damageTaken;
					
					System.out.println("\t>> You wreaked " + damageDealt + " damage to the " + enemy);
					System.out.println("\t>> " + damageTaken + " damage have been inflicted on you.");
					
				// if player has died or hp's at the lowest
					if(playerHealth < 0) {
						System.out.println("\tHealth is Critical!\n"
								+ "You have taken too much damage, you are too weak to go on.");
						break;
					}
				}
				
				else if(input.equals("2")){ // chose health potion
					if (healPotions > 0) {
						healPotions --;
						playerHealth += healPotion_amount;
						
					// info on your health and potions: amount,	health, and number of potions left
						System.out.println("\t>> You drank a health potion." + healPotion_amount + " have been healed of your damage."
										+ "\n\t>> You have " + healPotions + " left."
										+ "\n\t>> Your HP is now " + playerHealth + ".\n");
						
					}
					else { // no health potion
						System.out.println("\t>> You have no health potions left! \nDefeat an enemy for a chance to acquire a health potion");
					}
				}
				
				else if(input.equals("3")) { // chose retreat option
					int retreat_chance = rand.nextInt(retreatChance);
					System.out.println("\t>> You have " + retreat_chance + "% chance to retreat from the enemy.\n");
					System.out.println("\t>> Incoming high level attacks! Damage on you will be heavy.\n");
						if (retreat_chance > 23) {
							System.out.println("\t===>You have escaped!<===\n");
							System.out.println("\t>> Replenish yourself and Plan your next move!");
							continue GAME;
						}
						else{
							System.out.println("\n\tFailed attempt at escaping! T_T \n");
							playerHealth = 0;
							break;
						}
				}
				
				else {
					System.out.println("\n \t===>Invalid command.<===\n");
				}
			}
			
			if(playerHealth < 1) { // if player has died
				System.out.println("\t You have been defeated!");
				System.out.println("\t You've been ejected from the dungeon, weak from battle.\n");
				break;
			}
			
			// enemy was defeated
			System.out.println("======================================================\n");
			System.out.println("\t===>" + enemy + " was defeated! <===\n");
			System.out.println("\t===> You have " + healPotions + " health potions left.<===\n" );
			
			// enemy potion drop chance. should be above 50%
			if (rand.nextInt(100) > healPotion_drop){
				healPotions++;
				System.out.println("\t>> The " + enemy + " have dropped health potions!\n");
				System.out.println("\t>> You now have " + healPotions + " health potions in your inventory! \\(*O*)// \n");
			}
			
			System.out.println("======================================================\n");
			System.out.println("\t ===> What would you like to do now?<===\n");
			System.out.println("\t1.Continue playing.");
			System.out.println("\t2.Exit the game.");
			System.out.println("\n======================================================\n");
			
			String input = scan.nextLine();
			
			// if invalid input
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("\n \t===>Invalid command.<===\n");
				input = scan.nextLine();
			}
			
			if (input.equals("1")) {// chose play again
				System.out.println("\t>> You chose to continue your battle. Good luck on your fight, Player!\n");
			}
			else if(input.equals("2")){
				System.out.println("\t\nYou have exited the dungeon!");
				break;
			}
			
			
		}
		System.out.println("======================================================\n");
		System.out.println("\n\tThank you for playing!");
		System.out.println("\n======================================================");
	}
}






