package org.jbs2011.jsoued;
import java.util.Scanner;


public class Game {

	static Scanner scan = new Scanner(System.in);
	static String user;
	static boolean repeat = true;


	public static void main(String[] args){
		
		Node first = new Question("Does it have stripes?");
		first.addYes(new Animal("zebra"));
		first.addNo(new Animal("kangaroo"));

		while(repeat){
			System.out.println("Think of an animal!");
			playGame(first);
		}	
	}

	
	public static void playGame(Node main){
		
		System.out.println(main.getQuestion());
		user = scan.nextLine();

		if(user.equals("yes")){

			if(main.isYes()){
				
				playGame(main.getYes());
				
			} else {
				
				restart();
			}
			
		} else if(user.equals("no")) {
			
			if(main.isNo()){
				
				playGame(main.getNo());
			
			} else {
				
				setBranch(main);
				restart();
			}

		} else {
			
			playGame(main);
		}
	}

	
	public static void setBranch(Node main){
		
		Node before = main.getPrevious();
		
		boolean x = false;
		
		if(before.getNo().equals(main)){
			
			x = true;
		}

		Question nuevo = newQ(main);

		if(x){
			
			before.addNo(nuevo);
			
		} else {
			
			before.addYes(nuevo);
		}

		nuevo.addNo(main);
		nuevo.addYes(newA());
	}
	
	
	public static void restart(){
		
		System.out.println("Wanna play again?");
		
		user = scan.nextLine();
		
		if(user.equals("yes")){
			
			repeat = true;
		
		} else {
			
			repeat = false;
		}
	}

	
	public static Node newA(){
		
		System.out.println("What was your animal?");
		user = scan.nextLine();

		return new Animal(user);
	}
	
	
	private static Question newQ(Node main) {
		
		System.out.println("Please write a question that would be true for your animal and false for a " + main.getAnimal());
		user = scan.nextLine();

		Question nuevo = new Question(user);
		
		return nuevo;
	}
}