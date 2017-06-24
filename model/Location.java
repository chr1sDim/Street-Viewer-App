package model;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Class Location.
 * A location object consists of several views and a description.
 * It also contains the exits that are linked to this location.
 * @author Christos Dimopoulos
 *
 */
public class Location {

	private String description;

	private LinkedHashMap<String, Location> exits; // Stores the exits of the Location. Key: picture to show, Value: Next Locations' Reference.
	private ArrayList<String> views; // Stores the views of the Location.
	private ArrayList<Location> valuelist; 
	private ArrayList<String> keylist;
	private Integer viewID;

	/**
	 * Create a location. Initially, it has no exits and no views.
	 * @param description It is the folder of which each location refers to.
	 */
	public Location(String description) {
		this.description = description;
		views = new ArrayList<>();
		exits = new LinkedHashMap<>();
	}

	/**
	 * Add a view to the location.
	 * @param view A location's view.
	 */
	public void setView(String view) {
		views.add(view);
	}
	
	/**
	 * Return all the location's views in an arraylist.
	 * @return All the views which were created.
	 */
	public ArrayList<String> getView() {
		return views;
	}

	/**
	 * Set the location's view ID.
	 * @param viewPoint The locations' view ID. 
	 */
	public void setViewPoint(Integer viewPoint) {
		viewID = viewPoint;
	}

	/**
	 * Return the current view ID.
	 * @return view ID.
	 */
	public Integer getViewPoint() {
		return viewID;
	}

	/**
	 * Define an exit from this location.
	 * @param direction The view which leads to the exit.
	 * @param neighbor The location to which the exit leads.
	 */
	public void setExit(String direction, Location neighbor) {
		exits.put(direction, neighbor);
	}

	/**
	 * Return the description (locations' folder name) of the location (the one that was defined in the constructor).
	 * @return The location's description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Return all the views that are attached to the location's exit in an arraylist.
	 * @return Details of the location's exits(the views specified).
	 */
	public List<String> getExitString() {
		keylist = new ArrayList<String>(exits.keySet());
		return keylist;
	}

	/**
	 * Return all the location's exits in an arraylist.
	 * @return The references of the locations from which you can exit.
	 */
	public List<Location> getExit() {
		valuelist = new ArrayList<Location>(exits.values());
		return valuelist;
	}
}
