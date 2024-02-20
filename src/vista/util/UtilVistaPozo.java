/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.util;

import controlador.TDA.grafos.GrafosEtiquetadosDirigidos;
import controlador.Utiles.Utiles;
import java.io.FileWriter;
import modelo.Pozo;

/**
 *
 * @author romer
 */
public class UtilVistaPozo {
    
    public static void crearMapaEscuela(GrafosEtiquetadosDirigidos<Pozo> ge) throws Exception {
        String maps = "var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',\n"
                + "        osmAttrib = '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors',\n"
                + "        osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});\n"
                + "\n"
                + "var map = L.map('map').setView([-4.036, -79.201], 15);\n"
                + "\n"
                + "L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {\n"
                + "    attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'\n"
                + "}).addTo(map);" + "\n";

        for (int i = 1; i <= ge.num_vertices(); i++) {
            Pozo pz = ge.getLabelE(i);
            maps += "L.marker([" + pz.getCoordenada().getLatitud() + ", " + pz.getCoordenada().getLogitud() + "]).addTo(map)" + "\n";
            maps += ".bindPopup('" + pz.toString() + "')" + "\n";
            maps += ".openPopup();" + "\n;";
        }

        FileWriter file = new FileWriter("mapas/mapa.js");
        file.write(maps);
        file.close();
    }
    
    public static Double calcularDistanciaPozo(Pozo o, Pozo d) {
        Double dist = Utiles.coordGpsToKm(o.getCoordenada().getLatitud(), o.getCoordenada().getLogitud(),
                                          d.getCoordenada().getLatitud(), d.getCoordenada().getLogitud());
        return Utiles.redondear(dist);
    }
    
}
