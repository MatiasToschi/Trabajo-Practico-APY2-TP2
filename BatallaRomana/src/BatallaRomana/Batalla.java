/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatallaRomana;

import Excepciones.ErrorDatosVaciosJugador;
/**
 *
 * @author Matias
 */
public class Batalla {
    
    private Jugador[] jugadores;
    private Jugador atacante, defensor;
    private static Batalla miBatalla;

	public static Batalla getBatalla() {
		if (miBatalla == null) {
			miBatalla = new Batalla();
		}
		return miBatalla;
	}

	public void crearJugador(String nombreDelJugador, int numeroDeJugador)
        throws ErrorDatosVaciosJugador
        {
            jugadores[numeroDeJugador] = new Jugador(nombreDelJugador);            
	}
        
        public Jugador getJugador(int numeroDeJugador){
            return jugadores[numeroDeJugador];
        }
        
        public boolean hayGanador(){
        if(
                atacante.getDinero() <= 49 || 
                (atacante.contarEjercito().get("Auxiliar") == null&& 
                atacante.contarEjercito().get("Legionario") == null && 
                atacante.contarEjercito().get("Centurion") == null
                )){
        return true;
        }
        return false;
        }
        
        public Jugador getGanador(){
            if(
                atacante.getDinero() <= 49 ||( 
                atacante.contarEjercito().get("Auxiliar") == null && 
                atacante.contarEjercito().get("Legionario") == null && 
                atacante.contarEjercito().get("Centurion") == null
                )){
            return defensor;
            }
        return atacante;
        }
        
        public void atacar(){
            atacante.atacar(defensor.getMiEjercito());
        }
        
        public void cambioDeTurno(){
            Jugador aux = atacante;
            atacante = defensor;
            defensor = aux;
        }
        
        public Jugador getAtacante(){
            return atacante;
        }
        
        public Jugador getDefensor(){
            return  defensor;
        }
        
        public void setAtacante(Jugador atacante){
            this.atacante = atacante;
        }
        
        public void setDefensor(Jugador defensor){
            this.defensor = defensor;
        }

	private Batalla() {
            System.out.println(Juego.getJuego().getMaximoNumeroDeJugadores());
            jugadores = new Jugador[Juego.getJuego().getMaximoNumeroDeJugadores()];
	}
       
    
}
