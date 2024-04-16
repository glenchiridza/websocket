package org.glenchiridza.websockets.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.glenchiridza.websockets.enums.MessageType;
import org.glenchiridza.websockets.model.RoomMessage;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageTemplate;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null){
            log.info("user disconnected :: {}",username);
            var roomMessage = RoomMessage.builder()
                    .messageType(MessageType.LEFT)
                    .sender(username)
                    .build();
            messageTemplate.convertAndSend("/room/public",roomMessage);
        }
    }

}
