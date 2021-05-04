package hr.ferit.rma_lv4_zad1.model

class BirdCounter(
    var counter: Int = 0,
    var color: String = "white"
) {

    fun birdSpotted(color: String) {
        this.color = color
        this.counter++
    }

    fun clearData() {
        this.color = "white"
        this.counter = 0
    }
}