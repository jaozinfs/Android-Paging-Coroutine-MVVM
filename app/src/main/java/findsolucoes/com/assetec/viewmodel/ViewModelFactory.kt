package findsolucoes.com.assetec.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import findsolucoes.com.assetec.client.RetrofitApiInterface
import findsolucoes.com.assetec.repositories.UserRepository
import findsolucoes.com.assetec.viewmodel.login.LoginViewModel

class ViewModelFactory( private val retrofitApiInterface: RetrofitApiInterface, private val repository: UserRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel( retrofitApiInterface, repository ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")

    }

}