/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatallaRomana;

import Excepciones.*;
import Intefaces.*;
import Lector.Lector;
import antlr.debug.GuessingEvent;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Matias
 */

//Aca se tratam todas las excepciones
// esta clase contiene el juego en si mismo
// y el static main para iniciar
public class Juego {
    
    private static Juego esteJuego;
    private static MenuPrincipal menu;   
    private CrearJugador crearJugador;
    private int maximoDeJugadores;
    private LanzarDado lanzador;
    private ComprarEjercito comprar;
    private int numeroDeJugador;
    private int[] resultadoDelDado;
    private MenuDeGuerra guerra;
    
    public static Juego getJuego(){
        if(esteJuego == null){
            esteJuego = new Juego();
        }
        return esteJuego;
    }
    
    public static void main (String arg[] ){
        menu = new MenuPrincipal();
    }
    
    public void empezarPartida() {
       menu.dispose();
       crearJugador = new CrearJugador();
       //System.out.println(numeroDeJugador);
    }
    
    public int getNumeroDeJugador(){
            return numeroDeJugador + 1;        
    }
    
    public void crearJugador(String Nombre){
        try {            
            //System.out.println("Antes de crear un jugador : " + numeroDeJugador);
            //System.out.println(Nombre);
            Batalla.getBatalla().crearJugador(Nombre, numeroDeJugador);  
            //Solo cuenta si crea bien si tira exception no cuenta
            numeroDeJugador++;
            if(numeroDeJugador >= 0 && numeroDeJugador < maximoDeJugadores){
            //System.out.println("Despues de crear un jugador" + numeroDeJugador);
            crearJugador.dispose();
            crearJugador = new CrearJugador();           
            }else{
                crearJugador.dispose();
                //resetNumeroDetJugador();
                //lanzador = new LanzarDado();
                lanzador = new LanzarDado();
            }            
        } catch (ErrorDatosVaciosJugador e) {
             new Mensajero(e.getMessage());
        }finally{
            
        }
        
    }  
    
    // Este lanzar dado va con lanzar en dado 2 
    public int lanzarDado(int numeroDeJugador){
        resultadoDelDado[numeroDeJugador - 1] = Batalla.getBatalla().getJugador(numeroDeJugador - 1).lanzarDado();
        // resultadoDelDado[numeroDeJugador - 1] = 1;
        continuarLanzadorDado();
        return resultadoDelDado[numeroDeJugador - 1];
    }
    
    
    public void continuarLanzadorDado(){
        // System.out.println(resultadoDelDado[0]);
        // System.out.println(resultadoDelDado[1]);
        if(resultadoDelDado[0] == resultadoDelDado[1]){
            resultadoDelDado[0] = 0;
            resultadoDelDado[1] = 0;
            lanzador.dispose();
            lanzador = new LanzarDado();            
            //System.out.println("Tendria que haber abierto otro lanzador");
        }else if (resultadoDelDado[0] > 0 && resultadoDelDado[1] > 0){
            lanzador.hacerVisibleBotonContinuar();
        }
    }
    
    public void cerrarLanzador(){
        if(resultadoDelDado[0] > resultadoDelDado[1]){
            Batalla.getBatalla().setAtacante(Batalla.getBatalla().getJugador(0));
            Batalla.getBatalla().setDefensor(Batalla.getBatalla().getJugador(1));
            
        /*System.out.println("Jugador 1 "+Batalla.getBatalla().getJugador(0).getNombre());
        System.out.println("Jugador 2 "+Batalla.getBatalla().getJugador(1).getNombre());
        System.out.println("Jugador Ata "+Batalla.getBatalla().getAtacante().getNombre());
        System.out.println("Jugador Def "+Batalla.getBatalla().getDefensor().getNombre());*/
        }else{
            Batalla.getBatalla().setAtacante(Batalla.getBatalla().getJugador(1));
            Batalla.getBatalla().setDefensor(Batalla.getBatalla().getJugador(0));
        /*    
        System.out.println("Jugador 1 "+Batalla.getBatalla().getJugador(0).getNombre());
        System.out.println("Jugador 2 "+Batalla.getBatalla().getJugador(1).getNombre());
        System.out.println("Jugador Ata "+Batalla.getBatalla().getAtacante().getNombre());
        System.out.println("Jugador Def "+Batalla.getBatalla().getDefensor().getNombre());*/
        }
        lanzador.dispose();
        comprar = new ComprarEjercito();
    }
    
