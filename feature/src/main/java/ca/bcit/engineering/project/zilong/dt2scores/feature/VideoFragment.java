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

public class VideoFragment extends Fragment {

    private WebView myWebView;

    private OnFragmentInteractionListener mListener;

    public VideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoFragment newInstance(String param1, String param2) {
        VideoFragment fragment = new VideoFragment();
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

        View view = inflater.inflate(R.layout.fragment_video, container, false);
        myWebView = view.findViewById(R.id.videowebview);
        myWebView.loadUrl("https://www.youtube.com/channel/UCjkem1Rik-q4xKeETu9geUw/recent");
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
                removeEleByCls("header-bar"); // Youtube research bar
                removeEleByCls("c4-tabbed-header-banner"); // Dota2 header
                removeEleByCls("c4-tabbed-header-channel"); // Dota2 header
                removeEleByCls("scbrr-tabs"); // Dota2 header tabs

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
