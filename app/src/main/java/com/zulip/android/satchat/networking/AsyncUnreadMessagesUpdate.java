package com.zulip.android.satchat.networking;

import android.text.TextUtils;

import com.zulip.android.satchat.ZulipApp;

import java.util.ArrayList;

/**
 * A background task used to notify the server that certain messages have been read.
 * This queue {@link ZulipApp#unreadMessageQueue} stores the messages ID's and
 * queue is emptied every couple of seconds.
 */
public class AsyncUnreadMessagesUpdate extends ZulipAsyncPushTask {

    public AsyncUnreadMessagesUpdate(ZulipApp app) {
        super(app);

    }

    public final void execute() {
        ArrayList<Integer> messageIds = new ArrayList<>();
        while (true) {
            Integer item = app.unreadMessageQueue.poll();
            if (item == null) {
                break;
            } else {
                messageIds.add(item);
            }
        }

        if (!messageIds.isEmpty()) {
            setProperty("messages", "[" + TextUtils.join(",", messageIds) + "]");
            setProperty("flag", "read");
            setProperty("op", "add");

            execute("POST", "v1/messages/flags");
        }
    }
}
