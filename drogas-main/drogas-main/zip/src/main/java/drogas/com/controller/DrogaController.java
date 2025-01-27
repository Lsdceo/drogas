package drogas.com.controller;

import drogas.com.model.DrogaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/droga")
@CrossOrigin
public class DrogaController {

    @Autowired
    private DrogaService service;

    @PostMapping
    public DrogaModel registerDroga(@RequestBody DrogaModel model) {
        return ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrogaModel> getDrogaById(@PathVariable Long id){
        return service.findDrogaById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
        service.deleteDroga(id);
        return ResponseEntity.ok("Droga deletada");
    }

    @PutMapping("/{id}")
    public ResponseEntity<DrogaModel> updateUsuario(@PathVariable Long id, @RequestBody DrogaDto atualizado ){
        DrogaDto model = service.updateDroga(id, atualizado);
        return ResponseEntity.ok(model);
    }
    @GetMapping()
    public ResponseEntity<List<DrogaModel>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}