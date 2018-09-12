/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatallaRomana;

import java.util.TreeMap;

/**
 *
 * @author Matias
 */

public abstract class Ejercito {
    
    /**
     * El enum es para identificar con facilidad el tipo de guerrero
     * posiblemente más adelante veamos como quitar lo y solo usar 
     * el map mostrarGuerrero
     */
    
    
    /*
    *  Estos metodo son abstracto por que varia entre las "hojas"
    *  y el composite.
    *  calcularAtaque , getCosto, mostrarGuerrero, restarVida
    */
    // falta agregar en varios metodos la condicion de muerte "vida < 0"
    public abstract double calcularAtaque();
    public abstract double getCosto();
    public abstract TreeMap<String, Integer> contarGuerrero();
    /**
     * Este metodo recibe el ataque que debe restar lo a la vida del objetivo
     * y retorna si es que sobra ataque para realizar al siguiente.
     */
    public abstract double restarVida(double danoARealizar, tipoDeGuerrero guerreroObjetivo);
    public abstract tipoDeGuerrero getTipo();
   
}
