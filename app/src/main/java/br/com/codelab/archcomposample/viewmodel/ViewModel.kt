package br.com.codelab.archcomposample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    var ScoreTeamA = MutableLiveData<Int>().apply { value = 0 }
    var ScoreTeamB = MutableLiveData<Int>().apply { value = 0 }

    fun updateTeamA() {
        update(ScoreTeamA)
    }

    fun updateTeamB() {
        update(ScoreTeamB)

    }

    fun update(score: MutableLiveData<Int>) {
        val value = score.value ?: 0
        score.value = value + 1
    }

    fun reset() {
        ScoreTeamA.value = 0
        ScoreTeamB.value = 0

    }
}
