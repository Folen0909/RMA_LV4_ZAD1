package hr.ferit.rma_lv4_zad1.ui.birdwatching.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.observe
import hr.ferit.rma_lv4_zad1.databinding.ActivityMainBinding
import hr.ferit.rma_lv4_zad1.model.BirdCounter
import hr.ferit.rma_lv4_zad1.persistance.PreferenceManager
import hr.ferit.rma_lv4_zad1.ui.birdwatching.viewmodels.BirdWatchingViewModel
import hr.ferit.rma_lv4_zad1.utilities.getColorResource
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<BirdWatchingViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            it.bReset.setOnClickListener { viewModel.clearData() }
            it.bBlueBird.setOnClickListener { viewModel.birdSpotted("blue") }
            it.bRedBird.setOnClickListener { viewModel.birdSpotted("red") }
            it.bGreenBird.setOnClickListener { viewModel.birdSpotted("green") }
            it.bGreyBird.setOnClickListener { viewModel.birdSpotted("grey") }
        }
        setContentView(binding.root)
        loadData()

        viewModel.birdCount.observe(this) {
            binding.tvTotalBirds.text = it.counter.toString()
            binding.tvTotalBirds.setBackgroundResource(getColorResource(it.color))
            saveData(it)
        }
    }

    private fun saveData(birdCounter: BirdCounter) {
        PreferenceManager().saveCounter(birdCounter.counter.toString())
        PreferenceManager().saveColor(birdCounter.color)
    }

    private fun loadData() {
        viewModel.loadData(PreferenceManager().retrieveCounter().toInt(), PreferenceManager().retrieveColor())
    }
}