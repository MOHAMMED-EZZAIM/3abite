package  ma.zs.univ.ws.facade.admin.NotificationRetardTroisiemeNiv;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauCriteria;
import ma.zs.univ.service.facade.admin.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauAdminService;
import ma.zs.univ.ws.converter.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauConverter;
import ma.zs.univ.ws.dto.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauDto;
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
@RequestMapping("/api/admin/notificationRetardTroisiemeNiveau/")
public class NotificationRetardTroisiemeNiveauRestAdmin  extends AbstractController<NotificationRetardTroisiemeNiveau, NotificationRetardTroisiemeNiveauDto, NotificationRetardTroisiemeNiveauCriteria, NotificationRetardTroisiemeNiveauAdminService, NotificationRetardTroisiemeNiveauConverter> {



    @Operation(summary = "upload one notificationRetardTroisiemeNiveau")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple notificationRetardTroisiemeNiveaus")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all notificationRetardTroisiemeNiveaus")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardTroisiemeNiveaus")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a notificationRetardTroisiemeNiveau by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new NotificationRetardTroisiemeNiveau(code));
    }

    @Operation(summary = "Saves the specified  notificationRetardTroisiemeNiveau")
    @PostMapping("")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> save(@RequestBody NotificationRetardTroisiemeNiveauDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  notificationRetardTroisiemeNiveau")
    @PutMapping("")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> update(@RequestBody NotificationRetardTroisiemeNiveauDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of notificationRetardTroisiemeNiveau")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> delete(@RequestBody List<NotificationRetardTroisiemeNiveauDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified notificationRetardTroisiemeNiveau")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> delete(@RequestBody NotificationRetardTroisiemeNiveauDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified notificationRetardTroisiemeNiveau")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple notificationRetardTroisiemeNiveaus by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by locale id")
    @GetMapping("locale/id/{id}")
    public List<NotificationRetardTroisiemeNiveauDto> findByLocaleId(@PathVariable Long id){
        return findDtos(service.findByLocaleId(id));
    }
    @Operation(summary = "delete by locale id")
    @DeleteMapping("locale/id/{id}")
    public int deleteByLocaleId(@PathVariable Long id){
        return service.deleteByLocaleId(id);
    }
    @Operation(summary = "find by redevable id")
    @GetMapping("redevable/id/{id}")
    public List<NotificationRetardTroisiemeNiveauDto> findByRedevableId(@PathVariable Long id){
        return findDtos(service.findByRedevableId(id));
    }
    @Operation(summary = "delete by redevable id")
    @DeleteMapping("redevable/id/{id}")
    public int deleteByRedevableId(@PathVariable Long id){
        return service.deleteByRedevableId(id);
    }
    @Operation(summary = "find by trim id")
    @GetMapping("trim/id/{id}")
    public List<NotificationRetardTroisiemeNiveauDto> findByTrimId(@PathVariable Long id){
        return findDtos(service.findByTrimId(id));
    }
    @Operation(summary = "delete by trim id")
    @DeleteMapping("trim/id/{id}")
    public int deleteByTrimId(@PathVariable Long id){
        return service.deleteByTrimId(id);
    }

    @Operation(summary = "Finds a notificationRetardTroisiemeNiveau and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds notificationRetardTroisiemeNiveaus by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> findByCriteria(@RequestBody NotificationRetardTroisiemeNiveauCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated notificationRetardTroisiemeNiveaus by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardTroisiemeNiveauCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports notificationRetardTroisiemeNiveaus by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody NotificationRetardTroisiemeNiveauCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets notificationRetardTroisiemeNiveau data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardTroisiemeNiveauCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public NotificationRetardTroisiemeNiveauRestAdmin (NotificationRetardTroisiemeNiveauAdminService service, NotificationRetardTroisiemeNiveauConverter converter) {
        super(service, converter);
    }




}
