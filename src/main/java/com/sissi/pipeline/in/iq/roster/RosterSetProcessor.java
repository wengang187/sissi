package com.sissi.pipeline.in.iq.roster;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.in.ProxyProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.iq.roster.GroupItem;
import com.sissi.protocol.iq.roster.Roster;
import com.sissi.ucenter.RelationRoster;
import com.sissi.ucenter.relation.ItemWrapRelation;

/**
 * @author kim 2013-10-31
 */
public class RosterSetProcessor extends ProxyProcessor {

	@Override
	public boolean input(JIDContext context, Protocol protocol) {
		GroupItem item = Roster.class.cast(protocol).getFirstItem();
		// convert jid to bare jid
		super.establish(context.jid(), new ItemWrapRelation(RelationRoster.class.cast(super.ourRelation(context.jid(), super.build(item.getJid()))), item));
		return true;
	}
}
