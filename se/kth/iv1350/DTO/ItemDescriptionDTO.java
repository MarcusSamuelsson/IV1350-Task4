package se.kth.iv1350.DTO;

public class ItemDescriptionDTO {
    int id;
    String name;
    double price;
    double weight;
    int VAT;

    public ItemDescriptionDTO(int id, String name, double price, double weight, int VAT) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.VAT = VAT;
    }

    /**
     * Gets the id variable
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name variable
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price variable
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the VAT variable
     * 
     * @return VAT
     */
    public int getVAT() {
        return VAT;
    }
    
    /**
     * Gets the weight variable
     * 
     * @return weight
     */
    public double getWeight() {
        return weight;
    }
}
