package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

/**
 * Class WorldViewer.
 * WorldViewer handles all the Interface specifics.
 * @author Christos Dimopoulos.
 *
 */
public class WorldViewer {

	private Controller controller = new Controller();
	private String name, Map;

	@FXML
	private TextField backpackHeading;
	@FXML
	private MenuItem pickItem_1, pickItem_2, pickItem_3;
	@FXML
	private MenuItem dropItem_1, dropItem_2, dropItem_3;
	@FXML
	private ImageView imageView, mapView, backImage;
	@FXML
	private ImageView image_1_Up, image_1_Down;
	@FXML
	private ImageView image_2_Up, image_2_Down;
	@FXML
	private ImageView image_3_Up, image_3_Down;
	@FXML
	private Button forwardbutton;

	/**
	 * It shows the first portable object image to the current view when you click the bar pick up or drop.
	 * It also disables or enables the relevant menu bar.
	 * @param event The action event from the menu bar.
	 */
	public void showFirstItem(ActionEvent event) {

		String Image1 = controller.getObjectName(0);

		if (event.getSource().equals(pickItem_1)) {
			Image imageItem1 = new Image(Image1);
			image_1_Down.setImage(imageItem1);
			image_1_Up.setImage(null);
			pickItem_1.setDisable(true);
			dropItem_1.setDisable(false);
			controller.setObjectLocation(null, 0);

		} else {
			Image imageItem1 = new Image(Image1);
			image_1_Down.setImage(null);
			image_1_Up.setImage(imageItem1);
			pickItem_1.setDisable(false);
			dropItem_1.setDisable(true);
			controller.setObjectLocation(controller.getLocation(), 0);
		}

	}

	/**
	 * It shows the second portable object to the current view when you click the bar pick up or drop.
	 * It also disables or enables the relevant menu bar.
	 * @param event The action event from the menu bar.
	 */
	public void showSecondItem(ActionEvent event) {

		String Image2 = controller.getObjectName(1);

		if (event.getSource().equals(pickItem_2)) {
			Image imageItem2 = new Image(Image2);
			image_2_Down.setImage(imageItem2);
			image_2_Up.setImage(null);
			pickItem_2.setDisable(true);
			dropItem_2.setDisable(false);
			controller.setObjectLocation(null, 1);

		} else {
			Image imageItem2 = new Image(Image2);
			image_2_Down.setImage(null);
			image_2_Up.setImage(imageItem2);
			pickItem_2.setDisable(false);
			dropItem_2.setDisable(true);
			controller.setObjectLocation(controller.getLocation(), 1);
		}

	}

	/**
	 * It shows the third portable object to the current view when you click the bar pick up or drop.
	 * It also disables or enables the relevant menu bar.
	 * @param event The action event from the menu bar.
	 */
	public void showThirdItem(ActionEvent event) {
		String Image3 = controller.getObjectName(2);

		if (event.getSource().equals(pickItem_3)) {
			Image imageItem3 = new Image(Image3);
			image_3_Down.setImage(imageItem3);
			image_3_Up.setImage(null);
			pickItem_3.setDisable(true);
			dropItem_3.setDisable(false);
			controller.setObjectLocation(null, 2);

		} else {
			Image imageItem3 = new Image(Image3);
			image_3_Down.setImage(null);
			image_3_Up.setImage(imageItem3);
			pickItem_3.setDisable(false);
			dropItem_3.setDisable(true);
			controller.setObjectLocation(controller.getLocation(), 2);
		}
	}

	/**
	 * Handle the action when the left arrow button is pressed.
	 * @param event The action when the button is pressed.
	 */
	public void leftButton(ActionEvent event) {
		String NewDirection = controller.TurnAround("left");
		showImage(NewDirection);
		showItemImage();
		forwardArrow();
	}

	/**
	 * Handle the action when the right arrow button is pressed.
	 * @param event The action when the button is pressed.
	 */
	public void rightButton(ActionEvent event) {
		String NewDirection = controller.TurnAround("right");
		showImage(NewDirection);
		showItemImage();
		forwardArrow();
	}

