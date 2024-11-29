package sap.smartroom.agents.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import sap.smartroom.env_model.Event;
import sap.smartroom.env_model.EventObserver;

/**
 * 
 * Base class for active components ("agents") 
 * based on an event-loop architecture 
 * 
 */
public abstract class BasicEventLoopAgent extends Thread implements EventObserver {
	
	private String agentName;
	private BlockingQueue<Event> queue;
	
	public BasicEventLoopAgent(String name) {
		agentName = name;
		queue = new LinkedBlockingQueue<Event>();
	}
	
	public void run() {
		while (true) {
			try {
				Event ev = queue.take();
				processEvent(ev);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	protected abstract void processEvent(Event ev);
	
	public void notifyEvent(Event ev) {
		try {
			queue.put(ev);
		} catch (Exception ex) {
		}
	}
	
	protected void log(String msg) {
		System.out.println("[" + agentName +"] " + msg);
	}

}
