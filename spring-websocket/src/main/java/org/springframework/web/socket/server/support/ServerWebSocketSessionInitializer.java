/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.socket.server.support;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.ConfigurableWebSocketSession;

/**
 * Copies information from the handshake HTTP request and response to a given
 * {@link WebSocketSession}.
 *
 * @author Rossen Stoyanchev
 * @since 4.0
 */
public class ServerWebSocketSessionInitializer {

	public void initialize(ServerHttpRequest request, ServerHttpResponse response,
			String protocol, ConfigurableWebSocketSession session) {

		session.setUri(request.getURI());
		session.setRemoteHostName(request.getRemoteHostName());
		session.setRemoteAddress(request.getRemoteAddress());
		session.setPrincipal(request.getPrincipal());
		session.setAcceptedProtocol(protocol);
	}

}
