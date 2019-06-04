package com.example.roshambill

data class GameInfo(var gameId: Int, var numberOfPlayers: Int, var serverNumber: Int) {
    override fun toString(): String {
        return "GAME ID: " + gameId.toString() + "\n" + "No. Players " +
                numberOfPlayers.toString() + "\n" + "ServerNumber " + serverNumber.toString() + "\n"
    }
}

data class TurnInfo(var playerNumber: Int, var numberPicked: Int) {

}

data class Guesses(var guesses: ArrayList<Int>) {
    override fun toString(): String {
        return guesses.toString()

    }
}
