import java.util.Scanner;

public class ElizaApplication {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		ChatBot eliza = new ChatBot();
		
		System.out.printf("Good day. What is your problem? Enter your response here or Q to quit: ");
		input = scan.nextLine();
		input = input.toLowerCase();
		while(!input.equals("q")){
			

			System.out.println(eliza.response(input));
			System.out.print("Enter your response here or Q to quit: "); 
			input = scan.nextLine().toLowerCase();
				
		}	
		
		
	}

}
