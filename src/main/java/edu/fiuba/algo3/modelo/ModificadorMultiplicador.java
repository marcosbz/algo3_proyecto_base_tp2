/**
 * 
 */
package edu.fiuba.algo3.modelo;

import java.util.List;

/**
 * @author marco
 *
 */
public class ModificadorMultiplicador implements Modificador {

	private Integer multiplicador;

	public ModificadorMultiplicador(Integer multiplicador) {
		// TODO Auto-generated constructor stub
		this.multiplicador = multiplicador;
	}

	@Override
	public void aplicar(Jugador jugador, List<Jugador> listaJugadores, List<Integer> listaPuntajesfinales) {
		// TODO Auto-generated method stub
		/* Precondicion: tamanio(listaJugadores) == tamanio(listaPuntajesfinales) */
		/* Precondicion: elementos unicos en la lista de jugadores */
		/* Encontrar en que posicion esta jugador en listaJugadores */
		/* Aplicar la multiplicacion en el elemento de esa posición en listaPuntajesfinales */
		for(int i = 0; i < listaJugadores.size(); i++) {
			/* TODO: Comparar referencias a jugador o comparar nombres? */
			if(listaJugadores.get(i) == jugador) {
				Integer puntajeJugadorInvocador = listaPuntajesfinales.get(i);
				listaPuntajesfinales.set(i, puntajeJugadorInvocador * multiplicador);
			}
		}
	}

}
