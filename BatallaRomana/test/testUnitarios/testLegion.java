/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarios;

import org.junit.*;
import java.util.*;
import BatallaRomana.*;
import Excepciones.ErrorValorNulo;
/**
 *
 * @author Matias
 */
public class testLegion {
    
    Ejercito miLegionPorNumeros;
    Ejercito miLegionPorLista;
    LinkedList<Ejercito> conjuntoDeGuerreros;
    
    
    @Before
        public void setup(){
            conjuntoDeGuerreros = new LinkedList<Ejercito>();
            try{
            miLegionPorNumeros = new Legion(10, 10, 10);}
            catch (Exception e){
                
            }
            conjuntoDeGuerreros.add(miLegionPorNumeros);
            try {
            miLegionPorLista = new Legion("Legion por lista", conjuntoDeGuerreros);
        } catch (Exception e) {
        }
        
    }
        
    @Test
    public void seImprimenAmbasLegionesYSeVerificaLaComposicion(){
        //En este caso miLegionPorLista esta compuesta por
        //miLegionPorNumeros y 2 auxilares que se agregan por medio de
        //conjuntoDeGuerreros
        System.out.println("Legion por numero " + miLegionPorNumeros.contarGuerrero());
        System.out.println("Legion por lista solo compuesta por otra legion " + miLegionPorLista.contarGuerrero());
        Assert.assertEquals(10, miLegionPorNumeros.contarGuerrero().get("Auxiliar"),0);
        Assert.assertEquals(10, miLegionPorNumeros.contarGuerrero().get("Legionario"),0);
        Assert.assertEquals(10, miLegionPorNumeros.contarGuerrero().get("Centurion"),0);        
        conjuntoDeGuerreros.add(new Auxiliar());
        conjuntoDeGuerreros.add(new Auxiliar());
        conjuntoDeGuerreros.add(new Legionario());
        conjuntoDeGuerreros.add(new Centurion());
        conjuntoDeGuerreros.add(new Centurion());
        conjuntoDeGuerreros.add(new Centurion());
        Assert.assertEquals(12, miLegionPorLista.contarGuerrero().get("Auxiliar"),0);
        Assert.assertEquals(11, miLegionPorLista.contarGuerrero().get("Legionario"),0);
        Assert.assertEquals(13, miLegionPorLista.contarGuerrero().get("Centurion"),0);
        System.out.println("Legion por lista compuesta de Legion,Legionario,Auxiliar y Centurion " + miLegionPorLista.contarGuerrero());       
    }
    
    @Test
    public void seVerificaMetodoRecursivoParaObtenerElCostoDeLasLegiones(){
    Assert.assertEquals(3500, miLegionPorNumeros.getCosto() ,0.0);
    conjuntoDeGuerreros.add(new Auxiliar());
    Assert.assertEquals(3550, miLegionPorLista.getCosto(), 0.0);    
    }
    
    //No se puede verificar ataque ya que al estar Randomizado
    //El test puede dar positivo como no
    
    @Test
    public void seVerificaElCalculoDeAtaque(){
    // Aclaracion la pasiva de los centuriones de plus de ataque
    // afecta a todo el ejercito
    // por lo tanto este se aplica en jugador no en legion
        System.out.println(miLegionPorNumeros.calcularAtaque());
    }
    
    @Test
    public void seVerificaQueElAtaqueRecibidoSoloSeVeanAfectadosElTipoDeGuerreroIndicado(){
        System.out.println(miLegionPorNumeros.contarGuerrero());
        Assert.assertEquals(0, miLegionPorNumeros.restarVida(900, tipoDeGuerrero.Auxiliar),0.0);
        Assert.assertEquals(1,miLegionPorNumeros.contarGuerrero().get("Auxiliar"), 0.0);
    }
    
}
