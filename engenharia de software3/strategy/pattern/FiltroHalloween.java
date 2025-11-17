public class FiltroHalloween implements Filtro {

    private String pngFantasma;

    public FiltroHalloween(String pngFantasma) {
        this.pngFantasma = pngFantasma;
    }

    @Override
    public void aplicar(Imagem imagem) {
        System.out.println("Aplicando filtro Halloween com overlay: " + pngFantasma);
        imagem.setContraste(imagem.getContraste() + 0.5);
    }
}
