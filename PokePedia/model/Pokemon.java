package model;

public class Pokemon {

    private int id;
    private String nome;
    private String tipo;
    private String categoria;
    private double altura;
    private double peso;
    private int geracao;

    public Pokemon() {
    }

    public Pokemon(int id, String nome, String tipo, String caregoria, double altura, double peso, int geracao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.categoria = caregoria;
        this.altura = altura;
        this.peso = peso;
        this.geracao = geracao;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getGeracao() {
        return this.geracao;
    }

    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }

    @Override
    public String toString() {
        return String.format(
                "Id: %-5d Nome: %-15s Tipo: %-10s "
                        + "Categoria: %-15s Altura: %-10.1f Peso: %-10.1f Geração: %-10d",
                id, nome, tipo, categoria, altura, peso, geracao);
    }
}