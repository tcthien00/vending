import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author thientruong
 *
 */
public class Main {

	/**
	 * @param args
	 */
    public static void main(String[] args) throws IOException {
        VendingMachine machine = new VendingMachine();
        
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String operatingSystem = System.getProperty("os.name");
        while(true) {
        	if (operatingSystem .contains("Windows")) {
        	    Runtime.getRuntime().exec("cls");
        	}
        	else {
        	    Runtime.getRuntime().exec("clear");
        	}
        	
            machine.printInventory();
        	System.out.println("CHOICES: n=nickle, d=dime, q=quarter, r=returnCoins, 1=item1, 2=item2, 3=item3");
        	System.out.print("Please enter your choice[" + machine.currentBalance + "c inserted]: ");
        	String name = reader.readLine();
        	
        	switch(name) {
        	case "d":
        		machine.insertCoin(Coin.DIME);
            	break;
        	case "n":
        		machine.insertCoin(Coin.NICKLE);
            	break;
        	case "q":
        		machine.insertCoin(Coin.QUARTER);
            	break;
        	case "r":
        		machine.returnCoins();
            	break;
        	case "1":
        		machine.dispenseItem(Item.ITEM1);
            	break;
        	case "2":
        		machine.dispenseItem(Item.ITEM2);
            	break;
        	case "3":
        		machine.dispenseItem(Item.ITEM3);
            	break;
        	default:
                System.err.println("Invalid input!");
        	}
        }
    }

}
