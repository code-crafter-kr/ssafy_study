public class Restaurant {
    protected int resId;
    protected String name;
    protected String address;
    protected String signatureMenu;
    protected int rate;

    public Restaurant(){};

    public Restaurant(int resId, String name, String address, String signatureMenu, int rate){
        this.resId = resId;
        this.name = name;
        this.address = address;
        this.signatureMenu = signatureMenu;
        this.rate = rate;
    };

    public int getResId(){
        return this.resId;
    }

    public void setResId(int resId){
        this.resId = resId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getSignatureMenu(){
        return this.signatureMenu;
    }

    public void setSignatureMenu(String signatureMenu){
        this.signatureMenu = signatureMenu;
    }

    public int getRate(){
        return this.rate;
    }

    public void setRate(int rate){
        this.rate = rate;
    }

    @Override
    public String toString(){
        return String.format("%-5d | %-18s | %-17s | %-15s | %4d", resId, name, address, signatureMenu, rate);
    }

}
