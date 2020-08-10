/**
 * 
 */
package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public class ElementoRespuestaTest {

	@Test
	public void testComparo2BooleanIgualesYDevuelveTrue() throws RespuestaNoReconocidaException {
		ElementoRespuesta bool1 = new ElementoBoolean(true);
		ElementoRespuesta bool2 = new ElementoBoolean(true);
		assertEquals(true, bool1.igualA(bool2));
	}
	@Test
	public void testComparo2BooleanDiferentesYDevuelveFalse() throws RespuestaNoReconocidaException {
		ElementoRespuesta bool1 = new ElementoBoolean(true);
		ElementoRespuesta bool2 = new ElementoBoolean(false);
		assertEquals(false, bool1.igualA(bool2));
	}
	@Test
	public void testComparo2EnterosIgualesYDevuelveTrue() throws RespuestaNoReconocidaException {
		ElementoRespuesta numero1 = new ElementoEntero(2);
		ElementoRespuesta numero2 = new ElementoEntero(2);
		assertEquals(true, numero1.igualA(numero2));
	}
	@Test
	public void testComparo2EnterosDiferentesYDevuelveFalse() throws RespuestaNoReconocidaException {
		ElementoRespuesta numero1 = new ElementoEntero(2);
		ElementoRespuesta numero2 = new ElementoEntero(0);
		assertEquals(false, numero1.igualA(numero2));
	}
	@Test
	public void testComparoEnteroYBoolYArrojaExcepcion() throws RespuestaNoReconocidaException {
		ElementoRespuesta bool1 = new ElementoBoolean(true);
		ElementoRespuesta numero2 = new ElementoEntero(2);
		assertThrows(RespuestaNoReconocidaException.class, () -> {bool1.igualA(numero2);});
	}
	@Test
	public void testComparoBoolYEnteroYArrojaExcepcion() throws RespuestaNoReconocidaException {
		ElementoRespuesta numero1 = new ElementoEntero(1);
		ElementoRespuesta bool2 = new ElementoBoolean(false);
		assertThrows(RespuestaNoReconocidaException.class, () -> {numero1.igualA(bool2);});
	}
	
}
