package findsolucoes.com.assetec.viewmodel.teste

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import findsolucoes.com.assetec.BuildConfig
import findsolucoes.com.assetec.adapter.MovieAdapter
import findsolucoes.com.assetec.client.RetrofitApiInterface
import findsolucoes.com.assetec.client.response.RedditPost
import findsolucoes.com.assetec.client.response.Result
import findsolucoes.com.assetec.view.teste.PostsDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TesteViewModel(private val retrofitApiInterface: RetrofitApiInterface) : ViewModel() {


    var postsLiveData  : LiveData<PagedList<Result>>

    init {

        val config = PagedList.Config.Builder()
            .setPageSize( 10 )
            .setEnablePlaceholders(true)
            .setPrefetchDistance(2)
            .build()

        postsLiveData  = initializedPagedListBuilder(config).build()

    }

    fun getPosts():LiveData<PagedList<Result>> = postsLiveData

    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<Int, Result> {

        val dataSourceFactory = object : DataSource.Factory<Int, Result>() {
            override fun create(): DataSource<Int, Result> {
                return PostsDataSource( retrofitApiInterface )
            }

        }
        return LivePagedListBuilder<Int, Result>(dataSourceFactory, config)
    }

}