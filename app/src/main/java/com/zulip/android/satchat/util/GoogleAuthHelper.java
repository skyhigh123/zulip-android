package com.zulip.android.satchat.util;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.zulip.android.satchat.BuildConfig;
import com.zulip.android.satchat.ZulipApp;

/**
 * Class to encapsulate logic for the Google Authentication flows
 */

public class GoogleAuthHelper implements GoogleApiClient.ConnectionCallbacks {

    private GoogleApiClient mGoogleApiClient;

    public void logOutGoogleAuth() {
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(BuildConfig.GOOGLE_CLIENT_ID)
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(ZulipApp.get())
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .addConnectionCallbacks(this)
                .build();

        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient);
    }

    @Override
    public void onConnectionSuspended(int i) {
        // do nothing
    }
}
