public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String block = "";
		
		for(int i = 0; i < 9; i++) {
			block = block + Integer.toString(i);
		}
		
		char[] blocks = block.toCharArray();
		
		boolean game = true;
		
		while(game) {
			
			for(int i = 0; i < 9;i += 3) {
				System.out.println(blocks[i] + "|" + blocks[i + 1] + "|" + blocks[i + 2]);
				System.out.println("~~~~~");
				
			}	
			System.out.println("Player 1");
			System.out.println("Please select a box:");
			
			int box = scan.nextInt();
			
			while(blocks[box] == 'O' || blocks[box] == 'X') {
				System.out.println("This place is captured. PLease select another box.");
				box = scan.nextInt();
			}
			
			blocks[box] = 'X';
			
			if(checker(blocks)) {
				System.out.println("we have a winner!!");
				game = false;
				break;
			}
			
			for(int i = 0; i < 9;i += 3) {
				
				System.out.println(blocks[i] + "|" + blocks[i + 1] + "|" + blocks[i + 2]);
				System.out.println("~~~~~");
				
			}	
			
			System.out.println("Player 2");
			System.out.println("Please select a box:");
			
			box = scan.nextInt();
			
			while(blocks[box] == 'O' || blocks[box] == 'X') {
				System.out.println("This place is captured. PLease select another box.");
				box = scan.nextInt();
			}
			
			blocks[box] = 'O';

			if(checker(blocks)) {
				System.out.println("we have a winner!!");
				game = false;
				break;
			}
			
		}
		scan.close();
	}
	
	public static boolean checker(char[] blocks) {
		
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
