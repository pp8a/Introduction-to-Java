package Treasures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Payment.ProviderEnum;

public class Cave {
	private List<Treasures> treasures = new ArrayList<>();
	
	public Cave() {
		super();
	}
	
	public List<Treasures> getTreasures() {
		return treasures;
	}

	public void readerTreasure() throws FileNotFoundException, IOException {
		String str = "src\\Treasures\\treasures.txt";
		Path path = Path.of(str).toAbsolutePath();
		
		String strTreasures = String.valueOf(path);
		try (BufferedReader readerTreasures = new BufferedReader(new FileReader(strTreasures))) {
			String lineTreasures;
			while ((lineTreasures = readerTreasures.readLine()) != null) {			    
				String name = splitWord(lineTreasures);
				Double cost = splitNumber(lineTreasures);
			    treasures.add(new Treasures(0, name, cost));
			}
		}
	}
	
	private String splitWord(String str) {		
		final String WORD = "[a-zA-Z'\\-\s]+";
		
		Pattern pWord = Pattern.compile(WORD);		
		Matcher mWord = pWord.matcher(str);		
		
		return result(str, mWord);	
	}
	
	private Double splitNumber(String str) {		
		final String NUMBER = "[0-9]+[.]*[0-9]*";
		
		Pattern pNumber = Pattern.compile(NUMBER);		
		Matcher mNumber = pNumber.matcher(str);
		
		return Double.valueOf(result(str, mNumber));		
	}
	
	public String result(String str, Matcher mSplit) {	
		/**
		 * result of regex
		 */
		String result = "";
		while(mSplit.find()) {
			int start=mSplit.start();
	        int end=mSplit.end();
	       result += str.substring(start,end);
		}
		return result;
	}	

	@Override
	public String toString() {
		treasures.forEach(System.out::println);
		return "";
	}
	
	public void menu() {
		Actions[] actions = Arrays.stream(Actions.values()).toArray(Actions[]::new);
		Stream.of(actions).forEach(t -> System.out.println((t.ordinal()+1)+" "+t.getTitle()));
		int n = numberAction(actions);
		
		actions[n-1].start();		
	}
	
	public int numberAction(Actions[] actions) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);		
		int number = 0;
		boolean checkId = false;
		while(!checkId) {
			System.out.print("Select number of menu: ");			
			number = in.nextInt();	
			int check = number;
			checkId = Stream.of(actions)					
					.anyMatch(t -> (t.ordinal()+1)==check);
			if(!checkId) {
		    	System.err.println("There's no such menu "+number);
		    }
		};
		return number;
	}	
	
	public Comparator<Treasures> sortTreasures() {
		return Comparator.comparing(Treasures::getName).thenComparing(Treasures::getCost);
	}
	
	public void expensiveTreasures() {			
		Double maxCost = treasures.stream().map(t -> t.getCost()).max(Comparator.comparingDouble(value -> value.doubleValue())).get();
		treasures.stream()
			.filter(t -> t.getCost().equals(maxCost))
			.forEach(t -> System.out.println("The most expensive treasure: "+t));		
	}	
	
	
	public int numberTreasures(Bogatyr bogatyr) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Input number treasures: ");
		int number = in.nextInt();	
				
		Optional<List<Treasures>> optionals = Optional.of((treasures.stream().filter(t -> t.getId()==number)).toList());
//		Optional<List<Treasures>> optional = optionals.isPresent() ? Optional.of(optionals.get()) : Optional.empty(); // or
		Optional<List<Treasures>> optional = optionals.map(Optional::of).orElseGet(Optional::empty);	
		
//		List<Treasures> list = optional.get();		
		if(optional.get().isEmpty()) {
			System.out.println("There is no treasure under number: "+number);
		}else {
			System.out.println("You've chosen: "+optional.get());
			cash(optional.get(), bogatyr);
		}		
	
		return 0;
	}
	
	public void cash(List<Treasures> list, Bogatyr bogatyr) {
		Double money = bogatyr.getMoney();
		boolean check = list.stream().anyMatch(t -> money-t.getCost()>=0);
		if(check) {
			bogatyr.getTreasures().addAll(list);
			
			list.stream().forEach(t -> {
				BigDecimal bd = BigDecimal.valueOf(money-t.getCost());
				bd = bd.setScale(2, RoundingMode.HALF_UP);
				bogatyr.setMoney(bd.doubleValue());
			});			

			System.out.println("You have "+bogatyr.getMoney()+"$");
			
		}else {
			list.stream().forEach(t -> System.out.println("You can't take \""+t.getName()+"\" treasure. Insufficient funds :("));			
		}
		
		System.out.println("Your treasures: "+bogatyr.getTreasures());
	}	
}
