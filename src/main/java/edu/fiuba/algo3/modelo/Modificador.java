/**
 * 
 */
package edu.fiuba.algo3.modelo;

import java.util.List;

/**
 * @author marco
 *
 */
public interface Modificador {

	void aplicar(Jugador jugador, List<Jugador> listaJugadores, List<Integer> listaPuntajesfinales);

}
