package step.android.sharks_chat;

import java.util.Date;

public class Message {
    private String userName;
    private String textMessage;
    private long messageTime;

    public Message(){
        userName = "Guest";
        textMessage = "";
        Date date = new Date();
        messageTime = date.getTime();
    }
    public Message(String userName, String textMessage){
        this.userName = userName;
        this.textMessage = textMessage;
        Date date = new Date();
        messageTime = date.getTime();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
