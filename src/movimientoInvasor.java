import javax.swing.*;
import java.util.ArrayList;

public class movimientoInvasor extends Thread{
    ArrayList<invasor> aliens;
    JFrame formPadre;
    jugador jugador;

    public movimientoInvasor(ArrayList<invasor> aliens, JFrame form, jugador jugador){

        super();
        this.aliens = aliens;
        this.formPadre = form;
        this.jugador = jugador;
    }

    public boolean choqueJugador(invasor alien){
        return alien.hitbox.intersects(jugador.hitbox);
    }

   /* public boolean choquefondo(invasor alien){
       return  alien.hitbox.intersects(tablero.getOwnerlessWindows().length, )
    }
*/
    public void run(){
        while (aliens.size()>0){
            try {
                for (invasor alien: aliens){
                    alien.moveDown();
                }

                for (invasor alien: aliens){

                    if (choqueJugador(alien)){
                        JOptionPane.showMessageDialog(null, "Ha terminado la partida");
                        return;
                    }
                    alien.actualizarTablero();
                }

                System.out.println("\n- movimiento aliens");
                sleep(1000);
            }catch (Exception e){
                System.out.println("error en aliens al mover");
                e.printStackTrace();
            }finally {
                formPadre.repaint();
            }

        }
    }
}
