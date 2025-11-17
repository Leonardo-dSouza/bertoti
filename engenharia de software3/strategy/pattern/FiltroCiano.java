public class FiltroCiano implements Filtro {

    private double tomCiano;

    public FiltroCiano(double tomCiano) {
        this.tomCiano = tomCiano;
    }

    @Override
    public void aplicar(Imagem imagem) {
        System.out.println("Aplicando filtro Ciano com tom: " + tomCiano);
        imagem.setSaturacao(imagem.getSaturacao() + 0.2);
    }
}
