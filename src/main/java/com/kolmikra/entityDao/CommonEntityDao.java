package com.kolmikra.entityDao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.kolmikra.attribute.AttributeTitle.*;

@Data
@Entity
@Table(name = "object")
public class CommonEntityDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private int id;

    @Column(name = "type_id")
    private Integer type_id;

    @OneToMany(mappedBy = "object_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Value> values;

    @OneToMany(mappedBy = "object_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reference> references;

    @OneToMany(mappedBy = "reference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReverseReference> reverseReferences;


    private Value getValue(int attrId) {
        return this.getValues().stream().filter(v -> v.getAttribute_id() == attrId).findFirst().get();
    }

    private List<Reference> getReference(int refType) {
        return this.getReferences().stream().filter(v -> v.getRef_type() == refType).collect(Collectors.toList());
    }

    public String getRegPlate() {
        return this.getValue(regPlateNumb).getVarcharValue();
    }

    public String getModel() {
        return this.getValue(modelNumb).getVarcharValue();
    }

    public String getMake() {
        return this.getValue(makeNumb).getVarcharValue();
    }

    public String getVehicleClass() {
        return this.getValue(vehicleClassNumb).getVarcharValue();
    }

    public String getVehicleType() {
        return this.getValue(vehicleTypeNumb).getVarcharValue();
    }

    public String getColor() {
        return this.getValue(colorNumb).getVarcharValue();
    }

    public Integer getIssueYear() {
        return this.getValue(issueYearNumb).getIntegerValue();
    }

    public Double getInsuranceCost() {
        return this.getValue(insuranceCostNumb).getDecimalValue();
    }

    public Integer getCapacity() {
        return this.getValue(capasityNumb).getIntegerValue();
    }

    public Double getRentalCostPerDay() {
        return this.getValue(rentalCostPerDayNumb).getDecimalValue();
    }

    public Double getBail() {
        return this.getValue(bailNumb).getDecimalValue();
    }

    public Boolean isRented() {
        return this.getValue(rentedNumb).getBooleanValue();
    }

    public String getName() {
        return this.getValue(nameNumb).getVarcharValue();
    }

    public String getClientType() {
        return this.getValue(clientTypeNumb).getVarcharValue();
    }

    public Double getPhone() {
        return this.getValue(phoneNumb).getDecimalValue();
    }

    public String getEmail() {
        return this.getValue(emailNumb).getVarcharValue();
    }

    public String getAgent() {
        return this.getValue(agentNumb).getVarcharValue();
    }

    public Integer getOrganizationCode() {
        return this.getValue(organizationCodeNumb).getIntegerValue();
    }

    public String getSecondName() {
        return this.getValue(secondNameNumb).getVarcharValue();
    }

    public String getMiddleName() {
        return this.getValue(middleNameNumb).getVarcharValue();
    }

    public Integer getDrivingExperience() {
        return this.getValue(drivingExperienceNumb).getIntegerValue();
    }

    public Integer getPassportSeries() {
        return this.getValue(passportSeriesNumb).getIntegerValue();
    }

    public Integer getPassportId() {
        return this.getValue(passportIdNumb).getIntegerValue();
    }

    public Date getBirthDate() {
        return this.getValue(birthDateNumb).getDateValue();
    }

    public Date getStartDate() {
        return this.getValue(startDateNumb).getDateValue();
    }

    public Integer getRentalTime() {
        return this.getValue(rentalTimeNumb).getIntegerValue();
    }

    public Double getRentalCost() {
        return this.getValue(rentalCostNumb).getDecimalValue();
    }

    public Integer getClientId(){
        return this.getReverseReferences().stream().filter(v->v.getRef_type() == contractSignedNumb)
                .findFirst().get().getObject_id();
    }

    public List<Integer> getContractId() {
        return this.getReference(contractSignedNumb).stream().map(Reference::getReference).collect(Collectors.toList());
    }

    public Integer getVehicleIssuedId() {
        return this.getReference(carIssuedNumb).get(0).getReference();
    }

    @JsonIgnore
    public List<Value> getValues() {
        return values;
    }
    @JsonIgnore
    public List<Reference> getReferences() {
        return references;
    }
    @JsonIgnore
    public List<ReverseReference> getReverseReferences() {
        return reverseReferences;
    }
}
