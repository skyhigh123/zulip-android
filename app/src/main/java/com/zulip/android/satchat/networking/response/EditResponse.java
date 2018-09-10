package com.zulip.android.satchat.networking.response;

import com.google.gson.annotations.SerializedName;

public class EditResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("result")
    private String result;

    public String getMsg() {
        return msg;
    }

    public String getResult() {
        return result;
    }
}