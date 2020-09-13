/**
 * 
 */
package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.view.KahootVistaEtapaFactory;
import edu.fiuba.algo3.view.KahootVistaInicio;
import edu.fiuba.algo3.view.KahootVistaInsertarJugadores;
import edu.fiuba.algo3.view.KahootVistaJuegoPrincipal;
import edu.fiuba.algo3.view.KahootVistaMostrarResultados;

/**
 * @author marco
 *
 */
public class KahootVistaEtapaFactoryTest {

	@Test
	public void testKahootVistaEtapaFactory() throws Exception {
		KahootVistaEtapaFactory etapaFactory = new KahootVistaEtapaFactory(null);
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
