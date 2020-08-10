/**
 * 
 */
package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public class ElementoEntero implements ElementoRespuesta {

	private Integer valor;

	public ElementoEntero(Integer i) {
		// TODO Auto-generated constructor stub
		this.valor = i;
	}

	@Override
	public Boolean igualA(ElementoRespuesta elemento) throws RespuestaNoReconocidaException {
		// TODO Auto-generated method stub
		return elemento.igualadoPor(this);
	}

	@Override
	public Boolean igualadoPor(ElementoBoolean elemento) throws RespuestaNoReconocidaException {
		// throw exception for comparing incompatible values
		throw new RespuestaNoReconocidaException();
	}

	@Override
	public Boolean igualadoPor(ElementoEntero elemento) {
		// TODO Auto-generated method stub
		return this.valor == elemento.getValor();
	}

	private Integer getValor() {
		// TODO Auto-generated method stub
		return valor;
	}

}
