/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2lp1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sala1
 */
public class Creacion implements ActionListener {

    private String tipo;//tipo de objeto que se va acrear
    private JPanel panel;//panel donde se van a pintar
    private JButton BConexion;//boton conexion
    private JMenu MenuConexion;
    private JButton BMejorRuta;
    private String key;
    String[] boton1 = new String[100];
    String[] boton2 = new String[100];
    int auxNodos = 0;
    String[] temp = new String[2];//auxiliar xonexion
    String[] tempRuta = new String[2];//Auxiliar ruta

    int indice = 0;
    ArrayList<String> indices = new ArrayList<String>();
    ArrayList<String> nombreNodos = new ArrayList<String>();
    private int contadorRouter = 0;
    private int contadorComputador = 0;
    private int contadorConexion = 0;
    //indica la conexion entre elementos
    private int union = 0;
    private int auxRuta = 0;

    private ArrayList<String> rutas = new ArrayList<String>();

    /**
     * Los objetos se almacenaran en un MAP
     */
    private Map map = new HashMap();
    //Map para las conexiones
    private Map conexiones = new HashMap();
    private Map mapaRutas = new HashMap();
    private Map keyRutas = new HashMap();

    /**
     * Identificador de objeto
     */
    private int conectar = 0;// indica si se debe conectar o no;

    public Creacion(JPanel contenedor, JButton conexion, JMenu conexiones, JButton BCalcularRuta) {

        this.panel = contenedor;
        this.BConexion = conexion;
        this.MenuConexion = conexiones;
        this.BMejorRuta = BCalcularRuta;

    }

    public void Crear(String tipo, String key) {
        this.key = key;
        this.tipo = tipo;
        Objetos nuevo;

        switch (tipo) {

            case "router":
                this.contadorRouter++;
                nuevo = new Objetos(key, tipo);
                //coloca al objeto creado en una posicion aleatoria
                nuevo.setLocation(rndNum(this.panel.getWidth() - nuevo.getWidth()), rndNum(this.panel.getHeight() - nuevo.getHeight()));
                nuevo.addActionListener(this);
                map.put(key, nuevo);
                this.panel.add(nuevo);
                this.panel.repaint();
                break;

            case "computador":
                this.contadorComputador = this.contadorComputador + 1;
                nuevo = new Objetos(key, tipo);
                //coloca al objeto creado en una posicion aleatoria
                nuevo.setLocation(rndNum(this.panel.getWidth() - nuevo.getWidth()), rndNum(this.panel.getHeight() - nuevo.getHeight()));
                nuevo.addActionListener(this);
                map.put(key, nuevo);

                this.panel.add(nuevo);
                this.panel.repaint();

                break;

            case "conexion":
                this.contadorConexion++;
                this.panel.repaint();
                Iterator it = map.entrySet().iterator();

                break;

        }
        panel.repaint();
        repintar();
    }

