package dev.waca.socket.config

import dev.waca.socket.handler.WebSocketHandler
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.*

@Configuration
@EnableWebSocket
open class SocketConfig(
    private val webSocketHandler: WebSocketHandler
) : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry
            .addHandler(webSocketHandler, "/stream")
            .setAllowedOrigins("*")
    }
}