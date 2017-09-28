package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;
import java.util.List;
import java.util.ArrayList;

public class MonsterController
{
	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
		monsterList = new ArrayList<MarshmallowMonster>();
	}
	
	
	public void start()
	{
		boolean finished = true;
		int count = 0;
//		while(count < 100)
//		{
//			popup.displayText("Big Baller Brand!" + count);
//			count += 1;
//		}
		
//		for(int loop = 0; loop < 15; loop +=1)	
//		{
//			popup.displayText("I am balling " + (loop +1) + " times out of 15");
//		}
		MarshmallowMonster sample = new MarshmallowMonster();
//		System.out.println(sample);
		popup.displayText(sample.toString());
		MarshmallowMonster realMonster = new MarshmallowMonster("Lavar Ball", 3, 4, 2.3, true);
		
//		System.out.println(realMonster);
		popup.displayText(realMonster.toString());
//		System.out.println("Sean is hungry, he is going to eat a tentacle");
		popup.displayText("Sean is hungry, he is going to eat a tentacle");
		realMonster.setTentacleAmount(1.3);
//		System.out.println(realMonster);
		popup.displayText(realMonster.toString());
		
		monsterList.add(realMonster);
		monsterList.add(sample);
		testList();
		
		interactWithTheMonster(realMonster);

	}
	
	private void testList()
	{
		for(int index = 0; index < monsterList.size(); index ++)
		{
			MarshmallowMonster currentMonster = monsterList.get(index);
			popup.displayText(currentMonster.getName());
			String newName = popup.getResponse("What should my new name be??");
			currentMonster.setName(newName);
			popup.displayText(currentMonster.getName());
		}
		
		for(MarshmallowMonster current : monsterList)
		{
			popup.displayText(current.getName());
			String newName = popup.getResponse("What should my new name be?");
			current.setName(newName);;
			popup.displayText(current.getName());
		}
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
//		System.out.println(currentMonster.getName() + " wants to know what to eat next");
		popup.displayText(currentMonster.getName() + " wants to know what to eat next");
//		System.out.println(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
		popup.displayText(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
//		System.out.println("How many do you want to eat?");
		int specialAnswer = 0;
		String unconverted = popup.getResponse("How many do you want to eat?");
		
		while(!isValidInteger(unconverted))
		{
			popup.displayText("Try again!");
			unconverted = popup.getResponse("How many do you want to eat?");
		}
		
//		if(isValidInteger(unconverted))
//		{
			specialAnswer = Integer.parseInt(unconverted);
//		}
		
		Scanner myScanner = new Scanner(System.in);
		int consumed = 0;
		consumed = specialAnswer;
		
		if(consumed < 0)
		{
//			System.out.println("You cannot eat a negative amount silly human");
			popup.displayText("You cannot eat a negative amount silly human");
			consumed = 0;
		}
		else if(consumed == 0)
		{
//			System.out.println("Not that hungry are you?");
			popup.displayText("Not that hungry are you?");
		}
		else if(consumed > currentMonster.getArmCount())
		{
//			System.out.println("That is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
			popup.displayText("That is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
//			System.out.println("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
			popup.displayText("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
		}
		
//		System.out.println(currentMonster.getName() + " wants some eyes to be zapped. He has " + currentMonster.getEyeCount() + " eyes.");
		popup.displayText(currentMonster.getName() + " wants some eyes to be zapped. He has " + currentMonster.getEyeCount() + " eyes.");
//		System.out.println("How many do you want to zap?");
//		popup.getResponse("How many do you want to zap?");
//		Scanner secondScanner = new Scanner(System.in);
		int zapAnswer = 0;
		String zapUnconverted = popup.getResponse("How many do you want to zap?");
		
		while(!isValidInteger(zapUnconverted))
		{
			popup.displayText("Try again!");
			zapUnconverted = popup.getResponse("How many do you want to zap?");
		}
		
		zapAnswer = Integer.parseInt(zapUnconverted);
		
		Scanner secondScanner = new Scanner(System.in);
		int zapped = 0;
		zapped = zapAnswer;
		
		if(zapped == 0)
		{
//			System.out.println("Wow, you don't want to zap my eyes??");
			popup.displayText("Wow, you don't want to zap my eyes??");
		}
		else if (zapped < 0)
		{
//			System.out.println("I think it's pretty obvious that you can't zap negative eyes");
			popup.displayText("I think it's pretty obvious that you can't zap negative eyes");
			zapped = 0;
		}
		else if (zapped > currentMonster.getEyeCount())
		{
//			System.out.println("That's a little overkill but do your worst!");
			popup.displayText("That's a little overkill but do your worst!");
			zapped = currentMonster.getEyeCount();
			currentMonster.setEyeCount(currentMonster.getEyeCount() - zapped);
//			System.out.println("*Zap*");
			popup.displayText("*Zap*");
//			System.out.println("AHHHH, My eyes! I think I have " + currentMonster.getEyeCount() + " eyes!");
			popup.displayText("AHHHH, My eyes! I think I have " + currentMonster.getEyeCount() + " eyes!");
		}
		else
		{
//			System.out.println("AHAHAHAAH Perfect! Zap me!");
			popup.displayText("AHAHAHAAH Perfect! Zap me!");
			currentMonster.setEyeCount(currentMonster.getEyeCount() - zapped);
//			System.out.println("*Zap*");
			popup.displayText("*Zap*");
//			System.out.println("I only have " + currentMonster.getEyeCount() + " eyes now!");
			popup.displayText("I only have " + currentMonster.getEyeCount() + " eyes now!");
		}
		
		popup.displayText("Hey look a me!!!");
		String answer = popup.getResponse("How many meals are you eating today?");
		
		while(!isValidInteger(answer))
		{
			popup.displayText("Try again! That's not a valid innteger");
			answer = popup.getResponse("How many do you want to zap?");
		}
		
//		System.out.println(answer);
		popup.displayText(answer);
		
	}
	

	//Helper methods
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Only integer values are valid: " + sample + " is not");
		}
		
		return valid;
	}
	
	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid=false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only double values are valid: " +sampleDouble + " is not.");
		}
		
		return valid;
	}
	
	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;
		
		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only boolean values are valid: " + sampleBoolean + " is not.");
		}
		
		return valid;
	
	}
}


//This class is the instructions and it firsts goes through the outputs then it requires user input. It replies based off these inputs.
//There are also helper methods so that it can prevent crashing and burning on user inputs.
//If Else gives options to what the code should do based off certain values.
//Try and Catch methods help prevent crashing by returning it valid and trying it if actually is valid
