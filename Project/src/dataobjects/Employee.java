package dataobjects;

public class Employee extends AnyClass {
    private String name, surname;
    private double pay;


    public Employee(int iSeqNo, String iName, String iSurname, double iPay) {
        super(iSeqNo);
        name = iName;
        surname = iSurname;
        pay = iPay;
    }

    //superclass methods
    public String getKey() {
        return surname;
    }

    public String getData() {
        return super.getData() + "Name: " + name + " " + surname + "\nPay: " + getSalary() + "\n";
    }

    public void setPay(double newPay) {
        pay = newPay;
    }

    public double getSalary() {
        return pay;
    }

}