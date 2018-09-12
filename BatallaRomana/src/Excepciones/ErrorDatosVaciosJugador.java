package Excepciones;

public class ErrorDatosVaciosJugador extends Exception
{

	public ErrorDatosVaciosJugador() {
		super("No se aceptan nombres vacios");
	}

}
