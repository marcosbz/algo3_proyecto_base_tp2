/**
 * 
 */
package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public interface MediatorArbitro {

	void iniciarDesafio(Desafio desafioTestVoF);

	void finalizarDesafio() throws RespuestaNoReconocidaException;

	void aceptarJugada(Jugador jugador, RespuestaDesafio respuesta, List<Modificador> modificadoresDelJugador);

}
