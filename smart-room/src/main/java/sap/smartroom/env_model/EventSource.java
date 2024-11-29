package sap.smartroom.env_model;

/**
 *  
 *  Basic interfaces for devices generating events
 * 
 */
public interface EventSource {

	void register(EventObserver c);

}
