public class Imagem {

    protected String nomeArquivo;
    protected double saturacao;
    protected double contraste;

    public Imagem(String nomeArquivo, double saturacao, double contraste) {
        this.nomeArquivo = nomeArquivo;
        this.saturacao = saturacao;
        this.contraste = contraste;
    }

    public void aplicarFiltro() {
        // No anti-pattern, a superclasse não sabe qual filtro está sendo aplicado.
        System.out.println("Aplicando filtro genérico na imagem: " + nomeArquivo);
    }
}
