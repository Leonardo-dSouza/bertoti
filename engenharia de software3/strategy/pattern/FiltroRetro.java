public class FiltroRetro implements Filtro {

    private String musicaDisco;

    public FiltroRetro(String musicaDisco) {
        this.musicaDisco = musicaDisco;
    }

    @Override
    public void aplicar(Imagem imagem) {
        System.out.println("Aplicando filtro Retrô com música: " + musicaDisco);
        imagem.setSaturacao(imagem.getSaturacao() - 0.3);
    }
}
