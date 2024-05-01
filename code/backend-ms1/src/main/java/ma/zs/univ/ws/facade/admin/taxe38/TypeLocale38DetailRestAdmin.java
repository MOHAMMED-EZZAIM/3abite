package  ma.zs.univ.ws.facade.admin.taxe38;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.TypeLocale38DetailCriteria;
import ma.zs.univ.service.facade.admin.taxe38.TypeLocale38DetailAdminService;
import ma.zs.univ.ws.converter.taxe38.TypeLocale38DetailConverter;
import ma.zs.univ.ws.dto.taxe38.TypeLocale38DetailDto;
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
@RequestMapping("/api/admin/typeLocale38Detail/")
public class TypeLocale38DetailRestAdmin  extends AbstractController<TypeLocale38Detail, TypeLocale38DetailDto, TypeLocale38DetailCriteria, TypeLocale38DetailAdminService, TypeLocale38DetailConverter> {



    @Operation(summary = "upload one typeLocale38Detail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeLocale38Details")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeLocale38Details")
    @GetMapping("")
    public ResponseEntity<List<TypeLocale38DetailDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeLocale38Details")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeLocale38DetailDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeLocale38Detail by code")
    @GetMapping("code/{code}")
    public ResponseEntity<TypeLocale38DetailDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new TypeLocale38Detail(code));
    }

    @Operation(summary = "Saves the specified  typeLocale38Detail")
    @PostMapping("")
    public ResponseEntity<TypeLocale38DetailDto> save(@RequestBody TypeLocale38DetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeLocale38Detail")
    @PutMapping("")
    public ResponseEntity<TypeLocale38DetailDto> update(@RequestBody TypeLocale38DetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeLocale38Detail")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeLocale38DetailDto>> delete(@RequestBody List<TypeLocale38DetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeLocale38Detail")
    @DeleteMapping("")
    public ResponseEntity<TypeLocale38DetailDto> delete(@RequestBody TypeLocale38DetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeLocale38Detail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeLocale38Details by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a typeLocale38Detail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeLocale38DetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds typeLocale38Details by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeLocale38DetailDto>> findByCriteria(@RequestBody TypeLocale38DetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeLocale38Details by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeLocale38DetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeLocale38Details by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeLocale38DetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeLocale38Detail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeLocale38DetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeLocale38DetailRestAdmin (TypeLocale38DetailAdminService service, TypeLocale38DetailConverter converter) {
        super(service, converter);
    }




}
