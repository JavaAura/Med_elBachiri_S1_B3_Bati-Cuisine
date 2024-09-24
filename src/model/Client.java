package model;

public class Client {
    private int id;
    private String name;
    private String address;
    private String phone;
    private boolean isProfessional;

    public Client(String name, String address, String phone, boolean isProfessional){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isProfessional = isProfessional;
    }

    // getters
    public int getId() { return id; }
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public String getPhone(){return this.phone;}
    public boolean getIsProfessional(){return this.isProfessional;}
    // setters

    public void setId(int id) { this.id = id; }
    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setPhone(String phone){this.phone = phone;}
    public void setIsProfessional(boolean isProfessional){this.isProfessional = isProfessional;}

    // display
    public void display(){
        System.out.println(
                "\tID: " + this.id + " | Name: " + this.name + " | Address: " + this.address + " | Phone: " + this.phone + "\n"
        );
    }
}
