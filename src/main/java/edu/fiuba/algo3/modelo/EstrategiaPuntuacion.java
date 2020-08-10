/**
 * 
 */
package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public interface EstrategiaPuntuacion {

	Integer evaluar(RespuestaDesafio respuestaCorrecta, RespuestaDesafio respuestaEvaluada) throws RespuestaNoReconocidaException;

}
