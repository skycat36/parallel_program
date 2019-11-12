package com.vsu.data;

import com.vsu.controller.MessageController;

import java.util.ArrayList;
import java.util.List;

public class Message implements Runnable {
    private int id;

    private int countMessage;

    private List<Integer> listMessage;

    private List<Message> messageList;

    private MessageController messageController;

    public Message(int id, int countMessage, MessageController messageController) {

        this.id = id;
        this.countMessage = countMessage;
        this.messageController = messageController;
        this.listMessage = new ArrayList<Integer>();
        this.messageList = new ArrayList<Message>();
    }

    private Integer generateMessage(){
        return Integer.parseInt(String.valueOf(Math.round(Math.random() * 100)));
    }

    public void run() {
        for (int i = 0; i < this.countMessage; i++) {
            sendMessageOtherMessagers();
        }
    }

    private void sendMessageOtherMessagers(){

        Integer minValue;
        Integer maxValue;

        for (Message message: messageList){
            message.getMessage(this.generateMessage());
            minValue = this.getMinValue();
            maxValue = message.getMaxValue();
            if (minValue != null && maxValue != null){
                if (maxValue > minValue){
                    this.messageController.sendMessage("Thread №" + message.getId()
                                    + " | Now thread  " + this.getId() + " min value " + minValue
                                    + " | Thread №" + message.getId() + " max value " + maxValue
                    );
                }
            }
        }
    }

    private synchronized void getMessage(Integer message){
        this.listMessage.add(message);
    }

    private Integer getMinValue(){
        int minValue;

        if (this.listMessage.size() == 0){
            return null;
        }

        minValue = this.listMessage.get(0);
        for (Integer message : this.listMessage){
            if (minValue > message){
                minValue = message;
            }
        }
        return minValue;
    }

    private Integer getMaxValue(){
        int maxValue;

        if (this.listMessage.size() == 0){
            return null;
        }

        maxValue = this.listMessage.get(0);
        for (Integer message : this.listMessage){
            if (maxValue < message){
                maxValue = message;
            }
        }
        return maxValue;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getListMessage() {
        return listMessage;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
