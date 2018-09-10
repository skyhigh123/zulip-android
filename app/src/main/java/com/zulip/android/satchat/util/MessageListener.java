package com.zulip.android.satchat.util;

import com.zulip.android.satchat.models.Message;

public interface MessageListener {

    void onMessages(Message[] messages, LoadPosition pos, boolean moreAbove,
                    boolean moreBelow, boolean noFurtherMessages);

    void onMessageError(LoadPosition pos);

    public enum LoadPosition {
        ABOVE, BELOW, NEW, INITIAL,
    }
}
