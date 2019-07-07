package tk.crucial.wikipedia.activities.ui.explore

import adapters.ArticleCardRecyclerAdapter
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_explore.*
import tk.crucial.wikipedia.R
import tk.crucial.wikipedia.activities.SearchActivity

class ExploreFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel
    var searchCardView: CardView? = null
    var exploreRecycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exploreViewModel =
            ViewModelProviders.of(this).get(ExploreViewModel::class.java)
        var view = inflater.inflate(R.layout.fragment_explore, container, false)


        searchCardView = view.findViewById(R.id.search_card_view)
        searchCardView!!.setOnClickListener {
            val searchIntent = Intent(context, SearchActivity::class.java)
            context?.startActivity(searchIntent)
        }


        exploreRecycler = view.findViewById(R.id.explore_article_recycler)
        exploreRecycler!!.layoutManager = LinearLayoutManager(context)
        exploreRecycler!!.adapter = ArticleCardRecyclerAdapter()

        return view
    }

}
