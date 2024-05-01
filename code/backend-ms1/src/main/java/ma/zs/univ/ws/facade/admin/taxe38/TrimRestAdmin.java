package  ma.zs.univ.ws.facade.admin.taxe38;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.taxe38.Trim;
import ma.zs.univ.dao.criteria.core.taxe38.TrimCriteria;
import ma.zs.univ.service.facade.admin.taxe38.TrimAdminService;
import ma.zs.univ.ws.converter.taxe38.TrimConverter;
import ma.zs.univ.ws.dto.taxe38.TrimDto;
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
@RequestMapping("/api/admin/trim/")
public class TrimRestAdmin  extends AbstractController<Trim, TrimDto, TrimCriteria, TrimAdminService, TrimConverter> {



    @Operation(summary = "upload one trim")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple trims")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all trims")
    @GetMapping("")
    public ResponseEntity<List<TrimDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  trim")
    @PostMapping("")
    public ResponseEntity<TrimDto> save(@RequestBody TrimDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  trim")
    @PutMapping("")
    public ResponseEntity<TrimDto> update(@RequestBody TrimDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of trim")
    @PostMapping("multiple")
    public ResponseEntity<List<TrimDto>> delete(@RequestBody List<TrimDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified trim")
    @DeleteMapping("")
    public ResponseEntity<TrimDto> delete(@RequestBody TrimDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified trim")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple trims by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a trim and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TrimDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds trims by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TrimDto>> findByCriteria(@RequestBody TrimCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated trims by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TrimCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports trims by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TrimCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets trim data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TrimCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TrimRestAdmin (TrimAdminService service, TrimConverter converter) {
        super(service, converter);
    }




}
