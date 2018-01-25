package com.mscharhag.sparkdemo;

import java.util.List;

import static spark.Spark.*;
import static com.mscharhag.sparkdemo.JsonUtil.*;


public class gameController {

	public gameController(final gameService gameService) {

		get("/numbers", (req, res) -> { return 9999; }, json());

		get("/game/:id", (req, res) -> {
			System.out.println(req.params(":id"));
			String id_S = req.params(":id");
			int id = Integer.parseInt(id_S);
			if (gameService.existGame(id)) {
				return gameService.findGame(id).toString();
			}
			res.status(400);
			return new ResponseError("No game with id "+ id +" found");
		}, json());

		get("/cinta/:id", (req, res) -> {
			System.out.println(req.params(":id"));
			String id = req.params(":id");
			if (gameService.existCinta(id)) {

				return gameService.getAllGamesFromCinta(id);
			}
			res.status(400);
			return new ResponseError("No game with id '%s' found", id);
		}, json());

		after((req, res) -> {
			res.type("application/json");
		});

		exception(IllegalArgumentException.class, (e, req, res) -> {
			res.status(400);
			res.body(toJson(new ResponseError(e)));
		});
	}
}
