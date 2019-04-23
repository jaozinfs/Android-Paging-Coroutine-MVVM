package findsolucoes.com.assetec.utils

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.AppCompatActivityInjector
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity
import com.github.salomonbrys.kodein.instance
import findsolucoes.com.assetec.application.AssetecApplication
import findsolucoes.com.assetec.client.RetrofitApiInterface
import findsolucoes.com.assetec.database.AssetecDatabase
import findsolucoes.com.assetec.viewmodel.ViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import retrofit2.Retrofit

open class BaseActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()

    //ViewModel factory by Kodein instance
    val viewModelFactory: ViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)


    }


}