package tictactoegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {
	
	static ArrayList<Integer>playerPosition=new ArrayList<Integer>();
	static ArrayList<Integer>computerPosition=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
	
		
		char [][] gameboard= {{' ','|',' ','|',' '} ,
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
	printgameBoard(gameboard)	;
	
	while(true) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Hamle yapmak için 1-9 arasý kutu seçiniz.");
	int pos=scan.nextInt();
		
	if(playerPosition.contains(pos) || computerPosition.contains(pos)) {
		System.out.println("Tekrarlý hamle giriþi tekrar giriþ yapýnýz");
		pos=scan.nextInt();
	}
	
	hamle(gameboard,pos,"player");
	printgameBoard(gameboard);	
	System.out.println();
	
	Random rand=new Random();
	int cpuPos=rand.nextInt(9)+1;
	if(computerPosition.contains(cpuPos) || computerPosition.contains(cpuPos)) {
		System.out.println("Tekrarlý hamle giriþi tekrar giriþ yapýnýz");
		cpuPos=rand.nextInt(9)+1;
	}
	
	hamle(gameboard,cpuPos,"computer");
	
	printgameBoard(gameboard);
	
	String result=winningcheck();
	System.out.println(result);
	}
	}
	public static void printgameBoard(char [][] gameboard) {
		for(char [] row:gameboard) {
			for(char c:row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}	
	public static void hamle(char [][] gameboard,int pos,String user) {
		
		char hamlecesidi=' ';
		if(user.equals("player")) 
		{
			hamlecesidi='X';
			playerPosition.add(pos);
		}else if(user.equals("computer")){
			hamlecesidi='O';
			computerPosition.add(pos);
		}
		
		
		switch(pos) {
		case 1:
			gameboard[0][0]=hamlecesidi;
			break;
		case 2:
			gameboard[0][2]=hamlecesidi;
			break;
		case 3:
			gameboard[0][4]=hamlecesidi;
			break;
		case 4:
			gameboard[2][0]=hamlecesidi;
			break;
		case 5:
			gameboard[2][2]=hamlecesidi;
			break;
		case 6:
			gameboard[2][4]=hamlecesidi;
			break;
		case 7:
			gameboard[4][0]=hamlecesidi;
			break;
		case 8:
			gameboard[4][2]=hamlecesidi;
			break;
		case 9:
			gameboard[4][4]=hamlecesidi;
			break;
			default:
				break;
		}
		
		
	}
	
	public static String winningcheck() {
		List ustsatir=Arrays.asList(1,2,3);
		List ortasatir=Arrays.asList(4,5,6);
		List altsatir=Arrays.asList(7,8,9);
		List ilksutun=Arrays.asList(1,4,7);
		List ortasutun=Arrays.asList(2,5,8);
		List sonsutun=Arrays.asList(3,6,9);
		List ilkcapraz=Arrays.asList(1,5,9);
		List ikincicapraz=Arrays.asList(3,5,7);
		
		
		List<List> winning=new ArrayList<List>();
		winning.add(ustsatir);
		winning.add(ortasatir);
		winning.add(altsatir);
		winning.add(ilksutun);
		winning.add(ortasutun);
		winning.add(sonsutun);
		winning.add(ilkcapraz);
		winning.add(ikincicapraz);
		
		for(List l:winning) 
		{
			if(playerPosition.containsAll(l)) {
				System.out.println("Kazandýnýz");
			}else if(playerPosition.containsAll(l)) {
				System.out.println("cpu kazandý.");
			}else if(playerPosition.size() + computerPosition.size() == 9) {
				System.out.println("beraberlik.");
			}
			
		}
		
		
		
		
		return "";
	}

}
