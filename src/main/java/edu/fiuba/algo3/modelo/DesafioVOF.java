/**
 * 
 */
package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public class DesafioVOF implements Desafio {

	private String consigna;
	private RespuestaVOF respuestaCorrecta;
	private EstrategiaPuntuacion estrategiaEvaluacion;

	public DesafioVOF(String consigna, Boolean b) {
		// TODO Auto-generated constructor stub
		this.consigna = consigna;
		this.respuestaCorrecta = new RespuestaVOF(b);
		this.estrategiaEvaluacion = new EstrategiaPuntuacionClasico();
	}

	@Override
	public Integer evaluarRespuesta(RespuestaDesafio respuestaVOF) throws RespuestaNoReconocidaException {
		// TODO Auto-generated method stub
		return this.estrategiaEvaluacion.evaluar(this.respuestaCorrecta, respuestaVOF);
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
