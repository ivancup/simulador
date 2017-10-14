/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2lp1;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author sala1
 */
public class Objetos extends JButton implements MouseListener, MouseMotionListener{
    /** Posicion de imagen */
    private Point posicion = new Point(0,0);
    /** Tamaño de imagen */
    private Dimension d = new Dimension(100,100);    
    /** variable que sirve para calcular el movimiento del objeto */
    private Point start_loc;
    /** variable que sirve para calcular el movimiento del objeto */
    private Point start_drag;
    /** variable que sirve para calcular el movimiento del objeto */
    private Point offset;
    /** variables auxiliares para el desplazamiento del objeto*/
    
    
    private int nuevo_X = 1;
    private int nuevo_Y = 1;
    private int seleccion = 0;
    private String key;
    public Objetos(String nombre, String imagen){
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));        
        this.setSize(d);
        this.setPreferredSize(d);  
        this.setText(nombre);
        this.setHorizontalTextPosition(SwingConstants.CENTER );
        this.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.setIcon( new ImageIcon(getClass().getResource("/imagenes/" + imagen + "m.png")) );
        this.setToolTipText(nombre);
        
        this.setName(nombre);
        this.setVisible( true );
        this.setLocation( posicion );
        //se agregan los listener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        this.seleccion = 1;
    }
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        this.start_drag = getScreenLocation(e);
        this.start_loc = this.getLocation();}

    @Override
    public void mouseReleased(MouseEvent e) {
        nuevo_X = (this.getLocation().x);
        nuevo_Y = (this.getLocation().y);
        this.setLocation( nuevo_X, nuevo_Y );
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(97, 0, 51), 1));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder( null );
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point current = this.getScreenLocation(e);
        offset = new Point((int) current.getX() - (int) start_drag.getX(),(int) current.getY() - (int) start_drag.getY());
        Point new_location = new Point((int) (this.start_loc.getX() + offset.getX()), (int) (this.start_loc.getY() + offset.getY()));
        this.setLocation(new_location);  
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    private Point getScreenLocation(MouseEvent evt) {
        Point cursor = evt.getPoint();
        Point target_location = this.getLocationOnScreen();
        return new Point((int) (target_location.getX() + cursor.getX()),
               (int) (target_location.getY() + cursor.getY()));
    }

    /**
     * @return the seleccion
     */
    public int getSeleccion() {
        return seleccion;
    }

    /**
     * @param seleccion the seleccion to set
     */
    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }
}
