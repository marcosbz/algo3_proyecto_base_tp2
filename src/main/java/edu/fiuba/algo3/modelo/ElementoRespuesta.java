/**
 * 
 */
package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public interface ElementoRespuesta {

	Boolean igualA(ElementoRespuesta elemento) throws RespuestaNoReconocidaException;
	/* Double Dispatch helper methods */
	Boolean igualadoPor(ElementoBoolean elemento) throws RespuestaNoReconocidaException;
	Boolean igualadoPor(ElementoEntero elemento) throws RespuestaNoReconocidaException;

}
