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
public class EstrategiaPuntuacionParcial implements EstrategiaPuntuacion {

	@Override
	public Integer evaluar(RespuestaDesafio respuestaCorrecta, RespuestaDesafio respuestaEvaluada)
			throws RespuestaNoReconocidaException {
		// TODO Auto-generated method stub
		/* Compara cada elemento y suma al total. Si alguno no coincide suma -1. Sino suma 1 */
		List<ElementoRespuesta> listaCorrecta = respuestaCorrecta.getListaElementos();
		List<ElementoRespuesta> listaEvaluada = respuestaEvaluada.getListaElementos();
		/* Comparar cada elemento de la lista con == */
		if(listaCorrecta.size() != listaEvaluada.size()) throw new RespuestaNoReconocidaException();
		Integer acumulado = 0;
		for(int i = 0; i < listaCorrecta.size(); i++) {
			if(null != listaEvaluada.get(i)) {
				if(true == listaCorrecta.get(i).igualA(listaEvaluada.get(i))) {
					acumulado++;
				}
				else {
					/* Elemento incorrecto. Invalida toda la respuesta */
					acumulado = 0; break;
				}
			}
			else {
				/* Respuesta en blanco. No modifica puntaje */
			}
		}
		return acumulado;
	}

}
