package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class DesafioTest {

	@Test
	void testDesafioVOFClasicoRecibeRespuestaVOFCorrectayDevuelve1Punto() {
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		RespuestaDesafio respuestaVOF = new RespuestaVOF(true);
		/* Devuelve 1 punto ya que la respuesta es correcta */
		assertEquals(1, desafioVOF.evaluarRespuesta(respuestaVOF));
	}
	@Test
	void testDesafioVOFClasicoRecibeRespuestaVOFIncorrectayDevuelve0Puntos() {
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		RespuestaDesafio respuestaVOF = new RespuestaVOF(false);
		/* Devuelve 0 punto ya que la respuesta es incorrecta */
		assertEquals(0, desafioVOF.evaluarRespuesta(respuestaVOF));
	}
	@Test
	void testDesafioVOFPenalidadRecibeRespuestaVOFCorrectayDevuelve1Punto() {
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		RespuestaDesafio respuestaVOF = new RespuestaVOF(true);
		/* Devuelve 1 punto ya que la respuesta es correcta */
		assertEquals(1, desafioVOF.evaluarRespuesta(respuestaVOF));
	}
	@Test
	void testDesafioVOFPenalidadRecibeRespuestaVOFInorrectayResta1Punto() {
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		RespuestaDesafio respuestaVOF = new RespuestaVOF(false);
		/* Devuelve 1 punto ya que la respuesta es correcta */
		assertEquals(-1, desafioVOF.evaluarRespuesta(respuestaVOF));
	}
	@Test
	void testDesafioChoiceClasicoRecibeRespuestasChoiceCorrectasyDevuelve1Punto() {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, true, false);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 4 puntos ya que hay 4 respuestas correctas y 0 incorrectas */
		assertEquals(1, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	void testDesafioChoiceClasicoRecibeRespuestasChoiceIncorrectasyDevuelve0Puntos() {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, true, true);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 0 puntos ya que hay 3 respuestas correctas y 1 incorrecta */
		assertEquals(0, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	void testDesafioChoicePenalidadRecibeRespuestasChoiceIncorrectasyResta4Puntos() {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(false, false, false, true);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve -4 puntos ya que hay 4 respuestas incorrectas y 0 correctas */
		assertEquals(-4, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	void testDesafioChoicePenalidadRecibeRespuestasChoiceCorrectasySuma4Puntos() {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, true, false);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 4 puntos ya que hay 4 respuestas correctas y 0 incorrectas */
		assertEquals(4, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	void testDesafioChoiceParcialRecibeRespuestasChoiceCorrectasySuma2Puntos() {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, false, false);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 2 puntos ya que hay 2 respuestas correctas y 0 incorrectas */
		assertEquals(2, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
	@Test
	void testDesafioChoiceParcialRecibeRespuestasChoiceIncorrectasySuma0Puntos() {
		List<String> opciones = Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion");
		List<Boolean> respuestaCorrecta = Arrays.asList(true, true, true, false);
		List<Boolean> respuestaEvaluada = Arrays.asList(true, true, false, false);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", opciones, respuestaCorrecta);
		RespuestaDesafio respuestaChoice = new RespuestaChoice(respuestaEvaluada);
		/* Devuelve 0 puntos ya que hay 2 respuestas correctas y 1 incorrecta */
		assertEquals(0, desafioChoice.evaluarRespuesta(respuestaChoice));
	}
}
