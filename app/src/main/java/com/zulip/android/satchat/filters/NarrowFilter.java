package com.zulip.android.satchat.filters;

import android.os.Parcelable;

import com.j256.ormlite.stmt.Where;
import com.zulip.android.satchat.models.Message;
import com.zulip.android.satchat.models.Stream;

import org.json.JSONException;

import java.sql.SQLException;

/**
 * A narrow that can fetch results from the local cache or server.
 */
public interface NarrowFilter extends Parcelable {
    /**
     * Mutates a Where object to implement the desired narrowing filter.
     *
     * @return the original Where object, as modified by the function
     */
    public Where<Message, Object> modWhere(Where<Message, Object> where)
            throws SQLException;

    /**
     * Determines whether an incoming Message would match this filter
     */
    public boolean matches(Message msg);

    /**
     * A string to be shown in the title portion of an ActionBar
     */
    public String getTitle();

    /**
     * A string to be shown in the subtitle portion of an ActionBar
     */
    public String getSubtitle();

    /**
     * A string to fill in if a stream compose is initiated
     */
    public Stream getComposeStream();

    /**
     * A string to fill in if a PM compose is initiated
     */
    public String getComposePMRecipient();

    /**
     * A filter to apply when fetching additional messages from the server
     */
    public String getJsonFilter() throws JSONException;

    /**
     * Check if the current narrow filter matches the passed filter
     */
    public boolean equals(NarrowFilter filter);
}
