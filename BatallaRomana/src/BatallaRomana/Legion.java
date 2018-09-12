/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatallaRomana;

import java.util.*;
import Excepciones.ErrorValorNulo;
import Excepciones.ErrorCompraNegativa;

/**
 *
 * @author Matias
 */
public class Legion extends Ejercito {

	private LinkedList<Ejercito> conjuntoDeGuerreros = new LinkedList<Ejercito>();
	private String nombre;

	public Legion(String nombre,LinkedList ejercito) 
        throws ErrorValorNulo
        {
            if(!(nombre.equals("") || nombre == null || ejercito == null)){
		this.conjuntoDeGuerreros = ejercito;
                this.nombre = nombre;
            }else{
                throw new ErrorValorNulo();
            }
	}
        
        public Legion(int cantidadDeAuxliar , int cantidadDeLegionario , int cantidadDeCenturion) throws ErrorCompraNegativa{
               if(cantidadDeAuxliar >= 0 && cantidadDeLegionario >= 0 && cantidadDeCenturion >= 0){
                   for(int i = 0; i < cantidadDeAuxliar; i++){
                       conjuntoDeGuerreros.add(new Auxiliar());
                   }
                   for(int i = 0; i < cantidadDeLegionario; i++){
                       conjuntoDeGuerreros.add(new Legionario());
                   }
                   for(int i = 0; i < cantidadDeCenturion; i++){
                       conjuntoDeGuerreros.add(new Centurion());
                   }
                   nombre = "Legion generada por compra";
               }else{
                   throw new ErrorCompraNegativa();
               }
               
        }
        
        public String getNombre(){
            return nombre;
        }
        
        public LinkedList<Ejercito> getConjunto(){
            return conjuntoDeGuerreros;
        }

	public double calcularAtaque() {
		// Recorre lista y de manera recursiva pide a sus hijos el mismo metodo
		// esto se acumula
		double ataque = 0;
		for (Ejercito guerrero : conjuntoDeGuerreros) {
			ataque = ataque + guerrero.calcularAtaque();
		}
		return ataque;
	}

	public double getCosto() {
		double costo = 0;
		for (Ejercito guerrero : conjuntoDeGuerreros) {
			costo = costo + guerrero.getCosto();
		}
		return costo;
	}

	public TreeMap<String, Integer> contarGuerrero() {
		TreeMap soldado = new TreeMap<String, Integer>();
		for (Ejercito guerrero : conjuntoDeGuerreros) {
			// El Map entry es para poder iterar el segundo diccionario que se
			// recibe de las hojas
			// "entrada" hace referencia a ese diccionario
			for (Map.Entry<String, Integer> entrada : guerrero
					.contarGuerrero().entrySet()) {
				if (!soldado.containsKey(entrada.getKey())) {
					soldado.put(entrada.getKey(), 0);
				}
				soldado.put(entrada.getKey(), (Integer) ((int) soldado
						.get(entrada.getKey()) + entrada.getValue()));
			}
		}
		return soldado;
	}

	public double restarVida(double danoARealizar,
			tipoDeGuerrero guerreroObjetivo) {
		double danoTotal = danoARealizar;
		for (Ejercito guerrero : conjuntoDeGuerreros) {
			// Ver como sacar esto y usar solo el map del metodo mostrarSoldado
			// Conste es mucho más eficiente preguntar por los enum
			// Es más comodo contar con map y verificar con el enum
			// Se pregunta por guerrero.getTipo() == Legion
			// Por el caso de que haya una legion dentro de otra.
			if (guerrero.getTipo() == guerreroObjetivo
					|| guerrero.getTipo() == tipoDeGuerrero.Legion) {
				danoTotal = guerrero.restarVida(danoTotal, guerreroObjetivo);
			}
		}
		return danoTotal;
	}

	public tipoDeGuerrero getTipo() {
		return tipoDeGuerrero.Legion;
	}
                
        public boolean equals(Object obj){
            if(obj instanceof Legion){
                Legion auxLegion = (Legion)obj;
                if(this.nombre.equals(auxLegion.getNombre()) && this.contarGuerrero().equals(auxLegion.contarGuerrero())){
                    for(int i = 0; i < conjuntoDeGuerreros.size(); i++){                        
                        if(!(this.conjuntoDeGuerreros.get(i).equals(auxLegion.getConjunto().get(i)))){
                        return false;
                        }
                        //System.out.println("Tipo Legion " + this.conjuntoDeGuerreros.get(i).getTipo() + " = " + auxLegion.getConjunto().get(i).getTipo());
                    }
                    return true;
                }
                // System.out.println(this.nombre.equals(auxLegion.getNombre()));
                // System.out.println(this.contarGuerrero().equals(auxLegion.contarGuerrero()));
                return false;
            }
            System.out.println("No es instancia");
            return false;
            
        }
}
