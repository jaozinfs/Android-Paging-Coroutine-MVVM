package findsolucoes.com.assetec.repositories

import android.util.Log
import androidx.paging.PageKeyedDataSource
import findsolucoes.com.assetec.client.RetrofitApiInterface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import findsolucoes.com.assetec.client.response.Result

class PostsDataSource(

    private val apiService: RetrofitApiInterface

) : PageKeyedDataSource<Int, Result>() {


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Result>) {
        requestLaunch( 1, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        requestLaunch( params.key + 1, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {}


    private fun requestLaunch(
        pageKey: Int,
        loadInitialCallback: LoadInitialCallback<Int, Result>?,
        callback: LoadCallback<Int, Result>?
    ) {
        GlobalScope.launch {
            try {
                val response = apiService.getMovies( page = pageKey ).await()
                when {
                    response.isSuccessful -> {
                        val listing = response.body()
                        val redditPosts = listing?.results?.map { it }
                        val list = redditPosts ?: listOf()
                        loadInitialCallback?.onResult(list, null, pageKey)
                        callback?.onResult(list, pageKey)
                    }
                }
            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }
        }
    }

}