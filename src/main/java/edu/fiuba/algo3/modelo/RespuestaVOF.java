/**
 * 
 */
package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marco
 *
 */
public class RespuestaVOF implements RespuestaDesafio {

	private boolean respuesta;

	public RespuestaVOF(boolean respuesta) {
		// TODO Auto-generated constructor stub
		this.respuesta = respuesta;
	}

	@Override
	public List<ElementoRespuesta> getListaElementos() {
		// TODO Auto-generated method stub
		List<ElementoRespuesta> listaRespuestas = new ArrayList<>();
		ElementoRespuesta respuesta = new ElementoBoolean(this.respuesta);
		listaRespuestas.add(respuesta);
		return listaRespuestas;
	}
}
