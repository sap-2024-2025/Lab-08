package sap.smartroom.case2;

import sap.smartroom.environment.distributed.*;

public class LampControllerAgentLauncher {
	
	public static void main(String[] args) throws Exception {

		LampDeviceSimulator ld = new LampDeviceSimulator("MyLight");
		ld.init();
		
		try {
			LampControllerAgent agent = new LampControllerAgent(ld, 0.2);
			agent.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
