package  ma.zs.univ.ws.facade.admin.taxe38;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.taxe38.CategorieLocale;
import ma.zs.univ.dao.criteria.core.taxe38.CategorieLocaleCriteria;
import ma.zs.univ.service.facade.admin.taxe38.CategorieLocaleAdminService;
import ma.zs.univ.ws.converter.taxe38.CategorieLocaleConverter;
import ma.zs.univ.ws.dto.taxe38.CategorieLocaleDto;
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
@RequestMapping("/api/admin/categorieLocale/")
public class CategorieLocaleRestAdmin  extends AbstractController<CategorieLocale, CategorieLocaleDto, CategorieLocaleCriteria, CategorieLocaleAdminService, CategorieLocaleConverter> {



    @Operation(summary = "upload one categorieLocale")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categorieLocales")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categorieLocales")
    @GetMapping("")
    public ResponseEntity<List<CategorieLocaleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categorieLocales")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieLocaleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categorieLocale by code")
    @GetMapping("code/{code}")
    public ResponseEntity<CategorieLocaleDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new CategorieLocale(code));
    }

    @Operation(summary = "Saves the specified  categorieLocale")
    @PostMapping("")
    public ResponseEntity<CategorieLocaleDto> save(@RequestBody CategorieLocaleDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categorieLocale")
    @PutMapping("")
    public ResponseEntity<CategorieLocaleDto> update(@RequestBody CategorieLocaleDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categorieLocale")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieLocaleDto>> delete(@RequestBody List<CategorieLocaleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categorieLocale")
    @DeleteMapping("")
    public ResponseEntity<CategorieLocaleDto> delete(@RequestBody CategorieLocaleDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categorieLocale")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categorieLocales by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a categorieLocale and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieLocaleDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds categorieLocales by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieLocaleDto>> findByCriteria(@RequestBody CategorieLocaleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categorieLocales by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieLocaleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categorieLocales by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategorieLocaleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categorieLocale data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieLocaleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategorieLocaleRestAdmin (CategorieLocaleAdminService service, CategorieLocaleConverter converter) {
        super(service, converter);
    }




}
