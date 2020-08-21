/**
 * 
 */
package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public class MediatorArbitroV1 implements MediatorArbitro {

	public MediatorArbitroV1() {
		this.listaJugadores = new ArrayList<Jugador>();
		this.listaRespuestas = new ArrayList<RespuestaDesafio>();
		this.listaModificadoresJugadores = new ArrayList<List<Modificador>>();
		this.listaPuntajesParciales = new ArrayList<Integer>();
	}

	private Desafio desafio;
	private List<Jugador> listaJugadores;
	private List<RespuestaDesafio> listaRespuestas;
	private List<List<Modificador>> listaModificadoresJugadores;
	private List<Integer> listaPuntajesParciales;

	@Override
	public void iniciarDesafio(Desafio desafio) {
		this.desafio = desafio;
	}

	@Override
	public void aceptarJugada(Jugador jugador, RespuestaDesafio respuesta, List<Modificador> modificadoresDelJugador) {
		this.listaJugadores.add(jugador);
		this.listaRespuestas.add(respuesta);
		/* TODO Si modificadoresDelJugador esta vacía, es vacía o null? */
		this.listaModificadoresJugadores.add(modificadoresDelJugador);
	}

	@Override
	public void finalizarDesafio() throws RespuestaNoReconocidaException {
		// TODO Auto-generated method stub
		for(int i = 0; i < listaJugadores.size(); i++) {
			listaPuntajesParciales.add(desafio.evaluarRespuesta(listaRespuestas.get(i)));
		}
		/* Teniendo la referencia a los jugadores, sus modificadores y los puntajes parciales puedo calcular los puntajes finales */
		List<Integer> listaPuntajesFinales = new ArrayList<Integer>(listaPuntajesParciales);
		for(int i = 0; i < listaJugadores.size(); i++) {
			for(int j = 0; j < listaModificadoresJugadores.get(i).size(); j++) {
				/* A cada modificador del jugador lo ejecuto pasandole los parametros que corresponden */
				listaModificadoresJugadores.get(i).get(j).aplicar(listaJugadores.get(i), listaJugadores, listaPuntajesFinales);
			}
		}
		/* Aplico los puntajes finales a cada jugador */
		for(int i = 0; i < listaJugadores.size(); i++) {
			listaJugadores.get(i).recibirPuntaje(listaPuntajesFinales.get(i));
		}
	}

}
