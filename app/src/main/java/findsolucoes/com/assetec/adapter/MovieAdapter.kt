package findsolucoes.com.assetec.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import findsolucoes.com.assetec.R
import findsolucoes.com.assetec.utils.DiffUtilCallBack
import kotlinx.android.synthetic.main.list_row.view.*
import findsolucoes.com.assetec.client.response.Result
import findsolucoes.com.assetec.utils.extension.load
import findsolucoes.com.assetec.viewmodel.adapter.MovieViewModel
import findsolucoes.com.assetec.databinding.ListRowBinding
/**
 * Created by Joao Singh on 25/1/18.
 */
class MovieAdapter : PagedListAdapter<Result, MovieAdapter.MyViewHolder>(DiffUtilCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ListRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_row, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let { holder.bindItems(it) }
    }


    class MyViewHolder(private val binding: ListRowBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = MovieViewModel()

        fun bindItems(result: Result?) {

            viewModel.bind(result!!)
            binding.viewModel = viewModel

            val posterUri = Uri.parse("http://image.tmdb.org/t/p/w185/")
                .buildUpon()
                .appendEncodedPath(result.posterPath)
                .build()

            itemView.image_view_movie.load( posterUri.toString(), null, viewModel.progressVisibility )
        }
    }

    /**
     * View model provide to HolerAdapter
     *
     *
     */
    class MovieViewModel : ViewModel() {
        val postTitle = MutableLiveData<String>()
        val progressVisibility: MutableLiveData<Int> = MutableLiveData()

        fun bind(result: Result){
            postTitle.value = result.originalTitle
            progressVisibility.value = View.VISIBLE
        }
    }
}