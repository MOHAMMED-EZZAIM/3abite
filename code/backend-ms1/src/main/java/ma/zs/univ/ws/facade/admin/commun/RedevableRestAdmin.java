package  ma.zs.univ.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.commun.Redevable;
import ma.zs.univ.dao.criteria.core.commun.RedevableCriteria;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService;
import ma.zs.univ.ws.converter.commun.RedevableConverter;
import ma.zs.univ.ws.dto.commun.RedevableDto;
import ma.zs.univ.zynerator.controller.AbstractController;
import ma.zs.univ.zynerator.dto.AuditEntityDto;
import ma.zs.univ.zynerator.util.PaginatedList;


import ma.zs.univ.zynerator.security.bean.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.univ.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.univ.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/redevable/")
public class RedevableRestAdmin  extends AbstractController<Redevable, RedevableDto, RedevableCriteria, RedevableAdminService, RedevableConverter> {



    @Operation(summary = "upload one redevable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple redevables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all redevables")
    @GetMapping("")
    public ResponseEntity<List<RedevableDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  redevable")
    @PostMapping("")
    public ResponseEntity<RedevableDto> save(@RequestBody RedevableDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  redevable")
    @PutMapping("")
    public ResponseEntity<RedevableDto> update(@RequestBody RedevableDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of redevable")
    @PostMapping("multiple")
    public ResponseEntity<List<RedevableDto>> delete(@RequestBody List<RedevableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified redevable")
    @DeleteMapping("")
    public ResponseEntity<RedevableDto> delete(@RequestBody RedevableDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified redevable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple redevables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a redevable and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RedevableDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds redevables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RedevableDto>> findByCriteria(@RequestBody RedevableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated redevables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RedevableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports redevables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody RedevableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets redevable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RedevableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    @Operation(summary = "Change password to the specified  utilisateur")
    @PutMapping("changePassword")
    public boolean changePassword(@RequestBody User dto) throws Exception {
        return service.changePassword(dto.getUsername(),dto.getPassword());
    }
    public RedevableRestAdmin (RedevableAdminService service, RedevableConverter converter) {
        super(service, converter);
    }




}
