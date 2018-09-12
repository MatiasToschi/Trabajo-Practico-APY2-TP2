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
public class Legionario extends Ejercito {

	private static int costo = 100;
	private static double ataque = 1.4;
	private double vida = 100;
        
        public static double getCostoClase(){
        return costo;
    }

	public double calcularAtaque() {
		if (estaVivo()) {
			if (Math.random() > 0.5) {
				return ataque;
			}
			return 0;
		}
		return 0;

	}

	public double getCosto() {
		return costo;
	}

	public TreeMap<String, Integer> contarGuerrero() {
		TreeMap soldado = new TreeMap<String, Integer>();
		if (estaVivo()) {
			soldado.put("Legionario", 1);
		} else {
			soldado.put("Legionario Muerto", 1);
		}
		return soldado;
	}

	public double getVida() {
		if (estaVivo()) {
			return vida;
		} else {
			System.out.println("Legionario muerto");
			return 0;
		}
	}

	public tipoDeGuerrero getTipo() {
		return tipoDeGuerrero.Legionario;
	}

	public double restarVida(double danoARealizar,
			tipoDeGuerrero guerreroObjetivo) {
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
        if(obj instanceof Legionario){
            return true;
        }
        return false;
    }

	private boolean estaVivo() {
		return vida > 0;
	}

}
