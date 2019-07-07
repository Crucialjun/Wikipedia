package adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import holders.CardViewHolder
import tk.crucial.wikipedia.R

class ArticleCardRecyclerAdapter : RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardViewHolder {
        var cardItem = LayoutInflater.from(p0.context).inflate(R.layout.article_card_item,p0,false)
        return CardViewHolder(cardItem)
    }

    override fun getItemCount(): Int {
        return 15
    }

    override fun onBindViewHolder(p0: CardViewHolder, p1: Int) {
    }

}