/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Jessica Slaughter
 * jts3329
 * 16470
 * Rebecca Jiang
 * rsj498
 * 16470
 * Slip days used: <0>
 * Git URL: https://github.com/rsj498/ee422c
 * Fall 2016
 */


package assignment3;
import java.util.*;
import java.io.*;


public class Main {
<<<<<<< HEAD
	
	// static variables and constants only here.
	static DFSHelpers helpers;
	static int depth;
	static ArrayList<String> visited;
	static String startWord, endWord;
	
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
		if (input.equals("/quit")) {
			System.exit(0);
		}
		
		int i = 0;
		while (input.charAt(i) != ' ') {
			i++;
		}
		startWord = input.substring(0,  i);
		startWord = startWord.toUpperCase();
		endWord = input.substring(i + 1, input.length());
		endWord = endWord.toUpperCase();
		
		ArrayList<String> words = new ArrayList<String>();
		words.add(startWord);
		words.add(endWord);
		return words;
	}
	/**
	 * This method creates a word ladder using DFS
	 * @param start is the start word
	 * @param end is the end word
	 * @return the word ladder
	 */
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		start = start.toUpperCase();
		end = end.toUpperCase();
		Set<String> dict = makeDictionary();
		ArrayList<String> neighbors = helpers.getNeighbors(start, dict, visited);
		
		// Base Case: Found a word that is directly connected to end
		if (neighbors.contains(end)) {
			ArrayList<String> finPath = new ArrayList<String>();
			finPath.add(end);
			finPath.add(start);
			if (depth == 0) {
				startWord = start;
				endWord = finPath.get(0);
				finPath = helpers.reverse(finPath);
			}
			return finPath;
		}
		
		// No path
		if (neighbors.isEmpty()) {
			return null;
		}
		
		// Allow this path to be used again
		visited.add(start);
		
		neighbors = helpers.sortNeighbors(neighbors, end);
		ArrayList<String> path = new ArrayList<String>();
		for (String currentWord : neighbors) {
			depth++;
			path = getWordLadderDFS(currentWord, end);
			depth--;
			
			if (path == null) { // Dead end, don't use this path again
				visited.add(currentWord);
				continue;
			}
			else { // Found a working path
				break;
			}
		}
		
		// No path found
		if (path == null) {
			return null;
		}
		
		path.add(start);
		if (depth == 0) { // Finished ladder
			startWord = start;
			endWord = path.get(0);
			visited.clear();
			path = helpers.reverse(path);
		}
		return path;
	}
	
=======
    
    // static variables and constants only here.
    static Helpers helper;
    static int depth;
    static ArrayList<String> visited;
    static String startWord, endWord;
    
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
    }
    
    public static void initialize() {
        // initialize your static variables or constants here.
        // We will call this method before running our JUNIT tests.  So call it
        // only once at the start of main.
        helper = new Helpers();
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
        if (input.equals("/quit")) {
            System.exit(0);
        }
        
        int i = 0;
        while (input.charAt(i) != ' ') {
            i++;
        }
        startWord = input.substring(0,  i);
        endWord = input.substring(i + 1, input.length());
        
        ArrayList<String> words = new ArrayList<String>();
        words.add(startWord);
        words.add(endWord);
        return words;
    }
    /**
     * This method creates a word ladder using DFS
     * @param start is the start word
     * @param end is the end word
     * @return the word ladder
     */
    public static ArrayList<String> getWordLadderDFS(String start, String end) {
        start = start.toUpperCase();
        end = end.toUpperCase();
        Set<String> dict = makeDictionary();
        ArrayList<String> neighbors = helper.getNeighbors(start, dict, visited);
        
        // Base Case: Found a word that is directly connected to end
        if (neighbors.contains(end)) {
            ArrayList<String> finPath = new ArrayList<String>();
            finPath.add(end);
            finPath.add(start);
            if (depth == 0) {
            	startWord = start;
        		endWord = end;
        		finPath = helper.reverse(finPath);
            }
            return finPath;
        }
        
        // No path
        if (neighbors.isEmpty()) {
        	if (depth == 0) {
        		startWord = start;
        		endWord = end;
        	}
            return null;
        }
        
        // Allow this path to be used again
        visited.add(start);
        
        neighbors = helper.sortNeighbors(neighbors, end);
        ArrayList<String> path = new ArrayList<String>();
        for (String currentWord : neighbors) {
            depth++;
            path = getWordLadderDFS(currentWord, end);
            depth--;
            
            if (path == null) { // Dead end, don't use this path again
                visited.add(currentWord);
                continue;
            }
            else { // Found a working path
                break;
            }
        }
        
        // No path found
        if (path == null) {
            return null;
        }
        
        path.add(start);
        if (depth == 0) { // Finished ladder
            startWord = start;
            endWord = path.get(0);
            visited.clear();
            path = helper.reverse(path);
        }
        return path;
    }
    
>>>>>>> 3070209ea2fe70f6d714468fe9d1a33ddd404e85
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
        
        Set<String> dict = makeDictionary();
        ArrayList<Node> q = new ArrayList<Node>();
        ArrayList<String> ladder = new ArrayList<String>();
        Node root = new Node(null, start);
        q.add(root);
        Node foundKey = null;
        while(q.size()!=0 && foundKey == null){
            Node head = q.get(0);
            q.remove(0);
            foundKey = BFSHelper(head, end, dict, q, visited);
        }
        if(foundKey==null)
            return null; // not found
        else {
            ladder.add(foundKey.getString());
            while(foundKey.getParent()!=null){
                foundKey = foundKey.getParent();
                ladder.add(foundKey.getString());
            }
            return ladder;
        }
        
    }
    
    private static Node BFSHelper(Node root, String end, Set<String> dict, ArrayList<Node> q, ArrayList<String> visited){
        root.turnGray();
        visited.add(root.getString());
        ArrayList<Node> neighbors = root.getNodeNeighbors(dict, visited);
        for(Node n : neighbors){
            if(n.getString().equals(end)){
                return n;
            }
            //if(!visited.contains(n.getString())/*!n.isGray()&&!n.isBlack()*/){
            q.add(n);
            System.out.printf("Neighbor of %s: %s\n", root.getString(), n.getString());
            n.turnGray();
            //	}
        }
        root.turnBlack();
        return null;
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
        // No ladder exists
        if (ladder == null) {
            System.out.println("no word ladder can be found between " + startWord.toLowerCase() + " and " + endWord.toLowerCase() + ".");
            return;
        }
        
        // Ladder does exist
        System.out.println("a " + (ladder.size() - 2) + "-rung word ladder exists between " + startWord.toLowerCase() + " and " + endWord.toLowerCase() + ".");
        for (int i = 0; i < ladder.size(); i++) {
            System.out.println(ladder.get(i).toLowerCase());
        }
        return;
    }
}
