package com.hermanowicz.badmintonschool.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.hermanowicz.badmintonschool.BuildConfig;
import com.hermanowicz.badmintonschool.R;

public class AuthorDialog extends AppCompatDialogFragment {

    private ImageView linkedInProfile, facebookProfile;
    private TextView appVersion;

    public static AuthorDialog newInstance(int title) {
        AuthorDialog frag = new AuthorDialog();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Activity activity = getActivity();
        assert activity != null;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AppThemeDialog);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_author, null);

        builder.setView(view)
                .setTitle(getString(R.string.settings_authorLabel))
                .setPositiveButton(getString(R.string.settings_close), (dialog, which) -> {
                });

        initView(view);
        setListeners();
        showAppVersion();

        return builder.create();
    }

    private void initView(View view) {
        linkedInProfile = view.findViewById(R.id.linkedIn);
        facebookProfile = view.findViewById(R.id.facebook);
        appVersion = view.findViewById(R.id.appVersion);
    }

    private void setListeners() {
        linkedInProfile.setOnClickListener(view1 -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(getString(R.string.author_linked_in_profile)));
            startActivity(intent);
        });

        facebookProfile.setOnClickListener(view1 -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(getString(R.string.author_facebook_profile)));
            startActivity(intent);
        });
    }

    private void showAppVersion() {
        appVersion.setText(String.format("%s: %s", getResources().getText(R.string.settings_version), BuildConfig.VERSION_NAME));
    }
}