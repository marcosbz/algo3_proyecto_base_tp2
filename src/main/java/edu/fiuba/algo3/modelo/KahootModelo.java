/**
 * 
 */
package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author marco
 *
 */
public class KahootModelo {

	PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	/* addPropertyChangeListener(String, PropertyChangeListener): Add a property-change listener for a specific property. The listener is called only when there is a change to the specified property. */
	/* addPropertyChangeListener(PropertyChangeListener): Add a property-change listener to the listener list. */
	public void addObserver(PropertyChangeListener kahootVista) {
		// TODO Auto-generated method stub
		/* Every listener will care only about a specific property change */
		/* KahootVista will care about general model state change, but subscenes of that view will listen to more specific events, such as a new Desafio in the quiz stage */
		
	}

}
