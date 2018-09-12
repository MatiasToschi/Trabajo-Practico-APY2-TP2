/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lector;

/**
 *
 * @author Matias
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorDeArchivos {

	public ArrayList<String> leer() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList lineas = new ArrayList<String>();
		try {
			archivo = new File("src/Archivos/archivo.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String unaLinea;
			while ((unaLinea = br.readLine()) != null) {
				lineas.add(unaLinea);
			}
			fr.close();
		} catch (Exception e) {

		}
		return lineas;
	}
}

