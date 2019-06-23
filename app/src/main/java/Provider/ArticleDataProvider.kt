package Provider

import Models.WikiResult
import Models.urls
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Handler
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import java.io.Reader
import java.lang.Exception

class ArticleDataProvider {

    init {
        // here we setup an header
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "Psirius Wikipedia")
    }

    fun search(term:String, skip:Int,take:Int, responseHandler: (result:WikiResult)-> Unit?){
     urls.getSearchUrl(term, skip, take).httpGet()
         .responseObject(WikiPediaDataDeserializer()){_, response, result->
            if (response.httpStatusCode != 200){
                throw Exception("Unable to get Articles")
            }
             val(data, _) = result //get both data and error from result
             responseHandler.invoke(data as WikiResult) // here we invoke the data as the wikiresult class

         }
    }

    fun getRandom(take:Int, responseHandler: (result:WikiResult)-> Unit?){
        urls.getRandomUrl( take).httpGet()
            .responseObject(WikiPediaDataDeserializer()){_, response, result->
                if (response.httpStatusCode != 200){
                    throw Exception("Unable to get articles")
                }
                val(data, _) = result //get both data and error from result
                responseHandler.invoke(data as WikiResult) // here we invoke the data as the wikiresult class

            }
    }

    class WikiPediaDataDeserializer : ResponseDeserializable<WikiResult>{
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, WikiResult :: class.java)
    }
}
