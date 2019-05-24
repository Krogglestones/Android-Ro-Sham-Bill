package com.example.roshambill

data class GameInfo(var gameId: String, var numberOfPlayers: Int, var numberPicked: Int) {

}

data class TurnInfo(var playerNumber: Int, var serverNumber: Int) {

}