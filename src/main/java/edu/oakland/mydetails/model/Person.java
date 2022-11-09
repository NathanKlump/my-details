package edu.oakland.mydetails.model;

import edu.oakland.cas.model.LdapUserModel;
import edu.oakland.jwtAuth.model.JwtJsonModel;

public class Person {
  private String pidm;
  private String legalName;
  private String prefName;
  private String gid;
  private String email;
  private String address;
  private String phone;

  public Person() {}

  public Person(LdapUserModel ldapUserModel, String preferredName) {
    pidm = Integer.toString(ldapUserModel.pidm);
    legalName = ldapUserModel.firstName;
    prefName = preferredName == null ? ldapUserModel.firstName : preferredName;
    gid = ldapUserModel.gId;
    email = ldapUserModel.netId + "@oakland.edu";
    address = ldapUserModel.address;
    phone = ldapUserModel.telephoneNumber;
  }

  public Person(JwtJsonModel jwtJsonModel) {
    pidm = jwtJsonModel.pidm;
    legalName = jwtJsonModel.givenName;
    prefName =
        jwtJsonModel.preferredName == null ? jwtJsonModel.givenName : jwtJsonModel.preferredName;
    gid = jwtJsonModel.gid;
    email = jwtJsonModel.mail;
    address = null;
    phone = jwtJsonModel.telephoneNumber;
  }

  public void setPidm(String pidm) {
    this.pidm = pidm;
  }

  public String getPidm() {
    return pidm;
  }

  public void setLegalName(String legalName) {
    this.legalName = legalName;
  }

  public String getLegalName() {
    return legalName;
  }

  public void setPrefName(String prefName) {
    this.prefName = prefName;
  }

  public String getPrefName() {
    return prefName;
  }

  public void setGid(String gid) {
    this.gid = gid;
  }

  public String getGid() {
    return gid;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhone() {
    return phone;
  }
}
