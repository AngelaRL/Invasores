import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

public class tablero extends javax.swing.JFrame {
    //tiempo tiempo;
    jugador jugador;
    movimientoInvasor movimientoInvasor;
    ArrayList<invasor> aliens = new ArrayList<>();
    ArrayList<misil> misiles = new ArrayList<>();
    int milesimas, segundos;
    Timer reloj;


    public tablero() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializarPartida();
        this.setVisible(true);                  //despues de inicializar la partida
        reloj = new Timer(String.valueOf(1000),contador(90));
    }

    public void inicializarPartida() {
        jugador = new jugador((this.getWidth() / 2) - 32, this.getHeight() - 100, this);
        generarInvasores();
        movimientoInvasor = new movimientoInvasor(aliens, this, jugador);
        movimientoInvasor.start();
        //juegoterminado(aliens);
      //  tiempo.relojJuego.start();

    }

   /* public void juegoterminado(ArrayList<invasor> alien){
        if (alien. == this.getWidth() && alien.y == this.getHeight()){
            JOptionPane.showMessageDialog(null,"se termino el juego");
        }
    }*/

    public void generarInvasores() {
        int posY = 0;

        for (int i = 0; i < 2; i++) {               //numero de filas
            for (int j = 0; j < 8; j++) {      // numero de columnas
                aliens.add(new invasor(3, j * 64, posY, this));
            }
            posY += 64;
        }

        for (int i = 0; i < 2; i++) {                //numero de filas
            for (int j = 0; j < 8; j++) {       //numero de comlumnas
                aliens.add(new invasor(2, j * 64, posY, this));
            }
            posY += 64;
        }

        for (int i = 0; i < 1; i++) {                //numero de filas
            for (int j = 0; j < 8; j++) {       //numero de comlumnas
                aliens.add(new invasor(1, j * 64, posY, this));
            }
            posY += 64;
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("patalla");
        setPreferredSize(new java.awt.Dimension(620, 735));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("TIEMPO");

        jLabel2.setText("");

        jLabel3.setText("PUNTOS");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addGap(0, 13, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel4)
                                .addContainerGap(335, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(363, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        int tecla = evt.getKeyCode();

        switch (tecla) {

            case KeyEvent.VK_LEFT:
                jugador.moveLeft();
                System.out.println("izquierda");
                break;

            case KeyEvent.VK_RIGHT:
                jugador.moveRight();
                System.out.println("derecha");
                break;

            case KeyEvent.VK_SPACE:
                misiles.add(new misil(this));
                System.out.println("espacio");
                break;

            case KeyEvent.VK_ESCAPE:
                System.out.println("pausa");
                break;

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration


    void actualizarLabel() {
        // Operador ternario
        // condicion ? verdadero : falso;

        String strSegundos = segundos < 10 ? "0" + segundos : "" + segundos;
        String strMilesimas = milesimas < 10 ? "0" + milesimas : "" + milesimas;

        jLabel2.setText(strSegundos + ":" + strMilesimas);
    }

    private void contadortiempoVida(){
       // if (contador())
    }


    private boolean contador(int tiempo) {
        milesimas = tiempo*1000;
        boolean verificar= true;
        milesimas--;
        System.out.println("miles: "+milesimas);
        // Ver si las milesimas ya son 100, entonces contamos 1 segundo y reiniciamos el contador de milesimas
        if (milesimas >= 100) {
            segundos--;
            milesimas = 0;
            verificar =false;
        }

        actualizarLabel();

        return verificar;
    }
}
