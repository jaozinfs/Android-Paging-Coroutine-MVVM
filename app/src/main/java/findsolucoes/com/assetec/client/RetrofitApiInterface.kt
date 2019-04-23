package findsolucoes.com.assetec.client

import findsolucoes.com.assetec.client.response.MovieResult
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitApiInterface{

    @GET("popular")
    fun getMovies(@Query("api_key") key: String,
                  @Query("page") page: Int): Observable<MovieResult>
}