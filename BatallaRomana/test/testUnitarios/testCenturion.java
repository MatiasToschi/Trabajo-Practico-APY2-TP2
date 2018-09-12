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
public class testCenturion {
    
    @Test
    public void seImprimeCalculoDeRestarVidaParaVerficarQueEsquiveCiertosAtaquesYQueRecibaEl3Ataque(){
    Centurion cent = new Centurion();
    for(int i = 0; i < 15; i++){
        System.out.println("Ataque " + i + " " + cent.restarVida(5, tipoDeGuerrero.Centurion));
        }        
    }
       
    @Test
    public void seVerificaQueAuxiliarMuertoNoAfecteALosMetodosQueSePideEstarVivo(){
    Centurion cent = new Centurion();
    for(int i = 0; i < 20 ; i ++){
    cent.restarVida(100, tipoDeGuerrero.Centurion);
    }
    Assert.assertEquals(100, cent.restarVida(100, tipoDeGuerrero.Centurion), 0.0);
    Assert.assertEquals(0, cent.calcularAtaque(), 0.0);
    }
    
    @Test
    public void seVerificaQueAlSerAtacadoYNoCoincidirElTipoRetorneElAtaqueRestanteCorrespondiente(){
    Centurion cent = new Centurion();
    Assert.assertEquals(100, cent.restarVida(100, tipoDeGuerrero.Legionario), 0.0);
    }
    
}
