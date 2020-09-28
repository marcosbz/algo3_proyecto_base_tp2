/**
 * 
 */
package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author marco
 *
 */
public class KahootModeloTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void kahootModelo2Jugadores1RespuestaVOFtest() {
		var kahootModelo = new KahootModelo();
		kahootModelo.iniciar();
		kahootModelo.agregarJugador("Jugador1");
		kahootModelo.agregarJugador("Jugador2");
		kahootModelo.comenzarJuego();
		kahootModelo.insertarRespuesta(new RespuestaVOF(true));
		/* Metodo aceptarJugada() podría indicar qué jugador hace la jugada. Estoy aceptando que el modelo acepta las jugadas en orden */
		kahootModelo.aceptarJugada();
		kahootModelo.insertarRespuesta(new RespuestaVOF(false));
		kahootModelo.aceptarJugada();
		List<Jugador> listaJugadores = kahootModelo.getJugadores();
		assertTrue(listaJugadores.size() == 2);
		assertTrue(listaJugadores.get(0).getPuntaje() == 1);
		assertTrue(listaJugadores.get(0).getPuntaje() == 1);
	}

}
