package findsolucoes.com.assetec.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import findsolucoes.com.assetec.client.RetrofitApiInterface
import findsolucoes.com.assetec.repositories.UserRepository
import findsolucoes.com.assetec.viewmodel.login.LoginViewModel
import findsolucoes.com.assetec.viewmodel.teste.TesteViewModel

class ViewModelFactory(private val context: Context, private val retrofitApiInterface: RetrofitApiInterface, private val repository: UserRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel( retrofitApiInterface, repository ) as T
        }

        if (modelClass.isAssignableFrom(TesteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TesteViewModel( retrofitApiInterface ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")

    }

}