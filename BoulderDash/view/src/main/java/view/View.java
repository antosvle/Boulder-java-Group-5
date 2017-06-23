package view;

import javax.swing.JFrame;
import Imodel.IBeing;
import Imodel.IEntity;
import Imodel.IModel;
import Iview.IView;

public class View implements IView {

	private Frame frame;
	//private IControllerKeyBoard controller;
	private IModel model;
	private String frameTitle = "TestVue";
	private int frameWidth = 1200, frameHeight = 800;
	
	public View(IModel model/*, IControllerKeyBoard controller*/) {
		this.model = model;
		//this.controller = controller;
		
		frame = new Frame(frameTitle);
        frame.setSize(frameWidth,  frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public void frame() throws Exception {
		
		frame.getContentPane().removeAll();
		
		for (IBeing being : model.getLevel().getTray().getBeings().values()) {
			printEntity((IEntity) being);
		}
		
		for (IEntity entity: model.getLevel().getTray().getTiles().values()) {
			printEntity(entity);
		}

		frame.repaint();
	}
	
	private void printEntity(IEntity entity) {
		frame.add(new Component(entity));
		frame.validate();
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}
	
	public Frame getFrame(){
		return frame;
	}

}
