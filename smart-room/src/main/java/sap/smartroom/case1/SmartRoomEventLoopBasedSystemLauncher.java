package sap.smartroom.case1;

import sap.smartroom.env_impl.centralized.SinglelBoardSimulator;
import sap.smartroom.env_model.Event;

public class SmartRoomEventLoopBasedSystemLauncher {

	public static void main(String[] args) throws Exception {

		SinglelBoardSimulator board = new SinglelBoardSimulator();
		board.init();
	
		board.register((Event ev) -> {
			System.out.println("New event: " + ev);
		});
		
		SmartRoomEventLoopBasedController agent = new SmartRoomEventLoopBasedController("my-controller", board, 0.2);
		agent.start();
	}

}
