package sap.smartroom.case1;

import sap.smartroom.Event;
import sap.smartroom.environment.centralized.SinglelBoardSimulator;

public class EventLoopControllerLauncher {

	public static void main(String[] args) throws Exception {

		SinglelBoardSimulator board = new SinglelBoardSimulator();
		board.init();
	
		board.register((Event ev) -> {
			System.out.println("New event: " + ev);
		});
		
		SmartRoomEventLoopBasedAgent agent = new SmartRoomEventLoopBasedAgent("my-controller", board, 0.2);
		agent.start();
	}

}
