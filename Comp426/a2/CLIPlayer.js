var CLIPlayer = function(game, cli_output, myTable, is_player_one, fleet_info, forward, backward, rotatecw, rotateccw) {
    if (is_player_one) {
        var key = game.registerPlayerOne();
        var thisClass = 'p1';
    } else {
        key2 = game.registerPlayerTwo();
        thisClass = 'p2';
    }

    cli_output = $(cli_output);
    myTable = $(myTable);
    fleet_info = $(fleet_info);
    forward = $(forward);
    backward = $(backward);
    rotateCW = $(rotatecw);
    rotateCCW = $(rotateccw);

    var eventLogHandler = function(e) {
        var cli_msg = $('<div class="cli_msg"></div>');

        switch (e.event_type) {
            case SBConstants.TURN_CHANGE_EVENT:
                if (e.who == SBConstants.PLAYER_ONE) {
                    cli_msg.text("Player one's turn (count = " + game.getTurnCount() + ")");
                } else {
                    cli_msg.text("Player two's turn (count = " + game.getTurnCount() + ")");
                }
                break;
            case SBConstants.MISS_EVENT:
                cli_msg.text("Miss event at (" + e.x + ", " + e.y + ")");
                break;
            case SBConstants.HIT_EVENT:
                cli_msg.text("Hit event at (" + e.x + ", " + e.y + ")");
                break;
            case SBConstants.SHIP_SUNK_EVENT:
                var ship = e.ship;
                if (ship.isMine(key)) {
                    var pos = ship.getPosition(key);
                    cli_msg.text("Foe sunk your " + ship.getName() + " at (" + pos.x + ", " + pos.y + ")");
                } else {
                    var pos = ship.getPosition(null); // This works because ship is dead.
                    cli_msg.text("You sunk their " + ship.getName() + " at (" + pos.x + ", " + pos.y + ")");
                }
                break;
            case SBConstants.GAME_OVER_EVENT:
                if (is_player_one && e.winner == SBConstants.PLAYER_ONE) {
                    cli_msg.text("Game over. You win!");
                } else {
                    cli_msg.text("Game over. You lose!");
                }
                break;
        }
        cli_output.prepend(cli_msg);
    };

    game.registerEventHandler(SBConstants.TURN_CHANGE_EVENT,
        eventLogHandler);
    game.registerEventHandler(SBConstants.MISS_EVENT,
        eventLogHandler);
    game.registerEventHandler(SBConstants.HIT_EVENT,
        eventLogHandler);
    game.registerEventHandler(SBConstants.SHIP_SUNK_EVENT,
        eventLogHandler);


    var mapDrawHandler = function(e) {
        myTable.empty();
        for (y = 0; y < game.getBoardSize(); y++) {
            var row = $("<tr>", { class: "myRow table-bordered" });
            for (x = 0; x < game.getBoardSize(); x++) {
                var sqr = game.queryLocation(key, x, y);
                var column = $("<td>", { class: "myColumn table-bordered" }).append($("<span>", { style: "display: none" }));
                switch (sqr.type) {
                    case "empty":
                        //Could view p2
                        column.addClass("emptySea");
                        break;
                    case "invisible":
                        column.addClass("invisibleSea");
                        break;
                    case "miss":
                        column.addClass("miss");
                        break;
                    case "p1":
                        if (sqr.state == SBConstants.OK) {
                            column.addClass("p1-okay p1");
                        } else {
                            column.addClass("p1-hit p1");
                        }
                        break;
                    case "p2":
                        if (sqr.state == SBConstants.OK) {
                            column.addClass("p2-okay p2");
                        } else {
                            column.addClass("p2-hit p2");
                        }
                        break;
                }
                row.append(column);
            }
            myTable.append(row);
        }
    };

    game.registerEventHandler(SBConstants.TURN_CHANGE_EVENT, mapDrawHandler);

    myTable.on("click", "tr.myRow td.myColumn", function(e) {
        if ($(e.target).hasClass(thisClass)) {
            console.log("Friendly Fire");
            alert("Friendly Fire is not Allowed");
        } else if ($(e.target).hasClass("p2-hit")) {
            alert("Ship Already Hit");
        } else {
            game.shootAt(key, e.target.cellIndex, e.target.parentNode.rowIndex);
        }
    });

    fleet_info.on('click', function() {
        var fleet = game.getFleetByKey(key);
        var fleet_ul = $('<ul></ul>');
        fleet.forEach(function(s) {
            var output_str = "<li>" + s.getName();
            var ship_pos = s.getPosition(key);
            output_str += "<ul>";
            output_str += "<li>Position: " + ship_pos.x + ", " + ship_pos.y + "</li>";
            output_str += "<li>Direction: " + ship_pos.direction + "</li>";
            output_str += "<li>Size: " + s.getSize() + "</li>";
            if (s.getStatus() == SBConstants.ALIVE) {
                output_str += "<li>Status: ALIVE</li>";
            } else {
                output_str += "<li>Status: DEAD</li>";
            }
            output_str += "</ul></li>";
            fleet_ul.append(output_str);
        });
        cli_output.prepend($('<div class="cli_msg"></div>').append(fleet_ul));
    });

    rotateCW.on('click', function() {
        var ship = game.getShipByName(key, document.getElementById('ship').value);
        if (ship != null) {
            game.rotateShipCW(key, ship);
        }
    });

    rotateCCW.on('click', function() {
        var ship = game.getShipByName(key, document.getElementById('ship').value);
        if (ship != null) {
            game.rotateShipCCW(key, ship);
        }
    });

    forward.on('click', function() {
        var ship = game.getShipByName(key, document.getElementById('ship').value);
        if (ship != null) {
            game.moveShipForward(key, ship);
        }
    });

    backward.on('click', function() {
        var ship = game.getShipByName(key, document.getElementById('ship').value);
        if (ship != null) {
            game.moveShipBackward(key, ship);
        }
    });

};
