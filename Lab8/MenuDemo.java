import java.util.Scanner;
import java.io.*;

public class MenuDemo{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		PlayersInfo.loadPlayers();
		MenuController.startMenu();
	}
}