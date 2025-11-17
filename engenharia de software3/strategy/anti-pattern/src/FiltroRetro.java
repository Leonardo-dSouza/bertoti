public class FiltroRetro extends Imagem {

    private String musicaDisco;

    public FiltroRetro(String nomeArquivo, double saturacao, double contraste, String musicaDisco) {
        super(nomeArquivo, saturacao, contraste);
        this.musicaDisco = musicaDisco;
    }

    @Override
    public void aplicarFiltro() {
        System.out.println("Aplicando Filtro Retrô com música: " + musicaDisco);
    }
}