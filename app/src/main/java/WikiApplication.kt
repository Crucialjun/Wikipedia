import android.app.Application
import managers.WikiManager
import providers.ArticleDataProvider
import repositories.ArticleDatabaseOpenHelper
import repositories.FavoritesRepository
import repositories.HistoryRepository

class WikiApplication : Application() {
    private var dbHelper : ArticleDatabaseOpenHelper? = null
    private var favoritesRepository : FavoritesRepository? = null
    private var historyRepository : HistoryRepository? = null
    private var wikiProvider : ArticleDataProvider? = null
    var wikiManager : WikiManager? = null
        private set

    override fun onCreate() {
        super.onCreate()

        dbHelper = ArticleDatabaseOpenHelper(applicationContext)
        favoritesRepository = FavoritesRepository(dbHelper!!)
        historyRepository = HistoryRepository(dbHelper!!)
        wikiProvider = ArticleDataProvider()
        wikiManager = WikiManager(wikiProvider!!, favoritesRepository!!, historyRepository!!)

    }
}