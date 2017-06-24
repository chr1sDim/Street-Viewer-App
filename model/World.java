package model;
/**
 * Class World.
 * This is a class which creates the map of the world which of the locations and their views.
 * Each location gets a description which is the path to the folder that contains its view images.
 * It also sets the starting location.
 * @author Christos Dimopoulos
 *
 */
public class World {
	private Location currentLocation;

	/**
	 * Create the world and initialize its internal map.
	 */
	public World() {
		createLocations();
	}

	/**
	 * Create all the Locations and link their exits together.
	 */
	private void createLocations() {
		Location location1, location2, location3, location4, location5, location6, location7, location8;

		// create the Locations
		location1 = new Location("/location1");
		location2 = new Location("/location2");
		location3 = new Location("/location3");
		location4 = new Location("/location4");
		location5 = new Location("/location5");
		location6 = new Location("/location6");
		location7 = new Location("/location7");
		location8 = new Location("/location8");

		location1.setView("/location1/view1.jpg");
		location1.setView("/location1/view2.jpg");
		location1.setView("/location1/view3.jpg");
		location1.setView("/location1/view4.jpg");

		location2.setView("/location2/view1.jpg");
		location2.setView("/location2/view2.jpg");
		location2.setView("/location2/view3.jpg");
		location2.setView("/location2/view4.jpg");

		location3.setView("/location3/view1.jpg");
		location3.setView("/location3/view2.jpg");
		location3.setView("/location3/view3.jpg");
		location3.setView("/location3/view4.jpg");

		location4.setView("/location4/view1.jpg");
		location4.setView("/location4/view2.jpg");
		location4.setView("/location4/view3.jpg");
		location4.setView("/location4/view4.jpg");

		location5.setView("/location5/view1.jpg");
		location5.setView("/location5/view2.jpg");
		location5.setView("/location5/view3.jpg");
		location5.setView("/location5/view4.jpg");

		location6.setView("/location6/view1.jpg");
		location6.setView("/location6/view2.jpg");
		location6.setView("/location6/view3.jpg");
		location6.setView("/location6/view4.jpg");

		location7.setView("/location7/view1.jpg");
		location7.setView("/location7/view2.jpg");
		location7.setView("/location7/view3.jpg");
		location7.setView("/location7/view4.jpg");

		location8.setView("/location8/view1.jpg");
		location8.setView("/location8/view2.jpg");
		location8.setView("/location8/view3.jpg");
		location8.setView("/location8/view4.jpg");

		// initialize room exits
		location1.setExit("/location1/view1.jpg", location2);
		location1.setExit("/location1/view2.jpg", location7);
		location1.setExit("NoExit1", location1);
		location1.setExit("NoExit2", location1);

		location2.setExit("/location2/view1.jpg", location3);
		location2.setExit("NoExit1", location2);
		location2.setExit("/location2/view3.jpg", location1);
		location2.setExit("NoExit2", location2);

		location3.setExit("/location3/view1.jpg", location4);
		location3.setExit("NoExit1", location3);
		location3.setExit("/location3/view3.jpg", location2);
		location3.setExit("NoExit2", location3);

		location4.setExit("/location4/view1.jpg", location5);
		location4.setExit("NoExit1", location4);
		location4.setExit("/location4/view3.jpg", location3);
		location4.setExit("NoExit2", location4);

		location5.setExit("/location5/view1.jpg", location6);
		location5.setExit("NoExit1", location5);
		location5.setExit("/location5/view3.jpg", location4);
		location5.setExit("NoExit2", location5);

		location6.setExit("/location6/view1.jpg", location7);
		location6.setExit("NoExit1", location6);
		location6.setExit("/location6/view3.jpg", location5);
		location6.setExit("NoExit2", location6);

		location7.setExit("/location7/view1.jpg", location1);
		location7.setExit("NoExit1", location7);
		location7.setExit("/location7/view3.jpg", location6);
		location7.setExit("/location7/view4.jpg", location8);

		location8.setExit("NoExit1", location8);
		location8.setExit("NoExit2", location8);
		location8.setExit("/location8/view3.jpg", location7);
		location8.setExit("NoExit3", location8);

		// start from the entrance
		currentLocation = location1;
		currentLocation.setViewPoint(0);
	}
	
	/**
	 * Return the starting Location.
	 * @return The starting Location.
	 */
	public Location getStartingLocation() {
		return currentLocation;
	}

}