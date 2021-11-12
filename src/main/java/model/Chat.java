package model;

import java.util.Date;

public class Chat {
    private long ch_id;
    private int sender;
    private int receiver;
    private String message;
    private Date datetime;
    private int s_id;

    public Chat() {}
    public Chat(long ch_id, int sender, int receiver, String message, Date datetime, int s_id) {
        this.ch_id = ch_id;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.datetime = datetime;
        this.s_id = s_id;
    }

    public long getCh_id() {
        return ch_id;
    }

    public void setCh_id(long ch_id) {
        this.ch_id = ch_id;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }
}
