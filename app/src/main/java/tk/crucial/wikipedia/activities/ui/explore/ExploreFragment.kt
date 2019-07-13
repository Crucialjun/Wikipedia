package tk.crucial.wikipedia.activities.ui.explore

import adapters.ArticleCardRecyclerAdapter
import android.app.AlertDialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_explore.*
import managers.WikiManager
import org.jetbrains.anko.support.v4.act
import providers.ArticleDataProvider
import tk.crucial.wikipedia.R
import tk.crucial.wikipedia.activities.SearchActivity
import java.lang.Exception

class ExploreFragment : Fragment() {
    private var wikiManager : WikiManager? = null


    private lateinit var exploreViewModel: ExploreViewModel
    var searchCardView: CardView? = null
    var exploreRecycler: RecyclerView? = null
    var adapter: ArticleCardRecyclerAdapter = ArticleCardRecyclerAdapter()
    var refresher : SwipeRefreshLayout? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        wikiManager = (activity?.applicationContext as WikiApplication).wikiManager
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exploreViewModel =
            ViewModelProviders.of(this).get(ExploreViewModel::class.java)
        var view = inflater.inflate(R.layout.fragment_explore, container, false)


        searchCardView = view.findViewById(R.id.search_card_view)
        refresher = view.findViewById<SwipeRefreshLayout>(R.id.refresher)
        searchCardView!!.setOnClickListener {
            val searchIntent = Intent(context, SearchActivity::class.java)
            context!!.startActivity(searchIntent)
        }


        exploreRecycler = view.findViewById(R.id.explore_article_recycler)
        exploreRecycler!!.layoutManager = LinearLayoutManager(context)
        exploreRecycler!!.adapter =  adapter

        refresher?.setOnRefreshListener {
            getRandomArticles()
        }

        getRandomArticles()

        return view
    }

    private fun getRandomArticles(){
        refresher?.isRefreshing = true

        try {
            articleProvider.getRandom(15) { wikiResult ->
                adapter.currentResults.clear()
                adapter.currentResults.addAll(wikiResult.query!!.pages)
                activity!!.runOnUiThread { adapter.notifyDataSetChanged()
                    refresher?.isRefreshing = false
                }
            }
        }catch (ex:Exception){
            val builder = AlertDialog.Builder(activity)
            builder.setMessage(ex.message).setTitle("Oops")
            val dialog = builder.create()
            dialog.show()
        }


    }
    }