    /**
     * Retorna un numero entero aleatorio entre 0 y un numero pasado como
     * parametro
     *
     * @param int numero entero
     */
    public int rndNum(int value) {
        int num = (int) Math.floor(Math.random() * value + 1);
        return num;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        String comprobar = BConexion.getToolTipText();

        if (e.getActionCommand().equals("eliminar")) {
            JMenuItem temp = (JMenuItem) e.getSource();

            int keyTemp = Integer.parseInt(temp.getToolTipText());
            MenuConexion.removeAll();
            conexiones.remove(keyTemp);
            indices.remove(Integer.toString(keyTemp));
            modificarMenu();
            panel.repaint();
            repintar();
        }

        if (BMejorRuta.getToolTipText().equals("1")) {
            if (auxRuta == 0) {

                tempRuta[0] = e.getActionCommand();
                Objetos temp = (Objetos) (map.get(tempRuta[0]));
                if (temp.getText().substring(0, 6).equals("router")) {
                    JOptionPane.showMessageDialog(null, "La ruta se debe calcular desde un computador a otro");
                } else {
                    temp.setBackground(Color.red);
                    auxRuta = 1;
                }
            } else {
                String auxIndicesRuta;

                tempRuta[1] = e.getActionCommand();
                Objetos temp = (Objetos) (map.get(tempRuta[1]));
                if (temp.getText().substring(0, 6).equals("router")) {
                    JOptionPane.showMessageDialog(null, "La ruta se debe calcular desde un computador a otro");
                } else {
                    temp.setBackground(Color.red);
                    auxRuta = 1;
                    obtenerTodosCaminos(tempRuta[0], tempRuta[1]);

                    auxRuta = 0;
                    BMejorRuta.setToolTipText("0");
                }
            }
        }

        if (comprobar.equals("1")) {
            if (union == 0 && comprobar.equals("1")) {

                temp[0] = e.getActionCommand();
                union++;

            } else if (union == 1 && comprobar.equals("1")) {
                temp[1] = e.getActionCommand();
                int bandera = 0;
                int contador1 = 0;
                int contador2 = 0;
                String helper1;
                String helper2;

                Iterator it = conexiones.entrySet().iterator();
                helper1 = temp[0].substring(0, 6);
                helper2 = temp[1].substring(0, 6);
                if (temp[0].equals(temp[1])) {
                    bandera = 1;
                    JOptionPane.showMessageDialog(null, "No se puede conectar el componente con el mismo");

                }
                while (it.hasNext()) {
                    Map.Entry mapa = (Map.Entry) it.next();
                    Conexion datos = (Conexion) mapa.getValue();

                    if (temp[0].equals(datos.getConexionA()) && temp[1].equals(datos.getConexionB())) {
                        bandera = 1;
                        JOptionPane.showMessageDialog(null, "El componente ya esta conectado");
                        break;
                    }

                    if (temp[0].equals(datos.getConexionA()) || temp[0].equals(datos.getConexionB())) {

                        contador1++;
                        if (contador1 == 3 && helper1.equals("router")) {
                            bandera = 1;
                            JOptionPane.showMessageDialog(null, "El " + temp[0] + " ya tiene tres conexiones");
                            break;
                        }
                        if (contador1 == 1 && helper1.equals("comput")) {
                            bandera = 1;
                            JOptionPane.showMessageDialog(null, "El computador solo puede tener una conexion");
                            break;
                        }
                    } else if (temp[1].equals(datos.getConexionA()) || temp[1].equals(datos.getConexionB())) {
                        contador2++;

                        if (contador2 == 3 && helper2.equals("router")) {
                            bandera = 1;
                            JOptionPane.showMessageDialog(null, "El " + temp[1] + " ya tiene tres conexiones");
                            break;
                        }
                        if (contador2 == 1 && helper2.equals("comput")) {
                            bandera = 1;
                            JOptionPane.showMessageDialog(null, "El computador solo puede tener una conexiones");
                            break;
                        }
                    }
                }
                if (bandera == 0) {

                    boton1[indice] = temp[0];
                    boton2[indice] = temp[1];
                    Conexion conect = new Conexion(boton1[indice], boton2[indice]);
                    nombreNodos.add(conect.getConexionA());
                    nombreNodos.add(conect.getConexionB());

                    conexiones.put(indice, conect);

                    Objetos objTemporal1 = (Objetos) map.get(boton1[indice]);
                    Objetos objTemporal2 = (Objetos) map.get(boton2[indice]);

                    int x1 = (int) (objTemporal1.getBounds().getCenterX());
                    int x2 = (int) (objTemporal2.getBounds().getCenterX());
                    int y1 = (int) (objTemporal1.getBounds().getCenterY());
                    int y2 = (int) (objTemporal2.getBounds().getCenterY());

                    Graphics g = panel.getGraphics();
                    g.setColor(Color.BLUE);
                    g.drawLine(x1, y1, x2, y2);
                    JMenu MConexion = new JMenu(conect.getConexionA() + "->" + conect.getConexionB());
                    MenuConexion.add(MConexion);
                    JMenuItem MVelocidad = new JMenuItem("Velocidad " + conect.getVelocidad());
                    JMenuItem MRetardo = new JMenuItem("Retardo " + conect.getRestardo());
                    JMenuItem MTrafico = new JMenuItem("Trafico " + conect.getTrafico());
                    JMenuItem MEliminar = new JMenuItem("Eliminar conexion");
                    MEliminar.setActionCommand("eliminar");
                    MConexion.setToolTipText(Integer.toString(indice));
                    MEliminar.setName(Integer.toString(indice));
                    MEliminar.setToolTipText(Integer.toString(indice));
                    MEliminar.addActionListener(this);
                    MConexion.add(MVelocidad);
                    MConexion.add(MRetardo);
                    MConexion.add(MTrafico);
                    MConexion.add(MEliminar);
                    indices.add(Integer.toString(indice));

                    indice++;
                    union = 0;
                    auxNodos++;
                    BConexion.setToolTipText("0");
                    BConexion.setBackground(null);
                } else {
                    union = 0;
                }
            }
        }
        repintar();
    }

