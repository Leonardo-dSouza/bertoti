public class Imagem {

    private String nomeArquivo;
    private double saturacao;
    private double contraste;

    private Filtro filtro; // Aqui está o Strategy!

    public Imagem(String nomeArquivo, double saturacao, double contraste) {
        this.nomeArquivo = nomeArquivo;
        this.saturacao = saturacao;
        this.contraste = contraste;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }

    public void aplicarFiltro() {
        if (filtro != null) {
            filtro.aplicar(this);
        } else {
            System.out.println("Nenhum filtro foi definido!");
        }
    }

    // Getters e setters
    public String getNomeArquivo() { return nomeArquivo; }
    public double getSaturacao() { return saturacao; }
    public double getContraste() { return contraste; }

    public void setSaturacao(double s) { this.saturacao = s; }
    public void setContraste(double c) { this.contraste = c; }
}
