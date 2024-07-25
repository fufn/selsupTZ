package xfufnx.selsup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @JsonProperty("certificate_document")
    private String certificateDocument;

    @JsonProperty("certificate_document_date")
    private LocalDate certificateDocumentDate;

    @JsonProperty("certificate_document_number")
    private String certificateDocumentNumber;

    @JsonProperty("owner_inn")
    private String ownerInn;

    @JsonProperty("producer_inn")
    private String producerInn;

    @JsonProperty("production_date")
    private LocalDate productionDate;

    @JsonProperty("tnved_code")
    private String tnvedCode;

    @JsonProperty("uit_code")
    private String uitCode;

    @JsonProperty("uitu_code")
    private String uituCode;
}
