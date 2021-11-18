package bomberman;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class homegame extends JPanel{

    private ImageIcon BG = new ImageIcon(this.getClass().getResource("bomberman-info.jpg"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("start.png"));
    public JButton BStart = new JButton(start);
    public JButton BExit = new JButton(exit);
    homegame(){
        setLayout(null);
        BExit.setBounds(500, 600, 170,90);
        add(BExit);
        BStart.setBounds(750,600,170,90);
        add(BStart);
 }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(BG.getImage(),0,0,1000,800,this);
        g.setColor(Color.RED);
        g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));
        g.drawString(">BOMBERMAN<",140,200);
 }
    public static void main(String[] args){
        
        new homegame();
   }
}
