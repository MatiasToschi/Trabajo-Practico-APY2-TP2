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
public class ErrorPlataInsuficiente extends Exception {

	public ErrorPlataInsuficiente() {
		super("No tienes saldo suficiente para la compra ");
	}

}
