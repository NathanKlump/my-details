package edu.oakland.mydetails.controller;

import edu.oakland.cas.model.SessionDataModel;
import edu.oakland.jwtAuth.model.JwtJsonModel;
import edu.oakland.mydetails.dao.BannerDao;
import edu.oakland.mydetails.model.Person;
import edu.oakland.mydetails.model.Student;
import edu.oakland.mydetails.service.BannerService;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casified/v1")
public class MyDetailsController {
  protected final Logger log = LoggerFactory.getLogger("mydetails");
  @Autowired private BannerDao dao;
  @Autowired private BannerService service;

  @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal Arguments given")
  @ExceptionHandler({IllegalArgumentException.class, DataAccessException.class})
  public void illegalArgumentError(Exception e) {
    log.error("Throwing Illegal Argument or Data Access error");
    log.error("", e);
  }

  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Unspecified exception")
  @ExceptionHandler(Exception.class)
  public void generalError(Exception e) {
    log.error("Unspecified exception");
    log.error("", e);
  }

  @GetMapping("status-check")
  public boolean statusCheck() {
    return true;
  }

  @GetMapping("student")
  @ResponseStatus(HttpStatus.OK)
  public Student studentInfo(HttpServletRequest request) {
    SessionDataModel sessionDataModel =
        ((SessionDataModel) request.getSession().getAttribute("sessionDataModel"));
    Person person = new Person(sessionDataModel.ldapUserModel, sessionDataModel.preferredName);
    return service.getStudentInfo(person.getPidm());
  }

  @GetMapping("person")
  @ResponseStatus(HttpStatus.OK)
  public Person personInfo(HttpServletRequest request) {
    SessionDataModel sessionDataModel =
        ((SessionDataModel) request.getSession().getAttribute("sessionDataModel"));
    Person person = new Person(sessionDataModel.ldapUserModel, sessionDataModel.preferredName);
    return person;
  }

  @GetMapping("details")
  @ResponseStatus(HttpStatus.OK)
  public Map<String, Object> getAllDetails(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    Map<String, Object> details = new HashMap<>();
    Person person = getPersonFromAuth(httpServletRequest, httpServletResponse);
    String pidm = person.getPidm();
    details.put("person", person);
    details.put("student", service.getStudentInfo(pidm));
    return details;
  }

  private Person getPersonFromAuth(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    SessionDataModel sessionDataModel =
        ((SessionDataModel) httpServletRequest.getSession().getAttribute("sessionDataModel"));
    if (sessionDataModel != null) {
      return new Person(sessionDataModel.ldapUserModel, sessionDataModel.preferredName);
    }
    JwtJsonModel jwtJsonModel =
        ((JwtJsonModel) httpServletRequest.getSession().getAttribute("jwtJsonModel"));
    if (jwtJsonModel != null) {
      return new Person(jwtJsonModel);
    }
    return null;
  }
}
