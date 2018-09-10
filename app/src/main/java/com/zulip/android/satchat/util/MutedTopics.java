package com.zulip.android.satchat.util;

import android.content.SharedPreferences;

import com.zulip.android.satchat.ZulipApp;
import com.zulip.android.satchat.models.Message;
import com.zulip.android.satchat.models.MessageType;
import com.zulip.android.satchat.models.Stream;

import java.util.HashSet;
import java.util.List;


public class MutedTopics {

    private static final String MUTED_TOPIC_KEY = "mutedTopics";

    private static MutedTopics sMutedTopics;

    private MutedTopics() {
    }

    public static MutedTopics get() {
        if (sMutedTopics == null) {
            sMutedTopics = new MutedTopics();
        }
        return sMutedTopics;
    }

    public void addToMutedTopics(List<List<String>> mutedTopics) {
        if (mutedTopics == null) return;

        Stream stream;
        HashSet<String> topics = new HashSet<>();

        for (int i = 0; i < mutedTopics.size(); i++) {
            List<String> mutedTopic = mutedTopics.get(i);
            stream = Stream.getByName(ZulipApp.get(), mutedTopic.get(0));
            topics.add(stream.getId() + mutedTopic.get(1));
        }

        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putStringSet(MUTED_TOPIC_KEY, topics);
        editor.apply();
    }

    public boolean isTopicMute(int id, String subject) {
        String mutedTopicKey = String.valueOf(id) + subject;
        return getPrefs().getStringSet(MUTED_TOPIC_KEY, new HashSet<String>()).contains(mutedTopicKey);
    }

    public boolean isTopicMute(Message message) {
        // if message is private it cannot be muted
        if (message.getType() == MessageType.PRIVATE_MESSAGE) {
            return false;
        }
        return getPrefs().getStringSet(MUTED_TOPIC_KEY, new HashSet<String>()).contains(message.concatStreamAndTopic());
    }

    private SharedPreferences getPrefs() {
        return ZulipApp.get().getSettings();
    }


}
