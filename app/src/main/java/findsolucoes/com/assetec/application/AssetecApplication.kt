package findsolucoes.com.assetec.application

import android.app.Application
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import findsolucoes.com.assetec.BuildConfig
import findsolucoes.com.assetec.client.RetrofitApiInterface
import findsolucoes.com.assetec.database.AssetecDatabase
import findsolucoes.com.assetec.repositories.UserRepository
import findsolucoes.com.assetec.viewmodel.ViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor



/**
 * Application control of class
 *
 */
class AssetecApplication : Application(), KodeinAware {

    var database: AssetecDatabase? = null


    /**
     * Dependence Injection Initialize bind of class
     *
     */
    override val kodein: Kodein = Kodein {

        bind<RetrofitApiInterface>() with singleton {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            val r = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(BuildConfig.BASE_URL)
                .client(httpClient.build())
                .build()

            r.create(RetrofitApiInterface::class.java)
        }


        bind<AssetecDatabase>() with singleton { Room.databaseBuilder(applicationContext, AssetecDatabase::class.java, "assetec-database-v1").build() }

        bind<UserRepository>() with singleton { UserRepository(instance()) }

        bind() from provider { ViewModelFactory( applicationContext, instance(), instance() ) }


    }
}