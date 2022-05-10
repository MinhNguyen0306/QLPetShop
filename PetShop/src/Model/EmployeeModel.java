package Model;

public class EmployeeModel {
    private String eName;
    private String ePhone;
    private String eGender;
    private String ePass;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public String geteGender() {
        return eGender;
    }

    public void seteGender(String eGender) {
        this.eGender = eGender;
    }

    public String getePass() {
        return ePass;
    }

    public void setePass(String ePass) {
        this.ePass = ePass;
    }
}
