/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatallaRomana;

import java.util.*;
import Excepciones.*;

/**
 *
 * @author Matias
 */
public class Jugador {
    
    private LinkedList<Ejercito> miEjercito = new LinkedList<Ejercito>();
    private String nombre;
    private static double dineroIncial = 500000;
    private double dinero;
    private boolean primerCompra;
        
    public Jugador(String nombreDelJugador) 
    throws ErrorDatosVaciosJugador {
            if(!(nombreDelJugador.equals("") || nombreDelJugador == null)){
                nombre = nombreDelJugador;
                dinero = dineroIncial;
                primerCompra = false;                
            }else{
            throw new ErrorDatosVaciosJugador();
            }
	}
    
    public void atacar(LinkedList<Ejercito> ejercitoEnemigo){        
        double ataqueDeMiEjercito = calcularAtaqueDelEjercito();
        ataqueDeMiEjercito = atacarAUnTipoDeGuerrero(ejercitoEnemigo, tipoDeGuerrero.Auxiliar, ataqueDeMiEjercito);
        ataqueDeMiEjercito = atacarAUnTipoDeGuerrero(ejercitoEnemigo, tipoDeGuerrero.Legionario, ataqueDeMiEjercito);
        ataqueDeMiEjercito = atacarAUnTipoDeGuerrero(ejercitoEnemigo, tipoDeGuerrero.Legionario, ataqueDeMiEjercito);        
    }
    
    public LinkedList<Ejercito> getMiEjercito(){
        return miEjercito;
    }
    
    public int lanzarDado(){
        Random ram = new Random();
        return ram.nextInt(6) + 1;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public boolean getPrimerCompra(){
        return primerCompra;
    }
    
    public void setPrimerCompra(boolean estado){
        primerCompra = estado;
    }
    
    public void comprar(int cantidadDeAuxliar , int cantidadDeLegionario , int cantidadDeCenturion) throws ErrorCompraNegativa , ErrorPlataInsuficiente{
        if((cantidadDeAuxliar * Auxiliar.getCostoClase()) + (cantidadDeLegionario * Legionario.getCostoClase()) + (cantidadDeCenturion * Centurion.getCostoClase()) < dinero ){
            miEjercito.add(new Legion(cantidadDeAuxliar, cantidadDeLegionario, cantidadDeCenturion));
            double costo = 0;
            costo = costo + (cantidadDeAuxliar * Auxiliar.getCostoClase());
            costo = costo + (cantidadDeLegionario * Legionario.getCostoClase());
            costo = costo + (cantidadDeCenturion * Centurion.getCostoClase());
            dinero= dinero - costo;
        }else{
            throw new ErrorPlataInsuficiente();
        }
    }
    
    public void comprar(Legion legionPrefabricada){
        dinero = dinero - legionPrefabricada.getCosto();
        miEjercito.add(legionPrefabricada);
    }
    
    public double getDinero(){
        return dinero;
    }
    
    public TreeMap<String, Integer> contarEjercito() {
		TreeMap soldado = new TreeMap<String, Integer>();
		for (Ejercito guerrero : miEjercito) {
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
    
    private double atacarAUnTipoDeGuerrero(LinkedList<Ejercito> ejercitoEnemigo, tipoDeGuerrero guerreroObjetivo, double ataqueDeMiEjercito){
        for(Ejercito guerreroEnemigo : ejercitoEnemigo){
            ataqueDeMiEjercito = guerreroEnemigo.restarVida(ataqueDeMiEjercito, guerreroObjetivo);
            //System.out.println("Daño restante " + ataqueDeMiEjercito);
        }
        return ataqueDeMiEjercito;
    }
    
    private double calcularAtaqueDelEjercito(){
        double ataqueDeMiEjercito = 0;
        int cantidadDeCenturiones = 0;
        for(Ejercito guerreros : miEjercito){
            ataqueDeMiEjercito = ataqueDeMiEjercito + guerreros.calcularAtaque();
            // preguntar si es necesario el if para evtiar exceptions u o errores
            if(guerreros.contarGuerrero().containsKey("Centurio")){
                cantidadDeCenturiones = cantidadDeCenturiones + guerreros.contarGuerrero().get("Centurio");
            }
        }
        ataqueDeMiEjercito = ataqueDeMiEjercito + (ataqueDeMiEjercito * 0.1 * cantidadDeCenturiones);
        return ataqueDeMiEjercito;
    }
}
