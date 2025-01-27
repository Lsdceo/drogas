package drogas.com.service;

import java.util.List;
import java.util.Optional;

import drogas.com.dto.DrogasDto;
import drogas.com.model.DrogaModel;
import drogas.com.repository.DrogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class DrogasService {
	
	@Autowired
	private DrogaRepository droga;

	//Método para registrar um usuário
	public String registerDroga(DrogasDto usuario) {
		DrogaModel m = new DrogaModel(usuario);
		droga.save(usuario);
		return "Cadastro realizado";
	}
	
	//Método para buscar um usuário por Id                                 
	public ResponseEntity<DrogaModel> findUsuarioById(Long id){
		Optional<DrogaModel> usuario = droga.findById(id);
		return usuario.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
	//Método para listar todos os usuários
	public List<DrogaModel> findAllUsuarios(){
		return droga.findAll();
	}
	
	//Método para deletar um usuário
	public String deleteUsuario(Long id) {
		droga.deleteById(id);
		return"Usuário deletado com sucesso!";
	}
	//Método para atualizar um usuário
	public DrogaModel updateUsuario(Long id, DrogaModel usuarioAtualizado) {
		DrogaModel usuario = droga.findById(id).get();   //Obtém o usuário | busca se ja existe
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setPureza(usuarioAtualizado.getPureza());
		usuario.setQuantidade(usuarioAtualizado.getQuantidade());
		usuario.setLegalizada(usuarioAtualizado.getLegalizada());
		
		return droga.save(usuario);  //Salve e retorna o usuário que foi alterado
	}
}