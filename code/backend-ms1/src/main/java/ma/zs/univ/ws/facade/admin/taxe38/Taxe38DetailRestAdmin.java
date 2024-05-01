package  ma.zs.univ.ws.facade.admin.taxe38;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38DetailCriteria;
import ma.zs.univ.service.facade.admin.taxe38.Taxe38DetailAdminService;
import ma.zs.univ.ws.converter.taxe38.Taxe38DetailConverter;
import ma.zs.univ.ws.dto.taxe38.Taxe38DetailDto;
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
@RequestMapping("/api/admin/taxe38Detail/")
public class Taxe38DetailRestAdmin  extends AbstractController<Taxe38Detail, Taxe38DetailDto, Taxe38DetailCriteria, Taxe38DetailAdminService, Taxe38DetailConverter> {



    @Operation(summary = "upload one taxe38Detail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple taxe38Details")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all taxe38Details")
    @GetMapping("")
    public ResponseEntity<List<Taxe38DetailDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all taxe38Details")
    @GetMapping("optimized")
    public ResponseEntity<List<Taxe38DetailDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a taxe38Detail by code")
    @GetMapping("code/{code}")
    public ResponseEntity<Taxe38DetailDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new Taxe38Detail(code));
    }

    @Operation(summary = "Saves the specified  taxe38Detail")
    @PostMapping("")
    public ResponseEntity<Taxe38DetailDto> save(@RequestBody Taxe38DetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  taxe38Detail")
    @PutMapping("")
    public ResponseEntity<Taxe38DetailDto> update(@RequestBody Taxe38DetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of taxe38Detail")
    @PostMapping("multiple")
    public ResponseEntity<List<Taxe38DetailDto>> delete(@RequestBody List<Taxe38DetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified taxe38Detail")
    @DeleteMapping("")
    public ResponseEntity<Taxe38DetailDto> delete(@RequestBody Taxe38DetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified taxe38Detail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple taxe38Details by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by locale38Detail id")
    @GetMapping("locale38Detail/id/{id}")
    public List<Taxe38DetailDto> findByLocale38DetailId(@PathVariable Long id){
        return findDtos(service.findByLocale38DetailId(id));
    }
    @Operation(summary = "delete by locale38Detail id")
    @DeleteMapping("locale38Detail/id/{id}")
    public int deleteByLocale38DetailId(@PathVariable Long id){
        return service.deleteByLocale38DetailId(id);
    }
    @Operation(summary = "find by tauxTaxe38 id")
    @GetMapping("tauxTaxe38/id/{id}")
    public List<Taxe38DetailDto> findByTauxTaxe38Id(@PathVariable Long id){
        return findDtos(service.findByTauxTaxe38Id(id));
    }
    @Operation(summary = "delete by tauxTaxe38 id")
    @DeleteMapping("tauxTaxe38/id/{id}")
    public int deleteByTauxTaxe38Id(@PathVariable Long id){
        return service.deleteByTauxTaxe38Id(id);
    }
    @Operation(summary = "find by taxe38 id")
    @GetMapping("taxe38/id/{id}")
    public List<Taxe38DetailDto> findByTaxe38Id(@PathVariable Long id){
        return findDtos(service.findByTaxe38Id(id));
    }
    @Operation(summary = "delete by taxe38 id")
    @DeleteMapping("taxe38/id/{id}")
    public int deleteByTaxe38Id(@PathVariable Long id){
        return service.deleteByTaxe38Id(id);
    }

    @Operation(summary = "Finds a taxe38Detail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<Taxe38DetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds taxe38Details by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<Taxe38DetailDto>> findByCriteria(@RequestBody Taxe38DetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated taxe38Details by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody Taxe38DetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports taxe38Details by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody Taxe38DetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets taxe38Detail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody Taxe38DetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public Taxe38DetailRestAdmin (Taxe38DetailAdminService service, Taxe38DetailConverter converter) {
        super(service, converter);
    }




}
