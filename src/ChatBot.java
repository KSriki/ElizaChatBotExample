/*
 * Simulates the Eliza chat bot 
 * Srikant Kumar Kalaputapu
 * June 27th, 2017
 * 
 */

import java.util.*;


public class ChatBot {
	
	public Set<String> hedgeSet = new HashSet<String>();

	public Set<String> qualifierSet = new HashSet<String>();

	public Map<String,String> replacementMap = new HashMap<String,String>();
	
	public ChatBot() {
		/* Sample qualifiers:
    Why do you say that
    You seem to think that
    So, you are concerned that
		 */
		
		hedgeSet.add("Please tell me more");
		hedgeSet.add("Many of my patients tell me the same thing");
		hedgeSet.add("It is getting late, maybe we had better quit");
		
		qualifierSet.add("Why do you say that");
		qualifierSet.add("You seem to think that");
		qualifierSet.add("So, you are concerned that");
		
		replacementMap.put("i", "you");
		replacementMap.put("me", "you");
		replacementMap.put("my", "your");
		replacementMap.put("am", "are");
		
		
		
		// TODO Auto-generated constructor stub
	}
	
	private String choice(Set s){
		Random rand = new Random();
		int index = rand.nextInt(s.size());
		Iterator<String> iter = s.iterator();
		for (int i = 0; i < index; i++) {
		    iter.next();
		}
		return iter.next();
	}
	
	/**
	 * Replaces input from user with list of qualifiers and replace pronouns. NOTE: Requires complete sentences for input
	 * @param input - user input text to restructure for chatbot
	 * @return restructured user sentence for chatbot response
	 */
	private String replace(String input){
		String[] words = input.split("([^a-zA-Z']+)'*\\1*");
		String qual = choice(qualifierSet);
		String response = "";
		for(int i = 0; i < words.length; i++){
		
			if(this.replacementMap.containsKey(words[i])){
				response = response.concat(replacementMap.get(words[i]));
			}
			else{
				response = response.concat(words[i]);
			}
			
			if(i != words.length - 1){
				response = response.concat(" ");
			}
		}
		
		
		return qual + " " + response;
	
	}
	
	public String response(String input){
		//use hedges or restructured response
		
		Random rand = new Random();
		int style = rand.nextInt(2);
		if(style == 0){
			return replace(input);
		}
		else{
			return choice(hedgeSet);
		}
		
	}
}
