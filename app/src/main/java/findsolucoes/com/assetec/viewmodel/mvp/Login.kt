package findsolucoes.com.assetec.viewmodel.mvp

import androidx.lifecycle.LiveData

interface Login{

    interface ViewModel{
        fun onLoginRequest()
        fun onErrorLoginRequest()
        fun getLoadingVisibility() : LiveData<Int>
        fun login()
    }

    interface View{
        fun init()
        fun showError(errorMessage: Int)
        fun hideError()
    }

}