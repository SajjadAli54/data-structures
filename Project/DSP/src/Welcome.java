import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame {

    JButton play = new JButton("Play");
    JButton exit = new JButton("Exit");
    JComboBox selectCar;
    JLabel background, bg;

    Welcome(){
        adjust();
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.on = true;
                GamePanel.score.setText("Score : 0");
                int index = selectCar.getSelectedIndex();
                String car = "", op = "";
                switch (index){
                    case 0:
                        car = "images/white.png";
                        op = "images/blue.png";
                        break;
                    case 1:
                        car = "images/blueCar.png";
                        op = "images/yellow.png";
                        break;
                    case 2 :
                        car = "images/yellowCar.png";
                        op = "images/whiteCar.png";
                        break;
                    case 3:
                        car = "images/brown.png";
                        op = "images/yellow.png";
                        break;
                }
                new MyFrame(car,op);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Welcome();
            }
        });
    }

    private void adjust(){
        setTitle("Car Game");
        setSize(400,810);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("images/white.png").getImage());

        play.setBounds(30,280,120,60);
        play.setBackground(Color.GREEN);
        exit.setBounds(30,440,120,60);
        exit.setBackground(Color.GREEN);
        play.setIcon(new ImageIcon("images/play.png"));
        exit.setIcon(new ImageIcon("images/exit.png"));

        background = new JLabel(get("images/background.png",400,810));
        background.setBounds(0,0,400,810);
        bg = new JLabel(get("images/white.png",100,200));
        bg.setBounds(150,460,100,200);
        add(play);
        add(exit);
        setSelectCar();
        add(bg);
        add(background);
        setVisible(true);
    }

    private ImageIcon get(String name,int w, int h){
        ImageIcon imageIcon = new ImageIcon(name);
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(w,h,Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        return imageIcon;

    }

    private void setSelectCar(){
        ImageIcon[] arr = {get("images/white.png",20,40),
                get("images/blueCar.png",20,40),
                get("images/yellowCar.png",20,40),
                get("images/brown.png",20,40)
        };
        selectCar = new JComboBox(arr);
        selectCar.setBackground(Color.GREEN);
        selectCar.setBounds(30,360,120,60);
        add(selectCar);
    }
}
