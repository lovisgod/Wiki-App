package com.lovisgod.wikiapp

import Holders.CardHolder
import Models.WikiPage
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lovisgod.wikiapp.R

class ArticleCardRecyclerAdapter: RecyclerView.Adapter<CardHolder>() {
    val currentResults : ArrayList<WikiPage> = ArrayList<WikiPage>()

    override fun getItemCount(): Int {
        return currentResults.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        //this is where we update our views
        var page = currentResults[position]
        holder?.updateWikipage(page)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        //this is where we display the views
        var cartItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_card,parent,false)
        return CardHolder(cartItem)
    }

}