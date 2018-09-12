/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Matias
 */
public class ErrorValorNulo extends Exception{
    
    public ErrorValorNulo(){
        super("Ni el nombre ni la lista de la legion pueden ser nulas/vacias");
    }
    
}
