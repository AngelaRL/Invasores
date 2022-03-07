import javax.swing.*;
import java.awt.*;

public class jugador {

    public JLabel naveespa = new JLabel();
    public Rectangle hitbox = new Rectangle();
    public JFrame formPadre;
    public int x, y, velocidadnave;

    public jugador(int posicionX, int posicionY, JFrame form) {

        super();
        this.formPadre = form;
        this.x = posicionX;
        this.y = posicionY;
        this.velocidadnave = 5;

        naveespa.setBounds(x, y-70, 64, 64);
        hitbox.setBounds(x, y-70, 64, 64);
        naveespa.setIcon(new ImageIcon("img/nave.png"));
        formPadre.add(naveespa);
        formPadre.repaint();

    }

    public void moveRight() {
        if (this.x <= (formPadre.getWidth() - 165 - this.velocidadnave)) {
            this.x += this.velocidadnave;
            actualizaretiqueta();
        }
    }

    public void moveLeft() {
        if (this.x >= this.velocidadnave) {
            this.x -= this.velocidadnave;
            actualizaretiqueta();
        }
    }

    public void actualizaretiqueta() {
        naveespa.setLocation(this.x, this.y);
        hitbox.setLocation(this.x, this.y);
        formPadre.repaint();
    }

}
