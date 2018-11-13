package com.systelab.patient.entity;

import com.systelab.infrastructure.jaxb.JsonLocalDateTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;

@XmlRootElement

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patient implements Serializable {

    @Schema(description = "Surname")
    private String surname;

    private String name;

    private String medicalNumber;

    private String email;

    @XmlJavaTypeAdapter(JsonLocalDateTypeAdapter.class)
    @Schema(description = "ISO 8601 Format.", example = "1986-01-22T23:28:56.782Z")
    private LocalDate dob;

    private Address address;
}