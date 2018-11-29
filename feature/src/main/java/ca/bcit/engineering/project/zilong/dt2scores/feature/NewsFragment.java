package ca.bcit.engineering.project.zilong.dt2scores.feature;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    private WebView myWebView;

    private OnFragmentInteractionListener mListener;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        myWebView = view.findViewById(R.id.webview);
        myWebView.loadUrl("https://news.google.com/topics/CAAqKAgKIiJDQkFTRXdvS0wyMHZNR1JzYTNkdU1SSUZaVzR0UjBJb0FBUAE?oc=3");
        setUpWebView();
        return view;
    }

    // reset web view client
    protected void setUpWebView() {

        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return super.shouldOverrideUrlLoading(view, url);
            }

            public void removeEleByCls(String classname) {
                myWebView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('" + classname + "')[0].style.display='none'; })()");
            }

            public void removeEleById(String id) {
                myWebView.loadUrl("javascript:(function() { " +
                        "document.getElementById('" + id + "').style.display='none'; })()");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // hide element by class name
                removeEleByCls("pGxpHc"); // google news header
                removeEleByCls("XCz6Hb"); // google news Dota2 header

                Log.d("main", "load script");

                // hide element by id
                //myWebView.loadUrl("javascript:(function() { " +
                //        "document.getElementById('your_id').style.display='none';})()");

            }
        });
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
