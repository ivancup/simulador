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
import java.util.*;
 
public class Grafo {
    int[][] grafo;
    char[]  nodos;
    private  int indice;
 
    Grafo(String serieNodos) {
        nodos = serieNodos.toCharArray();
        grafo = new int[nodos.length][nodos.length];
    }
 
    // asigna el tamaño de la arista entre dos nodos
    public void agregarRuta(char origen, char destino, int distancia) {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);
        grafo[n1][n2]=distancia;
        grafo[n2][n1]=distancia;
    }
    
 
    // retorna la posición en el arreglo de un nodo específico
    private int posicionNodo(char nodo) {
        for(int i=0; i<nodos.length; i++) {
            if(nodos[i]==nodo) return i;
        }
        return -1;
    }
 
    // encuentra la ruta mínima entre dos nodos del grafo
    public void encontrarRutaMinimaFuerzaBruta(char inicio, char fin) {
        int p1 = posicionNodo(inicio);
        int p2 = posicionNodo(fin);
        // cola para almacenar cada ruta que está siendo evaluada
        Stack<Integer> resultado = new Stack<Integer>();
        resultado.push(p1);
        recorrerRutas(p1, p2, resultado);
    }
 
    // recorre recursivamente las rutas entre un nodo inicial y un nodo final
    // almacenando en una cola cada nodo visitado
    private void recorrerRutas(int nodoI, int nodoF, Stack<Integer> resultado) {
        // si el nodo inicial es igual al final se muestra y evalúa la ruta en revisión
        if(nodoI==nodoF) {
            for(int x: resultado) System.out.print(nodos[x]+ " ");
            System.out.print(": " + evaluar(resultado));
            System.out.println();
            return;
        }
        // Si el nodoInicial no es igual al final se crea una lista con todos los nodos
        // adyacentes al nodo inicial que no estén en la ruta en evaluación
        List<Integer> lista = new Vector<Integer>();
        for(int i=0; i<grafo.length;i++) {
            if(grafo[nodoI][i]!=0 && !resultado.contains(i))lista.add(i);
        }
        // se recorren todas las rutas formadas con los nodos adyacentes al inicial
        for(int nodo: lista) {
            resultado.push(nodo);
            recorrerRutas(nodo, nodoF, resultado);
            resultado.pop();
        }
    }
 
    // evaluar la longitud de una ruta
    public int evaluar(Stack<Integer> resultado) {
        int  resp = 0;
        int[]   r = new int[resultado.size()];
        int     i = 0;
        for(int x: resultado) r[i++]=x;
        for(i=1; i<r.length; i++) resp+=grafo[r[i]][r[i-1]];
        return resp;
    }
 
    public static void main(String[] args) {
        Grafo g = new Grafo("abcdef");
        g.agregarRuta('a','b', 5);
        g.agregarRuta('a','e', 3);
        g.agregarRuta('b','e', 6);
        g.agregarRuta('b','f', 9);
        g.agregarRuta('b','c', 10);
        g.agregarRuta('c','d', 15);
        g.agregarRuta('c','f', 9);
        g.agregarRuta('d','e', 1);
        g.agregarRuta('d','f', 2);
        g.agregarRuta('e','f', 12);
        g.agregarRuta('a', 'd', 19);
        char inicio = 'a';
        char fin    = 'd';
        g.encontrarRutaMinimaFuerzaBruta(inicio, fin);
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }
}