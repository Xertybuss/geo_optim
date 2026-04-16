package geo.optim.pfe.services.inter.organization;

import java.util.List;

import geo.optim.pfe.entities.organization.Company;

public interface CompanyService {
    public List<Company> getAllCompanies();
    public Company getCompanyById(Integer id);
    public Company createCompany(Company company);
    public Company updateCompany(Company company);
    public void deleteCompany(Integer id);
}
