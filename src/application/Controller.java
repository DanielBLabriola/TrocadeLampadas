package application;

import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebEngine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Controller implements Initializable  {
	
	int NumSalas;// numero de salas
	
	int NS=0;
		
		ArrayList<Object> CT=new ArrayList<>();
	
	    ArrayList<String> TipoLampada = new ArrayList<String>();
	    ArrayList<Integer> NumerodeLampadas=new ArrayList<Integer>();
	    ArrayList<Integer> PotenciadaLampadas=new ArrayList<Integer>();
	    ArrayList<Integer> TempoLampadas=new ArrayList<Integer>();
	   
	    ArrayList<String> custodasLampadas = new ArrayList<String>();
	    ArrayList<String> custoKWh = new ArrayList<String>();
	    ArrayList<String> custoKWhLED = new ArrayList<String>();
	    ArrayList<String> consumo = new ArrayList<String>(); 
	    ArrayList<String> consumoLED = new ArrayList<String>(); 
	  
	double totalLampadas=0;
	double totalConsumo=0;
	double totalConsumoLED;
	double custokWhtotal;
	double custokWhtotalLED;
	
	
	double TaxaTE=0.22402;
	double TaxaTTUSD=0.17038;
	double PLED120=44.76;
	double PLED60=34.76;
	
	int NumerodeMeses;
	double parcela;
	boolean dados=false;
	
	@FXML
	public TabPane TabPane;
	//passo 1 Variaveis 
	@FXML
    private Button btnSair;
	
	@FXML
	private Button btnAvanTelaIn;
    
    @FXML
    private Tab TabTelainicial;
   
    
   
    
    //passo2
    @FXML
    public  Tab TabInfo;
    
    @FXML
    private Button btnConfInfo;
    
    @FXML
    private Hyperlink Hiperlink;
    
    @FXML
    private TextField txtPLED120;
    
    @FXML
    private TextField txtPLED60;
    
    @FXML
    private TextField txtTaxaTUSD;
    
    @FXML
    private TextField txtTaxaTE;

    
    //passo 3
    @FXML
    private Button btnNumS;
    
    @FXML
    private TextField txtNumS;
    
    @FXML
    public Tab TabNumS;
    
    //passo 4 //loop
    
   @FXML
    private ComboBox combTipodeLamp;
    
    @FXML
    private TextField txtNumdeLamp;
    
    @FXML
    private TextField txtPotLamp;
    
    @FXML
    private TextField txtTempLig;
    
    @FXML
    private Button btnRep;
    
    @FXML
    private Button BtnAvanLoop;
    
    @FXML
   private Label lblSalaN;
    
    @FXML
    private Tab TabLoop;
    
    //passo 5
    
    @FXML
    private Tab TabTabela;
    
    //tabela 
    @FXML
    private TableView<CTabela> Tabela;
    @FXML
    private TableColumn<CTabela, String> colConsumo;

    @FXML
    private TableColumn<CTabela, Integer> colSala;
    @FXML
    private TableColumn<CTabela, String> colCusto;
    
    @FXML
    private TableColumn<CTabela, String> CustoKWh;
    @FXML
    private TableColumn<CTabela, String> CustoKwhLed;
    @FXML
    private TableColumn<CTabela, String> ConsumoLed;

    private List<CTabela> lisTabela = new ArrayList();

    private ObservableList<CTabela> observableListTabela;
    //total
    @FXML
    private TableView<Total> total;
    @FXML
    private TableColumn<Total, String> tconsumo;

    @FXML
    private TableColumn<Total, Integer> edificio;
    @FXML
    private TableColumn<Total, String> tcusto;
    @FXML
    private TableColumn<Total, String> tcustokwh;
    @FXML
    private TableColumn<Total, String> ConsumoLedT;
    @FXML
    private TableColumn<Total, String> CustoKwhLedT;
   
    private List<Total> lisTotal = new ArrayList();

    private ObservableList<Total> observableListTotal;
    
    //passo 6
    @FXML
    private Tab TabSalvar;
    
    @FXML
    private RadioButton rbSim;
    @FXML
    private RadioButton rbNao;
    
    
    //passo 7
    @FXML
    private Tab TabSimular;
    @FXML
    private TextField txtMeses;
    
    //passo 8
    @FXML
    private Tab TabGrafico;
    @FXML
    private LineChart<String, Integer> Grafico;
    
    ArrayList<String> MESES = new ArrayList<String>(); 
    
    //passo 9
    @FXML
    private Tab TabFinal;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		TabInfo.setDisable(true);
		TabNumS.setDisable(true);
		TabLoop.setDisable(true);
		TabTabela.setDisable(true);
		TabSalvar.setDisable(true);
		TabSimular.setDisable(true);
		TabGrafico.setDisable(true);
		TabFinal.setDisable(true);
		
		  
		  
		  
		 txtTaxaTE.setDisable(true);
		  txtTaxaTUSD.setDisable(true);
		  txtPLED120.setDisable(true);
		  txtPLED60.setDisable(true);
		  btnConfInfo.setDisable(true);
		  
		  
		  combTipodeLamp.getItems().removeAll(combTipodeLamp.getItems());
		  combTipodeLamp.getItems().addAll("Fluorescente 120cm", "Fluorescente 60cm");
		  combTipodeLamp.getSelectionModel().select("Selecione o tipo de lâmpada!");
		  
		  
		  ToggleGroup group = new ToggleGroup();
		  rbSim.setToggleGroup(group);
		    rbSim.setSelected(true);
		     rbNao.setToggleGroup(group);
	}
    //passo 1 funçoes
	 @FXML
	    private void Sair(){
	    	System.exit(0);
	    	
	    }
	 
	    @FXML
	    private void AvantTelainicial(){

	    	TabTelainicial.setDisable(true);
	    	TabPane.getSelectionModel().select(TabInfo);
	    	TabInfo.setDisable(false);
	     
	    	}
	    
	    //passo 2
	    
	    
	    @FXML
	    private void Avantpasso2(){// botao confirmar
    	
			  
			  TaxaTE=Double.parseDouble(txtTaxaTE.getText());
			  TaxaTTUSD=Double.parseDouble(txtTaxaTUSD.getText());
			  PLED120=Double.parseDouble(txtPLED120.getText());
			  PLED60=Double.parseDouble(txtPLED60.getText());
			  
			  
	    	TabInfo.setDisable(true);
	    	TabPane.getSelectionModel().select(TabNumS);
	    	TabNumS.setDisable(false);
	    	}
	    
	    @FXML
	    private void hiper(){// hiperlink eletro
	    	try {
                URI u = new URI("https://www.aeseletropaulo.com.br/para-sua-casa/prazos-e-tarifas/conteudo/tarifa-de-energia-eletrica");
                java.awt.Desktop.getDesktop().browse(u);
               
            } catch (final Exception exc) {
                System.out.println("Erro:" + Hiperlink.getText());
            }
	    }
	    
	   @FXML
	   private void SimInfo(){// botão sim paaso2
		   
		   txtTaxaTE.setDisable(false);
			  txtTaxaTUSD.setDisable(false);
			  txtPLED120.setDisable(false);
			  txtPLED60.setDisable(false);
			  btnConfInfo.setDisable(false);
			  
	   }
	   @FXML
	   private void NaoInfo(){// botão Não paaso2
		   TabInfo.setDisable(true);
	    	TabPane.getSelectionModel().select(TabNumS);
	    	TabNumS.setDisable(false);
	   }
	    
	  @FXML
	  private void iniciTabinfo(){// inicialisação do passo2
		  
		  txtTaxaTE.setText(String.valueOf(TaxaTE));
		  txtTaxaTUSD.setText(String.valueOf(TaxaTTUSD));
		  txtPLED120.setText(String.valueOf(PLED120));
		  txtPLED60.setText(String.valueOf(PLED60));
		  
	  }
	    
	    	
	    
	    
	    //passo 3
	    @FXML
	    private void Avantpasso3(){//botao avançar passo 3
	    	
	    	NumSalas=Integer.parseInt(txtNumS.getText());
	    	
	    	TabNumS.setDisable(true);
	    	TabPane.getSelectionModel().select(TabLoop);
	    	TabLoop.setDisable(false);
	    	
	    	System.out.println("TaxaTE "+TaxaTE);
	    	System.out.println("TaxaTUSD "+TaxaTTUSD);
	    	System.out.println("Preço 120:: "+PLED120);
	    	System.out.println("Preço 60::"+PLED60);
	    	}
	    
	    
	    
	    @FXML
	    private void btnJacad(){
	    	dados=true;
	    	TabNumS.setDisable(true);
	    	TabPane.getSelectionModel().select(TabTabela);
	    	TabTabela.setDisable(false);
	    }
	    
	  //passo 4 //loop
	    @FXML
	    private void Avantpasso4(){// botao avancar passo4

	     if(combTipodeLamp.getSelectionModel().getSelectedItem().toString()!="Selecione o tipo de lâmpada!"){
	    	if(NS<NumSalas){
	    		TipoLampada.add(String.valueOf(combTipodeLamp.getSelectionModel().getSelectedItem().toString()));
	    		NumerodeLampadas.add(Integer.parseInt(txtNumdeLamp.getText()));
	    		PotenciadaLampadas.add(Integer.parseInt(txtPotLamp.getText()));
	    		TempoLampadas.add(Integer.parseInt(txtTempLig.getText()));
	    		
	    		custoKWh.add(String.valueOf((((NumerodeLampadas.get(NS)*PotenciadaLampadas.get(NS)*TempoLampadas.get(NS)*TaxaTE)
	    				+(NumerodeLampadas.get(NS)*PotenciadaLampadas.get(NS)*TempoLampadas.get(NS)*TaxaTTUSD))/1000)*20));
	    		
	    		consumo.add(String.valueOf((1.0000*NumerodeLampadas.get(NS)*PotenciadaLampadas.get(NS)*TempoLampadas.get(NS)/1000)*20));
	    		
	    			    		 
	    		 if(combTipodeLamp.getSelectionModel().getSelectedItem().toString()=="Fluorescente 120cm"){
	    			 consumoLED.add(String.valueOf((1.0000*NumerodeLampadas.get(NS)*18*TempoLampadas.get(NS)/1000)*20));
	    			 custodasLampadas.add(String.valueOf((NumerodeLampadas.get(NS)*PLED120)/2));
	    			 custoKWhLED.add(String.valueOf((((NumerodeLampadas.get(NS)*18*TempoLampadas.get(NS)*TaxaTE)
	    				+(NumerodeLampadas.get(NS)*18*TempoLampadas.get(NS)*TaxaTTUSD))/1000)*20));
	    		 }
	    		 if(combTipodeLamp.getSelectionModel().getSelectedItem().toString()=="Fluorescente 60cm"){
	    			 consumoLED.add(String.valueOf((1.0000*NumerodeLampadas.get(NS)*9*TempoLampadas.get(NS)/1000)*20));
	    			 custodasLampadas.add(String.valueOf((NumerodeLampadas.get(NS)*PLED60)/2));
	    			 custoKWhLED.add(String.valueOf((((NumerodeLampadas.get(NS)*9*TempoLampadas.get(NS)*TaxaTE)
	 	    				+(NumerodeLampadas.get(NS)*9*TempoLampadas.get(NS)*TaxaTTUSD))/1000)*20));
	    		 }
	    		 
	    		 System.out.println("Sala : "+(NS+1));
	    		 System.out.println(TipoLampada.get(NS));
	    		 System.out.println(NumerodeLampadas.get(NS));
	    		 System.out.println(PotenciadaLampadas.get(NS));
	    		 System.out.println(TempoLampadas.get(NS));
	    		 System.out.println("consumo KWh "+consumo.get(NS));
	    		 System.out.println("custo por KWh "+custoKWh.get(NS));
	    		 System.out.println("consumo com lampada LED "+consumoLED.get(NS));
	    		 
	    		 NS++;
		    		lblSalaN.setText("Sala "+(NS+1));
		    		combTipodeLamp.getSelectionModel().select("Selecione o tipo de Lâmpada");
		    		txtNumdeLamp.clear();
		    		txtPotLamp.clear();
		    		txtTempLig.clear();
		    		
	    		 if(!(NS<NumSalas)){
	    			 TabLoop.setDisable(true);
	 		    	TabPane.getSelectionModel().select(TabTabela);
	 		    	TabTabela.setDisable(false);
	    		 }
	    		
	    	}
	     }
	     else{
	    	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
	       //  alert.setTitle("Este Ã© o tÃ­tulo do Alerta");
	        // alert.setHeaderText("Este Ã© o cabeÃ§alho do Alerta");
	         alert.setContentText("Selecione o tipo de Lampada");
	         alert.show();
	     }
	    	
	    	}
	    
	    @FXML
	    private void inciPasso4(){// inicialisação passo 4
	    	
	    	
	    	lblSalaN.setText("Sala "+(NS+1));
	    	
	    }
	    @FXML
	    private void Repetir(){
	    	if(NS>0){
	    	combTipodeLamp.getSelectionModel().select(String.valueOf(TipoLampada.get(NS-1)));
    		txtNumdeLamp.setText(String.valueOf(NumerodeLampadas.get(NS-1)));
    		txtPotLamp.setText(String.valueOf(PotenciadaLampadas.get(NS-1)));
    		txtTempLig.setText(String.valueOf(TempoLampadas.get(NS-1)));
	    }
	    else
	    {
	    	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
		     
		         alert.setContentText("Não foi registrado Sala/Ambiente anterior");
		         alert.show();
	    }
	    }
	    //passo 5
	    
	    @FXML
	    private void inciPasso5(){
	    	
			if(dados==false){
	    	//tabela
	    	colSala.setCellValueFactory(new PropertyValueFactory<>("Sala"));
	        colConsumo.setCellValueFactory(new PropertyValueFactory<>("Consumo"));
	        colCusto.setCellValueFactory(new PropertyValueFactory<>("Custo"));
	        CustoKWh.setCellValueFactory(new PropertyValueFactory<>("custoKWh"));
	        ConsumoLed.setCellValueFactory(new PropertyValueFactory<>("ConsumoLed"));
	        CustoKwhLed.setCellValueFactory(new PropertyValueFactory<>("CustoKwhLed"));
	       
	        		for (int i=0;i<NS;i++){
	        			CTabela tabela= new CTabela((i+1),consumo.get(i),custoKWh.get(i),custodasLampadas.get(i),consumoLED.get(i),custoKWhLED.get(i));
	        			lisTabela.add(tabela);
	        		}
	        		 observableListTabela = FXCollections.observableArrayList(lisTabela);

	        	        Tabela.setItems(observableListTabela);
	        	        //total	        
	        		      edificio.setCellValueFactory(new PropertyValueFactory<>("Edificio"));
	        		       tconsumo.setCellValueFactory(new PropertyValueFactory<>("Consumo"));
	        		       tcusto.setCellValueFactory(new PropertyValueFactory<>("Custo"));
	        		       tcustokwh.setCellValueFactory(new PropertyValueFactory<>("tcustokwh"));
	        		       
	        		       CustoKwhLedT.setCellValueFactory(new PropertyValueFactory<>("custokwhled"));
	        		       ConsumoLedT.setCellValueFactory(new PropertyValueFactory<>("consumoled"));
	        		       
	        		        
	        		       double[] custoT=new double[NumSalas];
	        		       double[] consumoT=new double[NumSalas];
	        		       double[] custokwhT=new double[NumSalas];
	        		       double[] consumoledT=new double[NumSalas];
	        		       double[] custokwhledT=new double[NumSalas];
	        		       
	        		       for(int i=0;i<NumSalas;i++){
	        		    	   System.out.println("teste");
	        		    	   custoT[i]=Double.parseDouble(custodasLampadas.get(i));
	        		    	   consumoT[i]=Double.parseDouble(consumo.get(i));
	        		    	   custokwhT[i]=Double.parseDouble(custoKWh.get(i));
	        		    	   consumoledT[i]=Double.parseDouble(consumoLED.get(i));
	        		    	   custokwhledT[i]=Double.parseDouble(custoKWhLED.get(i));
	        		    	   
	        		    	   
	        		    	   totalLampadas=totalLampadas+custoT[i];
	        		    	   totalConsumo=totalConsumo+consumoT[i];
	        		    	   custokWhtotal=custokWhtotal+custokwhT[i];
	        		    	   totalConsumoLED=totalConsumoLED+consumoledT[i];
	        		    	   custokWhtotalLED=custokWhtotalLED+custokwhledT[i];
	        		    	   
	        		       }
	        		       
	        		       Total T=new Total("Total",String.valueOf(totalConsumo),String.valueOf(custokWhtotal),
	        		    		   String.valueOf(totalLampadas),String.valueOf(totalConsumoLED),String.valueOf(custokWhtotalLED));
	        		       lisTotal.add(T);
	        		       observableListTotal=FXCollections.observableArrayList(lisTotal);
	        		       total.setItems(observableListTotal);
	    	}
	    	if(dados==true){
	    		
	    		//limpar dados nos Arrylist
	    		consumo.clear();
	    		custoKWh.clear();
	    		custodasLampadas.clear();
	    		consumoLED.clear();
	    		custoKWhLED.clear();
	    		
	    		
	    		colSala.setCellValueFactory(new PropertyValueFactory<>("Sala"));
		        colConsumo.setCellValueFactory(new PropertyValueFactory<>("Consumo"));
		        colCusto.setCellValueFactory(new PropertyValueFactory<>("Custo"));
		        CustoKWh.setCellValueFactory(new PropertyValueFactory<>("custoKWh"));
		        ConsumoLed.setCellValueFactory(new PropertyValueFactory<>("ConsumoLed"));
		        CustoKwhLed.setCellValueFactory(new PropertyValueFactory<>("CustoKwhLed"));
		       		        				        		
	    		 File arquivoCSV = new File("tabela.csv");
	              
	              try{
	                  
	                  //cria um scanner para ler o arquivo
	                  Scanner leitor = new Scanner(arquivoCSV);
	                  
	                  //variavel que armazenara as linhas do arquivo
	                  String linhasDoArquivo = new String();
	                  
	                  //ignora a primeira linha do arquivo
	                  leitor.nextLine();
	                  
	                  //percorre todo o arquivo
	                  while(leitor.hasNext()){
	                      
	                      //recebe cada linha do arquivo
	                      linhasDoArquivo = leitor.nextLine();
	                      
	                      //separa os campos entre as virgulas de cada linha
	                      String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
	                      
	                      //imprime a coluna que quiser
	                      CTabela tabela= new CTabela(Integer.parseInt(valoresEntreVirgulas[0]),valoresEntreVirgulas[1],
	                    		  valoresEntreVirgulas[2],valoresEntreVirgulas[3],valoresEntreVirgulas[4],valoresEntreVirgulas[5]);
	                      lisTabela.add(tabela);
	                      consumo.add(String.valueOf(valoresEntreVirgulas[1]));
	                      custoKWh.add(String.valueOf(valoresEntreVirgulas[2]));
	                      custodasLampadas.add(String.valueOf(valoresEntreVirgulas[3]));
	                      consumoLED.add(String.valueOf(valoresEntreVirgulas[4]));
	                      custoKWhLED.add(String.valueOf(valoresEntreVirgulas[5]));
	                  }
	                  observableListTabela = FXCollections.observableArrayList(lisTabela);

	        	        Tabela.setItems(observableListTabela);
	        	      //total	        
	        		      edificio.setCellValueFactory(new PropertyValueFactory<>("Edificio"));
	        		       tconsumo.setCellValueFactory(new PropertyValueFactory<>("Consumo"));
	        		       tcusto.setCellValueFactory(new PropertyValueFactory<>("Custo"));
	        		       tcustokwh.setCellValueFactory(new PropertyValueFactory<>("tcustokwh"));
	        		       
	        		       CustoKwhLedT.setCellValueFactory(new PropertyValueFactory<>("custokwhled"));
	        		       ConsumoLedT.setCellValueFactory(new PropertyValueFactory<>("consumoled"));
	        		       
	        		        
	        		       double[] custoT=new double[consumo.size()];
	        		       double[] consumoT=new double[consumo.size()];
	        		       double[] custokwhT=new double[consumo.size()];
	        		       double[] consumoledT=new double[consumo.size()];
	        		       double[] custokwhledT=new double[consumo.size()];
	        		       
	        		       for(int i=0;i<consumo.size();i++){
	        		    	   System.out.println("teste");
	        		    	   custoT[i]=Double.parseDouble(custodasLampadas.get(i));
	        		    	   consumoT[i]=Double.parseDouble(consumo.get(i));
	        		    	   custokwhT[i]=Double.parseDouble(custoKWh.get(i));
	        		    	   consumoledT[i]=Double.parseDouble(consumoLED.get(i));
	        		    	   custokwhledT[i]=Double.parseDouble(custoKWhLED.get(i));
	        		    	   
	        		    	   
	        		    	   totalLampadas=totalLampadas+custoT[i];
	        		    	   totalConsumo=totalConsumo+consumoT[i];
	        		    	   custokWhtotal=custokWhtotal+custokwhT[i];
	        		    	   totalConsumoLED=totalConsumoLED+consumoledT[i];
	        		    	   custokWhtotalLED=custokWhtotalLED+custokwhledT[i];
	        		    	   
	        		       }
	        		       
	        		       Total T=new Total("Total",String.valueOf(totalConsumo),String.valueOf(custokWhtotal),
	        		    		   String.valueOf(totalLampadas),String.valueOf(totalConsumoLED),String.valueOf(custokWhtotalLED));
	        		       lisTotal.add(T);
	        		       observableListTotal=FXCollections.observableArrayList(lisTotal);
	        		       total.setItems(observableListTotal);
	              }catch(FileNotFoundException e){
	            	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
	     		     
	 		         alert.setContentText("Não foram encontradas Salas cadastradas!");
	 		         alert.show();
	 		        consumo.clear();
		    		custoKWh.clear();
		    		custodasLampadas.clear();
		    		consumoLED.clear();
		    		custoKWhLED.clear();
	 		        TabTabela.setDisable(true);
	 		    	TabPane.getSelectionModel().select(TabNumS);
	 		    	TabNumS.setDisable(false);
	 		         
	 		         
	 		         
	              }
	    	}
	        
	        		
	        
	    	
	    		
	    	
	    }
	    @FXML
	    private void Avantpasso5(){

	    	TabTabela.setDisable(true);
	    	TabPane.getSelectionModel().select(TabSalvar);
	    	TabSalvar.setDisable(false);
	    	}
	    //passo 6
	    @FXML
	    private void Avantpasso6(){

	    	
	    	if(rbSim.isSelected()==true){
	    		createCsvFile();
	    	}
	    	TabSalvar.setDisable(true);
	    	TabPane.getSelectionModel().select(TabSimular);
	    	TabSimular.setDisable(false);
	    	}
	    @FXML
	    private Button a;
	    @FXML
	    private Button b;
	    //teste CSV GRAVAR
	    
	    public void createCsvFile(){ 
	    	//A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
	    	//excessões sejam tratadas
	    	try{
	    		 File arquivo;

	             arquivo = new File("tabela.csv");
	             FileOutputStream StrW = new FileOutputStream(arquivo);
	    	//Criação de um buffer para a escrita em uma stream
	    	//BufferedWriter StrW = new BufferedWriter(new FileWriter("tabela.csv"));

	    	//Escrita dos dados da tabela
	    	StrW.write(String.valueOf("Sala;Consumo (kw);Custo Kwh (R$);Custo da troca das lampadas (r$);Consumo com LED (kw);Custo Kwh (R$)\n").getBytes());
	    	for (int i=0;i<NS;i++){
    			
    		  	StrW.write((String.valueOf(i+1)+";"+consumo.get(i)+";"+custoKWh.get(i)+";"+custodasLampadas.get(i)+";"+consumoLED.get(i)+";"+custoKWhLED.get(i)+"\n").getBytes()); 
	    	}

	    	//Fechamos o buffer
	    	StrW.close(); 
	    	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
		       //  alert.setTitle("Este Ã© o tÃ­tulo do Alerta");
		        // alert.setHeaderText("Este Ã© o cabeÃ§alho do Alerta");
		         alert.setContentText("Informações salvas com sucesso!");
		         alert.show();
	    	}catch (FileNotFoundException ex)
	    	{ Alert alert = new Alert(Alert.AlertType.INFORMATION);
		       //  alert.setTitle("Este Ã© o tÃ­tulo do Alerta");
	        // alert.setHeaderText("Este Ã© o cabeÃ§alho do Alerta");
	         alert.setContentText("dados não Salvos com sucesso!");
	         alert.show();
	    	ex.printStackTrace(); 
	    	}catch (IOException e)
	    	{ Alert alert = new Alert(Alert.AlertType.INFORMATION);
		       //  alert.setTitle("Este Ã© o tÃ­tulo do Alerta");
	        // alert.setHeaderText("Este Ã© o cabeÃ§alho do Alerta");
	         alert.setContentText("dados não Salvos com sucesso!");
	         alert.show();
	    	e.printStackTrace(); } 
	    	}

	    	//Agora vamos criar um método que lê um arquivo CSV e imprima na tela as informações:

	    //teste CSV LER
	         @FXML	    
	    	public void readCsvFile(){
	        	 
	        	//abre um arquivo e cria um file
	             File arquivoCSV = new File("tabela.csv");
	              
	              try{
	                  
	                  //cria um scanner para ler o arquivo
	                  Scanner leitor = new Scanner(arquivoCSV);
	                  
	                  //variavel que armazenara as linhas do arquivo
	                  String linhasDoArquivo = new String();
	                  
	                  //ignora a primeira linha do arquivo
	                  leitor.nextLine();
	                  
	                  //percorre todo o arquivo
	                  while(leitor.hasNext()){
	                      
	                      //recebe cada linha do arquivo
	                      linhasDoArquivo = leitor.nextLine();
	                      
	                      //separa os campos entre as virgulas de cada linha
	                      String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
	                      
	                      //imprime a coluna que quiser
	                      System.out.print(valoresEntreVirgulas[0]+"\t");
	                      System.out.print(valoresEntreVirgulas[1]+"\t");
	                      System.out.print(valoresEntreVirgulas[2]+"\t");
	                      System.out.print(valoresEntreVirgulas[3]+"\t");
	                      System.out.print(valoresEntreVirgulas[4]+"\t");
	                      System.out.print(valoresEntreVirgulas[5]+"\t\n");
	                  }
	              
	              }catch(FileNotFoundException e){
	                  
	              }
	        	 


	    	}
	    
	    
	    //passo 7
	    @FXML
	    private void Avantpasso7(){// avancar

	    	NumerodeMeses=Integer.parseInt(txtMeses.getText());
	    	parcela=totalLampadas/NumerodeMeses;
	    	
	    	TabSimular.setDisable(true);
	    	TabPane.getSelectionModel().select(TabGrafico);
	    	TabGrafico.setDisable(false);
	    	}
	    //passo 8
	    @FXML
	    private void Avantpasso8(){// botao nâo
	    	
	    	TabGrafico.setDisable(true);
	    	TabPane.getSelectionModel().select(TabFinal);
	    	TabFinal.setDisable(false);
	    	}
	    @FXML
	    private void RecuaPasso8(){// botao Sim
	    	Grafico.getData().clear();
	    	TabGrafico.setDisable(true);
	    	TabPane.getSelectionModel().select(TabSimular);
	    	TabSimular.setDisable(false);
	    }
	    @FXML
	    private void iniciaGrafico(){// icialização do Grafíco
	    	Grafico.getData().clear();
	    	double linhaLampada=0;
	    	double linhaLED=0;
	    	int Mes = 0;
	    	//double par=parcela/2;
	    	//double custokwhtotal1=custokWhtotal/2;
	    	//double custoKWhtotal1=custokWhtotalLED/2;
	    	double par=parcela;
	    	double custokwhtotal1=custokWhtotal;
	    	double custoKWhtotal1=custokWhtotalLED;
	    	/*
	    	System.out.println("numero de meses "+NumerodeMeses);
	    	System.out.println("valor da parcela "+parcela);
	    	System.out.println("valor do kwh "+custokWhtotal);
	    	System.out.println("valor do kwh do LED "+custokWhtotalLED);
	    	System.out.println("/////////////////////////////");
	    	System.out.println("numero de meses "+NumerodeMeses);
	    	System.out.println("valor da parcela "+par);
	    	System.out.println("valor do kwh "+custokwhtotal1);
	    	System.out.println("valor do kwh do LED "+custoKWhtotal1);
	    	*/
	    	
	    	XYChart.Series LED = new XYChart.Series();
	    	LED.setName("LED");
            XYChart.Series Fluorescente = new XYChart.Series();
	    	Fluorescente.setName("Fluorescente");
	    	
	    	
	    	
	    	
	    	
	    	for(int i=0;i<NumerodeMeses;i++){
	    		linhaLED=linhaLED+parcela+custokWhtotalLED;
	    		linhaLampada=linhaLampada+custokWhtotal;
	    		Mes++;
	    		System.out.println("Mes "+Mes+" custo led "+linhaLED+" custo normal "+linhaLampada);
	    		MESES.add(String.valueOf(Mes));
	    		LED.getData().add(new XYChart.Data<>(MESES.get(Mes-1), linhaLED));
		    	Fluorescente.getData().add(new XYChart.Data<>(MESES.get(Mes-1), linhaLampada));
    		}
	    	do{
	    		linhaLED=linhaLED+custokWhtotalLED;
	    		linhaLampada=linhaLampada+custokWhtotal;
	    		Mes++;
	    		System.out.println("Mes "+Mes+" custo led "+linhaLED+" custo normal "+linhaLampada);
	    		MESES.add(String.valueOf(Mes));
	    		LED.getData().add(new XYChart.Data<>(MESES.get(Mes-1), linhaLED));
		    	Fluorescente.getData().add(new XYChart.Data<>(MESES.get(Mes-1), linhaLampada));
	    	}while(linhaLampada<linhaLED);
	    	Grafico.getData().add(LED);
	    	Grafico.getData().add(Fluorescente);
	    	//Grafico.setPrefSize(GRAFICO_LARGURA, GRAFICO_ALTURA);
	    	
	    }
	    
	    //passo 9
	    @FXML
	    private void Avantpasso9(){// botao finalizar

	    	System.exit(0);
	    	}
}
