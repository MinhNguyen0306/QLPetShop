package Model;

public class PetModel {
    private int pID;
    private String pName;
    private String pCategory;
    private int pQuantity;
    private float pPrice;

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
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
