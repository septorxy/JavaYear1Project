package linearnode;

import dataobjects.*;

public class Node
{
    public Node next;
    public AnyClass obj;

    public Node(AnyClass iObject)
    {
        next = null;
        obj = iObject;
    }
}
