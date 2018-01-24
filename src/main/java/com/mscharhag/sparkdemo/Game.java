package com.mscharhag.sparkdemo;

public class Game {

	private int id;
	private String name;
	private String tipo;
	private String cinta;
	private int registro;

    public Game(int id, String name, String tipo, String cinta, int registro) {
		this.id = id;
		this.name = name;
		this.tipo = tipo;
		this.cinta = cinta;
		this.registro = registro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    public String getCinta() { return cinta; }

    public void setCinta(String cinta) { this.cinta = cinta; }

    public int getRegistro() { return registro;  }

    public void setRegistro(int registro) { this.registro = registro; }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cinta='" + cinta + '\'' +
                ", registro=" + registro +
                '}';
    }
}
