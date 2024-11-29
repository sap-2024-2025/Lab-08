package sap.smartroom.env_impl.distributed;

import sap.smartroom.env_model.Event;
import sap.smartroom.env_model.EventObserver;

public class MyController implements EventObserver {

	@Override
	public void notifyEvent(Event ev) {
		System.out.println("New event: " + ev);
	}

	
}
