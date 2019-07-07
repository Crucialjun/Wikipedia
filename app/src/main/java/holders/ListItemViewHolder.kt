package holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import tk.crucial.wikipedia.R

class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById(R.id.result_icon)
    private val titleTextView: TextView = itemView.findViewById(R.id.result_title)


}