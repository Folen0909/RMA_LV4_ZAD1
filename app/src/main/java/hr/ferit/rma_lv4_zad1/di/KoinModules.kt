package hr.ferit.rma_lv4_zad1.di

import hr.ferit.rma_lv4_zad1.model.BirdCounter
import hr.ferit.rma_lv4_zad1.ui.birdwatching.viewmodels.BirdWatchingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory<BirdCounter> { BirdCounter() }
}

val viewModelModule = module {
    viewModel<BirdWatchingViewModel> { BirdWatchingViewModel(get()) }
}