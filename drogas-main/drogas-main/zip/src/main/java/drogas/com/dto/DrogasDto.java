package drogas.com.dto;

public class DrogasDto(String nome, Double pureza, Double quantidade, String Legalizada) {


    public DrogasDto(DrogasDto d){
        this.nome = d.getNome();
        this.pureza = d.getPureza();
        this.quantidade = d.getQuantidade();
        this.Legalizada = d.getLegalizada();
    }
}