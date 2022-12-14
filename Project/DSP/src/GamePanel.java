import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable{

    JLabel road, road2;
    static JLabel whiteCar, blueCar;
    static JLabel score = new JLabel("Score : 0");
    static Thread thread;
    MyTimer timer;
    public static final int HEIGHT = 1600;

    public GamePanel(String car,String op){
        setImages(car,op);
        JLabel time = new JLabel();
        addCom(time);
        design(time);

        timer = new MyTimer(time);
        RandomCars randomCars = new RandomCars(blueCar);
        thread.start();
        timer.start();
        randomCars.start();
    }

    public void run(){
        while (MyFrame.on){
            road.setBounds(0,road.getY()+1,380,HEIGHT);
            road2.setBounds(0,road2.getY()+1,380,HEIGHT);
            try{
                Thread.sleep(5);
            }
            catch (Exception e){

            }
            if(road.getY() == (HEIGHT/2))
                road.setBounds(0,-1 * (HEIGHT + (HEIGHT/2)),380,HEIGHT);
            if(road2.getY() == (HEIGHT/2))
                road2.setBounds(0,-1 * (HEIGHT + (HEIGHT/2)),380,HEIGHT);
        }
    }

    public void leftSide(){
        new MoveCar(whiteCar,40,-2);
    }
    public void rightSide(){
        new MoveCar(whiteCar,240,2);
    }

    private ImageIcon getImageIcon(String name,int w,int h){
        ImageIcon imageIcon = new ImageIcon(name);
        Image image = imageIcon.getImage();
        Image imag = image.getScaledInstance(w,h,Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(imag);

        return imageIcon;
    }

    private void addCom(JLabel time){
        add(score);
        add(time);
        add(blueCar);
        add(whiteCar);
        add(road);
        add(road2);
    }

    private void setImages(String car,String op){
        thread = new Thread(this);
        setLayout(null);

        whiteCar = new JLabel(getImageIcon(car,100,200));
        road = new JLabel(getImageIcon("images/road.jpeg",380,HEIGHT));
        road2 = new JLabel(getImageIcon("images/road.jpeg",380,HEIGHT));
        blueCar = new JLabel(getImageIcon(op,100,200));
    }

    private void design(JLabel time){
        time.setForeground(Color.ORANGE);
        score.setForeground(Color.WHITE);
        time.setBounds(10,10,50,20);
        score.setBounds(310,10,80,20);
        road.setBounds(0, -1 * HEIGHT/2, 380, HEIGHT);
        road2.setBounds(0, -1 * (HEIGHT + (HEIGHT/2)), 380, HEIGHT);
        whiteCar.setBounds(40,(HEIGHT/2)-300,100,200);
    }
}