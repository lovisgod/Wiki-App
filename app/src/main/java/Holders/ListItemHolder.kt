package Holders

import Models.WikiPage
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.lovisgod.wikiapp.ArticleDetailActivity
import com.lovisgod.wikiapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_card.view.*

// the CardHolder takes in an item view and extended RecyclerView ViewHolder that takes in the same itemView as parameter

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById(R.id.result_icon)
    private val articleTextView : TextView = itemView.findViewById(R.id.result_title)

    private var currentPage: WikiPage? = null

    init {
        itemView.setOnClickListener { view: View? ->
            var detailPageIntent = Intent(itemView.context, ArticleDetailActivity::class.java)
            var pageJson = Gson().toJson(currentPage)
            detailPageIntent.putExtra("page", pageJson)
            itemView.context.startActivity(detailPageIntent);
        }
    }

    fun updateWikipage(page: WikiPage){
        currentPage = page
        articleTextView.text = page.title
        if (page.thumbnail != null){

            Picasso.with(itemView.context).load(page.thumbnail!!.source).into(articleImageView)

        }
    }
}