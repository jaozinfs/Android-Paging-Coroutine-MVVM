package findsolucoes.com.assetec.utils

import androidx.recyclerview.widget.DiffUtil
import findsolucoes.com.assetec.client.response.Result

class DiffUtilCallBack : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }
}