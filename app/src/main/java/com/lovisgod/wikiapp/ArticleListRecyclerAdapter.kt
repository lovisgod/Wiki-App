package com.lovisgod.wikiapp

import Holders.CardHolder
import Holders.ListItemHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lovisgod.wikiapp.R

class ArticleListRecyclerAdapter: RecyclerView.Adapter<ListItemHolder>() {
    override fun getItemCount(): Int {
        return 15 //temporal
    }

    override fun onBindViewHolder(holder:ListItemHolder, position: Int) {
        //this is where we update our views
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        //this is where we display the views
        var ListItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_list_istem,parent,false)
        return ListItemHolder(ListItem)
    }

}