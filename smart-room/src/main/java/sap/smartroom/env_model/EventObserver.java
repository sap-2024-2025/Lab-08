package sap.smartroom.env_model;

/**
 *  
 *  Basic interface for observers, observing
 *  events generated by devices
 * 
 */
public interface EventObserver {

	void notifyEvent(Event ev);
}
