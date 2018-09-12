/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lector;

/**
 *
 * @author Matias
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import BatallaRomana.*;

import Excepciones.ErrorValorNulo;

public class Lector {

	LectorDeArchivos archivo = new LectorDeArchivos();
        private static Lector esteLector;
       
        public static Lector getLector(){
            if(esteLector == null){
                esteLector = new Lector();
            }
            return esteLector;
        }
        
        public int cantidadDeLegiones(){
            return archivo.leer().size();
        }
        
	public Legion main(int opcion) {                
		ArrayList<String> lineas = archivo.leer();
		String aux;
		String[] lineaSeparada = null;
		aux = lineas.get(opcion);
		if (aux.contains(";")) {
			lineaSeparada = aux.split(";");
		} else if (aux.contains(",")) {
			lineaSeparada = aux.split(",");
		}
		int unidad = 1;
		LinkedList<Ejercito> listaAux = new LinkedList<Ejercito>();
		cargarDatos(lineaSeparada, unidad, listaAux);
                Legion miLegion;
                try{
                miLegion = new Legion(lineaSeparada[0], listaAux);                
                return miLegion;
                }catch(ErrorValorNulo e){
                    return null;
                }
	}

	private void cargarDatos(String[] lineaSeparada, int unidad,
			LinkedList<Ejercito> listaAux) {
		for (int i = 1; i < lineaSeparada.length; i++) {
			if (lineaSeparada[i].codePointAt(0) > 64) {                            
				ArrayList<String> lineas = archivo.leer();
				Iterator<String> linea = lineas.iterator();
				String[] lineaSeparada2 = null;
				while (linea.hasNext()) {
					String aux = linea.next();
					if (aux.contains(";")) {
						lineaSeparada2 = aux.split(";");
					} else if (aux.contains(",")) {
						lineaSeparada2 = aux.split(",");
					}
					if (lineaSeparada2[0].equals(lineaSeparada[i])) {                                                
						cargarDatos(lineaSeparada2, unidad, listaAux);                                                
					}
				}

			} else {
				switch (unidad) {
				case 1:
					for (int j = 0; j < Integer.parseInt(lineaSeparada[i]); j++) {
						listaAux.add(new Auxiliar());
					}
					;
					break;
				case 2:
					for (int j = 0; j < Integer.parseInt(lineaSeparada[i]); j++) {
						listaAux.add(new Legionario());
					}
					;
					break;
				case 3:
					for (int j = 0; j < Integer.parseInt(lineaSeparada[i]); j++) {
						listaAux.add(new Centurion());
					}
					;
					break;

				}
				unidad++;
			}

		}
	}
        
        private Lector(){
        }

}
