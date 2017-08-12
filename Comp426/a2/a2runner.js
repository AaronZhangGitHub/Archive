$(document).ready(function () {
    var game = new SuperBattleship({boardSize:30});
    console.log(game.getStatus());
    var cli_player_one = new CLIPlayer(game,
				       $('#p1_cli_output'), $('#myTable'), true, $('#fleet_info'),$('#forward'),$('#backward'), $('#rotatecw'), $('#rotateccw'));
    var ai_player_two = new DumbAI(game, false);
    game.startGame();
});
