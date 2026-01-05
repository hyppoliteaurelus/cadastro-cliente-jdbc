package br.com.banco.model;

public class Cliente {


    private int id;
    private String nome;
    private String email;
    private  String cpf;


    // construtor vazio (JDBC precisa)
    public Cliente() {

    }
    // construtor completo (uso no cadastro)
    public Cliente(String nome,String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;

    }
    // getters e setters
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}


