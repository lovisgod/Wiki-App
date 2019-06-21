package com.lovisgod.wikiapp


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_exploere.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ExploereFragment : Fragment() {

    var searchCardView : CardView? = null
    var expolre_recycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_exploere, container, false)
        searchCardView = view.findViewById(R.id.search_view_card)
        expolre_recycler = view.findViewById(R.id.expolre_recycler)
        searchCardView!!.setOnClickListener {
            val searchIntent = Intent(context, SearchActivity::class.java)
            context!!.startActivity(searchIntent)
        }
        expolre_recycler!!.layoutManager = LinearLayoutManager(context)
        expolre_recycler!!.adapter = ArticleCardRecyclerAdapter()
        return view
    }


}
