package model;

import view.View;

public class Diamond extends Block {
	
	public Diamond() throws Exception{
		super("Diamond", 'D', "C:/Users/MMoul/desktop/Blocks.png", new Coordinates(64, 0));
	}
	
	@Override
	public boolean isFallable() {
		return true;
	}
	
	@Override
	public boolean isSmooth() {
		return true;
	}
	
	@Override
	public boolean isReward() {
		return true;
	}
}
