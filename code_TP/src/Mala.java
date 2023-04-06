public class Mala extends Artigo{


    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------

    // dimensoes
    public double altura;
    public double largura;
    public double profundidade;

    public String material;
    public String anoColecao;


    //---------------------------------- CONSTRUTORES ----------------------------------


    public Mala() {
        super();
        this.altura = 0;
        this.largura = 0;
        this.profundidade = 0;
        this.material = "";
        this.anoColecao = "";
    }

    public Mala(String estado, String descricao, String marca, double preco, double desconto, int previous_owner, double altura, double largura, double profundidade, String material, String anoColecao) {
        super(estado, descricao, marca, preco, desconto, previous_owner);
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.material = material;
        this.anoColecao = anoColecao;
    }

    public Mala(Mala mala){
        super(mala);
        this.altura = mala.getAltura();
        this.largura = mala.getLargura();
        this.profundidade = mala.getProfundidade();
        this.material = mala.getMaterial();
        this.anoColecao = mala.getAnoColecao();
    }


    //---------------------------------- GET'S E SET'S ----------------------------------


    private double getAltura(){
        return this.altura;
    }

    private double getLargura(){
        return this.largura;
    }

    private double getProfundidade(){
        return this.profundidade;
    }

    private String getMaterial(){
        return this.material;
    }

    private String getAnoColecao(){
        return this.anoColecao;
    }

    private void setAltura(double altura){
        this.altura = altura;
    }

    private void setLargura(double largura){
        this.largura = largura;
    }

    private void setProfundidade(double profundidade){
        this.profundidade = profundidade;
    }

    private void setMaterial(String material){
        this.material = material;
    }

    private void setAnoColecao(String anoColecao){
        this.anoColecao = anoColecao;
    }


    //---------------------------------- CLONE / EQUALS ----------------------------------


    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Mala le = (Mala) o;
        return (super.equals(o) && this.altura == le.getAltura() && this.largura == le.getLargura() && this.profundidade == le.getProfundidade() &&
                this.material == le.getMaterial() && this.anoColecao == le.getAnoColecao());
    }

    public Mala clone(){
        return new Mala(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ARTIGO (Mala): ").append("\n");
        sb.append(super.toString());

        String res = sb.toString();
        return res;
    }


    //---------------------------------- OUTROS METODOS ----------------------------------


}