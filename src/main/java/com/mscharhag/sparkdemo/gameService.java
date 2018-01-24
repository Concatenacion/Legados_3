package com.mscharhag.sparkdemo;

import java.util.*;

public class gameService {

	private Map<String, Game> games = new HashMap<>();

	public List<Game> getAllUsers() {
		ArrayList<Game> lista = new ArrayList<>();
		for (int i = 0; i<5; i++){
			lista.add(new Game(i, "lore", "ipsum", " lore", 3 ));
		}
		return lista;
	}

	public int getCount(){
	    return 888;
    }

    public boolean existGame (int id) {
	    if (id%2==0){
	        return true;
        }
        else {
            return false;
        }

    }

    public Game findGame (int id){
	    return new Game (id, "Dos", "3", "4", 5);
    }

    public boolean existCinta (String id) {
            return true;
    }

    public String [] getAllGamesFromCinta(String id){
        String [ ] lista = {"Juego 1" ,"Juego 2"};
        return lista;
    }
}
