/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.Observable;
import persistence.VeiculoDAO;

/**
 *
 * @author victor.domingos
 */
public class Veiculo extends Observable {

    private int id;
    private String placa;
    private String marca;
    private String modelo;
    public VeiculoEstado estado;
    public String nomeFuncionario;

    public Veiculo() {
    }

    public Veiculo(int id) {
        this.id = id;
    }

    public Veiculo(int id, String placa, String marca, String modelo) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = new VeiculoEstadoDisponivel();
    }

    public Veiculo(int id, String placa, String marca, String modelo, String situacao) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        switch (situacao) {
            case "Disponível":
                this.estado = new VeiculoEstadoDisponivel();
                break;
            case "Em desuso":
                this.estado = new VeiculoEstadoEmDesuso();
                break;
            case "Em serviço":
                this.estado = new VeiculoEstadoEmServico();
                break;
            case "Oficina":
                this.estado = new VeiculoEstadoOficina();
                break;
        }
    }

    public Veiculo(String placa, String marca, String modelo, String situacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        switch (situacao) {
            case "Disponível":
                this.disponivel(this);
                break;
            case "Em desuso":
                this.emDesuso(this);
                break;
            case "Em serviço":
                this.emServico(this);
                break;
            case "Oficina":
                this.oficina(this);
                break;
        }
    }

    public Veiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = new VeiculoEstadoDisponivel();
    }
    
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setEstado(VeiculoEstado estado) {

        this.estado = estado;

    }

    public VeiculoEstado getEstado() {
        return estado;
    }

    public String disponivel(Veiculo v) {
        return estado.disponivel(this);
    }

    public String emDesuso(Veiculo v) {
        return estado.emDesuso(this);
    }

    public String emServico(Veiculo v) {
        return estado.emServico(this);
    }

    public String oficina(Veiculo v) {
        return estado.oficina(this);
    }

    public String mudarEstado(Veiculo v, String estado) {
        switch (estado) {
            case "Disponível":
                this.disponivel(v);
                
                break;
            case "Em desuso":
                this.emDesuso(v);
                break;
            case "Em serviço":
                this.emServico(v);
                break;
            case "Oficina":
                this.oficina(v);
                break;
        }
        return v.estado.getEstado();
    }
}
