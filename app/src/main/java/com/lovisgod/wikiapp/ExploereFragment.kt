package com.lovisgod.wikiapp


import Models.WikiResult
import Provider.ArticleDataProvider
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_exploere.*
import java.lang.Exception


/**
 * A simple [Fragment] subclass.
 *
 */
class ExploereFragment : Fragment() {
    private val articleDataProvider: ArticleDataProvider = ArticleDataProvider()

    var searchCardView : CardView? = null
    var expolre_recycler: RecyclerView? = null
    var adapter: ArticleCardRecyclerAdapter = ArticleCardRecyclerAdapter()
    var refreshListener: SwipeRefreshLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_exploere, container, false)
        searchCardView = view.findViewById(R.id.search_view_card)
        expolre_recycler = view.findViewById(R.id.expolre_recycler)
        refreshListener = view.findViewById<SwipeRefreshLayout>(R.id.refresher)
        searchCardView!!.setOnClickListener {
            val searchIntent = Intent(context, SearchActivity::class.java)
            context!!.startActivity(searchIntent)
        }
        expolre_recycler!!.layoutManager = LinearLayoutManager(context)
        expolre_recycler!!.adapter =adapter

        refreshListener?.setOnRefreshListener {
            getRandomArticles()
        }
        getRandomArticles()
        return view
    }

    private fun getRandomArticles(){
        refreshListener?.isRefreshing = true
        try {
            articleDataProvider.getRandom(15) { WikiResult ->
                adapter.currentResults.clear()
                adapter.currentResults.addAll(WikiResult.query!!.pages)
                activity!!.runOnUiThread{adapter.notifyDataSetChanged()
                    refreshListener?.isRefreshing = false
                }
            }
        }catch (ex : Exception){
            //show alert
            val builder = AlertDialog.Builder(activity)
            builder.setMessage(ex.message).setTitle("OOPS!!!")
            val dailog = builder.create()
            dailog.show()
        }

    }


}
