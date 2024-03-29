package com.lovisgod.wikiapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_favourites.*
import kotlinx.android.synthetic.main.fragment_history.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 *
 */
class HistoryFragment : Fragment() {

    var article_history_recycler : RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_history, container, false)

        article_history_recycler= view.findViewById(R.id.article_history_recycler)
        article_history_recycler!!.layoutManager = LinearLayoutManager(context)
        article_history_recycler!!.adapter = ArticleListRecyclerAdapter()
        return view
    }


}
