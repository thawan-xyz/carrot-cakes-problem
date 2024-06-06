fun main() {
    val (cakesNeeded, bakingTime, cakesPerBatch, buildOvenTime) = readln().split(" ").map(String::toInt)

    var cakesBaked = 0
    var iOvenTimer = 0
    var jOvenTimer = 0

    while (cakesBaked < cakesNeeded) {
        iOvenTimer += 1

        if (iOvenTimer % bakingTime == 0) {
            cakesBaked += cakesPerBatch
        }

        if (iOvenTimer > buildOvenTime) {
            jOvenTimer += 1
            if (jOvenTimer % bakingTime == 0) {
                cakesBaked += cakesPerBatch
            }
        }
    }

    val timeWithOneOven = ((cakesNeeded + (cakesPerBatch - 1)) / cakesPerBatch) * bakingTime
    val timeWithTwoOvens = iOvenTimer

    println(if (timeWithOneOven > timeWithTwoOvens) "YES" else "NO")
}
