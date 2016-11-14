package application;


public class CTabela {
private int Sala;
private String Consumo;
private String Custo;

public CTabela (int Sala, String Consumo, String Custo){
	this.Sala=Sala;
	this.Consumo=Consumo;
	this.Custo=Custo;
}
public int getSala() {
	return Sala;
}
public String getConsumo() {
	return Consumo;
}
public String getCusto() {
	return Custo;
}
public void setSala(int sala) {
	Sala = sala;
}
public void setConsumo(String consumo) {
	Consumo = consumo;
}
public void setCusto(String custo) {
	Custo = custo;
}
}
