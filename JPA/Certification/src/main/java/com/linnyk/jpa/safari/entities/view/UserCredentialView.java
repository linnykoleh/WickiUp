package com.linnyk.jpa.safari.entities.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Нужно создать view с таким же маппингом, как и в ентити
 *
 * CREATE VIEW v_user_credentials AS
 *   SELECT
 *     FINANCES_USER.USER_ID as user_id,
 *     FINANCES_USER.FIRST_NAME as first_name,
 *     FINANCES_USER.LAST_NAME as last_name,
 *     CREDENTIAL.USERNAME as username,
 *     CREDENTIAL.PASSWORD as password
 * FROM FINANCES_USER join CREDENTIAL on FINANCES_USER.USER_ID = CREDENTIAL.USER_ID;
 */
@Entity
@Table(name = "V_USER_CREDENTIAL")
public class UserCredentialView {

	@Id
	@Column(name="USER_ID")
	private Long userId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredentialView{" +
				"userId=" + userId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
