import javax.swing.*;

public class MyTimer extends Thread{
    static Thread thread;
    JLabel time = null;

    public MyTimer(JLabel label){
        this.time = label;
        thread = new Thread(this);
    }

    public void run(){
        for(int j = 0;MyFrame.on;j++){
            String min = j + ":";
            if(j <= 9)
                min = "0"+min;
            for(int i=0;i<60 && MyFrame.on;i++){
                String sec = "" + i;
                if(i<=9)
                    sec = "0"+sec;
                time.setText(min + sec);
                try{
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
    }
}
