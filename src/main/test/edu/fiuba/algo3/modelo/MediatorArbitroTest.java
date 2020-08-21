/**
 * 
 */
package edu.fiuba.algo3.modelo;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public class MediatorArbitroTest {

	@Test
	public void test5JugadoresDesafioVOFTodosRespuestaCorrectaSinModificadores() throws RespuestaNoReconocidaException {
		/* Creo jugadores. Tienen modificadores por defecto */
		Jugador mockJugador0 = mock(Jugador.class);
		Jugador mockJugador1 = mock(Jugador.class);
		Jugador mockJugador2 = mock(Jugador.class);
		Jugador mockJugador3 = mock(Jugador.class);
		Jugador mockJugador4 = mock(Jugador.class);
		
		/* Creo desafio VOF y su respuesta correcta */
		Desafio desafioTestVoF = new DesafioVOF("El cielo es azul", true);
		RespuestaDesafio respuestaDesafioTestVoF = new RespuestaVOF(true);
		
		/* Todos los jugadores deben entregar una lista de Modificadores para utilizar en el turno */
		/* En este iba a representar una lista vacía como null pero causa problemas */
		/* En cambio voy a pasar una lista vacia, 0 elementos */
		List<Modificador> modificadoresJugador = new ArrayList<Modificador>();
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador1, respuestaDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador2, respuestaDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador3, respuestaDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador4, respuestaDesafioTestVoF, modificadoresJugador);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(1);
		verify(mockJugador1).recibirPuntaje(1);
		verify(mockJugador2).recibirPuntaje(1);
		verify(mockJugador3).recibirPuntaje(1);
		verify(mockJugador4).recibirPuntaje(1);
	}
	@Test
	public void test5JugadoresDesafioVOFRespuestasMixtasSinModificadores() throws RespuestaNoReconocidaException {
		/* Creo jugadores. Tienen modificadores por defecto */
		Jugador mockJugador0 = mock(Jugador.class);
		Jugador mockJugador1 = mock(Jugador.class);
		Jugador mockJugador2 = mock(Jugador.class);
		Jugador mockJugador3 = mock(Jugador.class);
		Jugador mockJugador4 = mock(Jugador.class);
		
		/* Creo desafio VOF y su respuesta correcta */
		Desafio desafioTestVoF = new DesafioVOF("El cielo es azul", true);
		RespuestaDesafio respuestaTrueDesafioTestVoF = new RespuestaVOF(true);
		RespuestaDesafio respuestaFalseDesafioTestVoF = new RespuestaVOF(false);
		
		/* Todos los jugadores deben entregar una lista de Modificadores para utilizar en el turno */
		/* En este iba a representar una lista vacía como null pero causa problemas */
		/* En cambio voy a pasar una lista vacia, 0 elementos */
		List<Modificador> modificadoresJugador = new ArrayList<Modificador>();
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaTrueDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador1, respuestaTrueDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador4, respuestaFalseDesafioTestVoF, modificadoresJugador);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(1);
		verify(mockJugador1).recibirPuntaje(1);
		verify(mockJugador2).recibirPuntaje(0);
		verify(mockJugador3).recibirPuntaje(0);
		verify(mockJugador4).recibirPuntaje(0);
	}
	@Test
	public void test5JugadoresDesafioVOFPenalidadRespuestasMixtasSinModificadores() throws RespuestaNoReconocidaException {
		/* Creo jugadores. Tienen modificadores por defecto */
		Jugador mockJugador0 = mock(Jugador.class);
		Jugador mockJugador1 = mock(Jugador.class);
		Jugador mockJugador2 = mock(Jugador.class);
		Jugador mockJugador3 = mock(Jugador.class);
		Jugador mockJugador4 = mock(Jugador.class);
		
		/* Creo desafio VOF y su respuesta correcta */
		Desafio desafioTestVoF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaPenalidad = new EstrategiaPuntuacionPenalidad();
		desafioTestVoF.setEstrategia(estrategiaPenalidad);
		RespuestaDesafio respuestaTrueDesafioTestVoF = new RespuestaVOF(true);
		RespuestaDesafio respuestaFalseDesafioTestVoF = new RespuestaVOF(false);
		
		/* Todos los jugadores deben entregar una lista de Modificadores para utilizar en el turno */
		/* En este iba a representar una lista vacía como null pero causa problemas */
		/* En cambio voy a pasar una lista vacia, 0 elementos */
		List<Modificador> modificadoresJugador = new ArrayList<Modificador>();
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaTrueDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador1, respuestaTrueDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugador);
		arbitro.aceptarJugada(mockJugador4, respuestaFalseDesafioTestVoF, modificadoresJugador);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(1);
		verify(mockJugador1).recibirPuntaje(1);
		verify(mockJugador2).recibirPuntaje(-1);
		verify(mockJugador3).recibirPuntaje(-1);
		verify(mockJugador4).recibirPuntaje(-1);
	}

}
