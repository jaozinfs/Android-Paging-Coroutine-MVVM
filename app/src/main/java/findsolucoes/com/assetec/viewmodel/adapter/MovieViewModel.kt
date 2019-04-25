package findsolucoes.com.assetec.viewmodel.adapter

import android.net.Uri
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import findsolucoes.com.assetec.client.response.Result


class MovieViewModel : ViewModel() {

    val postTitle = MutableLiveData<String>()
    val progressVisibility: MutableLiveData<Int>  = MutableLiveData()

    fun bind(result: Result){
        postTitle.value = result.originalTitle
        progressVisibility.value = View.VISIBLE
    }


}