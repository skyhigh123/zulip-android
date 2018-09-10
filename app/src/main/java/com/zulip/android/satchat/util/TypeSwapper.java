package com.zulip.android.satchat.util;


public interface TypeSwapper<GIVEN, RETURN> {
    RETURN convert(GIVEN given);

}
