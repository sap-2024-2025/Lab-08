/**
 * 
 * Simulator/mock for a single system including
 * a light device, a light sensor device and a presence detection sensor device
 * 
 */
package sap.smartroom.env_impl.centralized;

import sap.smartroom.env_model.*;

public class SinglelBoardSimulator extends AbstractEventSource implements LampDevice, LightSensorDevice, PresenceDetectionDevice {

	private SingleBoardFrame frame;

	private double currentLuminosityLevel;
	private boolean isPresenceDetected;

	public SinglelBoardSimulator(){	
	}
	
	public void init() {
		frame = new SingleBoardFrame(this);
		frame.display();
	}
	
	@Override
	public void on() {
		frame.setOn(true);	
	}

	@Override
	public void off() {
		frame.setOn(false);	
	}

	@Override
	public synchronized double getLuminosity() {
		return currentLuminosityLevel;
	}
	
	@Override
	public synchronized boolean presenceDetected() {
		return isPresenceDetected;
	}

    synchronized void updateLumValue(double value) {
    	long ts = System.currentTimeMillis();
		this.currentLuminosityLevel = value;
		this.notifyEvent(new LightLevelChanged(ts, value));
	}

	synchronized void updatePresDetValue(boolean value) {
		long ts = System.currentTimeMillis();
		this.isPresenceDetected = value;
		if (value) {
			this.notifyEvent(new PresenceDetected(ts));
		} else {
			this.notifyEvent(new PresenceNoMoreDetected(ts));
		}
	}


}
