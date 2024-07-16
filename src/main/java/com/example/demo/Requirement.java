package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "requirement")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Requirement implements Serializable {

    public enum Type {
        FORM
    }

    @Id
    @GeneratedValue(generator = "seq_requirement", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "seq_requirement", sequenceName = "seq_requirement")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(insertable = false, length = 32, name = "type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    protected Requirement(Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }
}
