import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */

/**
 * @author thientruong
 *
 */
public class VendingMachine {
	
	private Inventory<Coin> inventoryCash = new Inventory<Coin>(); 
	private Inventory<Item> inventoryItem = new Inventory<Item>();   

    State fundsNotEnoughState = new FundsNotEnoughState(this);
    State fundsEnoughState = new FundsEnoughState(this);

    static State machineState = null;
    int currentBalance = 0;
    
    public VendingMachine() {
        machineState = fundsNotEnoughState;
        initialize();
    }
	
    private void initialize(){
    	//load machine with 5 coins of each denomination
    	for(Coin c : Coin.values()){ 
    		inventoryCash.put(c, 5); 
    	}
    	 //load 10 counts of each Item
    	for(Item i : Item.values()){
    		inventoryItem.put(i, 10); 
    	}
    }
    
    public void printInventory() throws IOException{
    	System.out.println();
    	System.out.println("------------------------Inventory Counts------------------------");
    	for(Coin c : Coin.values())
            System.out.print(c + "(" + c.getDenomination() +"c)" +  " = " + inventoryCash.getQuantity(c) + "\t\t");
        
        System.out.println();
    	for(Item i : Item.values())
            System.out.print(i.getName() + "(" + i.getPrice() + "c) = "+ inventoryItem.getQuantity(i) + "\t\t");
    	System.out.println();
    	System.out.println("----------------------------------------------------------------");
    }

    /**
     * Three Actions: insertCoin(), dispenseItem(), and returnCoins()
     */
    public void insertCoin(Coin coin) {
        if ((currentBalance+coin.getDenomination()) <= 100) {
	        currentBalance += coin.getDenomination();
	        machineState.insertCoin(coin);
	        inventoryCash.add(coin);
        }else
	        System.err.println("Extra " + coin + " returned.");
    }
    
    public void dispenseItem(Item item) {
    	if (inventoryItem.hasItem(item))
    		machineState.dispenseItem(item);
    	else
    		System.err.println(item + " not available! Please select another item. You have inserted " + currentBalance + "c. ");
    }
    
    public void returnCoins() {
    	int totalToReturn = currentBalance;
		List<Coin> changes = Collections.emptyList();
		changes = new ArrayList<Coin>();
		Coin coinToReturn = null;
		
		while(currentBalance > 0) {
			coinToReturn = null;
			if(inventoryCash.hasItem(Coin.QUARTER)&&(currentBalance>=Coin.QUARTER.getDenomination()))
				coinToReturn = Coin.QUARTER;
			else if(inventoryCash.hasItem(Coin.DIME)&&(currentBalance>=Coin.DIME.getDenomination()))
				coinToReturn = Coin.DIME;
			else if(inventoryCash.hasItem(Coin.NICKLE)&&(currentBalance>=Coin.NICKLE.getDenomination()))
				coinToReturn = Coin.NICKLE;
			
			if (coinToReturn != null) {
				changes.add(coinToReturn);
				inventoryCash.deduct(coinToReturn);
				currentBalance -= coinToReturn.getDenomination();
			}else {
		        System.err.println("cashInventory is empty!");
		        break;
			}
		}
		if (!changes.isEmpty())
			System.out.println("Please pick up your change(" + totalToReturn + "c) -> " + changes);
    }
    //-----------------------

    /*
     * Return true if the amount of the inserted coins is enough
     * to buy the item with the lowest price in inventory.
     */
    public boolean isEnoughFund() {
    	float lowestPrice = 0;
    	if (inventoryItem.hasItem(Item.ITEM1))
    		lowestPrice = Item.ITEM1.getPrice();
    	else if (inventoryItem.hasItem(Item.ITEM2))
    		lowestPrice = Item.ITEM2.getPrice();
    	else if (inventoryItem.hasItem(Item.ITEM3))
    		lowestPrice = Item.ITEM3.getPrice();
    	
    	return currentBalance >= lowestPrice;
    }
    //to check if the fund is enough to buy a specific item
    public boolean isEnoughFund(Item item) {
    	return currentBalance >= item.getPrice();
    }
    
    public void removeItemFromInventory(Item item){
        if(!inventoryItem.isEmpty())
        	inventoryItem.deduct(item);
    }
    
    public void setMachineState(State machineState) {
        VendingMachine.machineState = machineState;
    }
    public State getMachineState() {
        return machineState;
    }
    
    public void setFundsEnoughState(State fundsEnoughState) {
        this.fundsEnoughState = fundsEnoughState;
    }
    public State getFundsEnoughState() {
        return fundsEnoughState;
    }
    
    public void setFundsNotEnoughState(State fundsNotEnoughState) {
        this.fundsNotEnoughState = fundsNotEnoughState;
    }
    public State getFundsNotEnoughState() {
        return fundsNotEnoughState;
    }
}
