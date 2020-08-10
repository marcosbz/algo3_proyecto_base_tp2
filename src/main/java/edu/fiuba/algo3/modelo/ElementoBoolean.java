/**
 * 
 */
package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public class ElementoBoolean implements ElementoRespuesta {

	private Boolean valor;

	public ElementoBoolean(Boolean b) {
		// TODO Auto-generated constructor stub
		this.valor = b;
	}

	@Override
	public Boolean igualA(ElementoRespuesta elemento) throws RespuestaNoReconocidaException {
		// TODO Auto-generated method stub
		return elemento.igualadoPor(this);
	}

	@Override
	public Boolean igualadoPor(ElementoBoolean elemento) throws RespuestaNoReconocidaException {
		// TODO Auto-generated method stub
		return this.valor == elemento.getValue();
	}

	private Boolean getValue() {
		// TODO Auto-generated method stub
		return this.valor;
	}

	@Override
	public Boolean igualadoPor(ElementoEntero elemento) throws RespuestaNoReconocidaException {
		// TODO Auto-generated method stub
		throw new RespuestaNoReconocidaException();
	}
}
