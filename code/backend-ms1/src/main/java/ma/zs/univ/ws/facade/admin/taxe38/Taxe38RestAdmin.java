package  ma.zs.univ.ws.facade.admin.taxe38;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.taxe38.Taxe38;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38Criteria;
import ma.zs.univ.service.facade.admin.taxe38.Taxe38AdminService;
import ma.zs.univ.ws.converter.taxe38.Taxe38Converter;
import ma.zs.univ.ws.dto.taxe38.Taxe38Dto;
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
@RequestMapping("/api/admin/taxe38/")
public class Taxe38RestAdmin  extends AbstractController<Taxe38, Taxe38Dto, Taxe38Criteria, Taxe38AdminService, Taxe38Converter> {



    @Operation(summary = "upload one taxe38")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple taxe38s")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all taxe38s")
    @GetMapping("")
    public ResponseEntity<List<Taxe38Dto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all taxe38s")
    @GetMapping("optimized")
    public ResponseEntity<List<Taxe38Dto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a taxe38 by code")
    @GetMapping("code/{code}")
    public ResponseEntity<Taxe38Dto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new Taxe38(code));
    }

    @Operation(summary = "Saves the specified  taxe38")
    @PostMapping("")
    public ResponseEntity<Taxe38Dto> save(@RequestBody Taxe38Dto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  taxe38")
    @PutMapping("")
    public ResponseEntity<Taxe38Dto> update(@RequestBody Taxe38Dto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of taxe38")
    @PostMapping("multiple")
    public ResponseEntity<List<Taxe38Dto>> delete(@RequestBody List<Taxe38Dto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified taxe38")
    @DeleteMapping("")
    public ResponseEntity<Taxe38Dto> delete(@RequestBody Taxe38Dto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified taxe38")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple taxe38s by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by redevable id")
    @GetMapping("redevable/id/{id}")
    public List<Taxe38Dto> findByRedevableId(@PathVariable Long id){
        return findDtos(service.findByRedevableId(id));
    }
    @Operation(summary = "delete by redevable id")
    @DeleteMapping("redevable/id/{id}")
    public int deleteByRedevableId(@PathVariable Long id){
        return service.deleteByRedevableId(id);
    }
    @Operation(summary = "find by locale id")
    @GetMapping("locale/id/{id}")
    public List<Taxe38Dto> findByLocaleId(@PathVariable Long id){
        return findDtos(service.findByLocaleId(id));
    }
    @Operation(summary = "delete by locale id")
    @DeleteMapping("locale/id/{id}")
    public int deleteByLocaleId(@PathVariable Long id){
        return service.deleteByLocaleId(id);
    }
    @Operation(summary = "find by trim id")
    @GetMapping("trim/id/{id}")
    public List<Taxe38Dto> findByTrimId(@PathVariable Long id){
        return findDtos(service.findByTrimId(id));
    }
    @Operation(summary = "delete by trim id")
    @DeleteMapping("trim/id/{id}")
    public int deleteByTrimId(@PathVariable Long id){
        return service.deleteByTrimId(id);
    }

    @Operation(summary = "Finds a taxe38 and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<Taxe38Dto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds taxe38s by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<Taxe38Dto>> findByCriteria(@RequestBody Taxe38Criteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated taxe38s by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody Taxe38Criteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports taxe38s by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody Taxe38Criteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets taxe38 data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody Taxe38Criteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public Taxe38RestAdmin (Taxe38AdminService service, Taxe38Converter converter) {
        super(service, converter);
    }




}
