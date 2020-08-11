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
	
	@Test
	public void testEstrategiaPuntuacionClasicoComparoRespuestasDiferentes1VaciaMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(null, true, false);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaClasico = new EstrategiaPuntuacionClasico();
		/* Devuelve 0 puntos por un item sin responder */
		assertEquals(0, estrategiaClasico.evaluar(respuestaCorrecta, respuestaEvaluada));
	}

	@Test
	public void testEstrategiaPuntuacionPenalidadComparoRespuestasIgualesMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(false, true, false);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		/* Devuelve 3 puntos por 3 respuestas correctas */
		assertEquals(3, estrategiaPenalidad.evaluar(respuestaCorrecta, respuestaEvaluada));
	}

	@Test
	public void testEstrategiaPuntuacionPenalidadComparoRespuestasDiferentes1MalMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(false, false, false);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		/* Devuelve 1 punto por 2 respuestas correctas y una incorrecta */
		assertEquals(1, estrategiaPenalidad.evaluar(respuestaCorrecta, respuestaEvaluada));
	}

	@Test
	public void testEstrategiaPuntuacionPenalidadComparoRespuestasDiferentes3MalMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(true, false, true);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		/* Devuelve -3 puntos por 3 respuestas incorrectas */
		assertEquals(-3, estrategiaPenalidad.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
	
	@Test
	public void testEstrategiaPuntuacionPenalidadComparoRespuestasDiferentes3SinResponderMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(null, null, null);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		/* Devuelve -3 puntos por 3 respuestas vacias */
		assertEquals(-3, estrategiaPenalidad.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
	
	@Test
	public void testEstrategiaPuntuacionPenalidadComparoRespuestasDiferentes1SinResponderMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(false, true, null);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		/* Devuelve 1 punto por 2 items correctos y 1 sin responder */
		assertEquals(1, estrategiaPenalidad.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
	
	@Test
	public void testEstrategiaPuntuacionParcialComparoRespuestasIgualesMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(false, true, false);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaParcial = new EstrategiaPuntuacionParcial();
		/* Devuelve 3 punto por 3 items correctos */
		assertEquals(3, estrategiaParcial.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
	
	@Test
	public void testEstrategiaPuntuacionParcialComparoRespuestasDiferentes3IncorrectasMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(true, false, true);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaParcial = new EstrategiaPuntuacionParcial();
		/* Devuelve 0 punto por 3 items incorrectos */
		assertEquals(0, estrategiaParcial.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
	
	@Test
	public void testEstrategiaPuntuacionParcialComparoRespuestasDiferentes1IncorrectaMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(false, true, true);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaParcial = new EstrategiaPuntuacionParcial();
		/* Devuelve 0 punto por 1 items incorrecto */
		assertEquals(0, estrategiaParcial.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
	
	@Test
	public void testEstrategiaPuntuacionParcialComparoRespuestasDiferentes2IncorrectasMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(true, true, true);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaParcial = new EstrategiaPuntuacionParcial();
		/* Devuelve 0 punto por 2 items incorrectos */
		assertEquals(0, estrategiaParcial.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
	
	@Test
	public void testEstrategiaPuntuacionParcialComparoRespuestasDiferentes1VaciaFinalMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(false, true, null);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaParcial = new EstrategiaPuntuacionParcial();
		/* Devuelve 2 puntos por 2 items correctos y 1 vacio */
		assertEquals(2, estrategiaParcial.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
	
	@Test
	public void testEstrategiaPuntuacionParcialComparoRespuestasDiferentes1VaciaPrincipioMismoTamaño3() throws RespuestaNoReconocidaException {
		List<Boolean> listaCorrecta = Arrays.asList(false, true, false);
		List<Boolean> listaEvaluada = Arrays.asList(null, true, false);
		RespuestaDesafio respuestaCorrecta = new RespuestaChoice(listaCorrecta);
		RespuestaDesafio respuestaEvaluada = new RespuestaChoice(listaEvaluada);
		EstrategiaPuntuacion estrategiaParcial = new EstrategiaPuntuacionParcial();
		/* Devuelve 2 puntos por 2 items correctos y 1 vacio */
		assertEquals(2, estrategiaParcial.evaluar(respuestaCorrecta, respuestaEvaluada));
	}
}
