fun main() {
    val (cakesNeeded, bakingTime, cakesPerBatch, buildOvenTime) = readln().split(" ").map(String::toInt)

    var cakesBaked = 0
    var ovenTimer = 0

    while (cakesBaked < cakesNeeded) {
        ovenTimer += 1

        if (ovenTimer % bakingTime == 0) {
            cakesBaked += cakesPerBatch
        }

        if (ovenTimer > buildOvenTime) {
            if ((ovenTimer - buildOvenTime) % bakingTime == 0) {
                cakesBaked += cakesPerBatch
            }
        }
    }

    val timeWithOneOven = ((cakesNeeded + (cakesPerBatch - 1)) / cakesPerBatch) * bakingTime
    val timeWithTwoOvens = ovenTimer

    println(if (timeWithOneOven > timeWithTwoOvens) "YES" else "NO")
}
