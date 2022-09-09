package models.professional_furama;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractDetail {
    private int id_details;
    private int id_contract;
    private int id_attach_service;
    private int quantity;

    public ContractDetail(int id_details, int id_contract, int id_attach_service, int quantity) {
        this.id_details = id_details;
        this.id_contract = id_contract;
        this.id_attach_service = id_attach_service;
        this.quantity = quantity;
    }

    public int getId_details() {
        return id_details;
    }

    public void setId_details(int id_details) {
        this.id_details = id_details;
    }

    public int getId_contract() {
        return id_contract;
    }

    public void setId_contract(int id_contract) {
        this.id_contract = id_contract;
    }

    public int getId_attach_service() {
        return id_attach_service;
    }

    public void setId_attach_service(int id_attach_service) {
        this.id_attach_service = id_attach_service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
