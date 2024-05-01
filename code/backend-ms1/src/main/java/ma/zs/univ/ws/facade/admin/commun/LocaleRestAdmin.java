package  ma.zs.univ.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.commun.Locale;
import ma.zs.univ.dao.criteria.core.commun.LocaleCriteria;
import ma.zs.univ.service.facade.admin.commun.LocaleAdminService;
import ma.zs.univ.ws.converter.commun.LocaleConverter;
import ma.zs.univ.ws.dto.commun.LocaleDto;
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
@RequestMapping("/api/admin/locale/")
public class LocaleRestAdmin  extends AbstractController<Locale, LocaleDto, LocaleCriteria, LocaleAdminService, LocaleConverter> {

    @Operation(summary = "upload one locale")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple locales")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all locales")
    @GetMapping("")
    public ResponseEntity<List<LocaleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all locales")
    @GetMapping("optimized")
    public ResponseEntity<List<LocaleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a locale by code")
    @GetMapping("code/{code}")
    public ResponseEntity<LocaleDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new Locale(code));
    }

    @Operation(summary = "Saves the specified  locale")
    @PostMapping("")
    public ResponseEntity<LocaleDto> save(@RequestBody LocaleDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  locale")
    @PutMapping("")
    public ResponseEntity<LocaleDto> update(@RequestBody LocaleDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of locale")
    @PostMapping("multiple")
    public ResponseEntity<List<LocaleDto>> delete(@RequestBody List<LocaleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified locale")
    @DeleteMapping("")
    public ResponseEntity<LocaleDto> delete(@RequestBody LocaleDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified locale")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple locales by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by rue id")
    @GetMapping("rue/id/{id}")
    public List<LocaleDto> findByRueId(@PathVariable Long id){
        return findDtos(service.findByRueId(id));
    }
    @Operation(summary = "delete by rue id")
    @DeleteMapping("rue/id/{id}")
    public int deleteByRueId(@PathVariable Long id){
        return service.deleteByRueId(id);
    }
    @Operation(summary = "find by redevable id")
    @GetMapping("redevable/id/{id}")
    public List<LocaleDto> findByRedevableId(@PathVariable Long id){
        return findDtos(service.findByRedevableId(id));
    }
    @Operation(summary = "delete by redevable id")
    @DeleteMapping("redevable/id/{id}")
    public int deleteByRedevableId(@PathVariable Long id){
        return service.deleteByRedevableId(id);
    }
    @Operation(summary = "find by categorieLocale id")
    @GetMapping("categorieLocale/id/{id}")
    public List<LocaleDto> findByCategorieLocaleId(@PathVariable Long id){
        return findDtos(service.findByCategorieLocaleId(id));
    }
    @Operation(summary = "delete by categorieLocale id")
    @DeleteMapping("categorieLocale/id/{id}")
    public int deleteByCategorieLocaleId(@PathVariable Long id){
        return service.deleteByCategorieLocaleId(id);
    }

    @Operation(summary = "Finds a locale and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<LocaleDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds locales by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<LocaleDto>> findByCriteria(@RequestBody LocaleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated locales by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody LocaleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports locales by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody LocaleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets locale data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody LocaleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public LocaleRestAdmin (LocaleAdminService service, LocaleConverter converter) {
        super(service, converter);
    }




}
