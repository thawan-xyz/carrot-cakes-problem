import kotlin.math.*

fun main() {
    val (cakesNeeded, bakingTime, cakesPerBatch, buildOvenTime) = readln().split(" ").map(String::toInt)

    var cakesBaked = 0
    var primaryOvenTimer = 0
    var secondaryOvenTimer = 0

    while (cakesBaked < cakesNeeded) {
        primaryOvenTimer += 1

        if (primaryOvenTimer % bakingTime == 0) {
            cakesBaked += cakesPerBatch
        }

        if (primaryOvenTimer > buildOvenTime) {
            secondaryOvenTimer += 1
            if (secondaryOvenTimer % bakingTime == 0) {
                cakesBaked += cakesPerBatch
            }
        }
    }

    val timeWithOneOven = ceil(cakesNeeded.toDouble() / cakesPerBatch.toDouble()) * bakingTime
    val timeWithTwoOvens = primaryOvenTimer

    println(if (timeWithOneOven > timeWithTwoOvens) "YES" else "NO")
}
