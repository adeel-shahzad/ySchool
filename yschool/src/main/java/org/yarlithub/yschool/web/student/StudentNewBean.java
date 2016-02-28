package org.yarlithub.yschool.web.student;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.yarlithub.yschool.repository.model.obj.yschool.Student;
import org.yarlithub.yschool.service.StudentService;


/**
 * $LastChangedDate$
 * $LastChangedBy$
 * $LastChangedRevision$
 */
@ManagedBean
//@Scope(value = "request")
@ViewScoped
@Controller
public class StudentNewBean implements Serializable {
	
	private UIComponent component;
	private String status;

    private String admission_No;
    private String name;
    private String fullname;
    private String name_wt_initial;
    private Date dob;
    private String gender;
    private String address;
    @Autowired
    private StudentService studentService;

    public String getAdmission_No() {
        return admission_No;
    }

    public void setAdmission_No(String admission_No) {
        this.admission_No = admission_No;
    }

    public UIComponent getComponent() {
		return component;
	}

	public void setComponent(UIComponent component) {
		this.component = component;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getName_wt_initial() {
        return name_wt_initial;
    }

    public void setName_wt_initial(String name_wt_initial) {
        this.name_wt_initial = name_wt_initial;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String addStudent() {

        Student student = studentService.addNewStudent(admission_No, name, fullname, name_wt_initial, dob, gender, address);
        if (student.getId() > 0) {
        	status = "Student added successfully";
            return "AddStudentSuccess";
        }
        status = "Failed to add student. Please add again.";
        return "AddStudentFailed";
    }
}
