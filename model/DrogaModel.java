package drogas.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="drogas")
public class DrogaModel {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String nome;
		private double pureza;
		private double quantidade;
		private String legalizada;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getPureza() {
			return pureza;
		}
		public void setPureza(double pureza) {
			this.pureza = pureza;
		}
		public double getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(double quantidade) {
			this.quantidade = quantidade;
		}
		public String getLegalizada() {
			return legalizada;
		}
		public void setLegalizada(String legalizada) {
			this.legalizada = legalizada;
		}	
}
