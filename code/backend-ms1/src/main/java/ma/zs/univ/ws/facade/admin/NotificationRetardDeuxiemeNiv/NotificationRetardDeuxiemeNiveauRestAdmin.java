package  ma.zs.univ.ws.facade.admin.NotificationRetardDeuxiemeNiv;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauCriteria;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauAdminService;
import ma.zs.univ.ws.converter.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauConverter;
import ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDto;
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
@RequestMapping("/api/admin/notificationRetardDeuxiemeNiveau/")
public class NotificationRetardDeuxiemeNiveauRestAdmin  extends AbstractController<NotificationRetardDeuxiemeNiveau, NotificationRetardDeuxiemeNiveauDto, NotificationRetardDeuxiemeNiveauCriteria, NotificationRetardDeuxiemeNiveauAdminService, NotificationRetardDeuxiemeNiveauConverter> {



    @Operation(summary = "upload one notificationRetardDeuxiemeNiveau")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple notificationRetardDeuxiemeNiveaus")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all notificationRetardDeuxiemeNiveaus")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardDeuxiemeNiveaus")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveau by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new NotificationRetardDeuxiemeNiveau(code));
    }

    @Operation(summary = "Saves the specified  notificationRetardDeuxiemeNiveau")
    @PostMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> save(@RequestBody NotificationRetardDeuxiemeNiveauDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  notificationRetardDeuxiemeNiveau")
    @PutMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> update(@RequestBody NotificationRetardDeuxiemeNiveauDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of notificationRetardDeuxiemeNiveau")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> delete(@RequestBody List<NotificationRetardDeuxiemeNiveauDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveau")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> delete(@RequestBody NotificationRetardDeuxiemeNiveauDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveau")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple notificationRetardDeuxiemeNiveaus by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by locale id")
    @GetMapping("locale/id/{id}")
    public List<NotificationRetardDeuxiemeNiveauDto> findByLocaleId(@PathVariable Long id){
        return findDtos(service.findByLocaleId(id));
    }
    @Operation(summary = "delete by locale id")
    @DeleteMapping("locale/id/{id}")
    public int deleteByLocaleId(@PathVariable Long id){
        return service.deleteByLocaleId(id);
    }
    @Operation(summary = "find by redevable id")
    @GetMapping("redevable/id/{id}")
    public List<NotificationRetardDeuxiemeNiveauDto> findByRedevableId(@PathVariable Long id){
        return findDtos(service.findByRedevableId(id));
    }
    @Operation(summary = "delete by redevable id")
    @DeleteMapping("redevable/id/{id}")
    public int deleteByRedevableId(@PathVariable Long id){
        return service.deleteByRedevableId(id);
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveau and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds notificationRetardDeuxiemeNiveaus by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> findByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated notificationRetardDeuxiemeNiveaus by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports notificationRetardDeuxiemeNiveaus by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody NotificationRetardDeuxiemeNiveauCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets notificationRetardDeuxiemeNiveau data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardDeuxiemeNiveauCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public NotificationRetardDeuxiemeNiveauRestAdmin (NotificationRetardDeuxiemeNiveauAdminService service, NotificationRetardDeuxiemeNiveauConverter converter) {
        super(service, converter);
    }




}
