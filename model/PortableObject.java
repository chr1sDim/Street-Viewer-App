package model;
/**
 * Class PortableObject.
 * A portable object can attach a location to it.
 * This location is the location where the object is. 
 * @author Christos Dimopoulos
 *
 */
public class PortableObject {
	
	private String description;
	private String objectLocation;
	
	/**
	 * Create a portable object. It takes the path to the object's image.
	 * @param description The path to the object's image.
	 */
	public PortableObject(String description) {
		this.description  = description;
	}
	
	/**
	 * Return the description of the portable object(the one specified in the constructor).
	 * @return description The description of the portable object.
	 */
	public String getItem(){
		return description;
	}
	
	/**
	 * Set the location of the portable object.
	 * @param objectLocation The location which is the portable object. 
	 */
	public void setItemLocation(String objectLocation){
		this.objectLocation = objectLocation;
	}
	
	/**
	 * Return the current location of the portable object.
	 * @return objectLocation The current location of the portable object. 
	 */
	public String getItemLocation(){
		return objectLocation;
	}

}
