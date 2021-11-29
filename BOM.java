package bomexplosion;
import java.io.IOException;
import java.util.*;

public class BOM {
	public static void main(String[] args) throws IOException{
		Inventory in = new Inventory();
		in.collectData();
	}
}

class Inventory {
	private static final String PADDLES = "Paddles";
	private static final String CRANK_SET = "Crank set";
	private static final String CHAINS = "Chains";
	private static final String TIRES = "Tires";
	private static final String WHEELS = "Wheels";
	private static final String HANDLEBARS = "Handlebars";
	private static final String BRAKE_SHOES = "Brake Shoes";
	private static final String LEVERS = "Levers";
	private static final String BRAKE_CABLES = "Brake Cables";
	private static final String BRAKE_PADDLES = "Brake Paddles";
	private static final String BRAKE_SETS = "Brake sets";
	private static final String FRAMES = "Frames";
	private static final String SEATS = "Seats";
	
	Scanner sc= new Scanner(System.in); // user input
	HashMap<String, Integer> inventory = new HashMap<String, Integer>(); //to match items with respective stock
	private int input = 0, result = 0, values=0;
	private String key = ""; 
	Inventory(){
	inventory.put(SEATS,1);
	inventory.put(FRAMES,1);
	inventory.put(BRAKE_SETS,2);
	inventory.put(BRAKE_PADDLES,1);
	inventory.put(BRAKE_CABLES,1);
	inventory.put(LEVERS,1);
	inventory.put(BRAKE_SHOES,2);
	inventory.put(HANDLEBARS,1);
	inventory.put(WHEELS,2);
	inventory.put(TIRES,2);
	inventory.put(CHAINS,1);
	inventory.put(CRANK_SET,1);
	inventory.put(PADDLES,2);
	}
	void collectData() throws IOException{ //collects the data through user input
		try {
			System.out.println("Enter the number of cycles to be manufactured");
			input = sc.nextInt();
		}
		catch(Exception e){
			System.out.println("Exception occured due to invalid input");
			throw new IOException("Input invalid " + e);
		}
		getKey();
	}
	void getKey() { //iterates through hashmap to get key
		Iterator<String> it = inventory.keySet().iterator();
		while(it.hasNext()) 
		{
			key = (String)it.next();
			getValues();
		}
		
	}
	void getValues() { //gets stock of respective item
		values = inventory.get(key);
		result = values*input;
		display();
	}
	void display() { //displays the output on console
		System.out.println(result+" "+ key +" are required to manufacture "+input+" bicycles");
	}
}
