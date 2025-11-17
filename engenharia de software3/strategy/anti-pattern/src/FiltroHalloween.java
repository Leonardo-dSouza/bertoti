public class FiltroHalloween extends Imagem {

    private String pngFantasma;

    public FiltroHalloween(String nomeArquivo, double saturacao, double contraste, String pngFantasma) {
        super(nomeArquivo, saturacao, contraste);
        this.pngFantasma = pngFantasma;
    }

    @Override
    public void aplicarFiltro() {
        System.out.println("Aplicando Filtro Halloween com PNG: " + pngFantasma);
    }
}
