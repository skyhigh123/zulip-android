package com.zulip.android.satchat.networking;

import com.zulip.android.satchat.ZulipApp;
import com.zulip.android.satchat.activities.ZulipActivity;
import com.zulip.android.satchat.models.Message;
import com.zulip.android.satchat.models.MessageType;
import com.zulip.android.satchat.models.Person;

import org.json.JSONArray;

public class AsyncSend extends ZulipAsyncPushTask {

    /**
     * Initialise an AsyncSend task to send a specific message.
     *
     * @param zulipActivity The calling Activity
     * @param msg           The message to send.
     */
    public AsyncSend(ZulipActivity zulipActivity, Message msg) {
        super((ZulipApp) zulipActivity.getApplication());
        this.setProperty("type", msg.getType().toString());
        if (msg.getType() == MessageType.STREAM_MESSAGE) {
            this.setProperty("to", msg.getStream().getName());
        } else {
            JSONArray arr = new JSONArray();
            for (Person recipient : msg.getPersonalReplyTo((ZulipApp) zulipActivity.getApplication())) {
                arr.put(recipient.getEmail());
            }
            this.setProperty("to", arr.toString());
        }
        this.setProperty("stream", msg.getSubject());
        this.setProperty("subject", msg.getSubject());
        this.setProperty("content", msg.getContent());
    }

    public final void execute() {
        execute("POST", "v1/messages");
    }

}
