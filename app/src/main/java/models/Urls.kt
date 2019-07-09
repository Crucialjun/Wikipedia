package models

object Urls {
    val BaseUrl = "https://en.wikipedia.org/w/api.php"

    fun getSearchUrl(term:String,skip:Int,take:Int) : String{
        return BaseUrl+
                "?action=query" +
                "&formatversion=2"+
                "&generator=prefixsearch" +
                "&gpssearch=$term" +
                "&gpslimit=$take" +
                "&gpsoffset=$skip" +
                "&prop=pageimages|info" +
                "&pipprop=thumbnail|url" +
                "&pithumbsize=200" +
                "&pilimit=$take" +
                "&wbptterms=description" +
                "&format=json" +
                "&inprop=url"
    }

    fun getRandomUrl(take: Int) : String{
        return BaseUrl +
                "?action=query" +
                "&formatversion=2"+
                "&generator=random" +
                "&grnnamespace=0" +
                "&grnlimit=$take" +
                "&prop=pageimages|info" +
                "&pithumbsize=200" +
                "&pilimit=$take" +
                "&format=json"+
                "&inprop=url"
    }
}