package model;

public class User {
    private String name;
    private String address;
    private String phone;
    private boolean isProfessional;

    User(String name, String address, String phone, boolean isProfessional){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isProfessional = isProfessional;
    }
    // geters
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public String getPhone(){return this.phone;}
    public boolean getIsProfessional(){return this.isProfessional;}
    // setters
    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setPhone(String phone){this.phone = phone;}
    public void setIsProfessional(boolean isProfessional){this.isProfessional = isProfessional;}
}
