package findsolucoes.com.assetec.application

import android.app.Application
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
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
            val r = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()

            r.create(RetrofitApiInterface::class.java)
        }


        bind<AssetecDatabase>() with singleton { Room.databaseBuilder(applicationContext, AssetecDatabase::class.java, "assetec-database-v1").build() }

        bind<UserRepository>() with singleton { UserRepository(instance()) }

        bind() from provider { ViewModelFactory( instance(), instance() ) }


    }
}