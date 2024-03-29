package controller;

import Imodel.*;
import model.*;
import model.Character;
//import model.Character;
import Iview.*;
import view.View;


/**
 * <b> This class is a design patern Factory </b>
 * <p> It have to create object in few method to simplify the code when a constructor is modified.</p>
 * @author Antoine Savalle
 * @version 1.5
 * @see Controller, ControllerDB, ControllerDAO
 */
public abstract class Factory {
	
	// ------ Java Object ------ //
	public static String createString(){
		return new String();
	}
	// ------------------------ //
	
	
	
	
	
	// --- Controller Object --- //
	
	public static ControllerDB createControllerDB() {
		// TODO Auto-generated method stub
		try {
			return new ControllerDB("java", "bigouneroot");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// ------------------------ //
	
	
	
	
	
	// ----- Model Object ----- //
	public static IModel createModel(){
			try {
				return (IModel) new Model();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	public static IHuman createHuman() throws Exception{
		return (IHuman) new Human();
	}
	
	public static IDummy createDummy() throws Exception{
		return (IDummy) new Dummy();
	}
	
	public static IPlayer createPlayer(int idPlayer, String playerName){
		 return (IPlayer) new Player(idPlayer, playerName);
	}
	
	public static IBoundary createBoundary(ITray tray, IDelimitations delimitations){
		return (IBoundary) new Boundary((Tray)tray, (Delimitations) delimitations);
	}
	
	public static IBoundary createBoundary(ITray iTray, int a, int b, int c, int d){
		try {
			return (IBoundary) new Boundary((Tray) iTray, a, b, c, d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
 	public static Tile createTile(Block iBlock, Position position){
 		return new Tile(iBlock,  position);
 	}
 	
 	public static Position createPosition(Tray iTray, int a, int b){
 		try {
			return new Position( iTray, a, b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return null;
 	}
 	
 	public static IHero createHero(IHuman iHuman, IObjective iObjective, IPosition iPosition){
 		return (IHero) new Hero((Character) iHuman, (Objective) iObjective, (Position) iPosition);
 	}
 	
 	public static IEnemy createEnemy(IDummy iDummy, Direction direction, IPosition iPosition){
 		return (IEnemy) new Enemy((Dummy) iDummy, direction, (Position) iPosition);
 	}
 	
 	public static IDiamond createDiamond() throws Exception{
 		return (IDiamond) new Diamond();
 	}
 	
 	public static IRock createRock() throws Exception{
 		return (IRock) new Rock();
 	}
 	
 	public static IAir createAir() throws Exception{
		return (IAir) new Air();
	}
 	
 	public static IMud createMud() throws Exception{
 		return (IMud) new Mud();
 	}
 	
 	public static IWall createWall() throws Exception{
 		return (IWall) new Wall();
 	}
	// ------------------------ //
	
	
	
	
	
	// ----- View Object ----- //
	public static IView createView(IModel model/*, ControllerKeyBoard controllerKey*/){
			return new View(model /*,controllerKey*/);
		}
	// ------------------------ //







}
