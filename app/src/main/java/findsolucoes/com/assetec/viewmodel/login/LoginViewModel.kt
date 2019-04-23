package findsolucoes.com.assetec.viewmodel.login


import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import findsolucoes.com.assetec.R
import findsolucoes.com.assetec.client.RetrofitApiInterface
import findsolucoes.com.assetec.repositories.UserRepository
import findsolucoes.com.assetec.viewmodel.mvp.Login



class LoginViewModel(
    private val retrofitApi: RetrofitApiInterface,
    private val repository: UserRepository
) : ViewModel(), Login.ViewModel {

    //progress login
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    override fun getLoadingVisibility(): LiveData<Int> = loadingVisibility


    //snackbar toast
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { onLoginRequest() }

    init {
        //start progress login view visibility gone
        loadingVisibility.value = View.GONE
    }




    /*
     Click from layout bind onClick action
     */
    @SuppressLint("CheckResult")
    override fun onLoginRequest() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    //error request response
    override fun onErrorLoginRequest() {
        loadingVisibility.value = View.GONE
        errorMessage.value = R.string.post_error
    }

    @SuppressLint("CheckResult")
    override fun login() {}


}