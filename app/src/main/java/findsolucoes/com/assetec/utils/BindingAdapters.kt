package findsolucoes.com.assetec.utils

import android.app.Activity
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import findsolucoes.com.assetec.BuildConfig
import findsolucoes.com.assetec.utils.extension.getParentActivity

/**
 * SET VISIBILITY TO VIEW IN XML FROM LIVEDATA OF VIEWMODEL
 */
@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {

    val parentActivity: AppCompatActivity? = view.getParentActivity()

    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}
/**
 * SET ADAPTER FROM DATABINDING IN VIEWXML RECYCLERVIEW
 */
@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

/**
 * LOG TAG SIMPLE PASS "MESSAGE" AND SHOW WITH SIMPLECLASSNAME
 */
fun Activity.logd(message: String){
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}
fun ViewModel.logd(message: String){
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}