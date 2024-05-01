package  ma.zs.univ.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.commun.Rue;
import ma.zs.univ.dao.criteria.core.commun.RueCriteria;
import ma.zs.univ.service.facade.admin.commun.RueAdminService;
import ma.zs.univ.ws.converter.commun.RueConverter;
import ma.zs.univ.ws.dto.commun.RueDto;
import ma.zs.univ.zynerator.controller.AbstractController;
import ma.zs.univ.zynerator.dto.AuditEntityDto;
import ma.zs.univ.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.univ.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.univ.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/rue/")
public class RueRestAdmin  extends AbstractController<Rue, RueDto, RueCriteria, RueAdminService, RueConverter> {



    @Operation(summary = "upload one rue")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple rues")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all rues")
    @GetMapping("")
    public ResponseEntity<List<RueDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all rues")
    @GetMapping("optimized")
    public ResponseEntity<List<RueDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a rue by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<RueDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Rue(libelle));
    }

    @Operation(summary = "Saves the specified  rue")
    @PostMapping("")
    public ResponseEntity<RueDto> save(@RequestBody RueDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  rue")
    @PutMapping("")
    public ResponseEntity<RueDto> update(@RequestBody RueDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of rue")
    @PostMapping("multiple")
    public ResponseEntity<List<RueDto>> delete(@RequestBody List<RueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified rue")
    @DeleteMapping("")
    public ResponseEntity<RueDto> delete(@RequestBody RueDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified rue")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple rues by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by quartier id")
    @GetMapping("quartier/id/{id}")
    public List<RueDto> findByQuartierId(@PathVariable Long id){
        return findDtos(service.findByQuartierId(id));
    }
    @Operation(summary = "delete by quartier id")
    @DeleteMapping("quartier/id/{id}")
    public int deleteByQuartierId(@PathVariable Long id){
        return service.deleteByQuartierId(id);
    }

    @Operation(summary = "Finds a rue and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RueDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds rues by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RueDto>> findByCriteria(@RequestBody RueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated rues by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports rues by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody RueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets rue data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public RueRestAdmin (RueAdminService service, RueConverter converter) {
        super(service, converter);
    }




}
