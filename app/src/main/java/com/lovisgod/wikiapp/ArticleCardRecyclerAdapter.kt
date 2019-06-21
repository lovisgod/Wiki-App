package com.lovisgod.wikiapp

import Holders.CardHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lovisgod.wikiapp.R

class ArticleCardRecyclerAdapter: RecyclerView.Adapter<CardHolder>() {
    override fun getItemCount(): Int {
        return 15 //temporal
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        //this is where we update our views
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        //this is where we display the views
        var cartItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_card,parent,false)
        return CardHolder(cartItem)
    }

}