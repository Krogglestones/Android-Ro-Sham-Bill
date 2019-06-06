package com.example.roshambill

object DataManager {

    var games = ArrayList<GameInfo>()
    var turns = ArrayList<TurnInfo>()
    var guesses = ArrayList<Guesses>()

    var numberOfPlayers = 3
    var serverNumber = 123

    var position = 0
    var gameNumber = 1

    var lowNum = 1
    var highNum = 500
    var currentPlayer = 1

    init {

        initializeGames()
        initializeTurns()
    }

    private fun initializeGames() {
//        var game = GameInfo(1, 4, 326)
//        games.add(game)

//        game = GameInfo(2, 3, 410)
//        games.add(game)
//
//        game = GameInfo(3, 6, 112)
//        games.add(game)
//
//        game = GameInfo(4, 2, 321)
//        games.add(game)
//
//        game = GameInfo(5, 5, 88)
//        games.add(game)
//
//        game = GameInfo(6, 7, 4)
//        games.add(game)
    }

    private fun initializeTurns() {
//        var turn = TurnInfo( 3, 444)
//        turns.add(turn)
//
//        turn = TurnInfo( 4, 338)
//        turns.add(turn)
//
//        turn = TurnInfo( 2, 44)
//        turns.add(turn)
//
//        turn = TurnInfo( 13, 22)
//        turns.add(turn)
//
//        turn = TurnInfo( 22, 187)
//        turns.add(turn)
//
//        turn = TurnInfo( 3, 287)
//        turns.add(turn)
    }

}
