/**
 * 
 */
package edu.fiuba.algo3.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.controller.KahootControlador;
import edu.fiuba.algo3.modelo.Desafio;
import edu.fiuba.algo3.modelo.DesafioChoice;
import edu.fiuba.algo3.modelo.DesafioVOF;
import edu.fiuba.algo3.modelo.KahootModelo;
import edu.fiuba.algo3.view.Excepciones.VistaDeDesafioNoImplementadaException;
import javafx.scene.Node;

/**
 * @author marco
 *
 */
public class KahootVistaEscenaDesafioFactoryTest {

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
	public void KahootVistaEscenaDesafioFactoryCrearTodasLasEscenastest() throws VistaDeDesafioNoImplementadaException {
		KahootVistaEscenaDesafioFactory escenaFactory = new KahootVistaEscenaDesafioFactory(new KahootControlador(new KahootModelo()));
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		Desafio desafioChoice = new DesafioChoice("Provincias de argentina", Arrays.asList("Mendoza", "BsAs", "Misiones", "Asuncion"), Arrays.asList(true, true, true, false));
		var escenaVOF = escenaFactory.createEscena(desafioVOF);
		var escenaMultipleChoice = escenaFactory.createEscena(desafioChoice);
		
		assertTrue(escenaVOF instanceof KahootVistaDesafioVOF);
		assertTrue(escenaMultipleChoice instanceof KahootVistaDesafioMultipleChoice);
	}

}
