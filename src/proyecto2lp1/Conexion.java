/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2lp1;

/**
 *
 * @author sala1
 */
public class Conexion {
    private String conexionA;
    private String ConexionB;
    private int velocidad;
    private int restardo;
    private int trafico;
    private int color;
    public Conexion(String A, String B){
        this.conexionA = A;
        this.ConexionB = B;
        this.velocidad = (int) (Math.random() * 10) + 1;
        this.restardo = (int) (Math.random() * 10) + 1;
        this.trafico = (int) (Math.random() * 10) + 1;
        this.color = 0;
        
    }

    /**
     * @return the conexionA
     */
    public String getConexionA() {
        return conexionA;
    }

    /**
     * @param conexionA the conexionA to set
     */
    public void setConexionA(String conexionA) {
        this.conexionA = conexionA;
    }

    /**
     * @return the ConexionB
     */
    public String getConexionB() {
        return ConexionB;
    }

    /**
     * @param ConexionB the ConexionB to set
     */
    public void setConexionB(String ConexionB) {
        this.ConexionB = ConexionB;
    }

    /**
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the restardo
     */
    public int getRestardo() {
        return restardo;
    }

    /**
     * @param restardo the restardo to set
     */
    public void setRestardo(int restardo) {
        this.restardo = restardo;
    }

    /**
     * @return the trafico
     */
    public int getTrafico() {
        return trafico;
    }

    /**
     * @param trafico the trafico to set
     */
    public void setTrafico(int trafico) {
        this.trafico = trafico;
    }

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }
}
