/**
 * 
 */
package edu.fiuba.algo3.modelo;

import java.util.List;

/**
 * @author marco
 *
 */
public class ModificadorExclusividad implements Modificador {

	@Override
	public void aplicar(Jugador jugador, List<Jugador> listaJugadores, List<Integer> listaPuntajesfinales) {
		// TODO Auto-generated method stub
		/* Precondicion: tamanio(listaJugadores) == tamanio(listaPuntajesfinales) */
		/* Precondicion: elementos unicos en la lista de jugadores */
		/* Encontrar en que posicion esta jugador en listaJugadores */
		/* Verificar que solo UNO de todos los jugadores tuvo respuesta correcta y el resto todos respuesta incorrecta */
		/* Si se verifica la condicion anterior duplicar puntaje del jugador con respuesta correcta */
		/* Si otro jugador tambien tiene respuesta correcta, se anula el modificador */
		long cantidadJugadoresAcertados = listaPuntajesfinales.stream().filter(puntaje -> (puntaje > 0)).count();
		if(cantidadJugadoresAcertados == 1) {
			for(int i = 0; i < listaPuntajesfinales.size(); i++) {
				/* Encontrar indice de jugador que acerto */
				/* Por condicion anterior es unico */
				/* Buscar el indice iterando en listaPuntajesfinales */
				if(listaPuntajesfinales.get(i) > 0) {
					Integer puntajeJugadorAcertado = listaPuntajesfinales.get(i);
					listaPuntajesfinales.set(i, puntajeJugadorAcertado * 2);
				}
			}
		}
		else {
			/* Ninguno acerto la respuesta o mas de uno acerto la respuesta */
			/* Se cancela el efecto del Modificador de Exclusividad */
			/* TODO: No hacer nada o cancela la puntuacion de los que respondieron mal? */
		}
	}

}
