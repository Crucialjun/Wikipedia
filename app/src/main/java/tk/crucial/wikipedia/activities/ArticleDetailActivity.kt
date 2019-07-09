package tk.crucial.wikipedia.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_article_detail.*
import models.WikiPage
import tk.crucial.wikipedia.R

class ArticleDetailActivity : AppCompatActivity() {
    private var currentPage: WikiPage? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val articledetailwebview = findViewById<WebView>(R.id.article_detail_webview)

        val wikipageJson = intent.getStringExtra("page")
        currentPage = Gson().fromJson(wikipageJson,WikiPage::class.java)
        articledetailwebview?.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        val webSettings = articledetailwebview.settings
        webSettings.domStorageEnabled
        webSettings.javaScriptEnabled
        articledetailwebview.loadUrl(currentPage?.fullurl)
        WebView.setWebContentsDebuggingEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home){
            finish()
        }
        return true
    }
}