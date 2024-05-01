package  ma.zs.univ.ws.facade.admin.NotificationRetardDeuxiemeNiv;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailCriteria;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailAdminService;
import ma.zs.univ.ws.converter.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailConverter;
import ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailDto;
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
@RequestMapping("/api/admin/notificationRetardDeuxiemeNiveauDetail/")
public class NotificationRetardDeuxiemeNiveauDetailRestAdmin  extends AbstractController<NotificationRetardDeuxiemeNiveauDetail, NotificationRetardDeuxiemeNiveauDetailDto, NotificationRetardDeuxiemeNiveauDetailCriteria, NotificationRetardDeuxiemeNiveauDetailAdminService, NotificationRetardDeuxiemeNiveauDetailConverter> {



    @Operation(summary = "upload one notificationRetardDeuxiemeNiveauDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple notificationRetardDeuxiemeNiveauDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all notificationRetardDeuxiemeNiveauDetails")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardDeuxiemeNiveauDetails")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetail by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new NotificationRetardDeuxiemeNiveauDetail(code));
    }

    @Operation(summary = "Saves the specified  notificationRetardDeuxiemeNiveauDetail")
    @PostMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> save(@RequestBody NotificationRetardDeuxiemeNiveauDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  notificationRetardDeuxiemeNiveauDetail")
    @PutMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> update(@RequestBody NotificationRetardDeuxiemeNiveauDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of notificationRetardDeuxiemeNiveauDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> delete(@RequestBody List<NotificationRetardDeuxiemeNiveauDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveauDetail")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> delete(@RequestBody NotificationRetardDeuxiemeNiveauDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveauDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple notificationRetardDeuxiemeNiveauDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by trim id")
    @GetMapping("trim/id/{id}")
    public List<NotificationRetardDeuxiemeNiveauDetailDto> findByTrimId(@PathVariable Long id){
        return findDtos(service.findByTrimId(id));
    }
    @Operation(summary = "delete by trim id")
    @DeleteMapping("trim/id/{id}")
    public int deleteByTrimId(@PathVariable Long id){
        return service.deleteByTrimId(id);
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds notificationRetardDeuxiemeNiveauDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> findByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated notificationRetardDeuxiemeNiveauDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports notificationRetardDeuxiemeNiveauDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody NotificationRetardDeuxiemeNiveauDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets notificationRetardDeuxiemeNiveauDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardDeuxiemeNiveauDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public NotificationRetardDeuxiemeNiveauDetailRestAdmin (NotificationRetardDeuxiemeNiveauDetailAdminService service, NotificationRetardDeuxiemeNiveauDetailConverter converter) {
        super(service, converter);
    }




}
