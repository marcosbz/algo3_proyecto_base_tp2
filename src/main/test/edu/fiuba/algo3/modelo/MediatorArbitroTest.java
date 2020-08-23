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
	@Test
	public void test5JugadoresDesafioVOFPenalidadRespuestasMixtasConModificadorMultiplicadorX2() throws RespuestaNoReconocidaException {
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
		List<Modificador> modificadoresJugadorVacio = new ArrayList<Modificador>();
		List<Modificador> modificadoresJugadorX2 = new ArrayList<Modificador>();
		Modificador modificadorX2 = new ModificadorMultiplicador(2);
		modificadoresJugadorX2.add(modificadorX2);
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaTrueDesafioTestVoF, modificadoresJugadorX2);
		arbitro.aceptarJugada(mockJugador1, respuestaTrueDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador4, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(2);
		verify(mockJugador1).recibirPuntaje(1);
		verify(mockJugador2).recibirPuntaje(-1);
		verify(mockJugador3).recibirPuntaje(-1);
		verify(mockJugador4).recibirPuntaje(-1);
	}
	@Test
	public void test5JugadoresDesafioVOFPenalidadRespuestasMixtasConModificadoresMultiplicadoresVariosEnUnicoJugador() throws RespuestaNoReconocidaException {
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
		List<Modificador> modificadoresJugadorVacio = new ArrayList<Modificador>();
		List<Modificador> modificadoresJugadorX2X3 = new ArrayList<Modificador>();
		Modificador modificadorX2 = new ModificadorMultiplicador(2);
		Modificador modificadorX3 = new ModificadorMultiplicador(3);
		modificadoresJugadorX2X3.add(modificadorX2);
		modificadoresJugadorX2X3.add(modificadorX3);
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaTrueDesafioTestVoF, modificadoresJugadorX2X3);
		arbitro.aceptarJugada(mockJugador1, respuestaTrueDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador4, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(6);
		verify(mockJugador1).recibirPuntaje(1);
		verify(mockJugador2).recibirPuntaje(-1);
		verify(mockJugador3).recibirPuntaje(-1);
		verify(mockJugador4).recibirPuntaje(-1);
	}
	@Test
	public void test5JugadoresDesafioVOFPenalidadRespuestasMixtasConModificadoresMultiplicadoresVariosEnVariosJugadores() throws RespuestaNoReconocidaException {
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
		List<Modificador> modificadoresJugadorVacio = new ArrayList<Modificador>();
		List<Modificador> modificadoresJugadorX2X3 = new ArrayList<Modificador>();
		Modificador modificadorX2 = new ModificadorMultiplicador(2);
		Modificador modificadorX3 = new ModificadorMultiplicador(3);
		modificadoresJugadorX2X3.add(modificadorX2);
		modificadoresJugadorX2X3.add(modificadorX3);
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaTrueDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador1, respuestaTrueDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugadorX2X3);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador4, respuestaFalseDesafioTestVoF, modificadoresJugadorX2X3);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(1);
		verify(mockJugador1).recibirPuntaje(1);
		verify(mockJugador2).recibirPuntaje(-6);
		verify(mockJugador3).recibirPuntaje(-1);
		verify(mockJugador4).recibirPuntaje(-6);
	}
	@Test
	public void test5JugadoresDesafioVOFClasicoRespuestasMixtasConModificadorExclusividadUnicoJugadorUnicaRespuestaCorrecta() throws RespuestaNoReconocidaException {
		/* Creo jugadores. Tienen modificadores por defecto */
		Jugador mockJugador0 = mock(Jugador.class);
		Jugador mockJugador1 = mock(Jugador.class);
		Jugador mockJugador2 = mock(Jugador.class);
		Jugador mockJugador3 = mock(Jugador.class);
		Jugador mockJugador4 = mock(Jugador.class);
		
		/* Creo desafio VOF y su respuesta correcta */
		Desafio desafioTestVoF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioTestVoF.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaTrueDesafioTestVoF = new RespuestaVOF(true);
		RespuestaDesafio respuestaFalseDesafioTestVoF = new RespuestaVOF(false);
		
		/* Todos los jugadores deben entregar una lista de Modificadores para utilizar en el turno */
		/* En este iba a representar una lista vacía como null pero causa problemas */
		/* En cambio voy a pasar una lista vacia, 0 elementos */
		List<Modificador> modificadoresJugadorVacio = new ArrayList<Modificador>();
		List<Modificador> modificadoresJugadorExclusividad = new ArrayList<Modificador>();
		Modificador modificadorExclusividad = new ModificadorExclusividad();
		modificadoresJugadorExclusividad.add(modificadorExclusividad);
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaTrueDesafioTestVoF, modificadoresJugadorExclusividad);
		arbitro.aceptarJugada(mockJugador1, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador4, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(2);
		verify(mockJugador1).recibirPuntaje(0);
		verify(mockJugador2).recibirPuntaje(0);
		verify(mockJugador3).recibirPuntaje(0);
		verify(mockJugador4).recibirPuntaje(0);
	}
	@Test
	public void test5JugadoresDesafioVOFClasicoRespuestasMixtasConModificadorExclusividadUnicoJugadorUnicaRespuestaCorrectaDeOtroJugador() throws RespuestaNoReconocidaException {
		/* Creo jugadores. Tienen modificadores por defecto */
		Jugador mockJugador0 = mock(Jugador.class);
		Jugador mockJugador1 = mock(Jugador.class);
		Jugador mockJugador2 = mock(Jugador.class);
		Jugador mockJugador3 = mock(Jugador.class);
		Jugador mockJugador4 = mock(Jugador.class);
		
		/* Creo desafio VOF y su respuesta correcta */
		Desafio desafioTestVoF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioTestVoF.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaTrueDesafioTestVoF = new RespuestaVOF(true);
		RespuestaDesafio respuestaFalseDesafioTestVoF = new RespuestaVOF(false);
		
		/* Todos los jugadores deben entregar una lista de Modificadores para utilizar en el turno */
		/* En este iba a representar una lista vacía como null pero causa problemas */
		/* En cambio voy a pasar una lista vacia, 0 elementos */
		List<Modificador> modificadoresJugadorVacio = new ArrayList<Modificador>();
		List<Modificador> modificadoresJugadorExclusividad = new ArrayList<Modificador>();
		Modificador modificadorExclusividad = new ModificadorExclusividad();
		modificadoresJugadorExclusividad.add(modificadorExclusividad);
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaFalseDesafioTestVoF, modificadoresJugadorExclusividad);
		arbitro.aceptarJugada(mockJugador1, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador4, respuestaTrueDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(0);
		verify(mockJugador1).recibirPuntaje(0);
		verify(mockJugador2).recibirPuntaje(0);
		verify(mockJugador3).recibirPuntaje(0);
		verify(mockJugador4).recibirPuntaje(2);
	}
	@Test
	public void test5JugadoresDesafioVOFClasicoRespuestasMixtasConModificadorExclusividadUnicoJugador2RespuestasCorrectasDeOtroJugador() throws RespuestaNoReconocidaException {
		/* Creo jugadores. Tienen modificadores por defecto */
		Jugador mockJugador0 = mock(Jugador.class);
		Jugador mockJugador1 = mock(Jugador.class);
		Jugador mockJugador2 = mock(Jugador.class);
		Jugador mockJugador3 = mock(Jugador.class);
		Jugador mockJugador4 = mock(Jugador.class);
		
		/* Creo desafio VOF y su respuesta correcta */
		Desafio desafioTestVoF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioTestVoF.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaTrueDesafioTestVoF = new RespuestaVOF(true);
		RespuestaDesafio respuestaFalseDesafioTestVoF = new RespuestaVOF(false);
		
		/* Todos los jugadores deben entregar una lista de Modificadores para utilizar en el turno */
		/* En este iba a representar una lista vacía como null pero causa problemas */
		/* En cambio voy a pasar una lista vacia, 0 elementos */
		List<Modificador> modificadoresJugadorVacio = new ArrayList<Modificador>();
		List<Modificador> modificadoresJugadorExclusividad = new ArrayList<Modificador>();
		Modificador modificadorExclusividad = new ModificadorExclusividad();
		modificadoresJugadorExclusividad.add(modificadorExclusividad);
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaTrueDesafioTestVoF, modificadoresJugadorExclusividad);
		arbitro.aceptarJugada(mockJugador1, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador4, respuestaTrueDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(1);
		verify(mockJugador1).recibirPuntaje(0);
		verify(mockJugador2).recibirPuntaje(0);
		verify(mockJugador3).recibirPuntaje(0);
		verify(mockJugador4).recibirPuntaje(1);
	}
	@Test
	public void test5JugadoresDesafioVOFClasicoRespuestasMixtasConModificadoresExclusividadVariosJugadores2RespuestasCorrectasDeOtroJugador() throws RespuestaNoReconocidaException {
		/* Creo jugadores. Tienen modificadores por defecto */
		Jugador mockJugador0 = mock(Jugador.class);
		Jugador mockJugador1 = mock(Jugador.class);
		Jugador mockJugador2 = mock(Jugador.class);
		Jugador mockJugador3 = mock(Jugador.class);
		Jugador mockJugador4 = mock(Jugador.class);
		
		/* Creo desafio VOF y su respuesta correcta */
		Desafio desafioTestVoF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioTestVoF.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaTrueDesafioTestVoF = new RespuestaVOF(true);
		RespuestaDesafio respuestaFalseDesafioTestVoF = new RespuestaVOF(false);
		
		/* Todos los jugadores deben entregar una lista de Modificadores para utilizar en el turno */
		/* En este iba a representar una lista vacía como null pero causa problemas */
		/* En cambio voy a pasar una lista vacia, 0 elementos */
		List<Modificador> modificadoresJugadorVacio = new ArrayList<Modificador>();
		List<Modificador> modificadoresJugadorExclusividad = new ArrayList<Modificador>();
		Modificador modificadorExclusividad = new ModificadorExclusividad();
		modificadoresJugadorExclusividad.add(modificadorExclusividad);
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaTrueDesafioTestVoF, modificadoresJugadorExclusividad);
		arbitro.aceptarJugada(mockJugador1, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador4, respuestaTrueDesafioTestVoF, modificadoresJugadorExclusividad);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(1);
		verify(mockJugador1).recibirPuntaje(0);
		verify(mockJugador2).recibirPuntaje(0);
		verify(mockJugador3).recibirPuntaje(0);
		verify(mockJugador4).recibirPuntaje(1);
	}
	@Test
	public void test5JugadoresDesafioVOFClasicoRespuestasMixtasConModificadoresExclusividadVariosJugadores1RespuestaCorrectaDeMismoJugador() throws RespuestaNoReconocidaException {
		/* Creo jugadores. Tienen modificadores por defecto */
		Jugador mockJugador0 = mock(Jugador.class);
		Jugador mockJugador1 = mock(Jugador.class);
		Jugador mockJugador2 = mock(Jugador.class);
		Jugador mockJugador3 = mock(Jugador.class);
		Jugador mockJugador4 = mock(Jugador.class);
		
		/* Creo desafio VOF y su respuesta correcta */
		Desafio desafioTestVoF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioTestVoF.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaTrueDesafioTestVoF = new RespuestaVOF(true);
		RespuestaDesafio respuestaFalseDesafioTestVoF = new RespuestaVOF(false);
		
		/* Todos los jugadores deben entregar una lista de Modificadores para utilizar en el turno */
		/* En este iba a representar una lista vacía como null pero causa problemas */
		/* En cambio voy a pasar una lista vacia, 0 elementos */
		List<Modificador> modificadoresJugadorVacio = new ArrayList<Modificador>();
		List<Modificador> modificadoresJugadorExclusividad = new ArrayList<Modificador>();
		Modificador modificadorExclusividad = new ModificadorExclusividad();
		modificadoresJugadorExclusividad.add(modificadorExclusividad);
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaFalseDesafioTestVoF, modificadoresJugadorExclusividad);
		arbitro.aceptarJugada(mockJugador1, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador4, respuestaTrueDesafioTestVoF, modificadoresJugadorExclusividad);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(0);
		verify(mockJugador1).recibirPuntaje(0);
		verify(mockJugador2).recibirPuntaje(0);
		verify(mockJugador3).recibirPuntaje(0);
		verify(mockJugador4).recibirPuntaje(4);
	}
	@Test
	public void test5JugadoresDesafioVOFClasicoRespuestasMixtasConModificadoresExclusividadVariosJugadores1RespuestaCorrectaDeOtroJugador() throws RespuestaNoReconocidaException {
		/* Creo jugadores. Tienen modificadores por defecto */
		Jugador mockJugador0 = mock(Jugador.class);
		Jugador mockJugador1 = mock(Jugador.class);
		Jugador mockJugador2 = mock(Jugador.class);
		Jugador mockJugador3 = mock(Jugador.class);
		Jugador mockJugador4 = mock(Jugador.class);
		
		/* Creo desafio VOF y su respuesta correcta */
		Desafio desafioTestVoF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioTestVoF.setEstrategia(estrategiaClasica);
		RespuestaDesafio respuestaTrueDesafioTestVoF = new RespuestaVOF(true);
		RespuestaDesafio respuestaFalseDesafioTestVoF = new RespuestaVOF(false);
		
		/* Todos los jugadores deben entregar una lista de Modificadores para utilizar en el turno */
		/* En este iba a representar una lista vacía como null pero causa problemas */
		/* En cambio voy a pasar una lista vacia, 0 elementos */
		List<Modificador> modificadoresJugadorVacio = new ArrayList<Modificador>();
		List<Modificador> modificadoresJugadorExclusividad = new ArrayList<Modificador>();
		Modificador modificadorExclusividad = new ModificadorExclusividad();
		modificadoresJugadorExclusividad.add(modificadorExclusividad);
		
		/* Creo arbitro, le indico el desafio y acepto una jugada de cada jugador */
		MediatorArbitro arbitro = new MediatorArbitroV1();
		arbitro.iniciarDesafio(desafioTestVoF);
		arbitro.aceptarJugada(mockJugador0, respuestaTrueDesafioTestVoF, modificadoresJugadorExclusividad);
		arbitro.aceptarJugada(mockJugador1, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador2, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador3, respuestaFalseDesafioTestVoF, modificadoresJugadorVacio);
		arbitro.aceptarJugada(mockJugador4, respuestaFalseDesafioTestVoF, modificadoresJugadorExclusividad);
		arbitro.finalizarDesafio();
		
		/* Verificar que todos los jugadores hayan recibido puntaje */
		/* Como verifico esto sin violar el encapsulamiento? Con Mock */
		verify(mockJugador0).recibirPuntaje(4);
		verify(mockJugador1).recibirPuntaje(0);
		verify(mockJugador2).recibirPuntaje(0);
		verify(mockJugador3).recibirPuntaje(0);
		verify(mockJugador4).recibirPuntaje(0);
	}
	
}
