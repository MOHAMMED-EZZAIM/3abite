package  ma.zs.univ.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.commun.Quartier;
import ma.zs.univ.dao.criteria.core.commun.QuartierCriteria;
import ma.zs.univ.service.facade.admin.commun.QuartierAdminService;
import ma.zs.univ.ws.converter.commun.QuartierConverter;
import ma.zs.univ.ws.dto.commun.QuartierDto;
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
@RequestMapping("/api/admin/quartier/")
public class QuartierRestAdmin  extends AbstractController<Quartier, QuartierDto, QuartierCriteria, QuartierAdminService, QuartierConverter> {



    @Operation(summary = "upload one quartier")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple quartiers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all quartiers")
    @GetMapping("")
    public ResponseEntity<List<QuartierDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all quartiers")
    @GetMapping("optimized")
    public ResponseEntity<List<QuartierDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a quartier by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<QuartierDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Quartier(libelle));
    }

    @Operation(summary = "Saves the specified  quartier")
    @PostMapping("")
    public ResponseEntity<QuartierDto> save(@RequestBody QuartierDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  quartier")
    @PutMapping("")
    public ResponseEntity<QuartierDto> update(@RequestBody QuartierDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of quartier")
    @PostMapping("multiple")
    public ResponseEntity<List<QuartierDto>> delete(@RequestBody List<QuartierDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified quartier")
    @DeleteMapping("")
    public ResponseEntity<QuartierDto> delete(@RequestBody QuartierDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified quartier")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple quartiers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by secteur id")
    @GetMapping("secteur/id/{id}")
    public List<QuartierDto> findBySecteurId(@PathVariable Long id){
        return findDtos(service.findBySecteurId(id));
    }
    @Operation(summary = "delete by secteur id")
    @DeleteMapping("secteur/id/{id}")
    public int deleteBySecteurId(@PathVariable Long id){
        return service.deleteBySecteurId(id);
    }

    @Operation(summary = "Finds a quartier and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<QuartierDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds quartiers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<QuartierDto>> findByCriteria(@RequestBody QuartierCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated quartiers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody QuartierCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports quartiers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody QuartierCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets quartier data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody QuartierCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public QuartierRestAdmin (QuartierAdminService service, QuartierConverter converter) {
        super(service, converter);
    }




}
