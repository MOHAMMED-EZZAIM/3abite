package  ma.zs.univ.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.commun.Secteur;
import ma.zs.univ.dao.criteria.core.commun.SecteurCriteria;
import ma.zs.univ.service.facade.admin.commun.SecteurAdminService;
import ma.zs.univ.ws.converter.commun.SecteurConverter;
import ma.zs.univ.ws.dto.commun.SecteurDto;
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
@RequestMapping("/api/admin/secteur/")
public class SecteurRestAdmin  extends AbstractController<Secteur, SecteurDto, SecteurCriteria, SecteurAdminService, SecteurConverter> {



    @Operation(summary = "upload one secteur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple secteurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all secteurs")
    @GetMapping("")
    public ResponseEntity<List<SecteurDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all secteurs")
    @GetMapping("optimized")
    public ResponseEntity<List<SecteurDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a secteur by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<SecteurDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Secteur(libelle));
    }

    @Operation(summary = "Saves the specified  secteur")
    @PostMapping("")
    public ResponseEntity<SecteurDto> save(@RequestBody SecteurDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  secteur")
    @PutMapping("")
    public ResponseEntity<SecteurDto> update(@RequestBody SecteurDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of secteur")
    @PostMapping("multiple")
    public ResponseEntity<List<SecteurDto>> delete(@RequestBody List<SecteurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified secteur")
    @DeleteMapping("")
    public ResponseEntity<SecteurDto> delete(@RequestBody SecteurDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified secteur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple secteurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by ville id")
    @GetMapping("ville/id/{id}")
    public List<SecteurDto> findByVilleId(@PathVariable Long id){
        return findDtos(service.findByVilleId(id));
    }
    @Operation(summary = "delete by ville id")
    @DeleteMapping("ville/id/{id}")
    public int deleteByVilleId(@PathVariable Long id){
        return service.deleteByVilleId(id);
    }

    @Operation(summary = "Finds a secteur and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SecteurDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds secteurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SecteurDto>> findByCriteria(@RequestBody SecteurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated secteurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SecteurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports secteurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SecteurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets secteur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SecteurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SecteurRestAdmin (SecteurAdminService service, SecteurConverter converter) {
        super(service, converter);
    }




}
