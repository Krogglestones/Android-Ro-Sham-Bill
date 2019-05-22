package com.example.roshambill

object DataManager {

    var games = ArrayList<GameInfo>()

    init {
        initializeGames()
    }

    private fun initializeGames() {
        var game = GameInfo("1", 4, 326)
        games.add(game)

        game = GameInfo("2", 3, 410)
        games.add(game)

        game = GameInfo("3", 6, 112)
        games.add(game)

        game = GameInfo("4", 2, 321)
        games.add(game)

        game = GameInfo("5", 5, 88)
        games.add(game)

        game = GameInfo("6", 7, 4)
        games.add(game)
    }

}
