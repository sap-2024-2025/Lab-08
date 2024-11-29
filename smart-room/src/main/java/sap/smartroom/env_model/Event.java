package sap.smartroom.env_model;

/**
 * 
 * Base class for event generate by devices
 * 
 */
public abstract class Event {

	private long timestamp;
	
	public Event(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
}
