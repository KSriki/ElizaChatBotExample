import java.util.Scanner;

public class ElizaApplication {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		ChatBot eliza = new ChatBot();
		
		System.out.printf("Good day. What is your problem? Enter your response here or Q to quit: ");
		input = scan.nextLine();
		
		while(!input.equals("Q")){
			

			eliza.addHedge(input);
			System.out.println(eliza.response(input));
			input = scan.nextLine();
				
		}	
		
		
	}

}
