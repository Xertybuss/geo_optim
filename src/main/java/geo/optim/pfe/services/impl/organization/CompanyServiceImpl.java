package geo.optim.pfe.services.impl.organization;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.organization.Company;
import geo.optim.pfe.repositories.organization.CompanyRepository;
import geo.optim.pfe.services.inter.organization.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Integer id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        Company existingCompany = companyRepository.findById(company.getId()).get();
        BeanUtils.copyProperties(company, existingCompany, "id");
        return companyRepository.save(existingCompany);
    }

    @Override
    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }

    
}
