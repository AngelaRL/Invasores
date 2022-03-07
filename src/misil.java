import javax.swing.*;
import java.awt.*;

public class misil extends Thread {
    JLabel misl = new JLabel();
    Rectangle hitbox = new Rectangle();
    tablero tablero;
    public int x, y, velocidaMisil;

    public misil(tablero tablero) {

        super();
        this.tablero = tablero;
        this.x = tablero.jugador.x + (tablero.jugador.naveespa.getWidth() / 2) - 11;
        this.y = tablero.jugador.y;
        this.velocidaMisil = 10;

        misl.setIcon(new ImageIcon("img/misil.png"));
        misl.setBounds(this.x, this.y, 24, 24);
        hitbox.setBounds(this.x, this.y, 24, 24);

        tablero.add(misl);
        tablero.repaint();

        this.start();
    }

    public void run() {
        while (this.y >= 0) {
            try {
                this.y -= velocidaMisil;
                actualizarTablero();

                for (invasor alien : this.tablero.aliens) {
                    if (alien.verificarImpacto(this.hitbox)) {
                        System.out.println("\n-- Impacto bala");
                        this.y = -24;
                        break;
                    }
                }
                sleep(100);
            } catch (Exception e) {
                System.out.println("ocurrio un error con misil");
                e.printStackTrace();
            }
        }
        this.misl.setVisible(false);
        this.tablero.remove(this.misl);
        this.tablero.misiles.remove(this);
    }

    public void actualizarTablero() {
        this.misl.setLocation(this.x, this.y);
        this.hitbox.setLocation(this.x, this.y);
    }
}
