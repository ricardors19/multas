package br.com.cleiberio.pdf;

public class Objeto {
	String rua1;
	String rua2;
	String rua3;
	String rua4;
	String dia;
	String diaSemana;
	
	public Objeto(){
		
	}
	
	public Objeto(String r1, String r2, String r3, String r4, String d, String ds){
		setRua1(r1);
		setRua2(r2);
		setRua3(r3);
		setRua4(r4);
		setDia(d);
		setDiaSemana(ds);
	}
	
	
	public String getRua1() {
		return rua1;
	}

	public void setRua1(String rua1) {
		this.rua1 = rua1;
	}

	public String getRua2() {
		return rua2;
	}

	public void setRua2(String rua2) {
		this.rua2 = rua2;
	}

	public String getRua3() {
		return rua3;
	}

	public void setRua3(String rua3) {
		this.rua3 = rua3;
	}

	public String getRua4() {
		return rua4;
	}

	public void setRua4(String rua4) {
		this.rua4 = rua4;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
}
