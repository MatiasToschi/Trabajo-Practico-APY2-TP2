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
public class Auxiliar extends Ejercito{

    private static int costo = 50;
    private static double ataque = 0.7;
    private double vida = 100;
    private boolean primerAtaqueNoConsecutivo = true;
    private int cantidadDeAtaquesConsecutivos = 0;
    
    public static double getCostoClase(){
        return costo;
    }
    
    public double calcularAtaque() {
        if(estaVivo()){
        if((primerAtaqueNoConsecutivo || (Math.random() > 0.5)) && (cantidadDeAtaquesConsecutivos < 2) ){
        primerAtaqueNoConsecutivo = false;
        cantidadDeAtaquesConsecutivos++;
        return ataque;
        }
        cantidadDeAtaquesConsecutivos = 0;
        primerAtaqueNoConsecutivo = true;
        return 0;
        }
        return 0;
    }
        
    public double getCosto() {
        return costo;
    }
    
    public TreeMap<String, Integer> contarGuerrero(){
        TreeMap soldado = new TreeMap<String, Integer>();
        if(estaVivo()){
        soldado.put("Auxiliar", 1);
        }else{
        soldado.put("Auxiliar Muerto", 1);
        }
        return soldado;
    }
    
    public double getVida(){
       if(estaVivo()){
       return vida;
    }else{
           System.out.println("Auziliar muerto");
            return 0;
         }
    }
    
    public tipoDeGuerrero getTipo(){
        return tipoDeGuerrero.Auxiliar;
    }
    
    public double restarVida(double danoARealizar, tipoDeGuerrero guerreroObjetivo){      
        if(guerreroObjetivo == getTipo() && estaVivo()){
        double aux = 0;
        if(danoARealizar > vida){
            aux = Math.abs(vida - danoARealizar);
            vida = 0;
        }else{
            vida = vida - danoARealizar;
            
        }
        return aux;
        }else{
        return danoARealizar;
        }
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Auxiliar){
            return true;
        }
        return false;
    }
    
    private boolean estaVivo(){
        return  vida > 0;
    }
    
}
