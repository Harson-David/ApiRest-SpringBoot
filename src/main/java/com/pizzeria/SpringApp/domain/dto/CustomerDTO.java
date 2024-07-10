package com.pizzeria.SpringApp.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pizzeria.SpringApp.persistence.entity.Pizza_order;
import jakarta.persistence.Column;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO {

    private Integer idCustomerDto;

    private String nameDto;

    private String addressDto;

    private String emailDto;

    private String phoneNumberDto;

    private List<Pizza_order> items;

    public Integer getIdCustomerDto() {
        return idCustomerDto;
    }

    public void setIdCustomerDto(Integer idCustomerDto) {
        this.idCustomerDto = idCustomerDto;
    }

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public String getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(String addressDto) {
        this.addressDto = addressDto;
    }

    public String getEmailDto() {
        return emailDto;
    }

    public void setEmailDto(String emailDto) {
        this.emailDto = emailDto;
    }

    public String getPhoneNumberDto() {
        return phoneNumberDto;
    }

    public void setPhoneNumberDto(String phoneNumberDto) {
        this.phoneNumberDto = phoneNumberDto;
    }

    public List<Pizza_order> getItems() {
        return items;
    }

    public void setItems(List<Pizza_order> items) {
        this.items = items;
    }
}
