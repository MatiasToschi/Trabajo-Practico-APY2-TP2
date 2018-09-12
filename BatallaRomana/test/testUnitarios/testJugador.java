/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarios;


import java.util.*;
import org.junit.*;
import BatallaRomana.*;
/**
 *
 * @author Matias
 */
public class testJugador {
    
    Ejercito miLegion, legionEnemiga;
    LinkedList<Ejercito> listaEjercitoEnemigo;
    Jugador miJugador;
    
    @Before
    public void setup(){
        listaEjercitoEnemigo = new LinkedList<Ejercito>();
        try{
        miJugador = new Jugador("Tomas");
        miLegion = new Legion(10, 10, 10);
        legionEnemiga = new Legion(20, 1, 1);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        miJugador.comprar((Legion)miLegion);
        listaEjercitoEnemigo.add(legionEnemiga);
    }
    
    @Test
    public void seVerificaElAtaqueContraElEnemigo(){
        //Aclaracion
        //Al ser el resultado "ramdom" este sera unimanete
        //impreso por consola;
        //En principio se verifica que los unicos/ primeros en morir
        //deben ser los auxiliares enemigos
        for(int i = 0; i < 100 ; i++){
        miJugador.atacar(listaEjercitoEnemigo);
            System.out.println(listaEjercitoEnemigo.get(0).contarGuerrero());
        }
    }
    
}
