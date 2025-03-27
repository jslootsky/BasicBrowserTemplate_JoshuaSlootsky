package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var urlEditText: EditText
    private lateinit var goButton: ImageButton
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)


        // Allow your browser to intercept hyperlink clicks
        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        goButton.setOnClickListener{
            var original = urlEditText.text.toString()
            //check if URL starts with https://
            if(!original.startsWith("https://")){
                original = "https://" + original
            }

            webView.loadUrl(original)
//            val url = URL(original.toString())
//
//            val response = url.openStream().bufferedReader().readLine().run{
//                val strBuilder = StringBuilder()
//
//                while(readLine().let{
//                        strBuilder.append("$it\n")
//                        it != null
//                    })
//                    strBuilder.toString()
//            }
//
//            withContext(Dispatchers.Main){
//                webView.text = response
//            }
        }

    }
}