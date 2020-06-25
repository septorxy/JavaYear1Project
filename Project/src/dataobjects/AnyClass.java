package dataobjects;

public abstract class AnyClass {
    public int seqNo;

    public AnyClass(int iSeqNo) {
        seqNo = iSeqNo;
    }

    public String getData() {
        return "Employee ID: " + seqNo + "\n";
    }

    public String getKey() {
        return ""+seqNo;
    }

    public void edit() {
    }

}