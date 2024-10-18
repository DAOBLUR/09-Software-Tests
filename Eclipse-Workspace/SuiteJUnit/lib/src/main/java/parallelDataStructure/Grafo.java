package parallelDataStructure;

import java.util.*;

// https://openwebinars.net/blog/introduccion-a-java-estructuras-de-datos/
// Clase para representar un grafo no dirigido utilizando una lista de adyacencia
public class Grafo 
{
     // Número de vértices
    private int V;
    // Lista de adyacencia para almacenar las conexiones
    private LinkedList<Integer>[] listaAdyacencia;

    public static final String separator = new String(" -> ");
    public static final char lineSeparator = '\n';

    // Constructor para inicializar el grafo con un número dado de vértices
    public Grafo(int v) 
    {
        V = v;
        listaAdyacencia = new LinkedList[v];

        for (int i = 0; i < v; ++i) 
        {
            listaAdyacencia[i] = new LinkedList<>();
        }
    }

    // Método para agregar una arista al grafo
    public void agregarArista(int v, int w) 
    {
        listaAdyacencia[v].add(w);
        listaAdyacencia[w].add(v);
    }

     // Método para imprimir el grafo
    public void imprimirGrafo() 
    {
        for (int i = 0; i < V; ++i) 
        {
            System.out.println("Lista de adyacencia del vértice " + i);
            System.out.print("Vértice " + i);

            for (Integer nodoAdyacente : listaAdyacencia[i]) 
            {
                System.out.print(" -> " + nodoAdyacente);
            }

            System.out.println("\n");
        }
    }

    public String ObtenerAristasAdyacentes(int nodo)
    {
        var text = new StringBuilder();

        text.append(nodo);

        for (Integer nodoAdyacente : listaAdyacencia[nodo]) 
        {
            text.append(separator);
            text.append(nodoAdyacente);
        }

        return text.toString();
    }
    
    public int ObtenerLargo(int arista)
    {
        return listaAdyacencia[arista].size();
    }

    @Override
    public String toString() 
    {
        var text = new StringBuilder();

        for (int i = 0; i < V; ++i) 
        {
            text.append(i);

            for (Integer nodoAdyacente : listaAdyacencia[i]) 
            {
                text.append(separator);
                text.append(nodoAdyacente);
            }

            text.append(lineSeparator);
        }
        
        return text.toString();
    }
}