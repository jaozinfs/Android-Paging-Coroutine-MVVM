package findsolucoes.com.assetec.view.teste
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import findsolucoes.com.assetec.R
import findsolucoes.com.assetec.adapter.MovieAdapter
import findsolucoes.com.assetec.mvp.Teste
import findsolucoes.com.assetec.utils.BaseActivity
import findsolucoes.com.assetec.viewmodel.teste.TesteViewModel

import kotlinx.android.synthetic.main.activity_teste.*


class Testeapi : BaseActivity(), Teste.View {

    private lateinit var viewModel: TesteViewModel
    val postListAdapter: MovieAdapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        initViewmodel()
        observedatas()
        listInit()
    }

    override fun initViewmodel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory ).get( TesteViewModel::class.java )
    }

    override  fun observedatas() {
        viewModel.getPosts().observe(this, Observer {
            postListAdapter.submitList(it)
        })
    }

    override fun listInit() {
        postList.layoutManager = LinearLayoutManager(this)
        postList.adapter = postListAdapter
    }
}