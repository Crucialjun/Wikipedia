package repositories

import com.google.gson.Gson
import models.WikiPage
import models.WikiThumbnail
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.rowParser

class FavoritesRepository(val databaseHelper : ArticleDatabaseOpenHelper) {
    private val TABLE_NAME: String = "Favorites"

    fun addFavorite(page: WikiPage){
        databaseHelper.use { insert(TABLE_NAME,
            "id" to page.pageid,
            "title" to page.title,
            "url" to page.fullurl,
            "thumbnailJson" to Gson().toJson(page.thumbnail)) }
    }

    fun removeFavoriteByID(pageId: Int){
        databaseHelper.use { delete(TABLE_NAME,
            "id = {pageId}",
            "pageId" to pageId) }
    }

    fun isArticleFavorite(pageId: Int) : Boolean{
        var pages = getAllFavorites()
        return pages.any{ page ->
            page.pageid == pageId
        }
    }

    fun getAllFavorites() : ArrayList<WikiPage>{
        var pages = ArrayList<WikiPage>()

        val articleRowParser = rowParser{ id: Int,title : String,url: String,thumbnailJson : String ->
            val page = WikiPage()
            page.title = title
            page.pageid = id
            page.fullurl = url
            page.thumbnail = Gson().fromJson(thumbnailJson,WikiThumbnail::class.java)

            pages.add(page)

        }

        return pages
    }
}