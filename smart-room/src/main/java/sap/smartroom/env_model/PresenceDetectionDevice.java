package sap.smartroom.env_model;

/**
 * 
 * Interface for presence detection devices
 * 
 */
public interface PresenceDetectionDevice extends EventSource {
	
	boolean presenceDetected();

}
