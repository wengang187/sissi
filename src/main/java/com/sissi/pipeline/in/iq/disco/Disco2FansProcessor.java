package com.sissi.pipeline.in.iq.disco;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.in.ProxyProcessor;
import com.sissi.protocol.Protocol;

/**
 * @author kim 2013年12月19日
 */
public class Disco2FansProcessor extends ProxyProcessor {

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		JIDContext target = super.addressing.findOne(super.build(protocol.getParent().getTo()));
		target.write(protocol.getParent().setFrom(context.getJid().asStringWithBare()).setTo(target.getJid().asStringWithBare()));
		return true;
	}
}
