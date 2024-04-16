package org.glenchiridza.websockets.room;

import org.glenchiridza.websockets.model.RoomMessage;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {

    public RoomMessage sendMessage(
           @Payload RoomMessage message
    ){

    }
}
