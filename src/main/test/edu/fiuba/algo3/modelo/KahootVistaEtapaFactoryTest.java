/**
 * 
 */
package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import de.saxsys.javafx.test.JfxRunner;
import edu.fiuba.algo3.controller.KahootControlador;
import edu.fiuba.algo3.view.KahootVistaEtapaFactory;
import edu.fiuba.algo3.view.KahootVistaInicio;
import edu.fiuba.algo3.view.KahootVistaInsertarJugadores;
import edu.fiuba.algo3.view.KahootVistaJuegoPrincipal;
import edu.fiuba.algo3.view.KahootVistaMostrarResultados;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author marco
 *
 */
@RunWith(JfxRunner.class)
public class KahootVistaEtapaFactoryTest {

	public static class AsNonApp extends Application {
		@Override
		public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			
		}
	}
	@BeforeAll
	public static void initJFX() {
	       Thread t = new Thread("JavaFX Init Thread") {
	           public void run() {
	               Application.launch(AsNonApp.class, new String[0]);
	           }
	       };
	       t.setDaemon(true);
	       t.start();
	}
	@Test
	public void testKahootVistaEtapaFactory() throws Exception {
		
		KahootVistaEtapaFactory etapaFactory = new KahootVistaEtapaFactory(new KahootControlador(new KahootModelo()));
		var vistaInicio = etapaFactory.createEtapa("etapaModeloInicio");
		var vistaInsertarJugadores = etapaFactory.createEtapa("etapaModeloInsertarJugadores");
		var vistaJuegoPrincipal = etapaFactory.createEtapa("etapaModeloJuegoPrincipal");
		var vistaMostrarResultados = etapaFactory.createEtapa("etapaModeloMostrarResultados");
		
		assertTrue(vistaInicio instanceof KahootVistaInicio);
		assertTrue(vistaInsertarJugadores instanceof KahootVistaInsertarJugadores);
		assertTrue(vistaJuegoPrincipal instanceof KahootVistaJuegoPrincipal);
		assertTrue(vistaMostrarResultados instanceof KahootVistaMostrarResultados);
	}

}
