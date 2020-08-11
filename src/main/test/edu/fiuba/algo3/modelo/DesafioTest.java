package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class DesafioTest {

	@Test
	public void testDesafioVOFClasicoRecibeRespuestaVOFCorrectayDevuelve1Punto() throws RespuestaNoReconocidaException {
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioVOF.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaVOF = new RespuestaVOF(true);
		/* Devuelve 1 punto ya que la respuesta es correcta */
		assertEquals(1, desafioVOF.evaluarRespuesta(respuestaVOF));
	}
	@Test
	public void testDesafioVOFClasicoRecibeRespuestaVOFIncorrectayDevuelve0Puntos() throws RespuestaNoReconocidaException {
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioVOF.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaVOF = new RespuestaVOF(false);
		/* Devuelve 0 punto ya que la respuesta es incorrecta */
		assertEquals(0, desafioVOF.evaluarRespuesta(respuestaVOF));
	}
	@Test
	public void testDesafioVOFPenalidadRecibeRespuestaVOFCorrectayDevuelve1Punto() throws RespuestaNoReconocidaException {
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		desafioVOF.setEstrategia(estrategiaPenalidad);
		RespuestaDesafio respuestaVOF = new RespuestaVOF(true);
		/* Devuelve 1 punto ya que la respuesta es correcta */
		assertEquals(1, desafioVOF.evaluarRespuesta(respuestaVOF));
	}
	@Test
	public void testDesafioVOFPenalidadRecibeRespuestaVOFInorrectayResta1Punto() throws RespuestaNoReconocidaException {
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		desafioVOF.setEstrategia(estrategiaPenalidad);
		RespuestaDesafio respuestaVOF = new RespuestaVOF(false);
		/* Devuelve 1 punto ya que la respuesta es correcta */
		assertEquals(-1, desafioVOF.evaluarRespuesta(respuestaVOF));
	}
	@Test
	public void testDesafioChoiceClasicoRecibeRespuestasChoiceCorrectasyDevuelve1Punto() throws RespuestaNoReconocidaException {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, true, false);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioChoice.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 4 puntos ya que hay 4 respuestas correctas y 0 incorrectas */
		assertEquals(1, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	public void testDesafioChoiceClasicoRecibeRespuestasChoiceIncorrectasyDevuelve0Puntos() throws RespuestaNoReconocidaException {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, true, true);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioChoice.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 0 puntos ya que hay 3 respuestas correctas y 1 incorrecta */
		assertEquals(0, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	public void testDesafioChoicePenalidadRecibeRespuestasChoiceIncorrectasyResta4Puntos() throws RespuestaNoReconocidaException {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(false, false, false, true);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		desafioChoice.setEstrategia(estrategiaPenalidad);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve -4 puntos ya que hay 4 respuestas incorrectas y 0 correctas */
		assertEquals(-4, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	public void testDesafioChoicePenalidadRecibeRespuestasChoiceCorrectasySuma4Puntos() throws RespuestaNoReconocidaException {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, true, false);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		desafioChoice.setEstrategia(estrategiaPenalidad);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 4 puntos ya que hay 4 respuestas correctas y 0 incorrectas */
		assertEquals(4, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	public void testDesafioChoiceParcialRecibeRespuestasChoiceCorrectasySuma2Puntos() throws RespuestaNoReconocidaException {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, null, null);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		EstrategiaPuntuacion estrategiaParcial = new EstrategiaPuntuacionParcial();
		desafioChoice.setEstrategia(estrategiaParcial);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 2 puntos ya que hay 2 respuestas correctas y 0 incorrectas */
		assertEquals(2, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	public void testDesafioChoiceParcialRecibeRespuestasChoiceIncorrectasySuma0Puntos() throws RespuestaNoReconocidaException {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, null, true);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		EstrategiaPuntuacion estrategiaParcial = new EstrategiaPuntuacionParcial();
		desafioChoice.setEstrategia(estrategiaParcial);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 0 puntos ya que hay 2 respuestas correctas y 1 incorrecta */
		assertEquals(0, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
}
