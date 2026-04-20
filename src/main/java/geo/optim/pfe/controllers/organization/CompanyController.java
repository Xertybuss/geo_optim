package geo.optim.pfe.controllers.organization;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geo.optim.pfe.dtos.readDtos.organization.CompanyReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.CompanyWriteDto;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.services.inter.organization.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;
    private CompanyMapper companyMapper;

    public CompanyController(CompanyService companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public List<CompanyReadDto> getAllCompanies() {
        return companyMapper.toDTOList(companyService.getAllCompanies());
    }

    @GetMapping("/company/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public CompanyReadDto getCompanyById(@PathVariable Integer id) {
        return companyMapper.toDTO(companyService.getCompanyById(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public CompanyReadDto createCompany(@RequestBody CompanyWriteDto entity) {
        return companyMapper.toDTO(companyService.createCompany(companyMapper.toEntity(entity)));
    }
    
    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public CompanyReadDto updateCompany(@RequestBody CompanyWriteDto entity) {
        return companyMapper.toDTO(companyService.updateCompany(companyMapper.toEntity(entity)));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public void deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
    }
}