package com.vsu.application;

import com.vsu.controller.MessageController;
import com.vsu.data.Message;

import java.util.ArrayList;
import java.util.List;


public class Application {

    private static int COUNT_MESSAGE = 1, COUNT_THREADS = 15;

    public static void main(String[] args){
        MessageController messageController = new MessageController();

        List<Message> messageList = new ArrayList<Message>();

        for (int i = 0; i < COUNT_THREADS; i++){
            messageList.add(new Message(i, COUNT_MESSAGE, messageController));
        }

        for (int i = 0; i < COUNT_THREADS; i++) {
            List<Message> tempMessageList = new ArrayList<Message>(messageList);
            tempMessageList.remove(i);
            messageList.get(i).setMessageList(tempMessageList);
        }

        for (Message m : messageList){
            m.run();
        }

        for (String str : messageController.getListMessage()){
            System.out.println(str);
        }
    }
}
