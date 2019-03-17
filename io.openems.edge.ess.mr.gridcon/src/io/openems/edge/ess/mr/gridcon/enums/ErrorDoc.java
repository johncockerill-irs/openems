package io.openems.edge.ess.mr.gridcon.enums;

import java.util.HashMap;
import java.util.Map;

import io.openems.edge.common.channel.doc.Doc;

public class ErrorDoc extends Doc {

	private static Map<Integer, ErrorDoc> mapCodeToDoc = new HashMap<>();
	
	public enum Acknowledge {
		AUTO_ACKNOWLEDGE,
		NO_ACKNOWLEDGE,
		RESTART,
		UNDEFINED
	}
	
	public enum ReactionLevel {
		CFG_ANYBUS,
		CFG_DERATING,
		DISABLED,
		FORCED,
		INFO,
		SHUTDOWN,
		WARNING,
	}
	
	private boolean needsHardReset;
	private Acknowledge acknowledge;
	private ReactionLevel reactionLevel;
	private int code;

	public ErrorDoc getErrorDoc(int code) {
		return mapCodeToDoc.get(code);
	}

	public boolean isNeedsHardReset() {
		return needsHardReset;
	}

	public ErrorDoc needsHardReset(boolean needsHardReset) {
		this.needsHardReset = needsHardReset;
		return this;
	}

	public Acknowledge getAcknowledge() {
		return acknowledge;
	}

	public ErrorDoc acknowledge(Acknowledge acknowledge) {
		this.acknowledge = acknowledge;
		return this;
	}

	public ReactionLevel getReactionLevel() {
		return reactionLevel;
	}

	public ErrorDoc reactionLevel(ReactionLevel reactionLevel) {
		this.reactionLevel = reactionLevel;
		return this;
	}

	public int getCode() {
		return code;
	}

	public ErrorDoc code(int code) {
		this.code = code;
		ErrorDoc.mapCodeToDoc.put(code, this);
		return this;
	}
	
	
}