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
public class testAuxiliar {

    @Test
    public void seImprimeCalculoDeAtaqueParaVerficarQueElAtaqueEsteRandomizadoYQueFalleEl3Ataque(){
    Auxiliar aux = new Auxiliar();
    for(int i = 0; i < 15; i++){
        System.out.println("Ataque " + i + " " + aux.calcularAtaque());
        }        
    }
    
    @Test
    public void seVerificaQueRecibaDanioCorrectamente(){
    Auxiliar aux = new Auxiliar();
    Assert.assertEquals(0,aux.restarVida(5, tipoDeGuerrero.Auxiliar),0.0);
    Assert.assertEquals(95, aux.getVida(), 0.0);
    Assert.assertEquals(0, aux.restarVida(20, tipoDeGuerrero.Auxiliar), 0.0);
    Assert.assertEquals(75, aux.getVida(), 0.0);    
    }
    
    @Test
    public void seVerificaQueRetorneElAtaqueSobrante(){
    Auxiliar aux = new Auxiliar();
    Assert.assertEquals(400,aux.restarVida(500, tipoDeGuerrero.Auxiliar),0.0);
    }
    
    @Test
    public void seVerificaQueAuxiliarMuertoNoAfecteALosMetodosQueSePideEstarVivo(){
    Auxiliar aux = new Auxiliar();
    aux.restarVida(100, tipoDeGuerrero.Auxiliar);
    Assert.assertEquals(100, aux.restarVida(100, tipoDeGuerrero.Auxiliar), 0.0);
    Assert.assertEquals(0, aux.calcularAtaque(), 0.0);
    }
    
    @Test
    public void seVerificaQueAlSerAtacadoYNoCoincidirElTipoRetorneElAtaqueRestanteCorrespondiente(){
    Auxiliar aux = new Auxiliar();
    Assert.assertEquals(100, aux.restarVida(100, tipoDeGuerrero.Legionario), 0.0);
    }
    
    
}
