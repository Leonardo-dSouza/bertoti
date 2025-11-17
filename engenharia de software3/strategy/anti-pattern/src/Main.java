public class Main {
    public static void main(String[] args) {

        Imagem img1 = new FiltroCiano("foto1.png", 1.0, 1.0, 0.9);
        img1.aplicarFiltro();

        Imagem img2 = new FiltroHalloween("foto2.png", 1.2, 0.8, "fantasma.png");
        img2.aplicarFiltro();

        Imagem img3 = new FiltroRetro("foto3.png", 0.7, 1.3, "disco.mp3");
        img3.aplicarFiltro();
    }
}
