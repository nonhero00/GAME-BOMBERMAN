package bomberman;
import static bomberman.Engine.startGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class PlayGames extends JFrame implements ActionListener{
    homegame homegame1 = new homegame();

public PlayGames(){
    this.setSize(1000,800);
    this.add(homegame1);
    homegame1.BStart.addActionListener(this);
    homegame1.BExit.addActionListener(this);
 }
public void actionPerformed(ActionEvent e){
    if(e.getSource()== homegame1.BStart){
        dispose();
        startGame();
    }
    else if(e.getSource()== homegame1.BExit){
        System.exit(0);
    }
}

public static void main(String[] args) {
JFrame gg = new PlayGames();
gg.setSize(1000,800);
gg.setTitle("BOMBERMAN");
gg.setVisible(true);
gg.setLocationRelativeTo(null);;
gg.setDefaultCloseOperation(EXIT_ON_CLOSE);
 
   }
}




