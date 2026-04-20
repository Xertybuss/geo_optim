package geo.optim.pfe.controllers.user;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geo.optim.pfe.dtos.readDtos.user.AccountUserReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.AccountUserWriteDto;
import geo.optim.pfe.mappers.user.AccountUserMapper;
import geo.optim.pfe.services.inter.user.AccountUserService;

@RestController
@RequestMapping("/account_users")
public class AccountUserController {
    private AccountUserService accountUserService;
    private AccountUserMapper accountUserMapper;

    public AccountUserController(AccountUserService accountUserService, AccountUserMapper accountUserMapper){
        this.accountUserService = accountUserService;
        this.accountUserMapper = accountUserMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<AccountUserReadDto> getAllAccountUsers() {
        return accountUserMapper.toDTOList(accountUserService.getAccountUsers());
    }
    
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public AccountUserReadDto getAccountUserById(@PathVariable Integer id) {
        return accountUserMapper.toDTO(accountUserService.getAccountUserById(id));
    }
    
    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public AccountUserReadDto createAccountUser(@RequestBody AccountUserWriteDto entity) {
        return accountUserMapper.toDTO(accountUserService.createAccountUser(accountUserMapper.toEntity(entity)));
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public AccountUserReadDto updateAccountUser(@RequestBody AccountUserWriteDto entity) {
        return accountUserMapper.toDTO(accountUserService.updateAccountUser(accountUserMapper.toEntity(entity)));   
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteAccountUser(@PathVariable Integer id){
        accountUserService.deleteAccountUser(id);
    }
}