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
public class EstrategiaPuntuacionClasico implements EstrategiaPuntuacion {

	@Override
	public Integer evaluar(RespuestaDesafio respuestaCorrecta, RespuestaDesafio respuestaEvaluada) throws RespuestaNoReconocidaException {
		// TODO Auto-generated method stub
		/* Compara cada elemento. Si alguno no coincide devuelve 0. Sino devuelve 1 */
		List<ElementoRespuesta> listaCorrecta = respuestaCorrecta.getListaElementos();
		List<ElementoRespuesta> listaEvaluada = respuestaEvaluada.getListaElementos();
		/* Comparar cada elemento de la lista con == */
		if(listaCorrecta.size() != listaEvaluada.size()) throw new RespuestaNoReconocidaException();
		for(int i = 0; i < listaCorrecta.size(); i++)
			if(false == listaCorrecta.get(i).igualA(listaEvaluada.get(i))) return 0;
		return 1;
	}

}
