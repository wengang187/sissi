package com.sissi.pipeline.in.iq.register.store;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.protocol.Error;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.ProtocolType;
import com.sissi.protocol.error.ServerError;
import com.sissi.protocol.error.detail.NotAcceptable;
import com.sissi.protocol.iq.register.Register;
import com.sissi.protocol.iq.register.simple.Username;

/**
 * 校验当前用户是否已登录
 * 
 * @author kim 2014年5月8日
 */
public class RegisterStoreCheckSimpleUsernameProcessor implements Input {

	private final Error error = new ServerError().type(ProtocolType.CANCEL).add(NotAcceptable.DETAIL);

	@Override
	public boolean input(JIDContext context, Protocol protocol) {
		Username username = protocol.cast(Register.class).findField(Username.NAME, Username.class);
		return username != null && username.valid() ? true : this.writeAndReturn(context, protocol);
	}

	private boolean writeAndReturn(JIDContext context, Protocol protocol) {
		context.write(protocol.parent().reply().setError(this.error));
		return false;
	}
}
