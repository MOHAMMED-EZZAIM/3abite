package  ma.zs.univ.ws.facade.admin.taxe38;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import ma.zs.univ.dao.criteria.core.taxe38.TauxTaxe38Criteria;
import ma.zs.univ.service.facade.admin.taxe38.TauxTaxe38AdminService;
import ma.zs.univ.ws.converter.taxe38.TauxTaxe38Converter;
import ma.zs.univ.ws.dto.taxe38.TauxTaxe38Dto;
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
@RequestMapping("/api/admin/tauxTaxe38/")
public class TauxTaxe38RestAdmin  extends AbstractController<TauxTaxe38, TauxTaxe38Dto, TauxTaxe38Criteria, TauxTaxe38AdminService, TauxTaxe38Converter> {



    @Operation(summary = "upload one tauxTaxe38")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple tauxTaxe38s")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all tauxTaxe38s")
    @GetMapping("")
    public ResponseEntity<List<TauxTaxe38Dto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all tauxTaxe38s")
    @GetMapping("optimized")
    public ResponseEntity<List<TauxTaxe38Dto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a tauxTaxe38 by code")
    @GetMapping("code/{code}")
    public ResponseEntity<TauxTaxe38Dto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new TauxTaxe38(code));
    }

    @Operation(summary = "Saves the specified  tauxTaxe38")
    @PostMapping("")
    public ResponseEntity<TauxTaxe38Dto> save(@RequestBody TauxTaxe38Dto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  tauxTaxe38")
    @PutMapping("")
    public ResponseEntity<TauxTaxe38Dto> update(@RequestBody TauxTaxe38Dto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of tauxTaxe38")
    @PostMapping("multiple")
    public ResponseEntity<List<TauxTaxe38Dto>> delete(@RequestBody List<TauxTaxe38Dto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified tauxTaxe38")
    @DeleteMapping("")
    public ResponseEntity<TauxTaxe38Dto> delete(@RequestBody TauxTaxe38Dto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified tauxTaxe38")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple tauxTaxe38s by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by typeLocale38Detail id")
    @GetMapping("typeLocale38Detail/id/{id}")
    public List<TauxTaxe38Dto> findByTypeLocale38DetailId(@PathVariable Long id){
        return findDtos(service.findByTypeLocale38DetailId(id));
    }
    @Operation(summary = "delete by typeLocale38Detail id")
    @DeleteMapping("typeLocale38Detail/id/{id}")
    public int deleteByTypeLocale38DetailId(@PathVariable Long id){
        return service.deleteByTypeLocale38DetailId(id);
    }
    @Operation(summary = "find by categorieLocale id")
    @GetMapping("categorieLocale/id/{id}")
    public List<TauxTaxe38Dto> findByCategorieLocaleId(@PathVariable Long id){
        return findDtos(service.findByCategorieLocaleId(id));
    }
    @Operation(summary = "delete by categorieLocale id")
    @DeleteMapping("categorieLocale/id/{id}")
    public int deleteByCategorieLocaleId(@PathVariable Long id){
        return service.deleteByCategorieLocaleId(id);
    }

    @Operation(summary = "Finds a tauxTaxe38 and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TauxTaxe38Dto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds tauxTaxe38s by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TauxTaxe38Dto>> findByCriteria(@RequestBody TauxTaxe38Criteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated tauxTaxe38s by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TauxTaxe38Criteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports tauxTaxe38s by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TauxTaxe38Criteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets tauxTaxe38 data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TauxTaxe38Criteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TauxTaxe38RestAdmin (TauxTaxe38AdminService service, TauxTaxe38Converter converter) {
        super(service, converter);
    }




}
