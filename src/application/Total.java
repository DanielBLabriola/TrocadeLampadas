package application;

public class Total {
private String edificio;
private String consumo;
private String custo;
private String tcustokwh;
private String consumoled;
private String custokwhled;
public Total(String edificio,String consumo,String tcustokwh, String custo,String consumoled,String custokwhled) {
	this.edificio=edificio;
	this.consumo=consumo;
	this.custo=custo;
	this.tcustokwh=tcustokwh;
	this.consumoled=consumoled;
	this.custokwhled=custokwhled;
	// TODO Auto-generated constructor stub
}
public String getConsumoled() {
	return consumoled;
}
public String getCustokwhled() {
	return custokwhled;
}
public void setConsumoled(String consumoled) {
	this.consumoled = consumoled;
}
public void setCustokwhled(String custokwhled) {
	this.custokwhled = custokwhled;
}

public void setTcustokwh(String tcustokwh) {
	this.tcustokwh = tcustokwh;
}
public String getTcustokwh() {
	return tcustokwh;
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
