package br.com.codelab.archcomposample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.codelab.archcomposample.R
import br.com.codelab.archcomposample.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: ViewModel by lazy {
        ViewModelProviders.of(this@MainActivity).get(ViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButtonAction()

        viewModelObserver()

    }

    private fun clickButtonAction() {
        btnA.setOnClickListener { viewModel.updateTeamA() }
        btnB.setOnClickListener { viewModel.updateTeamB() }
        reset.setOnClickListener { viewModel.reset() }
    }

    private fun viewModelObserver(){
        viewModel.ScoreTeamA.observe(this, Observer { value ->
            TeamA.text = value.toString()
        })
        viewModel.ScoreTeamB.observe(this, Observer { value ->
            TeamB.text = value.toString()
        })
    }
}
