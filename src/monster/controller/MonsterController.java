package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;


public class MonsterController
{
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}
	
	
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		MarshmallowMonster realMonster = new MarshmallowMonster("Dab of Ranch", 3, 4, 2.3, true);
		
		System.out.println(realMonster);
		System.out.println("Sean is hungry, he is going to eat a tentacle");
		realMonster.setTentacleAmount(1.3);
		System.out.println(realMonster);
		
		interactWithTheMonster(realMonster);
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		System.out.println(currentMonster.getName() + " wants to know what to eat next");
		System.out.println(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
		System.out.println("How many do you want to eat?");
		Scanner myScanner = new Scanner(System.in);
		int consumed = myScanner.nextInt();
		
		if(consumed < 0)
		{
			System.out.println("You cannot eat a negative amount silly human");
			consumed = 0;
		}
		else if(consumed == 0)
		{
			System.out.println("Not that hungry are you?");
		}
		else if(consumed > currentMonster.getArmCount())
		{
			System.out.println("That is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			System.out.println("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
		}
		
		System.out.println(currentMonster.getName() + " wants some eyes to be zapped. He has " + currentMonster.getEyeCount() + " eyes.");
		System.out.println("How many do you want to zap?");
		Scanner secondScanner = new Scanner(System.in);
		int zapped = secondScanner.nextInt();
		
		if(zapped == 0)
		{
			System.out.println("Wow, you don't want to zap my eyes??");
		}
		else if (zapped < 0)
		{
			System.out.println("I think it's pretty obvious that you can't zap negative eyes");
			zapped = 0;
		}
		else if (zapped > currentMonster.getEyeCount())
		{
			System.out.println("That's a little overkill but do your worst!");
			zapped = currentMonster.getEyeCount();
			currentMonster.setEyeCount(currentMonster.getEyeCount() - zapped);
			System.out.println("*Zap*");
			System.out.println("AHHHH, My eyes! I think I have " + currentMonster.getEyeCount() + " eyes!");
		}
		else
		{
			System.out.println("AHAHAHAAH Perfect! Zap me!");
			currentMonster.setEyeCount(currentMonster.getEyeCount() - zapped);
			System.out.println("*Zap*");
			System.out.println("I only have " + currentMonster.getEyeCount() + " eyes now!");
		}
		
		popup.displayText("Hey look a me!!!");
		String answer = popup.getResponse("How many meals are you eating today?");
		System.out.println(answer);
		popup.displayText(answer);
		
	}
	
	
}
