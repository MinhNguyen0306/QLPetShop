package Model;

public class PetModel {
    private String pID;
    private String pName;
    private String pCategory;
    private int pQuantity;
    private float pPrice;

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }
    
    public String getpName() {
        return pName;
    }

    public void setpName(String name) {
        this.pName = pName;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String category) {
        this.pCategory = pCategory;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int quantity) {
        this.pQuantity = pQuantity;
    }

    public float getpPrice() {
        return pPrice;
    }

    public void setpPrice(float price) {
        this.pPrice = pPrice;
    }
}
