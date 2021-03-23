package com.hermanowicz.badmintonschool.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.hermanowicz.badmintonschool.R;
import com.hermanowicz.badmintonschool.interfaces.KeyEventListener;

public class NewsFragment extends Fragment implements KeyEventListener {

    private WebView webview;
    private long pressedTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        initView(view);
        setView();

        return view;
    }

    private void initView(View view){
        webview = view.findViewById(R.id.webview_news);
    }

    private void setView() {
        webview.loadUrl("https://m.facebook.com/SzkolaBadmintona/posts/");
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (webview.canGoBack())
            webview.goBack();
        else if (pressedTime + 2000 > System.currentTimeMillis()) {
            getActivity().finish();
        } else {
            Toast.makeText(getContext(), getString(R.string.navigation_press_back_agait_to_exit), Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
        return false;
    }
}
