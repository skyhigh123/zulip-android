package com.zulip.android.satchat.networking.response;

import com.google.gson.annotations.SerializedName;
import com.zulip.android.satchat.models.Message;

import java.util.List;


public class GetMessagesResponse {

    @SerializedName("msg")
    private String msg;
    @SerializedName("result")
    private String result;

    @SerializedName("messages")
    private List<Message> messages;

    public String getMsg() {
        return msg;
    }

    public String getResult() {
        return result;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
