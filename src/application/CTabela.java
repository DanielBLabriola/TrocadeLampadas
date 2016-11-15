package application;


public class CTabela {
private int Sala;
private String Consumo;
private String Custo;
private String CustoKWh;
private String ConsumoLed;
private String CustoKwhLed;

public CTabela (int Sala, String Consumo,String CustoKWh, String Custo,String ConsumoLed, String CustoKwhLed){
	this.Sala=Sala;
	this.Consumo=Consumo;
	this.CustoKWh=CustoKWh;
	this.Custo=Custo;
	this.ConsumoLed=ConsumoLed;
	this.CustoKwhLed=CustoKwhLed;
	}
public void setCustoKwhLed(String custoKwhLed) {
	CustoKwhLed = custoKwhLed;
}
public String getCustoKwhLed() {
	return CustoKwhLed;
}
public void setConsumoLed(String consumoLed) {
	ConsumoLed = consumoLed;
}
public String getConsumoLed() {
	return ConsumoLed;
}
public void setCustoKWh(String custoKWh) {
	CustoKWh = custoKWh;
}
public String getCustoKWh() {
	return CustoKWh;
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
