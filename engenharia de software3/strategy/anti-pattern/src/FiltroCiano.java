public class FiltroCiano extends Imagem {

    private double tomCiano;

    public FiltroCiano(String nomeArquivo, double saturacao, double contraste, double tomCiano) {
        super(nomeArquivo, saturacao, contraste);
        this.tomCiano = tomCiano;
    }

    @Override
    public void aplicarFiltro() {
        System.out.println("Aplicando Filtro Ciano com tom: " + tomCiano);
    }
}
