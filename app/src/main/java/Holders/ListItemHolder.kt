package Holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.lovisgod.wikiapp.R
import kotlinx.android.synthetic.main.article_card.view.*

// the CardHolder takes in an item view and extended RecyclerView ViewHolder that takes in the same itemView as parameter

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById(R.id.result_icon)
    private val articleTextView : TextView = itemView.findViewById(R.id.result_title)
}