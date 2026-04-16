package geo.optim.pfe.services.inter.user;

import java.util.List;

import geo.optim.pfe.entities.user.AccountUser;

public interface AccountUserService {
    public AccountUser getAccountUserById(Integer id);
    public List<AccountUser> getAccountUsers();
    public AccountUser createAccountUser(AccountUser accountUser);
    public AccountUser updateAccountUser(AccountUser accountUser);
    public void deleteAccountUser(Integer id);
}
