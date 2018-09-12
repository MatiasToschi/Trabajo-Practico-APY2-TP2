/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarios;

/**
 *
 * @author Matias
 */

import Lector.Lector;
import BatallaRomana.*;
import Excepciones.*;
import org.junit.*;
import java.util.*;

public class testLector {
    
    @Test
    public void seCreaLaMismaLegionPorCodigoYPorLectorSeVerificaQueSeanIguales(){        
        Lector archivo = Lector.getLector();
        LinkedList<Ejercito> conjuntoGuerrero = new LinkedList<Ejercito>();
        Legion miLegion = null;
        for(int i = 0; i < 388; i++){
            conjuntoGuerrero.add(new Auxiliar());
        }
        for(int i = 0; i < 7; i++){
            conjuntoGuerrero.add(new Legionario());
        }
        conjuntoGuerrero.add(new Centurion());                
        try{
            miLegion = new Legion("CasiTodosAuxiliares", conjuntoGuerrero);
        }catch (ErrorValorNulo e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(miLegion, archivo.main(0));
    }
    
    @Test
    public void testDeLecturaSeLeeEImprimeTodosLoPrefabricados(){
        for(int i = 0; i < Juego.getJuego().cantidadDeLegiones(); i++){
            System.out.println(Juego.getJuego().getLegionPrefabricada(i).contarGuerrero());
        }
    }
}
