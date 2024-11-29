package sap.smartroom.case2;

import io.vertx.core.json.JsonObject;
import sap.smartroom.agents.common.BasicEventLoopAgent;
import sap.smartroom.env_impl.distributed.*;
import sap.smartroom.env_model.Event;
import sap.smartroom.env_model.PresenceDetectionDevice;

public class PresenceDetectionAgent extends BasicEventLoopAgent {

	public static final String PresenceDetectionChannelName = "presence-detection";
	private CommChannel channel;
	private String lightControllerChannelName;

	public PresenceDetectionAgent(PresenceDetectionDevice pdd, String lightControllerChannelName) throws Exception {
		super("presence-detection-agent");
		this.lightControllerChannelName = lightControllerChannelName;
		pdd.register(this);
		channel = new CommChannel(PresenceDetectionChannelName);
		log("init ok.");
	}

	protected void processEvent(Event ev) {
		if (ev instanceof PresenceDetected) {
			log("presence detected");
			JsonObject msg = new JsonObject();
			msg.put("event", "presence-detected");
			channel.sendMsg(lightControllerChannelName, msg);
		} else if (ev instanceof PresenceNoMoreDetected) {
			log("presence no more detected... ");
			JsonObject msg = new JsonObject();
			msg.put("event", "presence-no-more-detected");
			channel.sendMsg(lightControllerChannelName, msg);
		} 
	}
}
