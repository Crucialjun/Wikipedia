package adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import holders.CardViewHolder
import holders.ListItemViewHolder
import models.WikiPage
import tk.crucial.wikipedia.R

class ArticleListItemRecyclerAdapter : RecyclerView.Adapter<ListItemViewHolder>() {
    val currentResults : ArrayList<WikiPage> = ArrayList()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListItemViewHolder {
        var cardItem = LayoutInflater.from(p0.context).inflate(R.layout.article_list_item,p0,false)
        return ListItemViewHolder(cardItem)
    }

    override fun getItemCount(): Int {
        return currentResults.size
    }

    override fun onBindViewHolder(p0: ListItemViewHolder, p1: Int) {
        var page = currentResults[p1]
        p0.updateWithPage(page)
    }


}