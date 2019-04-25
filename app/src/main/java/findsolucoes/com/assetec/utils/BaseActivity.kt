package findsolucoes.com.assetec.utils

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import findsolucoes.com.assetec.viewmodel.ViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

open class BaseActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()

    //ViewModel factory by Kodein instance
    val viewModelFactory: ViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)


    }


}