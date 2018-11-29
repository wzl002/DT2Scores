package ca.bcit.engineering.project.zilong.dt2scores.feature;

import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    public final String SCORE_PAGE = "score";
    public final String NEWS_PAGE = "news";
    public final String VIDEO_PAGE = "video";

    private String currentPage = SCORE_PAGE;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.navigation_score) {
                loadMainPage();
                return true;
            } else if (id == R.id.navigation_news) {
                loadNewsPage();
                return true;
            } else if (id == R.id.navigation_video) {
                loadVideoPage();
                return true;
            }
            return false;
        }
    };

    protected void loadMainPage() {
        currentPage = SCORE_PAGE;
        myWebView.loadUrl("https://cybersportscore.com/en/dota-2");
    }

    protected void loadNewsPage() {
        currentPage = NEWS_PAGE;
        myWebView.loadUrl("https://news.google.com/topics/CAAqKAgKIiJDQkFTRXdvS0wyMHZNR1JzYTNkdU1SSUZaVzR0UjBJb0FBUAE?oc=3");


//        myWebView.evaluateJavascript("javascript:alert('1')", new ValueCallback<String>() {
//            @Override
//            public void onReceiveValue(String value) {
//                //此处为 js 返回的结果
//            }
//        });
    }

    protected void loadVideoPage() {
        currentPage = VIDEO_PAGE;
        myWebView.loadUrl("https://www.youtube.com/channel/UCjkem1Rik-q4xKeETu9geUw/recent");
    }

    public String getCurrentPage() {
        return currentPage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mTextMessage = (TextView) findViewById(R.id.message);
        myWebView = (WebView) findViewById(R.id.webview);

        setUpWebView();
        loadMainPage();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

}
