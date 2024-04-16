package org.glenchiridza.websockets.room;

import org.glenchiridza.websockets.model.RoomMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {

    @MessageMapping("/room.sendMessage")
    @SendTo("/room/public")
    public RoomMessage sendMessage(
           @Payload RoomMessage message
    ){
        return message;
    }

    @MessageMapping("/room.addParticipant")
    @SendTo("/room/public")
    public RoomMessage addParticipant(
            @Payload RoomMessage message,
            SimpMessageHeaderAccessor headerAccessor
    ){
        // add username in websocket session
        headerAccessor.getSessionAttributes().put("username",message.getSender());
        return message;
    }
}
