package geo.optim.pfe.dtos.writeUpdateDto.organization;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientApplicationWriteDto {
    private String code_app;
    private String label;
    private String api_key;
    private String secret;
    private Date max_transaction_day;
    private Boolean activated;
    private int companyId;
}
