import javax.swing.*;

public class MoveCar extends Thread{

    int end = 0, n = 0;
    JLabel car = null;
    static Thread thread;

    public MoveCar(JLabel car,int x,int y){
        thread = new Thread(this);
        this.car = car;
        end = x;
        n = y;
        start();
    }

    public void run(){
        while (car.getX() != end && MyFrame.on){
            car.setBounds(car.getX()+n,car.getY(),car.getWidth(),car.getHeight());
            try {
                sleep(1);
            }
            catch (Exception e){}
        }
    }
}
