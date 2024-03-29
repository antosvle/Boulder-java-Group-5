package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Imodel.IBeing;
import Imodel.IEntity;
import Imodel.IModel;
import Iview.IView;

/**
 * View create the window which will display the game
 * 
 * @author Pierre Hamel
 *
 */
public class View implements IView {

	private Frame frame;
	//private IControllerKeyBoard controller;
	private IModel model;
	
	/**
	 * Defines the title of the window
	 */
	private String frameTitle = "Boulder Dash";
	
	/**
	 * Defines the width and height of the window
	 */
	private int frameWidth = 1200, frameHeight = 800;
	
	/**
	 * Constructor 
	 * Contains the window parameters
	 * @param model
	 */
	public View(IModel model/*, IControllerKeyBoard controller*/) {
		this.model = model;
		//this.controller = controller;
		
		frame = new Frame(frameTitle);
        frame.setSize(frameWidth,  frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
        frame.setSize(32 + model.getLevel().getTray().getBoundary().getXMax() * 32, 32 + model.getLevel().getTray().getBoundary().getYMax() * 32);
	}
	
	/**
	 * Remove all entities and then load entities and print them
	 */
	public void frame() throws Exception {

		for (IEntity entity: model.getLevel().getTray().getTiles().values()) {
            printEntity(entity);
        }

        for (IBeing being : model.getLevel().getTray().getBeings().values()) {
            printEntity((IEntity) being);
        }
    }
	
	/**
	 * Add new entity to print it
	 */
	private void printEntity(IEntity entity) {
        frame.getGraphics().drawImage(entity.getElement().getSheet(), entity.getPosition().getX() *32, entity.getPosition().getY()  * 32, 32, 32, null);
    }

	/**
	 * Getter for the window width
	 * @return frameWidth
	 */
	public int getFrameWidth() {
		return frameWidth;
	}
	
	/**
	 * Getter for the window height
	 * @returnframeHeight
	 */
	public int getFrameHeight() {
		return frameHeight;
	}
	
	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	/**
	 * @return frame
	 */
	public Frame getFrame(){
		return frame;
	}
	
	public void win() throws InterruptedException{
		JOptionPane.showMessageDialog(null, "You win !");
		System.exit(-1);
	}
	
	public void lose() throws InterruptedException{
		JOptionPane.showMessageDialog(null, "Game Over");
		System.exit(-1);
	}

}
