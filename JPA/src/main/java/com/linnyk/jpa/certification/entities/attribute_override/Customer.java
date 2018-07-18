package com.linnyk.jpa.certification.entities.attribute_override;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER_AO")
public class Customer {

	@Id
	@GeneratedValue
	private int id;

	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "ADDR_STREET")),
			@AttributeOverride (name = "city", column = @Column (name = "ADDR_CITY")),
			@AttributeOverride (name = "country", column = @Column (name = "ADDR_COUNTRY")),
			@AttributeOverride (name = "info.name", column = @Column (name = "INFO_NAME")),
			@AttributeOverride (name = "info.value", column = @Column (name = "INFO_VALUE"))
	})
	@Embedded
	private Address address;

}
