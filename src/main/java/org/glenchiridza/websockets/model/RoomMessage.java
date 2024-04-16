package org.glenchiridza.websockets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glenchiridza.websockets.enums.MessageType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomMessage {
    private String message;
    private String sender;
    private MessageType messageType;
}
