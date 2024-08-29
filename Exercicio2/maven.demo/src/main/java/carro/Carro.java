public class Carro {
    private int id;
    private String modelo;
    private int ano;

   
    public Carro() {}


    public Carro(int id, String modelo, int ano) {
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Carro [id=" + id + ", modelo=" + modelo + ", ano=" + ano + "]";
    }
}
