package jp.co.pentain.sample.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String email;
	private String passwd;
	private String firstPasswd;
	private String expiredFristPasswdDate;
	private Date lastModifiedDate;
	private Integer lastModifiedBy;
	private Date createdDate;
	private Integer createdBy;
	private Integer version;

}
