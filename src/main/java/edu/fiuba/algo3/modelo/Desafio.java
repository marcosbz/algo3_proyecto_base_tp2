/**
 * 
 */
package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public interface Desafio {

	Integer evaluarRespuesta(RespuestaDesafio respuestaVOF) throws RespuestaNoReconocidaException;

	void setEstrategia(EstrategiaPuntuacion estrategia);

}
