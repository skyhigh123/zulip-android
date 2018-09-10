package com.zulip.android.satchat.filters;

import com.zulip.android.satchat.models.Message;
import com.zulip.android.satchat.models.Person;

/**
 * Listener for narrow actions
 */
public interface NarrowListener {
    void onNarrow(NarrowFilter narrowFilter);

    void onNarrow(NarrowFilter narrowFilter, int messageId);

    void onNarrowFillSendBox(Message message, boolean openSoftKeyboard);

    void onNarrowFillSendBoxStream(String stream, String message, boolean openSoftKeyboard);

    void onNarrowFillSendBoxPrivate(Person person[], boolean openSoftKeyboard);
}
