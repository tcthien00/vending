import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        	//clear the console
        	if (operatingSystem.contains("Windows"))
        	    Runtime.getRuntime().exec("cls");
        	else
        	    Runtime.getRuntime().exec("clear");
        	
            machine.printInventory();
        	System.out.println("CHOICES: n=nickle, d=dime, q=quarter, r=reset, 1=item1, 2=item2, 3=item3");
        	System.out.print("Please enter your choice[FUND=" + machine.currentBalance + "c]: ");
        	String key = reader.readLine();

        	switch(key) {
        	case "n":
        		machine.insertCoin(Coin.NICKLE);
            	break;
        	case "d":
        		machine.insertCoin(Coin.DIME);
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
                System.err.println("Invalid choice input!");
        	}
        }
    }

}
/*
State design pattern to implement the vending machine.
Keep it simple with two states: FundsNotEnough and FundsEnough.
Wrapper class handles the 'reset' max_fund check which are common in both states.

@startuml

title **Vending Machine FSM**\nState Diagram


[*] --> FundsNotEnough
FundsNotEnough: fund < item lowest price
FundsNotEnough --> FundsNotEnough: InsertCoin/\nReset/\nDispense
FundsNotEnough -down-> FundsEnough: EnoughFund

FundsEnough --> FundsEnough: InsertCoin
FundsEnough: fund >= item lowest price
FundsEnough --> FundsNotEnough: Reset/\nDispense\n!EnoughFund

@enduml
*/