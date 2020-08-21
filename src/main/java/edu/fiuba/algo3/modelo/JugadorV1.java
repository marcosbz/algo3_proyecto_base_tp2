/**
 * 
 */
package edu.fiuba.algo3.modelo;

/**
 * @author marco
 *
 */
public class JugadorV1 implements Jugador {

	private Integer puntaje;
	private String nombre;

	public JugadorV1(String nombre) {
		// TODO Auto-generated constructor stub
		this.puntaje = 0;
		this.nombre = nombre;
	}

	@Override
	public void recibirPuntaje(int puntaje) {
		// TODO Auto-generated method stub
		this.puntaje += puntaje;
	}

}
