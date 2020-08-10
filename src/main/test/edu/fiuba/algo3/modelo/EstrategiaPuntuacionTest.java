/**
 * 
 */
package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public class EstrategiaPuntuacionTest {
	
	@Test
	public void testEstrategiaPuntuacionClasicoComparoRespuestasMismoTamaño1() throws RespuestaNoReconocidaException {
		RespuestaDesafio respuestaCorrecta = new RespuestaVOF(true);
		RespuestaDesafio respuestaEvaluada = new RespuestaVOF(true);
		EstrategiaPuntuacion estrategiaClasico = new EstrategiaPuntuacionClasico();
		/* Devuelve 1 punto por respuesta correcta */
		assertEquals(1, estrategiaClasico.evaluar(respuestaCorrecta, respuestaEvaluada));
	}

	@Test
	public void testEstrategiaPuntuacionClasicoComparoRespuestasDiferentesMismoTamaño1() throws RespuestaNoReconocidaException {
		RespuestaDesafio respuestaCorrecta = new RespuestaVOF(true);
		RespuestaDesafio respuestaEvaluada = new RespuestaVOF(false);
		EstrategiaPuntuacion estrategiaClasico = new EstrategiaPuntuacionClasico();
		/* Devuelve 0 puntos por respuesta incorrecta */
		assertEquals(0, estrategiaClasico.evaluar(respuestaCorrecta, respuestaEvaluada));
	}

	@Test
	public void testEstrategiaPuntuacionClasicoComparoRespuestasIgualesMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(false, true, false);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaClasico = new EstrategiaPuntuacionClasico();
		/* Devuelve 1 punto por respuesta correcta */
		assertEquals(1, estrategiaClasico.evaluar(respuestaCorrecta, respuestaEvaluada));
	}

	@Test
	public void testEstrategiaPuntuacionClasicoComparoRespuestasDiferentesMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(false, false, false);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaClasico = new EstrategiaPuntuacionClasico();
		/* Devuelve 0 puntos por respuesta incorrecta */
		assertEquals(0, estrategiaClasico.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
}
