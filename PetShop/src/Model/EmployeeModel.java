package Model;

public class EmployeeModel {
    private int eID;
    private String eName;
    private String ePhone;
    private String eGender;
    private String ePass;

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

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

    @Override
    public String toString() {
        return "EmployeeModel{" + "eID=" + eID + ", eName=" + eName + ", ePhone=" + ePhone + ", eGender=" + eGender + ", ePass=" + ePass + '}';
    }
    
}
