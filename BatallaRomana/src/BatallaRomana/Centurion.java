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
public class Centurion extends Ejercito{
    
    private static int costo = 200;
    private static double ataque = 1;
    private double vida = 100 ;
    private int cantidadDeAtaquesEvitadosConsecutivos = 0;
    
   
    public Centurion(){
    	
    }
    
    public static double getCostoClase(){
        return costo;
    }
    
    
    public double calcularAtaque() {
        if(estaVivo()){
        return ataque;
        }
        return 0;
    }

    
    public double getCosto() {
        return costo;
    }
    
    public TreeMap<String, Integer> contarGuerrero(){
        TreeMap soldado = new TreeMap<String, Integer>();
        if(estaVivo()){
        soldado.put("Centurion", 1);
        }else{
            soldado.put("Centurion Muerto", 1);
        }
        return soldado;
    }  
    
    public double getVida(){
       if(estaVivo()){
       return vida;
    }else{
           System.out.println("Centurion muerto");
            return 0;
         }
    }
    
    public tipoDeGuerrero getTipo(){
        return tipoDeGuerrero.Centurion;
    }
    
    public double restarVida(double danoARealizar, tipoDeGuerrero guerreroObjetivo){      
        if(guerreroObjetivo == getTipo()){
            
        if((Math.random() > 0.5) && (cantidadDeAtaquesEvitadosConsecutivos < 2)){
            cantidadDeAtaquesEvitadosConsecutivos++;
            return danoARealizar;
        }else{
            //Esto pasa si el ataque golpea
            cantidadDeAtaquesEvitadosConsecutivos = 0;
            double aux = 0;
        if(danoARealizar > vida){
            aux = Math.abs(vida - danoARealizar);
            vida = 0;
        }else{
            vida = vida - danoARealizar;
        }
        return aux;
        }
        }
        return danoARealizar;
    }
    
     public boolean equals(Object obj){
        if(obj instanceof Centurion){
            return true;
        }
        return false;
    }
    
    private boolean estaVivo(){
        return  vida > 0;
    }
}
