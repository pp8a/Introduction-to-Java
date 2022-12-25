package composition.menu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import composition.Composition;
import composition.DirectorCompositions;
import composition.SetCompositions;
import composition.buyer.Buyer;
import composition.flower.DirectorFlowers;
import composition.flower.Flower;
import composition.flower.FlowerColor;
import composition.flower.FlowerName;
import composition.flower.SetFlowers;
import composition.packaging.DirectorPacks;
import composition.packaging.Pack;
import composition.packaging.PackColor;
import composition.packaging.PackType;
import composition.packaging.SetPacks;


public class Menu {
	
	public static void menu() {
		Actions[] actions = Arrays.stream(Actions.values()).toArray(Actions[]::new);
		Stream.of(actions).forEach(t -> System.out.println((t.ordinal()+1)+" "+t.getTitle()));
		int n = numberAction(actions);
		
		actions[n-1].start();		
	}
	
	public static <T> int numberAction(T[] actions) {		
		int number = 0;
		boolean checkId = false;
		while(!checkId) {
			
			System.out.print("Select number of menu: ");
			do {	
				number = inputCount();
				if(number<=0||number>actions.length) {
			    	System.err.println("There's no such menu "+number);
			    }
			}while(number<=0||number>actions.length);				
			
			T act =actions[number-1];			
			checkId = Stream.of(actions)					
					.anyMatch(t -> (t)==act);
			if(!checkId) {
		    	System.err.println("There's no such menu "+number);
		    }
		};
		return number;
	}	
	
	public static void selectionComposition() {
		DirectorFlowers directorFlowers = new DirectorFlowers();
		directorFlowers.setBuildFlowers(new SetFlowers());		
		
		System.out.print("Input count a flowers: ");
		int count = inputCount();
		System.out.println("Choosing flowers: ");
		FlowerColor color = choiceColor();
		FlowerName name = choiceName();
		Flower flower = directorFlowers.buildFlowers(count, color, name);		
		
		System.out.println("Choosing packaging: ");
		PackColor packColor =  choicePackColor();
		PackType packType = choicePackType();
		DirectorPacks directorPacks = new DirectorPacks().setBuildPacks(new SetPacks());
		Pack pack = directorPacks.buildPacks(packColor, packType);
		
		Composition composition = new DirectorCompositions().setBuildCompositions(new SetCompositions()).buildCompositions(flower, pack);
		
		Buyer.getBuyers().addBuyer(composition);
		
		System.out.println("You choose:\n"+ composition);
	}
	
	public static FlowerColor choiceColor() {
		FlowerColor[] flowerColors = FlowerColor.values();
		Stream.of(flowerColors).forEach(t -> System.out.print((t.ordinal()+1)+". "+t+" "));
		System.out.println();
		int n = numberAction(flowerColors);
		
		return flowerColors[n-1];
	}
	
	public static FlowerName choiceName() {
		FlowerName[] flowerName = FlowerName.values();
		Stream.of(flowerName).forEach(t -> System.out.print((t.ordinal()+1)+". "+t+" "));
		System.out.println();
		int n = numberAction(flowerName);
		
		return flowerName[n-1];
	}
	
	public static PackColor choicePackColor() {
		PackColor[] packColor = PackColor.values();
		Stream.of(packColor).forEach(t -> System.out.print((t.ordinal()+1)+". "+t+" "));
		System.out.println();
		int n = numberAction(packColor);
		
		return packColor[n-1];
	}
	
	public static PackType choicePackType() {
		PackType[] packType = PackType.values();
		Stream.of(packType).forEach(t -> System.out.print((t.ordinal()+1)+". "+t+" "));
		System.out.println();
		int n = numberAction(packType);
		
		return packType[n-1];
	}
	
	public static int inputCount() {		
		int number = 0;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);		
				
		while(number<=0) {			
			number = in.nextInt();
			if (number<=0) System.out.println("Input only positive number! ... Input:");
		}			
		return number;
	}
}
