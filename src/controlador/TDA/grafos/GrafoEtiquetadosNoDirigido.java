/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.grafos;

import controlador.TDA.grafos.exeption.VerticeExepction;
import controlador.TDA.listas.DynamicList;
import controlador.Utiles.Utiles;


/**
 *
 * @author romer
 */
public class GrafoEtiquetadosNoDirigido<E> extends GrafosEtiquetadosDirigidos<E>{
  
    public GrafoEtiquetadosNoDirigido(Integer num_vertices, Class clazz) {
        super(num_vertices, clazz);
    }
    
     @Override
    public void insertar_arista(Integer v1, Integer v2, Double peso) throws Exception {
        if(v1.intValue() <= num_vertices() && v2.intValue() <= num_vertices()){
            if(!existe_arista(v1, v2)) {
                setNum_aristas(num_aristas()+1);
                getListaAdyacencias()[v1].add(new Adyacencia(v2, peso));
                getListaAdyacencias()[v2].add(new Adyacencia(v1, peso));
                //num_aristas++;                
                //listaAdycencias[v1].add(new Adycencia(v2, peso));
            }
        } else 
            throw new VerticeExepction();
    }

    public static void main(String[] args) {
        try {
            GrafoEtiquetadosNoDirigido<String> ged = new GrafoEtiquetadosNoDirigido<>(7, String.class);
            ged.labelVertice(1, "Estefania");
            ged.labelVertice(2, "Luna");
            ged.labelVertice(3, "Jimenez");
            ged.labelVertice(4, "Criollo");
            ged.labelVertice(5, "Nivelo");
            ged.labelVertice(6, "Darwin");
            ged.labelVertice(7, "Romer");
            ged.insertEdge("Estefania", "Luna", 80.0);
            ged.insertEdge("Estefania", "Jimenez", 40.0);
            ged.insertEdge("Jimenez", "Criollo", 20.0);
            ged.insertEdge("Jimenez", "Nivelo", 70.0);
            ged.insertEdge("Luna", "Darwin", 20.0);
            ged.insertEdge("Darwin", "Romer", 60.0);

            System.out.println(ged.toString());
            System.out.println("----------------");
            ged.caminoFloyd(1, 7).toString();
            //System.out.println(ged.recorridoAnchura(1).toString());
            //System.out.println(ged.recorridoProfundidad(1).toString());
//            PaintGraph p =  new PaintGraph();
//            p.updateFileLabel(ged);
//            Utiles.abrirArchivoHTML("c:/Users/romer/Documents/NetBeansProjects/Pozos _luz/d3/grafo.html");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    
    
}
