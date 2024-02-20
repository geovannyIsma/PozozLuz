/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.grafos;

import controlador.TDA.grafos.exeption.VerticeExepction;
import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import controlador.Utiles.Utiles;


/**
 *
 * @author romer
 */
public class GrafoDirigido extends Grafo{
    private Integer num_vertice;
    private Integer num_aristas;
    private DynamicList<Adyacencia> listaAdyacencias[];

    public GrafoDirigido(Integer num_vertices) {
        this.num_vertice = num_vertices;
        this.num_aristas = 0;
        listaAdyacencias = new DynamicList[num_vertices + 1];
        for (int i = 1; i <= this.num_vertice; i++) {
            listaAdyacencias[i] = new DynamicList<>();
        }
    }
    
    
    @Override
    public Integer num_vertices() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return num_vertice;
    }

    @Override
    public Integer num_aristas() {
        // new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return num_aristas;
    }

    @Override
    public Boolean existe_arista(Integer v1, Integer v2) throws Exception{
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Boolean band = false;
        if (v1.intValue() <= num_vertice && v2.intValue() <= num_vertice) {
            DynamicList<Adyacencia> listaA = listaAdyacencias[v1];
            for (int i = 0; i < listaA.getLenght(); i++) {
                Adyacencia a = listaA.getInfo(i);
                if (a.getDestino().intValue() == v2.intValue()) {
                    band = true;
                    break;
                }
            }
        } else {
            throw new VerticeExepction();
        }
        return band;
    }

    @Override
    public Double peso_arista(Integer v1, Integer v2) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Double peso = Double.NaN;
        if (existe_arista(v1, v2)) {
            DynamicList<Adyacencia> listaA = listaAdyacencias[v1];
            for (int i = 0; i < listaA.getLenght(); i++) {
                Adyacencia a = listaA.getInfo(i);
                if (a.getDestino().intValue() == v2.intValue()) {
                    peso = a.getPeso();
                    break;
                }
            }
        }
        return peso;
    }

    @Override
    public void insertar_arista(Integer v1, Integer v2, Double peso) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (v1.intValue() <= num_vertice && v2.intValue() <= num_vertice) {
            if (!existe_arista(v1, v2)) {
                num_aristas++;
                listaAdyacencias[v1].add(new Adyacencia(v2, peso));
            }
        } else {
            throw new VerticeExepction();
        }
    }

    @Override
    public void insertar_arista(Integer v1, Integer v2) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        insertar_arista(v1, v2, Double.NaN);
    }

    @Override
    public DynamicList<Adyacencia> adyacentes(Integer v1) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return listaAdyacencias[v1];
    }

    @Override
    public DynamicList<Integer> recorridoAnchura(Integer v) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        DynamicList<Integer> recorrido = new DynamicList<>();
        DynamicList<Integer> cola = new DynamicList<>();
        DynamicList<Integer> visitados = new DynamicList<>();
        Integer w;
        visitados.add(v);
        recorrido.add(v);
        cola.add(v);
        while (!cola.isEmpty()) {
            Integer u = cola.remove(0);
            DynamicList<Adyacencia> listaA = adyacentes(u);
            for (int i = 0; i < listaA.getLenght(); i++) {
                Adyacencia a = listaA.getInfo(i);
                w = a.getDestino();
                if (!visitados.contains(w)) {
                    visitados.add(w);
                    recorrido.add(w);
                    cola.add(w);
                }
            }
        }
        return recorrido;
    }

    @Override
    public DynamicList<Integer> recorridoProfundidad(Integer v) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        DynamicList<Integer> recorrido = new DynamicList<>();
        DynamicList<Integer> pila = new DynamicList<>();
        DynamicList<Integer> visitados = new DynamicList<>();
        Integer w;
        pila.add(v);
        while (!pila.isEmpty()) {
            Integer u = pila.remove(pila.getLenght() - 1);
            if (!visitados.contains(u)) {
                visitados.add(u);
                recorrido.add(u);
                DynamicList<Adyacencia> listaA = adyacentes(u);
                for (int i = 0; i < listaA.getLenght(); i++) {
                    Adyacencia a = listaA.getInfo(i);
                    w = a.getDestino();
                    if (!visitados.contains(w)) {
                        pila.add(w);
                    }
                }
            }
        }
        return recorrido;
    }

    @Override
    public Double[][] floyd() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Double[][] matriz = new Double[num_vertice + 1][num_vertice + 1];
        for (int i = 1; i <= num_vertice; i++) {
            for (int j = 1; j <= num_vertice; j++) {
                if (i == j) {
                    matriz[i][j] = 0.0;
                } else {
                    matriz[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        for (int i = 1; i <= num_vertice; i++) {
            DynamicList<Adyacencia> listaA = adyacentes(i);
            for (int j = 0; j < listaA.getLenght(); j++) {
                Adyacencia a = listaA.getInfo(j);
                matriz[i][a.getDestino()] = a.getPeso();
            }
        }
        for (int k = 1; k <= num_vertice; k++) {
            for (int i = 1; i <= num_vertice; i++) {
                for (int j = 1; j <= num_vertice; j++) {
                    if (matriz[i][j] > matriz[i][k] + matriz[k][j]) {
                        matriz[i][j] = matriz[i][k] + matriz[k][j];
                    }
                }
            }
        }
        return matriz;
    }


    public Integer getNum_aristas() {
        return num_aristas;
    }

    public void setNum_aristas(Integer num_aristas) {
        this.num_aristas = num_aristas;
    }

    public DynamicList<Adyacencia>[] getListaAdyacencias() {
        return listaAdyacencias;
    }

    public void setListaAdyacencias(DynamicList<Adyacencia>[] listaAdyacencias) {
        this.listaAdyacencias = listaAdyacencias;
    }
    
    public static void main(String[] args) {
        Grafo f = new GrafoDirigido(6);
        System.out.println(f);
        try {
            f.insertar_arista(1, 3, 50.0);
            f.insertar_arista(2, 6, 20.0);
            f.insertar_arista(3, 4, 30.0);
            f.insertar_arista(5, 1, 40.0);
            f.insertar_arista(2, 4, 70.0);
            f.insertar_arista(5, 6, 80.0);
            f.insertar_arista(1, 4, 5.0);
            PaintGraph p = new PaintGraph();
            p.updateFile(f);
            Utiles.abrirArchivoHTML("c:/Users/romer/Documents/NetBeansProjects/Pozos _luz/d3/grafo.html");
            System.out.println(f);
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }


    
}
