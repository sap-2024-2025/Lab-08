package sap.smartroom.env_model;

/**
 * 
 * Interface for Light sensor devices
 * 
 */
public interface LightSensorDevice extends EventSource {

	double getLuminosity();
		
}
