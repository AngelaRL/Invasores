import javax.swing.*;
import java.awt.*;

public class invasor {
    public int vida, tipo, puntos;
    public int x, y, velocidadalien;
    public JLabel alien = new JLabel();
    public Rectangle hitbox = new Rectangle();
    public tablero tablero;

    public invasor(int tipo, int x, int y, tablero tablero) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.tablero = tablero;
        this.velocidadalien = 10;

        switch (tipo) {
            case 1:                                //tipo de alien 1
                this.vida = 1;
                this.puntos = 5;
                alien.setIcon(new ImageIcon("img/ufo.png"));
                alien.setBounds(this.x, this.y, 64, 64);
                hitbox.setBounds(this.x, this.y, 64, 64);
                tablero.add(alien);
                break;
            case 2:                                 //tipo de alien 2
                this.vida = 2;
                this.puntos = 10;
                alien.setIcon(new ImageIcon("img/ufo2.png"));
                alien.setBounds(this.x, this.y, 64, 64);
                hitbox.setBounds(this.x, this.y, 64, 64);
                tablero.add(alien);
                break;
            case 3:                                //tipo de alien 3
                this.vida = 3;
                this.puntos = 20;
                alien.setIcon(new ImageIcon("img/ufo3.png"));
                alien.setBounds(this.x, this.y, 64, 64);
                hitbox.setBounds(this.x, this.y, 64, 64);
                tablero.add(alien);
                break;
        }
        tablero.repaint();
    }

    public boolean verificarImpacto(Rectangle hitboxbala) {
        if (this.hitbox.intersects(hitboxbala)) {
            if (this.vida == 1) {           //para cuando la vida del alien sea igual a uno
                this.alien.setVisible(false);   //ya no sale el alien en el tablero
                tablero.remove(alien);          //se elimina de la lista
                tablero.aliens.remove(this);
                return true;
            }
            this.vida -= 1;
            return true;
        }
        return false;
    }

    public void moveDown() {
        this.y += velocidadalien;
    }

    public void actualizarTablero() {
        this.alien.setLocation(this.x, this.y);
        this.hitbox.setLocation(this.x, this.y);
    }
}
