/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2lp1;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author sala1
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    Creacion crear;
    int seleccion = 0;
    int conexion = 0;//indica se debe crear una conexion o no;
    int ruta = 0;
    int contadorRouter = 0;
    int contadorConexion = 0;
    int contadorComputador = 0;
    Map map = new HashMap();

    public GUI() {
        initComponents();

        crear = new Creacion(contenedor, BNConexion, MVConexiones, BCalcularRuta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PMenu = new javax.swing.JPanel();
        BNRouter = new javax.swing.JButton();
        BNConexion = new javax.swing.JButton();
        BNComputador = new javax.swing.JButton();
        BCalcularRuta = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        MConexiones = new javax.swing.JMenuBar();
        MVConexiones = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador");

        BNRouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/router.png"))); // NOI18N
        BNRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNRouterActionPerformed(evt);
            }
        });

        BNConexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conexion.png"))); // NOI18N
        BNConexion.setToolTipText("0");
        BNConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNConexionActionPerformed(evt);
            }
        });

        BNComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/computador.png"))); // NOI18N
        BNComputador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNComputadorActionPerformed(evt);
            }
        });

        BCalcularRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ruta.png"))); // NOI18N
        BCalcularRuta.setText("Calcular mejor ruta");
        BCalcularRuta.setToolTipText("0");
        BCalcularRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCalcularRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PMenuLayout = new javax.swing.GroupLayout(PMenu);
        PMenu.setLayout(PMenuLayout);
        PMenuLayout.setHorizontalGroup(
            PMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BNComputador)
                .addGap(18, 18, 18)
                .addComponent(BNRouter)
                .addGap(18, 18, 18)
                .addComponent(BNConexion)
                .addGap(18, 18, 18)
                .addComponent(BCalcularRuta)
                .addGap(136, 136, 136))
        );
        PMenuLayout.setVerticalGroup(
            PMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PMenuLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(PMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BCalcularRuta)
                    .addComponent(BNRouter)
                    .addComponent(BNConexion)
                    .addComponent(BNComputador))
                .addGap(36, 36, 36))
        );

        contenedor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                contenedorMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 996, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        MVConexiones.setText("Ver conexiones");
        MConexiones.add(MVConexiones);

        setJMenuBar(MConexiones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(PMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(PMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contenedorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenedorMouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_contenedorMouseMoved

    private void BNComputadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNComputadorActionPerformed
        // TODO add your handling code here:
        contadorComputador++;
        if (contadorComputador <= 3) {
            crear.Crear("computador", "computador" + contadorComputador);
        } else {
            JOptionPane.showMessageDialog(null, "El maximo de computadores es 3");
        }
    }//GEN-LAST:event_BNComputadorActionPerformed

    private void BNConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNConexionActionPerformed
        // TODO add your handling code here:
        if (BNConexion.getToolTipText().equals("0")) {
            conexion = 1;

            BNConexion.setToolTipText("1");
            BNConexion.setBackground(Color.green);

            crear.Crear("conexion", "conexion" + contadorConexion);
        } else {
            BNConexion.setToolTipText("0");
            BNConexion.setBackground(null);
            conexion = 0;
        }
    }//GEN-LAST:event_BNConexionActionPerformed

    private void BNRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNRouterActionPerformed
        // TODO add your handling code here:
        contadorRouter++;
        if (contadorRouter <= 5) {
            crear.Crear("router", "router" + contadorRouter);
        } else {
            JOptionPane.showMessageDialog(null, "El maximo de routers es 5");
        }
    }//GEN-LAST:event_BNRouterActionPerformed

    private void BCalcularRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCalcularRutaActionPerformed
        // TODO add your handling code here:
        if (BCalcularRuta.getToolTipText().equals("0")) {
            ruta = 1;

            BCalcularRuta.setToolTipText("1");
            BCalcularRuta.setBackground(Color.green);

        } else {
            BCalcularRuta.setToolTipText("0");
            BCalcularRuta.setBackground(null);
            ruta = 0;
        }
    }//GEN-LAST:event_BCalcularRutaActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCalcularRuta;
    private javax.swing.JButton BNComputador;
    private javax.swing.JButton BNConexion;
    private javax.swing.JButton BNRouter;
    private javax.swing.JMenuBar MConexiones;
    private javax.swing.JMenu MVConexiones;
    private javax.swing.JPanel PMenu;
    private javax.swing.JPanel contenedor;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
