package tk.crucial.wikipedia.activities.ui.history

import adapters.ArticleCardRecyclerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_history.*
import tk.crucial.wikipedia.R

class HistoryFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel
    var historyArticleRecycler: RecyclerView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historyViewModel =
            ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_history, container, false)

        historyArticleRecycler = root.findViewById(R.id.history_article_recycler)
        historyArticleRecycler!!.layoutManager = LinearLayoutManager(context)
        historyArticleRecycler!!.adapter = ArticleCardRecyclerAdapter()

        return root
    }
}