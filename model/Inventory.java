package model;

import java.util.ArrayList;
/**
 * Class Inventory.
 * A class which creates all the portable objects.
 * @author Christos Dimopoulos
 *
 */
public class Inventory {
	private ArrayList<PortableObject> Objects = new ArrayList<PortableObject>();
	
	/**
	 * Create the inventory and initializes the Portable Objects.
	 */
	public Inventory() {
		createObjects();
	}

	/**
	 * Create all the Portable Objects and specify the paths to the images.
	 */
	public void createObjects() {
		PortableObject Object1, Object2, Object3;
		Object1 = new PortableObject("/miscellaneous/sunglasses.png");
		Objects.add(Object1);
		Object2 = new PortableObject("/miscellaneous/basketball.png");
		Objects.add(Object2);
		Object3 = new PortableObject("/miscellaneous/headphones.png");
		Objects.add(Object3);
	}

	/**
	 * Return all the portable objects created in an arraylist.
	 * @return All the portable objects.
	 */
	public ArrayList<PortableObject> getObjects() {
		return Objects;
	}
}
