/**
 * 
 */

/**
 * @author thientruong
 *
 */
public enum Item {

	ITEM1("Item1", 55), ITEM2("Item2", 70), ITEM3("Item3", 75);
	
	private String name;
	private int price;
	
	private Item(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public String getName(){
		return name;
	}
	
	public long getPrice(){
		return price;
	}
	
}
