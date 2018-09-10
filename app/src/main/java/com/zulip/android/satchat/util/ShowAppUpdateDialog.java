package com.zulip.android.satchat.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;

import com.zulip.android.satchat.R;
import com.zulip.android.satchat.ZulipApp;


public class ShowAppUpdateDialog {

    public static void showDialog(final Context context) {
        // check whether don't show shown is opted
        if (ZulipApp.get().getSettings().getBoolean(Constants.DONT_SHOW_APP_UPDATE_DIALOG, false)) {
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setPositiveButton(R.string.update, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // open new app page on play store
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.zulipmobile&hl=en_IN"));
                context.startActivity(intent);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        builder.setNeutralButton(R.string.dont_show_again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ZulipApp.get().setDontShowAppDialog(true);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setMessage("This project is deprecated in favor of React Native app, " +
                "which supports both iOS and Android. Click update to switch to the new app.");

        dialog.show();
    }
}
