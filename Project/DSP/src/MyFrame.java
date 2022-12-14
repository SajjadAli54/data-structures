import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame {

    JFrame frame = new JFrame("My Car Game");
    static boolean on = true;

    public MyFrame(String car,String op){
        GamePanel panel = new GamePanel(car,op);
        listener(panel);
        set(panel);
    }

    private void set(GamePanel panel){
        frame.setSize(400, 810);
        frame.setIconImage(new ImageIcon("images/white.png").getImage());
        frame.add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void listener(GamePanel panel){
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 37)
                    panel.leftSide();
                else if(e.getKeyCode() == 39)
                    panel.rightSide();
            }
        });
    }
}
