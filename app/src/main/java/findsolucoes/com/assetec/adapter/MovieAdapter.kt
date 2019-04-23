package findsolucoes.com.assetec.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import findsolucoes.com.assetec.R
import kotlinx.android.synthetic.main.list_row.view.*
import java.lang.Exception
import findsolucoes.com.assetec.client.response.Result

/**
 * Created by Amanjeet Singh on 25/1/18.
 */
class MovieAdapter(val context: Context) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private var resultList: List<Result>? = mutableListOf()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(resultList?.get(position))
    }

    override fun getItemCount(): Int {
        return resultList?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.list_row,
            parent, false)
        return MyViewHolder(view)
    }

    fun updatePostList(postList:List<Result>?){
        this.resultList = postList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(result: Result?) {
            itemView.movie_title.text = result?.title
            val posterUri = Uri.parse("http://image.tmdb.org/t/p/w185/").buildUpon()
                .appendEncodedPath(result?.posterPath)
                .build()
            itemView.progress_bar.visibility = View.VISIBLE

            Picasso.get().load(posterUri.toString())
                .into(itemView.image_view_movie, object : Callback {
                    override fun onSuccess() {
                        itemView.progress_bar.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
        }
    }
}