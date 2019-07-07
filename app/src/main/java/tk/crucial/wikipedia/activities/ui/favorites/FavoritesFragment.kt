package tk.crucial.wikipedia.activities.ui.favorites

import adapters.ArticleListItemRecyclerAdapter
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
import kotlinx.android.synthetic.main.fragment_favorites.*
import tk.crucial.wikipedia.R

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel
    var favoritesArticleRecycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritesViewModel =
            ViewModelProviders.of(this).get(FavoritesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favorites, container, false)


        favoritesArticleRecycler = root.findViewById(R.id.favorites_article_recycler)
        favoritesArticleRecycler!!.layoutManager = LinearLayoutManager(context)
        favoritesArticleRecycler!!.adapter =ArticleListItemRecyclerAdapter()
        return root
    }
}