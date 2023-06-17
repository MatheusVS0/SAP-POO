
package sap_poo;


public class CartaoCredito {
    private String numero;
    private String titular;
    private String dtValidade;
    private String ccv;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(String dtValidade) {
        this.dtValidade = dtValidade;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
    
    public String imprimirInfo(){
        return String.format("Número: " + this.getNumero() + "\nTitular: " + this.getTitular() + "\nValidade: " + this.getDtValidade() + "\nCCV: " + this.getCcv());
    }
    
    
}
