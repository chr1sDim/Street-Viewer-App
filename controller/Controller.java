package controller;

import java.util.ArrayList;
import java.util.List;

import model.Location;
import model.PortableObject;
import model.World;
import model.Inventory;
/**
 * Class Controller.
 * The controller class makes connection between the world and the interface. 
 * It takes signals form the interface and controls the actions needed to be taken.
 * @author Christos Dimopoulos
 *
 */
public class Controller {
	private ArrayList<String> views;
	private List<String> keylist = new ArrayList<String>();
	private List<Location> valuelist = new ArrayList<Location>();
	private World world = new World();
	private Inventory inventory = new Inventory();
	private Location currentLocation = world.getStartingLocation();
	private ArrayList<PortableObject> Objects = inventory.getObjects();
	private PortableObject Item;
	private String description;

	/**
	 * Change the Location to a new one which is linked to the current.
	 */
	public void gotoLocation() {
		// Try to leave current room. Get the next location, its "key"
		valuelist = currentLocation.getExit();
		keylist = currentLocation.getExitString();

		Integer ViewID = currentLocation.getViewPoint();
		String currentView = getLocation();

		if (keylist.get(ViewID) == currentView) {
			currentLocation = valuelist.get(ViewID);
			setView(ViewID);
		}
	}

	/**
	 * Set the view ID of the location. 
	 * This method is used for changing the starting view point of the new location.
	 * @param ViewID The ID of the view.
	 */
	public void setView(Integer ViewID) {
		if (ViewID != 0) {
			if (ViewID == 3) {
				currentLocation.setViewPoint(0);
			} else {
				currentLocation.setViewPoint(2);
			}
		} else {
			currentLocation.setViewPoint(0);

		}
	}

	/**
	 * Check if we can go forward from the current view of the location.
	 * @return True if its possible to change location. False if not.
	 */
	public Boolean checkForward() {
		valuelist = currentLocation.getExit();
		keylist = currentLocation.getExitString();

		Integer ViewID = currentLocation.getViewPoint();
		String currentView = getLocation();

		if (keylist.get(ViewID) != currentView) {
			return true;
		} else {
			return false;

		}

	}

	/**
	 * Turn to a different view in the current location.
	 * It takes arguments left or right.
	 * @param Way The way which the user wants to turn (right or left).
	 * @return the new view of the location which is right or left.
	 */
	public String TurnAround(String Way) {
		views = currentLocation.getView();
		Integer ViewID = currentLocation.getViewPoint();

		if (Way == "left") {
			if (ViewID == 0) {
				currentLocation.setViewPoint(3);
				return views.get(3);

			} else {
				currentLocation.setViewPoint(ViewID - 1);
				return views.get(ViewID - 1);

			}
		} else {
			if (ViewID == 3) {
				currentLocation.setViewPoint(0);
				return views.get(0);

			} else {
				currentLocation.setViewPoint(ViewID + 1);
				return views.get(ViewID + 1);

			}
		}
	}

	/**
	 * Return the view of the current location.
	 * @return the current view.
	 */
	public String getLocation() {
		views = currentLocation.getView();
		Integer ViewID = currentLocation.getViewPoint();
		return views.get(ViewID);
	}
	
	/**
	 * Return the current location's Map.
	 * @return the map of the current location.
	 */
	public String getMap() {
		description = currentLocation.getDescription();
		return description + "/" + "Map.png";
	}

	/**
	 * Check if the portable object is in the current location's view.
	 * @param ItemID The ID of the portable object.
	 * @return True if the portable object is in the current location's view. False if not.
	 */
	public boolean checkItemLocation(Integer ItemID) {
		Item = Objects.get(ItemID);
		String ItemLocation = Item.getItemLocation();
		String currentView = getLocation();
		if (ItemLocation == currentView) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Return the description of the portable object(the path + image).
	 * @param ItemID The ID of the portable object.
	 * @return The description of the portable object.
	 */
	public String getObjectName(Integer ItemID) {
		Item = Objects.get(ItemID);
		String objectName = Item.getItem();
		return objectName;
	}

	/**
	 * Set a location and view to the portable object.
	 * @param Location	The view of the given location.
	 * @param ItemID The ID of the portable object.
	 */
	public void setObjectLocation(String Location, Integer ItemID) {
		Item = Objects.get(ItemID);
		Item.setItemLocation(Location);
	}

}
