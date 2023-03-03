package edu.oakland.jwtAuth.service;

import edu.oakland.jwtAuth.model.JwtJsonEduPersonAffiliationArrayModel;
import edu.oakland.jwtAuth.model.JwtJsonEduPersonAffiliationStringModel;
import edu.oakland.jwtAuth.model.JwtJsonModel;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.stereotype.Service;

@Service
public class ParseJwtJsonModelService {
  public ParseJwtJsonModelService() {}

  public JwtJsonModel parseJwtJsonModelService(String jsonPayloadString) {
    JwtJsonModel jwtJsonModel = parseJwtWithStringAsEduPersonAffiliation(jsonPayloadString);
    if (jwtJsonModel == null) {
      jwtJsonModel = parseJwtWithArrayAsEduPersonAffiliation(jsonPayloadString);
    }
    return jwtJsonModel;
  }

  private JwtJsonModel parseJwtWithStringAsEduPersonAffiliation(String jsonPayloadString) {
    try {
      JwtJsonEduPersonAffiliationStringModel jwtJsonEduPersonAffiliationStringModel =
          new Gson().fromJson(jsonPayloadString, JwtJsonEduPersonAffiliationStringModel.class);
      return new JwtJsonModel(jwtJsonEduPersonAffiliationStringModel);
    } catch (JsonSyntaxException e) {
      return null;
    }
  }

  private JwtJsonModel parseJwtWithArrayAsEduPersonAffiliation(String jsonPayloadString) {
    try {
      JwtJsonEduPersonAffiliationArrayModel jwtJsonEduPersonAffiliationArrayModel =
          new Gson().fromJson(jsonPayloadString, JwtJsonEduPersonAffiliationArrayModel.class);
      return new JwtJsonModel(jwtJsonEduPersonAffiliationArrayModel);
    } catch (JsonSyntaxException e) {
      return null;
    }
  }
}
