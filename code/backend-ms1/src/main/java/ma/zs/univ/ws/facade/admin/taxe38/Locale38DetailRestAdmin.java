package  ma.zs.univ.ws.facade.admin.taxe38;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Locale38DetailCriteria;
import ma.zs.univ.service.facade.admin.taxe38.Locale38DetailAdminService;
import ma.zs.univ.ws.converter.taxe38.Locale38DetailConverter;
import ma.zs.univ.ws.dto.taxe38.Locale38DetailDto;
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
@RequestMapping("/api/admin/locale38Detail/")
public class Locale38DetailRestAdmin  extends AbstractController<Locale38Detail, Locale38DetailDto, Locale38DetailCriteria, Locale38DetailAdminService, Locale38DetailConverter> {



    @Operation(summary = "upload one locale38Detail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple locale38Details")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all locale38Details")
    @GetMapping("")
    public ResponseEntity<List<Locale38DetailDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all locale38Details")
    @GetMapping("optimized")
    public ResponseEntity<List<Locale38DetailDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a locale38Detail by code")
    @GetMapping("code/{code}")
    public ResponseEntity<Locale38DetailDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new Locale38Detail(code));
    }

    @Operation(summary = "Saves the specified  locale38Detail")
    @PostMapping("")
    public ResponseEntity<Locale38DetailDto> save(@RequestBody Locale38DetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  locale38Detail")
    @PutMapping("")
    public ResponseEntity<Locale38DetailDto> update(@RequestBody Locale38DetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of locale38Detail")
    @PostMapping("multiple")
    public ResponseEntity<List<Locale38DetailDto>> delete(@RequestBody List<Locale38DetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified locale38Detail")
    @DeleteMapping("")
    public ResponseEntity<Locale38DetailDto> delete(@RequestBody Locale38DetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified locale38Detail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple locale38Details by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by typeLocale38Detail id")
    @GetMapping("typeLocale38Detail/id/{id}")
    public List<Locale38DetailDto> findByTypeLocale38DetailId(@PathVariable Long id){
        return findDtos(service.findByTypeLocale38DetailId(id));
    }
    @Operation(summary = "delete by typeLocale38Detail id")
    @DeleteMapping("typeLocale38Detail/id/{id}")
    public int deleteByTypeLocale38DetailId(@PathVariable Long id){
        return service.deleteByTypeLocale38DetailId(id);
    }

    @Operation(summary = "Finds a locale38Detail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<Locale38DetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds locale38Details by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<Locale38DetailDto>> findByCriteria(@RequestBody Locale38DetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated locale38Details by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody Locale38DetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports locale38Details by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody Locale38DetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets locale38Detail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody Locale38DetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public Locale38DetailRestAdmin (Locale38DetailAdminService service, Locale38DetailConverter converter) {
        super(service, converter);
    }




}
