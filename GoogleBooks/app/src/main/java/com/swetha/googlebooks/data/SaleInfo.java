
package com.swetha.googlebooks.data;

public class SaleInfo {

    private String country;
    private String saleability;
    private boolean isEbook;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SaleInfo() {
    }

    /**
     * 
     * @param country
     * @param isEbook
     * @param saleability
     */
    public SaleInfo(String country, String saleability, boolean isEbook) {
        super();
        this.country = country;
        this.saleability = saleability;
        this.isEbook = isEbook;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public boolean isIsEbook() {
        return isEbook;
    }

    public void setIsEbook(boolean isEbook) {
        this.isEbook = isEbook;
    }

}
