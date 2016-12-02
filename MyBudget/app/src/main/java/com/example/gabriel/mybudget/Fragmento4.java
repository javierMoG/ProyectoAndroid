package com.example.gabriel.mybudget;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento4 extends Fragment {

WebView wb;
    public Fragmento4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragmento4, container, false);
        wb= (WebView) view.findViewById(R.id.WebView);
        wb.loadUrl("https://www.google.com.mx/");
        wb.setWebViewClient(new MiWebViewClient());


        return view;
    }

}
class MiWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
