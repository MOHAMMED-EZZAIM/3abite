package  ma.zs.univ.ws.facade.admin.NotificationRetardDeuxiemeNiv;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Criteria;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38AdminService;
import ma.zs.univ.ws.converter.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Converter;
import ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Dto;
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
@RequestMapping("/api/admin/notificationRetardDeuxiemeNiveauDetailType38/")
public class NotificationRetardDeuxiemeNiveauDetailType38RestAdmin  extends AbstractController<NotificationRetardDeuxiemeNiveauDetailType38, NotificationRetardDeuxiemeNiveauDetailType38Dto, NotificationRetardDeuxiemeNiveauDetailType38Criteria, NotificationRetardDeuxiemeNiveauDetailType38AdminService, NotificationRetardDeuxiemeNiveauDetailType38Converter> {



    @Operation(summary = "upload one notificationRetardDeuxiemeNiveauDetailType38")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple notificationRetardDeuxiemeNiveauDetailType38s")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all notificationRetardDeuxiemeNiveauDetailType38s")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardDeuxiemeNiveauDetailType38s")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetailType38 by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new NotificationRetardDeuxiemeNiveauDetailType38(code));
    }

    @Operation(summary = "Saves the specified  notificationRetardDeuxiemeNiveauDetailType38")
    @PostMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> save(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Dto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  notificationRetardDeuxiemeNiveauDetailType38")
    @PutMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> update(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Dto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of notificationRetardDeuxiemeNiveauDetailType38")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> delete(@RequestBody List<NotificationRetardDeuxiemeNiveauDetailType38Dto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveauDetailType38")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> delete(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Dto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveauDetailType38")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple notificationRetardDeuxiemeNiveauDetailType38s by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by typeLocale38 id")
    @GetMapping("typeLocale38/id/{id}")
    public List<NotificationRetardDeuxiemeNiveauDetailType38Dto> findByTypeLocale38Id(@PathVariable Long id){
        return findDtos(service.findByTypeLocale38Id(id));
    }
    @Operation(summary = "delete by typeLocale38 id")
    @DeleteMapping("typeLocale38/id/{id}")
    public int deleteByTypeLocale38Id(@PathVariable Long id){
        return service.deleteByTypeLocale38Id(id);
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetailType38 and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds notificationRetardDeuxiemeNiveauDetailType38s by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> findByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated notificationRetardDeuxiemeNiveauDetailType38s by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports notificationRetardDeuxiemeNiveauDetailType38s by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets notificationRetardDeuxiemeNiveauDetailType38 data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public NotificationRetardDeuxiemeNiveauDetailType38RestAdmin (NotificationRetardDeuxiemeNiveauDetailType38AdminService service, NotificationRetardDeuxiemeNiveauDetailType38Converter converter) {
        super(service, converter);
    }




}
