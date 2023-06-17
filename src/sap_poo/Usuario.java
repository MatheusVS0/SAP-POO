
package sap_poo;

import java.util.ArrayList;
import java.util.Date;

public  abstract class Usuario {
    protected String login;
    protected String senha;
    protected Date dataRegistro;
    protected String email;
    protected ArrayList<Produto> produtos = new ArrayList();
    
    public Usuario(){}

    public Usuario(String login, String senha, String email) {
        this.login = login;
        this.senha = senha;
        this.email = email;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public abstract boolean verificarLogin();
    
    
}
