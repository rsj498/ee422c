/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2016
 */


package assignment3;
import java.util.*;
import java.io.*;


public class Main {
	
	// static variables and constants only here.
	static DFSHelpers helpers;
	static int depth;
	static ArrayList<String> visited;
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default from Stdin
			ps = System.out;			// default to Stdout
		}
		initialize();
		
		ArrayList<String> input = parse(kb);
		ArrayList<String> ladder = getWordLadderDFS(input.get(0), input.get(1));
		ArrayList<String> ladder2 = getWordLadderDFS("HELLO", "SAILS");
		printLadder(ladder);
		printLadder(ladder2);
	}
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
		helpers = new DFSHelpers();
		depth = 0;
		visited = new ArrayList<String>();
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of 2 Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		String input = keyboard.nextLine();
		if (input == "/quit") {
			return null;
		}
		
		int i = 0;
		while (input.charAt(i) != ' ') {
			i++;
		}
		String firstWord = input.substring(0,  i);
		firstWord = firstWord.toUpperCase();
		String secondWord = input.substring(i + 1, input.length());
		secondWord = secondWord.toUpperCase();
		
		ArrayList<String> words = new ArrayList<String>();
		words.add(firstWord);
		words.add(secondWord);
		return words;
	}
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		Set<String> dict = makeDictionary();
		ArrayList<String> neighbors = helpers.getNeighbors(start, dict, visited);
		// Base Case: Found a word that is directly connected to end
		if (neighbors.contains(end)) {
			ArrayList<String> finPath = new ArrayList<String>();
			finPath.add(end);
			finPath.add(start);
			return finPath;
		}
		
		// No path
		if (neighbors.isEmpty()) {
			return null;
		}
		
		// dict.remove(start);
		visited.add(start);
		
		neighbors = helpers.sortNeighbors(neighbors, end);
		ArrayList<String> path = new ArrayList<String>();
		for (String currentWord : neighbors) {
			depth++;
			path = getWordLadderDFS(currentWord, end);
			depth--;
			if (path == null) {
				// dict.remove(currentWord);
				visited.add(currentWord);
				continue;
			}
			else {
				break;
			}
		}
		if (path == null) {
			return null;
		}
		path.add(start);
		if (depth == 0) {
			visited.clear();
		}
		return path;
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		// TODO some code
		Set<String> dict = makeDictionary();
		// TODO more code
		
		return null; // replace this line later with real return
	}
    
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
	
	public static void printLadder(ArrayList<String> ladder) {
		for (int i = 0; i < ladder.size(); i++) {
			System.out.println(ladder.get(i));
		}
	}
	// TODO
	// Other private static methods here
}
