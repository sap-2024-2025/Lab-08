package sap.smartroom.case2;

import sap.smartroom.environment.distributed.*;

public class PresenceDetectionAgentLauncher {

	private static final String FIXED_LIGHT_CONTROLLER_CHANNEL_NAME = "light-controller";


	public static void main(String[] args) throws Exception {

		PresDetectSensorSimulator pd = new PresDetectSensorSimulator("Pres-Det-Agent");
		pd.init();
		
		try {
			PresenceDetectionAgent agent = new PresenceDetectionAgent(pd, FIXED_LIGHT_CONTROLLER_CHANNEL_NAME);
			agent.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
