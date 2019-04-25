package findsolucoes.com.assetec.utils.extension

import android.content.ContextWrapper
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


fun View.getParentActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}
fun ImageView.load(url: String, progressBar: ProgressBar?, mutableLiveDataProgressState: MutableLiveData<Int>?) {
    Picasso.get().load(url)
        .centerCrop()
        .fit()
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar?.visibility = View.GONE
                mutableLiveDataProgressState?.value = View.GONE

            }
            override fun onError(e: Exception?) {}
        })
}
