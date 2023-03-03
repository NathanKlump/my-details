package edu.oakland.jwtAuth.model;

import java.util.LinkedList;
import java.util.List;

public class JwtJsonModel {
  public String iss;
  public String sub;
  public String jti;
  public String agentDevice;
  public String telephoneNumber;
  public String gid;
  public String mail;
  public List<String> eduPersonAffiliation;
  public String displayName;
  public String givenName;
  public String serverName;
  public String impersonating;
  public String cn;
  public String shadowLastChange;
  public String uid;
  public String eduPersonPrimaryAffiliation;
  public String pidm;
  public String sn;
  public String username;
  public List<String> groups;

  // not part of JWT Token. Added in JwtAuthCustomFilterService from Banner call
  public String preferredName;

  public JwtJsonModel(JwtJsonEduPersonAffiliationStringModel model) {
    iss = model.iss;
    sub = model.sub;
    jti = model.jti;
    agentDevice = model.agentDevice;
    telephoneNumber = model.telephoneNumber;
    gid = model.gid;
    mail = model.mail;

    eduPersonAffiliation = new LinkedList<>();
    if (model.eduPersonAffiliation != null) {
      eduPersonAffiliation.add(model.eduPersonAffiliation);
    }

    displayName = model.displayName;
    givenName = model.givenName;
    serverName = model.serverName;
    impersonating = model.impersonating;
    cn = model.cn;
    shadowLastChange = model.shadowLastChange;
    uid = model.uid;
    eduPersonPrimaryAffiliation = model.eduPersonPrimaryAffiliation;
    pidm = model.pidm;
    sn = model.sn;
    username = model.username;
    groups = model.groups;
  }

  public JwtJsonModel(JwtJsonEduPersonAffiliationArrayModel model) {
    iss = model.iss;
    sub = model.sub;
    jti = model.jti;
    agentDevice = model.agentDevice;
    telephoneNumber = model.telephoneNumber;
    gid = model.gid;
    mail = model.mail;

    eduPersonAffiliation = new LinkedList<>();
    if (model.eduPersonAffiliation != null) {
      eduPersonAffiliation.addAll(model.eduPersonAffiliation);
    }

    displayName = model.displayName;
    givenName = model.givenName;
    serverName = model.serverName;
    impersonating = model.impersonating;
    cn = model.cn;
    shadowLastChange = model.shadowLastChange;
    uid = model.uid;
    eduPersonPrimaryAffiliation = model.eduPersonPrimaryAffiliation;
    pidm = model.pidm;
    sn = model.sn;
    username = model.username;
    groups = model.groups;
  }
}
