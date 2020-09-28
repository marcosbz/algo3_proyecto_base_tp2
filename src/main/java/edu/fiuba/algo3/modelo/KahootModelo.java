/**
 * 
 */
package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import edu.fiuba.algo3.modelo.excepciones.InsertaJugadorRepetidoException;
import edu.fiuba.algo3.modelo.excepciones.InsertaNombreInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.RespuestaNoReconocidaException;

/**
 * @author marco
 *
 */
public class KahootModelo {

	List<Jugador> listaJugadores;
	List<Desafio> listaDesafios;
	MediatorArbitro arbitroEvaluador;
	PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	/* Referencia temporal de la respuesta */
	private RespuestaDesafio respuestaDeTurno;
	private List<Modificador> modificadoresDeTurno;
	private Iterator<Jugador> iteradorJugadorActual;
	private Iterator<Desafio> iteradorDesafioActual;
	private Desafio desafioActual;
	private Jugador jugadorActual;
	
	public KahootModelo() {
		/* Inicializar estructuras */
		/* Cargar lista de Desafio a memoria */
		this.listaDesafios = new ArrayList<Desafio>();
		this.listaJugadores = new ArrayList<Jugador>();
		this.arbitroEvaluador = new MediatorArbitroV1();
		this.modificadoresDeTurno = new ArrayList<Modificador>();
		/* Cargo un solo Desafio para prueba */
		Desafio desafioVOF1 = new DesafioVOF("El cielo es azul", true);
		Desafio desafioVOF2 = new DesafioVOF("El cielo es verde", false);
		listaDesafios.add(desafioVOF1); listaDesafios.add(desafioVOF2);

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
		/* Generar aca un Desafio simulando la carga desde archivo */
		this.listaDesafios.add(new DesafioVOF("El cielo es azul", true));
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
	public void comenzarJuego() {
		// TODO Auto-generated method stub
		/* Debe habilitar el primer Desafío */
		try {
			this.iteradorDesafioActual = this.listaDesafios.iterator();
			this.iteradorJugadorActual = this.listaJugadores.iterator();
			this.desafioActual = this.iteradorDesafioActual.next();
			this.arbitroEvaluador.iniciarDesafio(this.desafioActual);
			pcs.firePropertyChange("KahootModeloEtapa", null, "etapaModeloJuegoPrincipal");
			pcs.firePropertyChange("KahootNuevoDesafio", null, this.desafioActual);
			this.jugadorActual = this.iteradorJugadorActual.next();
			pcs.firePropertyChange("KahootSiguienteJugador", null, this.jugadorActual);
		}
		catch (NoSuchElementException e) {
			/* No habia Desafios cargados. Notificar a la vista */
			pcs.firePropertyChange("KahootNoHayDesafios", null, null);
		}
	}
	public void insertarRespuesta(RespuestaDesafio respuesta) {
		// TODO Auto-generated method stub
		/* Guardar respuesta en contenedor temporal. Enviarla solo despues del llamado a siguienteJugador() */
		this.respuestaDeTurno = respuesta;
	}
	public List<Jugador> getJugadores() {
		// TODO Auto-generated method stub
		return this.listaJugadores;
	}
	public void aceptarJugada() {
		// TODO Auto-generated method stub
		try {
			/* Realizar la jugada con el jugador actual, la respuesta actual y el modificador actual. Pasar al siguiente jugador */
			this.arbitroEvaluador.aceptarJugada(this.jugadorActual, this.respuestaDeTurno, this.modificadoresDeTurno);
			/* Si ya se aceptó la jugada de todos los Jugadores, finalizar el desafio */
			if(this.iteradorJugadorActual.hasNext() == false) {
				this.arbitroEvaluador.finalizarDesafio();
				if(this.iteradorDesafioActual.hasNext()) {
					this.desafioActual = this.iteradorDesafioActual.next();
					this.arbitroEvaluador.iniciarDesafio(this.desafioActual);
					pcs.firePropertyChange("KahootNuevoDesafio", null, this.desafioActual);
					this.jugadorActual = iteradorJugadorActual.next();
					pcs.firePropertyChange("KahootSiguienteJugador", null, this.jugadorActual);
				}
				else {
					pcs.firePropertyChange("KahootModeloEtapa", null, "etapaModeloMostrarResultados");
				}
			}
			else {
				this.jugadorActual = this.iteradorJugadorActual.next();
				pcs.firePropertyChange("KahootSiguienteJugador", null, this.jugadorActual);
			}
		}
		catch(NoSuchElementException e) {
			/* No hay Jugadores */
			pcs.firePropertyChange("KahootNoHayJugadores", null, null);
		}
		catch (RespuestaNoReconocidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pcs.firePropertyChange("KahootRespuestaInvalida", null, e);
		}
	}

}
