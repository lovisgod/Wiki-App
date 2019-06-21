package com.lovisgod.wikiapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_favourites.*


/**
 * A simple [Fragment] subclass.
 *
 */
class FavouritesFragment : Fragment() {

    var favourite_recycler : RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_favourites, container, false)
        favourite_recycler = view.findViewById(R.id.favourite_recycler)

        favourite_recycler!!.layoutManager = LinearLayoutManager(context)
        favourite_recycler!!.adapter = ArticleCardRecyclerAdapter()
        return view
    }


}
