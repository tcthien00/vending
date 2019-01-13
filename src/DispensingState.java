/**
 * 
 */

/**
 * @author thientruong
 *
 */
public class DispensingState implements State {

    VendingMachine machine ;
    DispensingState(VendingMachine machine) {
        this.machine = machine;
    }
    
	/* (non-Javadoc)
	 * @see State#insertCoin()
	 */
	@Override
	public void insertCoin(Coin coin) {
		// TODO Auto-generated method stub
		System.out.println("DispensingState: insertCoin=" + coin);

	}

	/* (non-Javadoc)
	 * @see State#selectItem()
	 */
	@Override
	public void dispenseItem(Item item) {
		// TODO Auto-generated method stub
		System.out.println("DispensingState: selectItem=" + item);

	}

/*	 (non-Javadoc)
	 * @see State#dispense()
	 
	@Override
	public void returnCoins() {
		// TODO Auto-generated method stub
		System.out.println("DispensingState: dispense");

	}*/

}
