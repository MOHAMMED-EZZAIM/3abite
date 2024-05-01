package  ma.zs.univ.ws.facade.admin.NotificationPremierNiv;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import ma.zs.univ.dao.criteria.core.NotificationPremierNiv.NotificationRetardPremierNiveauCriteria;
import ma.zs.univ.service.facade.admin.NotificationPremierNiv.NotificationRetardPremierNiveauAdminService;
import ma.zs.univ.ws.converter.NotificationPremierNiv.NotificationRetardPremierNiveauConverter;
import ma.zs.univ.ws.dto.NotificationPremierNiv.NotificationRetardPremierNiveauDto;
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
@RequestMapping("/api/admin/notificationRetardPremierNiveau/")
public class NotificationRetardPremierNiveauRestAdmin  extends AbstractController<NotificationRetardPremierNiveau, NotificationRetardPremierNiveauDto, NotificationRetardPremierNiveauCriteria, NotificationRetardPremierNiveauAdminService, NotificationRetardPremierNiveauConverter> {



    @Operation(summary = "upload one notificationRetardPremierNiveau")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple notificationRetardPremierNiveaus")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all notificationRetardPremierNiveaus")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardPremierNiveauDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardPremierNiveaus")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardPremierNiveauDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a notificationRetardPremierNiveau by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardPremierNiveauDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new NotificationRetardPremierNiveau(code));
    }

    @Operation(summary = "Saves the specified  notificationRetardPremierNiveau")
    @PostMapping("")
    public ResponseEntity<NotificationRetardPremierNiveauDto> save(@RequestBody NotificationRetardPremierNiveauDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  notificationRetardPremierNiveau")
    @PutMapping("")
    public ResponseEntity<NotificationRetardPremierNiveauDto> update(@RequestBody NotificationRetardPremierNiveauDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of notificationRetardPremierNiveau")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardPremierNiveauDto>> delete(@RequestBody List<NotificationRetardPremierNiveauDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified notificationRetardPremierNiveau")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardPremierNiveauDto> delete(@RequestBody NotificationRetardPremierNiveauDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified notificationRetardPremierNiveau")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple notificationRetardPremierNiveaus by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by locale id")
    @GetMapping("locale/id/{id}")
    public List<NotificationRetardPremierNiveauDto> findByLocaleId(@PathVariable Long id){
        return findDtos(service.findByLocaleId(id));
    }
    @Operation(summary = "delete by locale id")
    @DeleteMapping("locale/id/{id}")
    public int deleteByLocaleId(@PathVariable Long id){
        return service.deleteByLocaleId(id);
    }
    @Operation(summary = "find by redevable id")
    @GetMapping("redevable/id/{id}")
    public List<NotificationRetardPremierNiveauDto> findByRedevableId(@PathVariable Long id){
        return findDtos(service.findByRedevableId(id));
    }
    @Operation(summary = "delete by redevable id")
    @DeleteMapping("redevable/id/{id}")
    public int deleteByRedevableId(@PathVariable Long id){
        return service.deleteByRedevableId(id);
    }

    @Operation(summary = "Finds a notificationRetardPremierNiveau and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardPremierNiveauDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds notificationRetardPremierNiveaus by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardPremierNiveauDto>> findByCriteria(@RequestBody NotificationRetardPremierNiveauCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated notificationRetardPremierNiveaus by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardPremierNiveauCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports notificationRetardPremierNiveaus by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody NotificationRetardPremierNiveauCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets notificationRetardPremierNiveau data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardPremierNiveauCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public NotificationRetardPremierNiveauRestAdmin (NotificationRetardPremierNiveauAdminService service, NotificationRetardPremierNiveauConverter converter) {
        super(service, converter);
    }




}
