import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class tiempo {
    int segundos, milesimas;

    public tiempo(int tiempo) {

        if (tiempo>=60){
            tiemposegudno();
            milesimas++;
            if (milesimas==1000){
                System.out.println(segundos);
                segundos--;
                milesimas=0;
            }
        }else if (segundos<=60){
            tiemposegudno();
            milesimas++;
            segundos--;
            milesimas=0;
        }

    }

    private void tiemposegudno(){
        try{
            Thread.sleep(1000);

        }catch (InterruptedException e){

        }
    }


}
