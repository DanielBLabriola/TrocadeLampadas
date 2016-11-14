package application;

public class Total {
private String edificio;
private String consumo;
private String custo;
public Total(String edificio,String consumo, String custo) {
	this.edificio=edificio;
	this.consumo=consumo;
	this.custo=custo;
	// TODO Auto-generated constructor stub
}
public void setConsumo(String consumo) {
	this.consumo = consumo;
}
public void setCusto(String custo) {
	this.custo = custo;
}
public void setEdificio(String edificio) {
	this.edificio = edificio;
}
public String getConsumo() {
	return consumo;
}
public String getCusto() {
	return custo;
}
public String getEdificio() {
	return edificio;
}

}
