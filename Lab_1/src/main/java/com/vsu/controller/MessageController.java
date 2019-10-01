package com.vsu.controller;

import java.util.ArrayList;
import java.util.List;

public class MessageController {

    private List<String> listMessage;

    public MessageController() {
        this.listMessage = new ArrayList<String>();
    }

    public synchronized void sendMessage(String message){
        listMessage.add(message);
    }

    public List<String> getListMessage() {
        return listMessage;
    }
}
