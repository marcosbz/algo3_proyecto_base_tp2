/**
 * 
 */
package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.InsertaJugadorRepetidoException;
import edu.fiuba.algo3.modelo.excepciones.InsertaNombreInvalidoException;

/**
 * @author marco
 *
 */
public class KahootModelo {

	List<Jugador> listaJugadores;
	List<Desafio> listaDesafios;
	MediatorArbitro arbitroEvaluador;
	PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public KahootModelo() {
		/* Inicializar estructuras */
		/* Cargar lista de Desafio a memoria */
		this.listaDesafios = new ArrayList<Desafio>();
		this.listaJugadores = new ArrayList<Jugador>();
		this.arbitroEvaluador = new MediatorArbitroV1();
		/* Cargo un solo Desafio para prueba */
		Desafio desafioVOF = new DesafioVOF("El cielo es azul", true);
		EstrategiaPuntuacion estrategiaClasica = new EstrategiaPuntuacionClasico();
		desafioVOF.setEstrategia(estrategiaClasica);
		listaDesafios.add(desafioVOF);

	}
	/* addPropertyChangeListener(String, PropertyChangeListener): Add a property-change listener for a specific property. The listener is called only when there is a change to the specified property. */
	/* addPropertyChangeListener(PropertyChangeListener): Add a property-change listener to the listener list. */
	public void addObserver(PropertyChangeListener vista) {
		// TODO Auto-generated method stub
		/* Every listener will care only about a specific property change */
		/* KahootVista will care about general model state change, but subscenes of that view will listen to more specific events, such as a new Desafio in the quiz stage */
		pcs.addPropertyChangeListener(vista);
	}

	public void iniciar() {
		// TODO Auto-generated method stub
		/* Notificar a la vista para aceptar la carga de lista de Jugador */
		pcs.firePropertyChange("KahootModeloEtapa", null, "etapaModeloInsertarJugadores");
	}
	public void agregarJugador(String nombreJugador) {
		// TODO Auto-generated method stub
		try {
			if(nombreJugador.isEmpty()) {
				throw new InsertaNombreInvalidoException("Debe tener al menos 1 caracter");
			}
			if(this.listaJugadores.stream().anyMatch((jugador) -> jugador.getNombre().equals(nombreJugador))) {
				throw new InsertaJugadorRepetidoException(nombreJugador);
			}
			Jugador nuevoJugador = new JugadorV1(nombreJugador);
			this.listaJugadores.add(nuevoJugador);
			pcs.firePropertyChange("KahootIncorporaNuevoJugador", null, this.listaJugadores);
		}
		catch(InsertaJugadorRepetidoException e)  {
			pcs.firePropertyChange("KahootInsertaJugadorRepetido", null, nombreJugador);
		}
		catch(InsertaNombreInvalidoException e) {
			pcs.firePropertyChange("KahootInsertaNombreInvalido", null, e.getMessage());
		}
	}

}
