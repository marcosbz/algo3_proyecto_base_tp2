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
public class RespuestaChoice implements RespuestaDesafio {

	private List<ElementoRespuesta> listaRespuestas;

	public RespuestaChoice(List<Boolean> respuesta) {
		// TODO Hacer copia de respuestas. Hago solo copia de referencias. Si necesito deep copy despues veo
		this.listaRespuestas = new ArrayList<ElementoRespuesta>();
		respuesta.forEach((tempBoolean) -> {
			if(null == tempBoolean)
				listaRespuestas.add(null);
			else {
				ElementoRespuesta nuevoElementoRespuesta = new ElementoBoolean(tempBoolean);
				listaRespuestas.add(nuevoElementoRespuesta);
			}
		});
	}

	@Override
	public List<ElementoRespuesta> getListaElementos() {
		// TODO Auto-generated method stub
		return this.listaRespuestas;
	}

}
