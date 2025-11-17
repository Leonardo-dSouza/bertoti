public class Main {
    public static void main(String[] args) {

        Imagem img = new Imagem("foto.png", 1.0, 1.0);

        img.setFiltro(new FiltroCiano(0.8));
        img.aplicarFiltro();

        img.setFiltro(new FiltroHalloween("fantasma.png"));
        img.aplicarFiltro();

        img.setFiltro(new FiltroRetro("disco.mp3"));
        img.aplicarFiltro();
    }
}
