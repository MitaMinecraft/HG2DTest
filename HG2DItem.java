import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 03.06.13
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public class HG2DItem {
	private String itemName;
	private int itemID;
	private static String[] nameData = {"Item0", "Item1", "Item2", "Item3"};

	public HG2DItem(int id) {
		if(id < -1 || id > nameData.length) {
			System.out.println("Error, invalid itemID!");
			return;
		} else if (id == -1) { //Empty item
			itemName = "None";
		} else {
			itemName = nameData[id];
		}
		itemID = id;
	}
	public  HG2DItem(String name) {
		if(name.equalsIgnoreCase("none")) {
			itemID = -1;
		} else if(!Arrays.asList(nameData).contains(name)) {
			System.out.println("Error, invalid itemName!");
			return;
		} else {
			itemID = Arrays.asList(nameData).indexOf(name);
		}
		itemName = name;
	}
	public String getName() {
		return itemName;
	}
	public int getID() {
		return itemID;
	}
}
