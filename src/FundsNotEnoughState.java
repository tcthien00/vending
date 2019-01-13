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

	/* (non-Javadoc)
	 * @see State#insertCoin()
	 */
	@Override
	public void insertCoin(Coin coin) {
		// TODO Auto-generated method stub
//		System.out.println("	FundsNotEnoughState: insertCoin=" + coin);
        if (machine.isEnoughFund()) {
            machine.setMachineState(machine.getFundsEnoughState());
        }
	}

	/* (non-Javadoc)
	 * @see State#selectItem()
	 */
	@Override
	public void dispenseItem(Item item) {
		// TODO Auto-generated method stub
		System.err.println("You Inserted " + machine.currentBalance + "c. Not Enough For " + item.getName() + "(" + item.getPrice() + "c). Please add more coins.");
	}

}
