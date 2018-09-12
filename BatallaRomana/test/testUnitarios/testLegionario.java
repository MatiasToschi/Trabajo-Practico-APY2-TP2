/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUnitarios;

import BatallaRomana.*;
import org.junit.*;
/**
 *
 * @author Matias
 */
public class testLegionario {
    
    @Test
    public void seImprimeCalculoDeAtaqueParaVerficarQueElAtaqueEsteRandomizado(){
    Legionario leg = new Legionario();
    for(int i = 0; i < 15; i++){
        System.out.println("Ataque " + i + " " + leg.calcularAtaque());
        }        
    }
    
    @Test
    public void seVerificaQueRecibaDanioCorrectamente(){
    Legionario leg = new Legionario();
    Assert.assertEquals(0,leg.restarVida(5, tipoDeGuerrero.Legionario),0.0);
    Assert.assertEquals(95, leg.getVida(), 0.0);
    Assert.assertEquals(0, leg.restarVida(20, tipoDeGuerrero.Legionario), 0.0);
    Assert.assertEquals(75, leg.getVida(), 0.0);     
    }
    
    @Test
    public void seVerificaQueRetorneElAtaqueSobrante(){
    Legionario leg = new Legionario();
    Assert.assertEquals(400,leg.restarVida(500, tipoDeGuerrero.Legionario),0.0);
    }
    
    @Test
    public void seVerificaQueAuxiliarMuertoNoAfecteALosMetodosQueSePideEstarVivo(){
    Legionario leg = new Legionario();
    leg.restarVida(100, tipoDeGuerrero.Legionario);
    Assert.assertEquals(100, leg.restarVida(100, tipoDeGuerrero.Legionario), 0.0);
    Assert.assertEquals(0, leg.calcularAtaque(), 0.0);
    }
    
    @Test
    public void seVerificaQueAlSerAtacadoYNoCoincidirElTipoRetorneElAtaqueRestanteCorrespondiente(){
    Legionario lef = new Legionario();
    Assert.assertEquals(100, lef.restarVida(100, tipoDeGuerrero.Auxiliar), 0.0);
    }
    
}
