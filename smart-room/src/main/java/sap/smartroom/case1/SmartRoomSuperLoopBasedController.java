package sap.smartroom.case1;

import sap.smartroom.agents.common.BasicSuperLoopAgent;
import sap.smartroom.env_impl.centralized.*;

/**
 * 
 * A Smart Room agent controller based on super-loop architecture,
 * implementing a synchronous FSM
 * 
 */
public class SmartRoomSuperLoopBasedController extends BasicSuperLoopAgent {
	
	private SinglelBoardSimulator board;
	
	private enum StateType { LIGHT_OFF, LIGHT_ON, LIGHT_GOING_OFF }
	private StateType currentState;

	private double threshold;
	private long startWaitingTime;
	
	private static final long PERIOD = 50;
	
	public SmartRoomSuperLoopBasedController(
				String id, 
				SinglelBoardSimulator board,
				double threshold) {
		super(id,PERIOD);
		this.board = board;
		this.threshold = threshold;
	}

	@Override
	protected void setup() {		
		currentState = StateType.LIGHT_OFF;
		board.off();		
	}
	
	@Override
	protected void loop() {
		switch (currentState) {
			case LIGHT_OFF:
				boolean pres = board.presenceDetected();
				double currentLight = board.getLuminosity();
				if (pres && currentLight < threshold) {
					log("presence detected && poor light => turn on");
					board.on();
					currentState = StateType.LIGHT_ON;
				} 
				break;
			case LIGHT_ON:
				pres = board.presenceDetected();
				if (!pres) {
					log("presence no more detected... wait for 5 secs");
					startWaitingTime = getTime();
					currentState = StateType.LIGHT_GOING_OFF;
				} 
				break;
			case LIGHT_GOING_OFF:	
				pres = board.presenceDetected();
				if (pres) {
					log("presence detected while waiting..going on");
					currentState = StateType.LIGHT_ON;
				} else if (getTime() - startWaitingTime > 5000) {
					log("going off");
					board.off();
					currentState = StateType.LIGHT_OFF;
				} 
				break;
		}
	}


}
