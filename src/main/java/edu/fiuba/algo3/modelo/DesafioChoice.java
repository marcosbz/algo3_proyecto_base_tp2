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
public class DesafioChoice implements Desafio {

	private String consigna;
	private RespuestaChoice respuestaCorrecta;
	private EstrategiaPuntuacion estrategiaEvaluacion;

	public DesafioChoice(String consigna, List<String> opciones, List<Boolean> respuesta) {
		// TODO Auto-generated constructor stub
		this.consigna = consigna;
		this.respuestaCorrecta = new RespuestaChoice(respuesta);
		this.estrategiaEvaluacion = new EstrategiaPuntuacionClasico();
	}

	@Override
	public Integer evaluarRespuesta(RespuestaDesafio respuestaChoice) throws RespuestaNoReconocidaException {
		// TODO Auto-generated method stub
		return this.estrategiaEvaluacion.evaluar(this.respuestaCorrecta, respuestaChoice);
	}

	@Override
	public void setEstrategia(EstrategiaPuntuacion estrategia) {
		this.estrategiaEvaluacion = estrategia;
		
	}

	@Override
	public String getConsigna() {
		// TODO Auto-generated method stub
		return this.consigna;
	}

}
