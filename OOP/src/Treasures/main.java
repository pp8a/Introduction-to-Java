package Treasures;


import java.io.FileNotFoundException;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Cave cave = new Cave();//for initialization
		cave.readerTreasure();//get from file
		Actions.setCave(cave);//pass in enum
		
		Bogatyr bogatyr = new Bogatyr("Ilya Muromets", 1000.00);//for initialization
		Actions.setBogatyr(bogatyr);//pass in enum for menu		
		
		while (!Actions.isExit) {
			cave.menu();
		}
		
	}

}
