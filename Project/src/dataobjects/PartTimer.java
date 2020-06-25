package dataobjects;

public class PartTimer extends Employee {
    private int hoursWorked;

    public PartTimer(int iSeqNo, String iName, String iSurname, int iHoursWorked, double iPay) {
        super(iSeqNo, iName, iSurname, iPay);
        hoursWorked = iHoursWorked;
    }

    public String getData() {
        return super.getData() + "Hours Worked: " + hoursWorked + "\nMoney Owed: " + hoursWorked * getSalary() + "\n";
    }
}