import javax.swing.*;
import java.util.Random;

public class RandomCars extends Thread {

    public static Thread thread;
    Random random = new Random();
    JLabel car;

    public RandomCars(JLabel car){
        this.car = car;
    }

    public void run(){
        thread = new Thread(this);
        int x = 0, score = 0;
        if(random.nextInt(2) == 0)
            x = 40;
        else
            x = 240;
        car.setBounds(x,-200,100,200);
        for(int i=0;i<1000;i+=2){
            try{
                Thread.sleep(5);
                car.setBounds(x,-200 + i,100,200);
            }
            catch (Exception e){JOptionPane.showMessageDialog(null,e);}
            if(i >= 998){
                GamePanel.score.setText("Score : "+(++score));
                i = 0;
                if(random.nextInt(2) == 0)
                    x = 40;
                else
                    x = 240;
            }
            if(collide()){
                stopAll();
                break;
            }
        }
    }

    public boolean collide(){
        int x1 = GamePanel.blueCar.getX();
        int y1 = GamePanel.blueCar.getY();
        int x2 = GamePanel.whiteCar.getX();
        int y2 = GamePanel.whiteCar.getY();
        boolean flag = false;
        if (x1 >= x2 && x1 <= x2 + 100 && y1 >= y2 && y1 <= y2 + 200)
            flag = true;
        else if(x1 + 100 >= x2 && x1 + 100<= x2 + 100 && y1 >= y2 && y1 <= y2 + 200)
            flag = true;
        else if(x1 + 100 >= x2 && x1 + 100<= x2 + 100 && y1 + 200>= y2 && y1 + 200 <= y2 + 200)
            flag = true;
        else if (x1 >= x2 && x1 <= x2 + 100 && y1 + 200 >= y2 && y1 + 200 <= y2 + 200)
            flag = true;
        return flag;
    }

    private void stopAll(){
        MyFrame.on = false;
        JOptionPane.showMessageDialog(null,"Oops. You lost");
        new Welcome();
    }
}
