package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@DiscriminatorValue("FORM")
@SecondaryTable(name = "formrequirement", pkJoinColumns = @PrimaryKeyJoinColumn(name = "requirement_id"))
public class FormRequirement extends Requirement {

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "formdefinition", nullable = false, table = "formrequirement")
    private JsonNode definition;

    public FormRequirement() {
        super(Type.FORM);
    }

    public JsonNode getDefinition() {
        return definition;
    }

    public void setDefinition(JsonNode definition) {
        this.definition = definition;
    }

}
