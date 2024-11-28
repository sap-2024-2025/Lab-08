package sap.smartroom.case1;

import sap.smartroom.Event;
import sap.smartroom.environment.centralized.SinglelBoardSimulator;

public class SuperLoopControllerLauncher {

	public static void main(String[] args) throws Exception {

		SinglelBoardSimulator board = new SinglelBoardSimulator();
		board.init();
	
		board.register((Event ev) -> {
			System.out.println("New event: " + ev);
		});
		
		SmartRoomSuperLoopBasedAgent agent = new SmartRoomSuperLoopBasedAgent("my-controller", board, 0.2);
		agent.start();
	}

}
