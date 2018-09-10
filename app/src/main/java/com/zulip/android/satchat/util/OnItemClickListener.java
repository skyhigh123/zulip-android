package com.zulip.android.satchat.util;

import com.zulip.android.satchat.models.Message;
import com.zulip.android.satchat.viewholders.MessageHeaderParent;

/**
 * An interface between the {@link com.zulip.android.satchat.viewholders.MessageHolder} and
 * {@link com.zulip.android.satchat.viewholders.MessageHeaderParent.MessageHeaderHolder}.
 */
public interface OnItemClickListener {
    void onItemClick(int viewId, int position);

    Message getMessageAtPosition(int position);

    MessageHeaderParent getMessageHeaderParentAtPosition(int position);

    void setContextItemSelectedPosition(int adapterPosition);
}
