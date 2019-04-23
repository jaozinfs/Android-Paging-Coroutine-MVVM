package findsolucoes.com.assetec.view.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import findsolucoes.com.assetec.R
import findsolucoes.com.assetec.application.AssetecApplication
import findsolucoes.com.assetec.databinding.ActivityLoginBinding
import findsolucoes.com.assetec.utils.BaseActivity
import findsolucoes.com.assetec.utils.logd
import findsolucoes.com.assetec.viewmodel.mvp.Login
import findsolucoes.com.assetec.viewmodel.login.LoginViewModel
import findsolucoes.com.assetec.viewmodel.ViewModelFactory

class LoginActivity : BaseActivity(), Login.View {


    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding
    private var errorSnackbar: Snackbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }


    //INIT ALL DEPENDENCE OF CLASS
    @SuppressLint("WrongConstant")
    override fun init() {
        //create view model
        viewModel = ViewModelProviders.of(this, viewModelFactory ).get( LoginViewModel::class.java )

        //set binding content view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        //observers from viewmodel
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })

        //binding loginviewmodel
        binding.loginViewModel = viewModel
    }

   override  fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    override fun hideError(){
        errorSnackbar?.dismiss()
    }

}