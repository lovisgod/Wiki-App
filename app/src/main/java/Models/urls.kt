package Models

object urls {
    val BaseUrl = "https://en.wikipedia.org/w/api.php"
    fun getSearchUrl(term:String, skip:Int,take:Int) : String {
        return BaseUrl + "?action=query"+
                "&formatversion=2" +
                "&generator=prefixsearch" +
                "&gpssearch=$term" +
                "&gpslimit=$take" +
                "&gpsoffset=$skip" +
                "&prop=pageimages|info" +
                "&piprop=thumbnail|url" +
                "&pitthumsize=200" +
                "&pilimit=$take" +
                "&wbptterms=description" +
                "&format=json" +
                "&inprop=url"
    }

    fun getRandomUrl(take:Int) : String{
        return BaseUrl + "?action=query"+
                "&formatversion=2" +
                "&generator=random" +
                "&prop=pageimages|info" +
                "&grnnamespace=0"+
                "&grnlimit=$take" +
                "&pitthumsize=200" +
                "&format=json" +
                "&inprop=url"
    }
}