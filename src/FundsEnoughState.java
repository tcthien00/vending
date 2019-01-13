/**
 * 
 */

/**
 * @author thientruong
 *
 */
public class FundsEnoughState implements State {
	
	VendingMachine machine =null;
    public FundsEnoughState(VendingMachine machine) {
        this.machine =  machine;
    }

	/* (non-Javadoc)
	 * @see State#insertCoin()
	 */
	@Override
	public void insertCoin(Coin coin) {
		// TODO Auto-generated method stub
//		System.out.println("	FundsEnoughState: insertCoin=" + coin);
	}

	/* (non-Javadoc)
	 * @see State#selectItem()
	 */
	@Override
	public void dispenseItem(Item item) {
		// TODO Auto-generated method stub
		if (machine.isEnoughFund(item)) {
			machine.removeItemFromInventory(item);
			machine.currentBalance -= item.getPrice();
			System.out.println("Please pick up your " + item);
			machine.returnCoins();
		}else {
			System.err.println("You Inserted " + machine.currentBalance + "c. Not Enough For " + item.getName() + "(" + item.getPrice() + "c). Please add more coins.");
		}
		if (!machine.isEnoughFund())
			machine.setMachineState(machine.getFundsNotEnoughState());
	}

}
