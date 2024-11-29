/**
 * Simulator/mock for a light device
 * 
 */
package sap.smartroom.env_impl.distributed;

import sap.smartroom.env_model.*;

public class LampDeviceSimulator implements LampDevice {

	private LampSimFrame frame;
	private String lightID;
	
	public LampDeviceSimulator(String lightID){
		this.lightID = lightID;
	}
	
	public void init() {
		frame = new LampSimFrame(lightID);
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
}
