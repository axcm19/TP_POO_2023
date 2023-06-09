package SubArtigo;

import SubEncomenda.Transportadora;

import java.io.Serializable;

public class TShirt extends Artigo implements Serializable {

    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------


    public String tamanho; // pode ser (S,M,L,XL)
    public String padrao; // pode ser (liso, riscas, palmeiras)


    //---------------------------------- CONSTRUTORES ----------------------------------


    public TShirt() {
        super();
        this.tamanho = "";
        this.padrao = "";
    }

    public TShirt(String estado, String descricao, String marca, double preco, int previous_owner, Transportadora t, String tamanho, String padrao) {
        super(estado, descricao, marca, preco, previous_owner, t);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(TShirt tShirt){
        super(tShirt);
        this.tamanho = tShirt.getTamanho();
        this.padrao = tShirt.getPadrao();
    }


    //---------------------------------- GET'S E SET'S ----------------------------------


    private String getTamanho(){
        return this.tamanho;
    }

    private String getPadrao(){
        return this.padrao;
    }

    private void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }

    private void setPadrao(String padrao){
        this.padrao = padrao;
    }


    //---------------------------------- CLONE / EQUALS ----------------------------------


    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        TShirt le = (TShirt) o;
        return (super.equals(o) && this.tamanho == le.getTamanho() && this.padrao == le.getPadrao());
    }

    public TShirt clone(){
        return new TShirt(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        String desconto = "0";
        if(this.estado.equals("usado") && this.padrao.equals("riscas")) {
            desconto = "0.5";
        }
        if(this.estado.equals("usado") && this.padrao.equals("palmeiras")) {
            desconto = "0.5";
        }

        sb.append("ARTIGO (T-Shirt): ");

        sb.append("Codigo: ").append(this.alfanumerico);
        sb.append(" | Estado: ").append(this.estado);
        sb.append(" | Descrição: ").append(this.descricao);
        sb.append(" | Marca: ").append(this.marca);
        sb.append(" | Preço: ").append(this.preco).append("€");
        sb.append(" | Desconto: ").append(desconto);
        sb.append(" | Quantos donos já teve: ").append(this.previous_owner);
        sb.append(" | Tamanho: ").append(this.tamanho);
        sb.append(" | Padrão: ").append(this.padrao).append(" |\n");
        //sb.append("\t---> SubEncomenda.Transportadora: ").append(this.transportadora.toString()).append("\n"); --> em principio o utilizador não precisa de saber quem faz o transporte

        String res = sb.toString();
        return res;
    }


    //---------------------------------- OUTROS METODOS ----------------------------------

    public double precoFinalArtigo() {
        double preco_final = 0;
        if(this.estado.equals("novo") && this.previous_owner <= 0) {
            preco_final = this.preco + this.getTransportadora().calculaValorExpedicao();
        }
        if(this.estado.equals("usado") && this.previous_owner > 0) {
            if(this.padrao.equals("liso")) {
                preco_final = this.preco + this.getTransportadora().calculaValorExpedicao();
            }
            if(this.padrao.equals("riscas")) {
                preco_final = this.preco - (this.preco / this.previous_owner * 0.5) + this.getTransportadora().calculaValorExpedicao();
            }
            if(this.padrao.equals("palmeiras")) {
                preco_final = this.preco - (this.preco / this.previous_owner * 0.5) + this.getTransportadora().calculaValorExpedicao();
            }
        }
        return preco_final;
    }
}
