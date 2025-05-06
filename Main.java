public class Main {

  public static void main(String[] args) {
  		
  		Scanner scan = new Scanner(System.in);
  		
  		String block = "";
  		//initializing blocks so player can choose by number
  		for(int i = 0; i < 9; i++) {
  			block = block + Integer.toString(i);
  		}
  		//turning blocks into char array so comparision will be less difficult
  		char[] blocks = block.toCharArray();
    
  		//I don't even need this I know
  		boolean game = true;
  		
  		while(game) {
  			
  			for(int i = 0; i < 9;i += 3) {
  				System.out.println(blocks[i] + "|" + blocks[i + 1] + "|" + blocks[i + 2]);
  				System.out.println("~~~~~");
  				
  			}	
  			System.out.println("Player 1");
  			System.out.println("Please select a box:");
  			//sadly, you can choose other player's box
  			int box = scan.nextInt();
  			
  			blocks[box] = 'X';
  			//checking requirements
  			if(checker(blocks)) {
  				System.out.println("we have a winner!!");
  				game = false;
  				break;
  			}
  			//I might need to make loop inside loop instead of loop inside two loop
  			for(int i = 0; i < 9;i += 3) {
  				
  				System.out.println(blocks[i] + "|" + blocks[i + 1] + "|" + blocks[i + 2]);
  				System.out.println("~~~~~");
  				
  			}	
  			
  			System.out.println("Player 2");
  			System.out.println("Please select a box:");
  			
  			box = scan.nextInt();
  			
  			blocks[box] = 'O';
        //checking requirements
  			if(checker(blocks)) {
  				System.out.println("we have a winner!!");
  				game = false;
  				break;
  			}
  			
  		}
  		scan.close();
  	}
  	// checks if the game ended or not
  	public static boolean checker(char[] blocks) {
  		//hellish comparision blocks
  		for(int i = 0; i < 9;i+=3) {
  			if(blocks[i] == blocks[i+1] && blocks[i+1] == blocks[i+2]) {
  				return true;
  			}
  		}
  		
  		for(int i = 0; i < 3;i++) {
  			if(blocks[i] == blocks[i+3] && blocks[i+3] == blocks[i+6]) {
  				return true;
  			}
  		}
  		
  		if(blocks[0] == blocks[4] && blocks[4] == blocks[8]) {
  			return true;
  		}
  		if(blocks[2] == blocks[4] && blocks[4] == blocks[6]) {
  			return true;
  		}
  		
  		return false;
  	}
}