    public void repintar() {

        Iterator it = conexiones.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            Conexion datos = (Conexion) e.getValue();
            Objetos objTemporal1 = (Objetos) map.get(datos.getConexionA());
            Objetos objTemporal2 = (Objetos) map.get(datos.getConexionB());

            int x1 = (int) (objTemporal1.getBounds().getCenterX());
            int x2 = (int) (objTemporal2.getBounds().getCenterX());
            int y1 = (int) (objTemporal1.getBounds().getCenterY());
            int y2 = (int) (objTemporal2.getBounds().getCenterY());

            if (datos.getColor() == 0) {

                Graphics g = panel.getGraphics();
                g.setColor(Color.BLUE);
                g.drawLine(x1, y1, x2, y2);
            } else {
                Graphics g = panel.getGraphics();
                g.setColor(Color.RED);
                g.drawLine(x1, y1, x2, y2);

            }

        }
    }

    public void modificarMenu() {
        Iterator it = conexiones.entrySet().iterator();
        int keyIndice = 0;
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            Conexion conect = (Conexion) e.getValue();
            JMenu MConexion = new JMenu(conect.getConexionA() + "->" + conect.getConexionB());
            MenuConexion.add(MConexion);
            JMenuItem MVelocidad = new JMenuItem("Velocidad " + conect.getVelocidad());
            JMenuItem MRetardo = new JMenuItem("Retardo " + conect.getRestardo());
            JMenuItem MTrafico = new JMenuItem("Trafico " + conect.getTrafico());
            JMenuItem MEliminar = new JMenuItem("Eliminar conexion");
            MEliminar.setActionCommand("eliminar");
            MEliminar.setName(indices.get(keyIndice));
            MEliminar.setToolTipText(indices.get(keyIndice));
            MEliminar.addActionListener(this);
            MConexion.add(MVelocidad);
            MConexion.add(MRetardo);
            MConexion.add(MTrafico);
            MConexion.add(MEliminar);

        }
    }
    int[][] grafo;
    String END;

    public void obtenerTodosCaminos(String fuente, String destino) {
        Graph grafo = new Graph();
        END = destino;
        Iterator it = conexiones.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            Conexion conect = (Conexion) e.getValue();

            grafo.addEdge(conect.getConexionA(), conect.getConexionB());
            grafo.addEdge(conect.getConexionB(), conect.getConexionA());

        }
        LinkedList<String> visited = new LinkedList();
        visited.add(fuente);

        depthFirst(grafo, visited);
        mejorRuta();

    }

    private void depthFirst(Graph graph, LinkedList<String> visited) {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        // examine adjacent nodes
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);
                printPath(visited);
                visited.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            visited.addLast(node);
            depthFirst(graph, visited);
            visited.removeLast();
        }
    }
    int contRutas = 0;

    private void printPath(LinkedList<String> visited) {
        mapaRutas.put(contRutas, visited.toArray());
        for (String node : visited) {
            System.out.print(node);
            System.out.print(" ");
        }
        contRutas++;
        System.out.println();
    }

    public void mejorRuta() {
        String[] temporal = new String[2];
        temporal[0] = "0";
        temporal[1] = "0";
        int keyMapaRuta = 0;
        Iterator it = mapaRutas.entrySet().iterator();
        //Toda esta vaina para obtener los indices del mapa conexion
        while (it.hasNext()) {
            ArrayList<String> indiceKeyConexion = new ArrayList<>();
            Map.Entry e = (Map.Entry) it.next();

            Object[] ruta;
            ruta = (Object[]) e.getValue();

            for (Object nombre : ruta) {
                if (temporal[0].equals("0")) {
                    temporal[0] = nombre.toString();
                } else if (temporal[1].equals("0")) {
                    temporal[1] = nombre.toString();
                    Iterator it2 = conexiones.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry e2 = (Map.Entry) it2.next();
                        Conexion conect = (Conexion) e2.getValue();

                        if (conect.getConexionA().equals(temporal[0]) && conect.getConexionB().equals(temporal[1])) {
                            indiceKeyConexion.add(e2.getKey().toString());
                        }
                        if (conect.getConexionA().equals(temporal[1]) && conect.getConexionB().equals(temporal[0])) {
                            indiceKeyConexion.add(e2.getKey().toString());
                        }

                    }

                    temporal[0] = temporal[1];
                    temporal[1] = "0";
                }

            }
            keyRutas.put(keyMapaRuta, indiceKeyConexion);
            keyMapaRuta++;
        }

        Iterator iterador = keyRutas.entrySet().iterator();
        //Sumas de verificacion para elegir el "mejor"
        float[] temp_mejor_ruta = new float[keyMapaRuta];

        int i = 0;
        while (iterador.hasNext()) {
            Map.Entry e = (Map.Entry) iterador.next();
            ArrayList<String> indicesKey = (ArrayList<String>) e.getValue();

            for (String key2 : indicesKey) {
                Conexion connect = (Conexion) conexiones.get(Integer.parseInt(key2));
                temp_mejor_ruta[i] += connect.getRestardo() * 0.4;
                temp_mejor_ruta[i] += connect.getTrafico() * 0.4;

                switch (connect.getVelocidad()) {
                    case 1:
                        temp_mejor_ruta[i] += 10 * 0.2;
                        break;
                    case 2:
                        temp_mejor_ruta[i] += 9 * 0.2;
                        break;
                    case 3:
                        temp_mejor_ruta[i] += 8 * 0.2;
                        break;
                    case 4:
                        temp_mejor_ruta[i] += 7 * 0.2;
                        break;
                    case 5:
                        temp_mejor_ruta[i] += 6 * 0.2;
                        break;
                    case 6:
                        temp_mejor_ruta[i] += 5 * 0.2;
                        break;
                    case 7:
                        temp_mejor_ruta[i] += 4 * 0.2;
                        break;
                    case 8:
                        temp_mejor_ruta[i] += 3 * 0.2;
                        break;
                    case 9:
                        temp_mejor_ruta[i] += 2 * 0.2;
                        break;
                    case 10:
                        temp_mejor_ruta[i] += 1 * 0.2;
                        break;
                }
            }
            i++;
        }

        float inicio = temp_mejor_ruta[0];//peor es buenoo
        int indiceMapa = 0;

        for (int j = 0; j < temp_mejor_ruta.length; j++) {
            //Caso ideal
            if (temp_mejor_ruta[j] <= inicio) {
                inicio = temp_mejor_ruta[j];
                indiceMapa = j;
            } //No tan ideal
        }

        ArrayList<String> ruta;
        ruta = (ArrayList<String>) keyRutas.get(indiceMapa);

        for (String nombre : ruta) {
            Conexion conexiones2 = (Conexion) this.conexiones.get(Integer.parseInt(nombre));
            conexiones2.setColor(1);
        }

    }

}
