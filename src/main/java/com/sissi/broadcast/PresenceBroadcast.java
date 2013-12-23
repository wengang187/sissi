package com.sissi.broadcast;

import com.sissi.context.JID;
import com.sissi.context.Status;

/**
 * @author kim 2013-11-17
 */
public interface PresenceBroadcast {

	public PresenceBroadcast broadcast(JID jid, JID from, JID to, Status status);
}
