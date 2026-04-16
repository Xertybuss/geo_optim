package geo.optim.pfe.services.impl.user;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.user.AccountUser;
import geo.optim.pfe.repositories.user.AccountUserRepository;
import geo.optim.pfe.services.inter.user.AccountUserService;

@Service
public class AccountUserServiceImpl implements AccountUserService {
    private final AccountUserRepository accountUserRepository;

    public AccountUserServiceImpl(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    @Override
    public AccountUser getAccountUserById(Integer id) {
        return accountUserRepository.findById(id).get();
    }

    @Override
    public List<AccountUser> getAccountUsers() {
        return accountUserRepository.findAll();
    }

    @Override
    public AccountUser createAccountUser(AccountUser accountUser) {
        return accountUserRepository.save(accountUser);
    }

    @Override
    public AccountUser updateAccountUser(AccountUser accountUser) {
        AccountUser existingAccountUser = accountUserRepository.findById(accountUser.getId()).get();
        BeanUtils.copyProperties(accountUser, existingAccountUser, "id");
        return accountUserRepository.save(existingAccountUser);
    }

    @Override
    public void deleteAccountUser(Integer id) {
        accountUserRepository.deleteById(id);
    }
}
