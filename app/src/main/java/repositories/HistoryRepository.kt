package repositories

import com.google.gson.Gson
import models.WikiPage
import models.WikiThumbnail
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.rowParser
import java.nio.file.Files.delete

class HistoryRepository (val databaseHelper :ArticleDatabaseOpenHelper) {
    private val TABLE_NAME: String = "History"

    fun addHistory(page: WikiPage){
        databaseHelper.use { insert(TABLE_NAME,
            "id" to page.pageid,
            "title" to page.title,
            "url" to page.fullurl,
            "thumbnailJson" to Gson().toJson(page.thumbnail)) }
    }

    fun removeHistoryByID(pageId: Int){
        databaseHelper.use { delete(TABLE_NAME,
            "id = {pageId}",
            "pageId" to pageId) }
    }



    fun getAllHistory() : ArrayList<WikiPage>{
        var pages = ArrayList<WikiPage>()

        val articleRowParser = rowParser{ id: Int,title : String,url: String,thumbnailJson : String ->
            val page = WikiPage()
            page.title = title
            page.pageid = id
            page.fullurl = url
            page.thumbnail = Gson().fromJson(thumbnailJson, WikiThumbnail::class.java)

            pages.add(page)

        }

        return pages
    }
}