package br.dev.ciquelerogabriel.mobile.vendascarros.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Carro {


    //atributos carro
    private int id;
    private int idCliente;
    private String marcaCarro;
    private String modeloCarro;
    private int anoCarro;
    private String placaCarro;
    private String chassiCarro;
    private double valorCarro;
    private String dataCarro;
    private String garantiaCarro;


    //construtor
   public Carro (JSONObject jo) {
       try {
           this.dataCarro = jo.getString("data");
           this.marcaCarro = jo.getString("marca");
           this.modeloCarro = jo.getString("modelo");
           this.anoCarro = jo.getInt("ano");
           this.placaCarro = jo.getString("placa");
           this.chassiCarro = jo.getString("chassi");
           this.valorCarro = jo.getDouble("valor");
           this.garantiaCarro = jo.getString("garantia");
       } catch (JSONException je){
           je.printStackTrace();
       }
       }


    public Carro() {
        this.dataCarro = "00/00/0000";
        this.marcaCarro = "0000";
        this.modeloCarro = "";
        this.anoCarro = 0000;
        this.placaCarro = "";
        this.chassiCarro = "";
        this.valorCarro = 0;
        this.garantiaCarro = "";
    }


    //metodo
//Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("data", this.data);
            json.put("marca", this.marca);
            json.put("modelo", this.modelo);
            json.put("ano", this.ano);
            json.put("placa", this.placa);
            json.put("chassi", this.chassi);
            json.put("valor", this.valor);
            json.put("garantia", this.garantia);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }


    public String getMarcaCarro () {
        return this.marcaCarro;
    }
    public int getIdCliente() {
        return idCliente;
    }


    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setMarcaCarro (String marca) {
        this.marcaCarro = marca;
    }



    public String getModeloCarro () {
        return this.modeloCarro;
    }
    public void setModeloCarro (String modelo) {
        this.modeloCarro = modelo;
    }



    public int getAnoCarro () {
        return this.anoCarro;
    }
    public void setAnoCarro (int ano) {
        this.anoCarro = ano;
    }



    public String getPlacaCarro () {
        return this.placaCarro;
    }
    public void setPlacaCarro (String placa) {
        this.placaCarro = placa;
    }



    public String getChassiCarro () {
        return this.chassiCarro;