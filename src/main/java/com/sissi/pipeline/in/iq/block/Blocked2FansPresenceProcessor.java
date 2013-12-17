package com.sissi.pipeline.in.iq.block;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.in.ProxyProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.iq.block.Blocked;
import com.sissi.protocol.presence.Presence;
import com.sissi.protocol.presence.Presence.Type;

/**
 * @author kim 2013年12月6日
 */
public class Blocked2FansPresenceProcessor extends ProxyProcessor {

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		JIDContext contacter = super.findOne(super.build(Blocked.class.cast(protocol).getItem().getJid()));
		super.broadcast(contacter.getJid(), context.getJid(), contacter.getJid(), new Presence().setType(Type.UNAVAILABLE));
		return true;
	}
}