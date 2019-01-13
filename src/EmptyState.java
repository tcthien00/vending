/**
 * 
 */

/**
 * @author thientruong
 *
 */
public class EmptyState implements State {
	
    VendingMachine machine;
    public EmptyState(VendingMachine machine) {
        this.machine =  machine;
    }

	/* (non-Javadoc)
	 * @see State#insertCoin()
	 */
	@Override
	public void insertCoin(Coin coin) {
		// TODO Auto-generated method stub
		System.out.println("EmptyState: insertCoin=" + coin);

	}

	/* (non-Javadoc)
	 * @see State#selectItem()
	 */
	@Override
	public void dispenseItem(Item item) {
		// TODO Auto-generated method stub
		System.out.println("EmptyState: selectItem=" + item);
	}

/*	 (non-Javadoc)
	 * @see State#dispense()
	 
	@Override
	public void returnCoins() {
		// TODO Auto-generated method stub
		System.out.println("EmptyState: dispense=");
	}*/

}