    public void imprimirUnidadesDeLegionesEnTextBox(String nombreDeLegion, int auxiliares, int legionarios, int centuriones){
                
        if(!(nombreDeLegion.equals("Seleccione una legion"))){                    
            for(int i = 0; i < cantidadDeLegiones(); i++){
                if(nombreDeLegion.equals(Lector.getLector().main(i).getNombre())){
                    //Lector.getLector().main(i).contarGuerrero()
                    if(Lector.getLector().main(i).contarGuerrero().containsKey("Auxiliar")){
                        auxiliares = Lector.getLector().main(i).contarGuerrero().get("Auxiliar");
                    }
                    if(Lector.getLector().main(i).contarGuerrero().containsKey("Legionario")){
                        legionarios = Lector.getLector().main(i).contarGuerrero().get("Legionario");
                    }
                    if(Lector.getLector().main(i).contarGuerrero().containsKey("Centurion")){
                        centuriones = Lector.getLector().main(i).contarGuerrero().get("Centurion");
                    }
                    setGuerrerosCompraTextBox(auxiliares,legionarios,centuriones);
                    setCostoDeLegionLabel(Lector.getLector().main(i).getCosto());
                }
            }
        }else{
        setCostoDeLegionLabel(auxiliares,legionarios,centuriones);
        }
        
    }
    
    public void comprarLegion(String nombreDeLegion, int auxiliares, int legionarios, int centuriones){
        if(!(nombreDeLegion.equals("Seleccione una legion"))){                    
            for(int i = 0; i < cantidadDeLegiones(); i++){
                if(nombreDeLegion.equals(Lector.getLector().main(i).getNombre())){
                    try{
                    if(Batalla.getBatalla().getAtacante().getDinero() > Lector.getLector().main(i).getCosto()){
                        
                    Batalla.getBatalla().getAtacante().comprar(Lector.getLector().main(i));                    
                    bucleDeCompraGuerra();
                    }else{
                    throw new ErrorPlataInsuficiente();
                    }
                    }catch(Exception e){
                        new Mensajero(e.getMessage());
                    }
                }
            }
        }else{
            //<---------->
            try{
            Batalla.getBatalla().getAtacante().comprar(auxiliares, legionarios, centuriones);
            bucleDeCompraGuerra();
            }catch(Exception e){
                new Mensajero(e.getMessage());
            }
        }
    }
    
    public void atacar(){
        Batalla.getBatalla().atacar();
        Batalla.getBatalla().cambioDeTurno();
        guerra.dispose();
        if(Batalla.getBatalla().hayGanador()){
            new Mensajero("Ganador es " + Batalla.getBatalla().getGanador().getNombre());
        }else{
        guerra = new MenuDeGuerra();
        }
    }
    
    public void abrirCompra(){
        guerra.dispose();
        comprar = new ComprarEjercito();
    }
    
    private void bucleDeCompraGuerra(){
    if(!(Batalla.getBatalla().getJugador(0).getPrimerCompra() || Batalla.getBatalla().getJugador(1).getPrimerCompra())){
            //Inicio            
            Batalla.getBatalla().getAtacante().setPrimerCompra(true);
            Batalla.getBatalla().cambioDeTurno();
            comprar.dispose();
            comprar = new ComprarEjercito();
            }else if((Batalla.getBatalla().getJugador(0).getPrimerCompra() && Batalla.getBatalla().getJugador(1).getPrimerCompra())){
            // Ciclo bucle
            if(Batalla.getBatalla().hayGanador()){
                comprar.dispose();
                guerra.dispose();
                new Mensajero("Ganador es " + Batalla.getBatalla().getGanador().getNombre());
            }
            comprar.dispose();
            Batalla.getBatalla().cambioDeTurno();
            guerra.dispose();
            guerra = new MenuDeGuerra();
            }else{
            //Segunda compra mantiene el turno
            Batalla.getBatalla().getAtacante().setPrimerCompra(true);
            comprar.dispose();
            guerra = new MenuDeGuerra();
            //System.out.println("Llegue aca");
            }
    }
    
    public Jugador getAtacante(){
        return Batalla.getBatalla().getAtacante();
    }
    
    public int getMaximoNumeroDeJugadores(){
        return maximoDeJugadores;
    }
    
    public int cantidadDeLegiones(){
        return Lector.getLector().cantidadDeLegiones();
    }
    
    public Legion getLegionPrefabricada(int numeroDeLegion){
        return Lector.getLector().main(numeroDeLegion);
    }
    
    public String getNombreDeAtacante(){
        return Batalla.getBatalla().getAtacante().getNombre();
    }
    
    public double getDineroDeAtacante(){
        return Batalla.getBatalla().getAtacante().getDinero();
    }
    
    private void setCostoDeLegionLabel(double CostoDeLegion){
        comprar.setCostoDeLegion(CostoDeLegion);
    }
    
    private void setCostoDeLegionLabel(int auxiliares, int legionarios, int centuriones){
        comprar.setCostoDeLegion((auxiliares * Auxiliar.getCostoClase()) + (legionarios * Legionario.getCostoClase()) + (centuriones * Centurion.getCostoClase()));
    }
        
    private void setGuerrerosCompraTextBox(int auxiliares, int legionarios, int centuriones){
        comprar.setCantidadDeGuerreros(auxiliares, legionarios, centuriones);
    }
    
    private void resetNumeroDetJugador(){
        numeroDeJugador = 0;
    }
        
    private Juego(){        
        numeroDeJugador = 0;
        maximoDeJugadores = 2;
        resultadoDelDado = new int[maximoDeJugadores];
    }
    
}
