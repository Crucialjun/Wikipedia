package holders

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import models.WikiPage
import tk.crucial.wikipedia.R
import tk.crucial.wikipedia.activities.ArticleDetailActivity

class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById(R.id.result_icon)
    private val titleTextView: TextView = itemView.findViewById(R.id.result_title)

    private var currentPage: WikiPage? = null

    init {
        itemView.setOnClickListener{ view : View? ->
            var detailPageIntent = Intent(itemView.context, ArticleDetailActivity::class.java)
            var pagejson = Gson().toJson(currentPage)
            detailPageIntent.putExtra("page",pagejson)
            itemView.context.startActivity(detailPageIntent)
        }
    }

    fun updateWithPage (page: WikiPage){
        currentPage = page

        titleTextView.text = page.title

        if(page.thumbnail != null)
            Picasso.get().load(page.thumbnail!!.source).into(articleImageView)
    }
}