
package binaryobjects;
import dataobjects.*;
import dataobjects.*;

public class BNode{
    public AnyClass obj;
    public BNode left;
    public BNode right;

    public BNode(AnyClass iObject){
        obj = iObject;
        left = null;
        right = null;
    }

}