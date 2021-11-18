package bomberman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

 
public final class Engine
{
    private static final int TIME_STEP = 30;
    private static int width = 20;
    private static int height = 15;
    private static int nrOfEnemies = 15;
    private static Timer clockTimer = null;

    private Engine() {}
    
    public static void main(String[] args) {
	startGame();
    }
    
      public static class textgameover extends JFrame {          
    }

      public static void textgameover() {
    }

      public static class textgamewin extends JFrame {          
    }

      public static void textgamewin() {
    }      

      
    public static void startGame() {
	Floor floor = new Floor(width, height, nrOfEnemies);
	BombermanFrame frame = new BombermanFrame("BOMBERMAN", floor);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	floor.addFloorListener(frame.getBombermanComponent());

	Action doOneStep = new AbstractAction()
	{
	    public void actionPerformed(ActionEvent e) {
		tick(frame, floor);
	    }
	};
	clockTimer = new Timer(TIME_STEP, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
    
    }

    private static void gameOver(BombermanFrame frame, Floor floor) {
        clockTimer.stop();
        textgameover();
        JFrame Pframe= new textgameover();
        Pframe.add(new JLabel("GAME OVER!", JLabel.CENTER));
        Pframe.setTitle("BOMBERMAN");
        Pframe.setSize(300, 300);
        Pframe.setLocationRelativeTo(null); // Center the frame
        Pframe.setVisible(true);
	frame.dispose();
        Pframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
	//startGame();
    }
    /*
    private static void gamewin(BombermanFrame frame, Floor floor) {
        clockTimer.stop();
        textgamewin();
        JFrame Pframe= new Engine.textgamewin();
        Pframe.add(new JLabel("YOU WIN!!!(>_<)", JLabel.CENTER));
        Pframe.setTitle("BOMBERMAN");
        Pframe.setSize(300, 300);
        Pframe.setLocationRelativeTo(null); // Center the frame
        Pframe.setVisible(true);
	//frame.dispose();
	//startGame();
    }
    */
    private static void tick(BombermanFrame frame, Floor floor) {
	if (floor.getIsGameOver()) {
	    gameOver(frame, floor);
	} else {
            floor.moveEnemies();
	    floor.bombCountdown();
	    floor.explosionHandler();
	    floor.characterInExplosion();
	    floor.notifyListeners();
	}
    }
}
