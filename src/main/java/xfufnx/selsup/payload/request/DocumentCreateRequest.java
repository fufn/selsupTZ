package xfufnx.selsup.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xfufnx.selsup.dto.DescriptionDto;
import xfufnx.selsup.dto.ProductDto;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentCreateRequest {

    @JsonProperty("description")
    private DescriptionDto description;

    @JsonProperty("doc_id")
    private String docId;

    @JsonProperty("doc_status")
    private String docStatus;

    @JsonProperty("doc_type")
    private String docType;

    @JsonProperty("importRequest")
    private boolean importRequest;

    @JsonProperty("owner_inn")
    private String ownerInn;

    @JsonProperty("participant_inn")
    private String participantInn;

    @JsonProperty("producer_inn")
    private String producerInn;

    @JsonProperty("production_date")
    private LocalDate productionDate;

    @JsonProperty("production_type")
    private String productionType;

    @JsonProperty("products")
    private List<ProductDto> products;

    @JsonProperty("reg_date")
    private LocalDate regDate;

    @JsonProperty("reg_number")
    private String regNumber;
}
