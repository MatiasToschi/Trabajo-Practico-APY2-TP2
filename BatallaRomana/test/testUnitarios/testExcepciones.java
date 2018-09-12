/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarios;

import Excepciones.*;
import BatallaRomana.*;
import java.util.*;
import org.junit.*;


/**
 *
 * @author Matias
 */
public class testExcepciones {

    Ejercito miLegion;
    LinkedList<Ejercito> listaEjercito;
    Jugador miJugador;
    
    @Before
    public void setup(){
        listaEjercito = new LinkedList<Ejercito>();
        try{
        miJugador = new Jugador("Tomas");
        miLegion = new Legion(10, 10, 10);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        miJugador.comprar((Legion)miLegion);
    }
    
    @Test
    public void testErrorCompraNegativa(){
        try{
            miJugador.comprar(-5, -10, 7);
            Assert.fail();
        }catch(ErrorCompraNegativa e){
            System.err.println(e.getMessage());
        }catch(ErrorPlataInsuficiente e){
        }
    }
    
    @Test
    public void testErrorPlataInsuficiente(){
        try{
            miJugador.comprar(2000, 2000, 2000);
            Assert.fail();
        }catch(ErrorCompraNegativa e){
        }catch(ErrorPlataInsuficiente e){            
            System.err.println(e.getMessage());
        }
    }
    
    @Test
    public void testDatosVaciosDelJugador(){
        try{
        miJugador = new Jugador("");
        Assert.fail();
        }catch(ErrorDatosVaciosJugador e){
            System.err.println(e.getMessage());
        }
    }
    
    @Test
    public void testErrorValorNulo(){
    try{
    miLegion = new Legion("", listaEjercito);
    Assert.fail();
    }catch(ErrorValorNulo e){
        System.err.println(e.getMessage());
    }
    }
    
}
