import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
class InventoryNetOff {
		public static final String SEATS = "Seats";
		public static final String FRAMES = "Frames";
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
		private static final String PADDLES = "Paddles";
		private final int NumberOfBicycles=200; //Since the number of bicycles to purchase are fixed
    	private String key=""; //to store the key value of HashMap
    	private int requiredQuantity=0;// to find the required quantity to be purchased
    	HashMap<String, Integer> map = new HashMap<String,Integer>();  // to store the respective values of an inventory item 
    	InventoryNetOff(){
    		map.put(SEATS,50);
    		map.put(FRAMES,80);
    		map.put(BRAKE_SETS,25);
    		map.put(BRAKE_PADDLES,100);
    		map.put(BRAKE_CABLES,75);
    		map.put(LEVERS,60);
    		map.put(BRAKE_SHOES,150);
    		map.put(HANDLEBARS,100);
    		map.put(WHEELS,60);
    		map.put(TIRES,80);
    		map.put(CHAINS,100);
    		map.put(CRANK_SET,50);
    		map.put(PADDLES,150);
    	}
    	void requiredInventory() // to iterate through hashmap 
    	{
    		Iterator<String> it = map.keySet().iterator(); 
    		while(it.hasNext()) 
    		{
    			key = (String)it.next(); 
    			getValues();
    		}
    	}
    	void getValues() //to get the stock with respect to item 
    	{
    		int value = 0;
    		if(key == SEATS || key == FRAMES || key == HANDLEBARS || key == CHAINS || key == CRANK_SET)
    		{	
    			value = map.get(key);
    		}
    	    else if(key == BRAKE_SETS|| key == WHEELS || key == TIRES || key == PADDLES || key == BRAKE_PADDLES || key == LEVERS || key == BRAKE_CABLES)
    	    {	
    	    	value = map.get(key)/2;
    	    } 
    	    else if(key == BRAKE_SHOES) 
    	    {
    	    	value = map.get(key)/4;
    	    }
    		setRequiredQuantity(NumberOfBicycles-value);
    		display();
    	   
    	}
		public int getRequiredQuantity() //returns requiredQunatity value
		{
			return requiredQuantity;
		}
		public void setRequiredQuantity(int requiredQuantity) // allows to vary requiredQunatity value
		{
			this.requiredQuantity = requiredQuantity;
		}
		public void display() //displays on console
		{
			System.out.println(getRequiredQuantity()+" "+key+" are to be purchased for manufacturing " +NumberOfBicycles+ " bicycles");
		}
 }
public class MRP extends InventoryNetOff {
    public static void main(String[] args) throws IOException {
	    InventoryNetOff a = new InventoryNetOff();
	    a.requiredInventory(); //calling requiredInventory method via an object in the class
    }
}
