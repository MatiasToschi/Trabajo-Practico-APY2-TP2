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
public class ErrorCompraNegativa extends Exception {

	public ErrorCompraNegativa() {
		super("No se acepta compras negativas");
	}

}