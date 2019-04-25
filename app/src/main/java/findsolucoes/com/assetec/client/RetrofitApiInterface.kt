package findsolucoes.com.assetec.client

import findsolucoes.com.assetec.client.ApiEndPoints.MOVIE_KEY
import findsolucoes.com.assetec.client.response.MovieResult
import findsolucoes.com.assetec.client.response.RedditApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiInterface{

    @GET("/r/aww/hot.json")
    fun fetchPosts(
        @Query("limit") loadSize: Int = 30,
        @Query("after") after: String? = null,
        @Query("before") before: String? = null
    ) : Deferred<Response<RedditApiResponse>>


    @GET("popular")
    fun getMovies(@Query("api_key") key: String = MOVIE_KEY,
                  @Query("page") page: Int? = null,
                  @Query("before") before: Int? = null): Deferred<Response<MovieResult>>
}