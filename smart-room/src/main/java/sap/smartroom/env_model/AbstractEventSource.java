package sap.smartroom.env_model;

/**
 * 
 * Abstract class representing a source of event
 * 
 */
public abstract class AbstractEventSource implements EventSource {

	private EventObserver controller;
	
	public void register(EventObserver c) {
		controller = c;
	}
	
	protected void notifyEvent(Event ev) {
		if (controller != null) {
			controller.notifyEvent(ev);
		}
	}
}
