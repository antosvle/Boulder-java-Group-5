package menu;



import menu.Game;



/**

 * Created by Nicolas on 21/06/2017.
 * Main.
 *
 * @param args the args
 */

public class Launcher {
    public static void runMenu(){
         Game game = new Game("Boulder Dash", 1152,832);
         game.start();
        Sound sound = new Sound();
        sound.start(100000,3);
    }
}
