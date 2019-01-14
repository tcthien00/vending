/**
 * 
 */

/**
 * @author thientruong
 *
 */
public class FundsNotEnoughState implements State {
	
    VendingMachine machine;
    public FundsNotEnoughState(VendingMachine machine) {
        this.machine =  machine;
    }

	@Override
	public void insertCoin(Coin coin) {
        if (machine.isEnoughFund()) {
            machine.setMachineState(machine.getFundsEnoughState());
        }
	}

	@Override
	public void dispenseItem(Item item) {
		System.err.println("You Inserted " + machine.currentBalance + "c. Not Enough For " + item.getName() + "(" + item.getPrice() + "c). Please add more coins.");
	}

}