	/**
	 * Handle the action when the forward arrow button is pressed.
	 * @param event The action when the button is pressed.
	 */
	public void forwardButton(ActionEvent event) {
		controller.gotoLocation();
		name = controller.getLocation();
		showImage(name);

		Map = controller.getMap();
		showMap(Map);

		showItemImage();
		forwardArrow();
	}

	/**
	 * Enables or disables the forward button.
	 */
	public void forwardArrow() {
		Boolean forwardflag = controller.checkForward();
		forwardbutton.setDisable(forwardflag);
	}

	/**
	 * Show the current Image View.
	 * @param Direction This the view(path + image) of the location to be shown.
	 */
	public void showImage(String Direction) {
		Image image = new Image(Direction);
		imageView.setImage(image);
	}
	
	/**
	 * Show the map of the current location.
	 * @param Map The name of the map to be shown.
	 */
	public void showMap(String Map) {
		Image imageMap = new Image(Map);
		mapView.setImage(imageMap);
		mapView.setFitWidth(200);
	}

	/**
	 * Handle the portable objects images.
	 * It gets flags from the controller if the portable images are in the current location view.
	 * Handle the relevant image menu bar buttons.
	 */
	public void showItemImage() {

		String Image1 = controller.getObjectName(0);
		String Image2 = controller.getObjectName(1);
		String Image3 = controller.getObjectName(2);

		// make a flag for
		boolean flag1 = controller.checkItemLocation(0);
		boolean flag2 = controller.checkItemLocation(1);
		boolean flag3 = controller.checkItemLocation(2);
		if (flag1) {
			Image imageItem1 = new Image(Image1);
			image_1_Up.setImage(imageItem1);
			pickItem_1.setDisable(false);
			dropItem_1.setDisable(true);
		} else {
			image_1_Up.setImage(null);
			if (image_1_Down.getImage() != null) {
				pickItem_1.setDisable(true);
				dropItem_1.setDisable(false);
			} else {
				pickItem_1.setDisable(true);
				dropItem_1.setDisable(true);
			}
		}
		if (flag2) {
			Image imageItem2 = new Image(Image2);
			image_2_Up.setImage(imageItem2);
			pickItem_2.setDisable(false);
			dropItem_2.setDisable(true);
		} else {
			image_2_Up.setImage(null);
			if (image_2_Down.getImage() != null) {
				pickItem_2.setDisable(true);
				dropItem_2.setDisable(false);
			} else {
				pickItem_2.setDisable(true);
				dropItem_2.setDisable(true);
			}
		}
		if (flag3) {
			Image imageItem3 = new Image(Image3);
			image_3_Up.setImage(imageItem3);
			pickItem_3.setDisable(false);
			dropItem_3.setDisable(true);
		} else {

			image_3_Up.setImage(null);
			if (image_3_Down.getImage() != null) {
				pickItem_3.setDisable(true);
				dropItem_3.setDisable(false);
			} else {
				pickItem_3.setDisable(true);
				dropItem_3.setDisable(true);
			}
		}
	}

	/**
	 * Initialize the Interface to be shown when the application starts.
	 */
	public void Initialise() {

		name = controller.getLocation();
		showImage(name);

		Map = controller.getMap();
		showMap(Map);
		backpackHeading.setDisable(true);
		Image backimage = new Image("/miscellaneous/backpack.jpg");
		backImage.setImage(backimage);

		pickItem_1.setDisable(true);
		pickItem_2.setDisable(true);
		pickItem_3.setDisable(true);

		String Image1 = controller.getObjectName(0);
		Image imageItem1 = new Image(Image1);
		image_1_Down.setImage(imageItem1);

		String Image2 = controller.getObjectName(1);
		Image imageItem2 = new Image(Image2);
		image_2_Down.setImage(imageItem2);

		String Image3 = controller.getObjectName(2);
		Image imageItem3 = new Image(Image3);
		image_3_Down.setImage(imageItem3);

	}
}
