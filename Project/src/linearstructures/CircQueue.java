package linearstructures;

import dataobjects.*;
import linearnode.Node;

import javax.swing.*;


public class CircQueue {
    public Node front, rear;
    public boolean isFull;

    public CircQueue(int maxNumberOfNodes) {
        for (int i = 0; i < maxNumberOfNodes; i++) {
            Node newNode = new Node(null);

            if (front == null) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        rear.next = front;
        isFull = false;
    }

    public boolean put(AnyClass newObj) {
        if (!isFull) {
            rear = rear.next;
            rear.obj = newObj;

            if (rear.next == front) {
                isFull = true;
            }

            return true;
        } else {
            return false;
        }
    }

    public AnyClass serve() {
        if (isFull || rear.next != front) {
            AnyClass objectToServe = front.obj;
            front = front.next;
            isFull = false;

            return objectToServe;
        } else {
            return null;
        }
    }

    public void listAll() {
        if (isFull || rear.next != front) {
            Node temp = front;
            StringBuilder display = new StringBuilder();
            do {
                display.append(temp.obj.getData()).append("----------------------\n");
                temp = temp.next;
            } while (temp != rear.next);
            JOptionPane.showMessageDialog(null, display.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Queue is empty");
        }
    }

    public AnyClass editObject(String key) {
        if (isFull || rear.next != front) {
            try{
                String idNoS = JOptionPane.showInputDialog("Enter ID No to search");
                int idNo = Integer.parseInt(idNoS);
                Node temp = front;
                while (temp != rear.next) {
                    if (temp.obj.getKey().equalsIgnoreCase(key) && temp.obj.seqNo == idNo) {
                        return temp.obj;
                    } else {
                        temp = temp.next;
                    }
                }
                JOptionPane.showMessageDialog(null, "None Found", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error. Invalid Inputs", "Error", JOptionPane.WARNING_MESSAGE);
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Queue is Empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void changePayOfAll(int percent) {
        if (isFull || rear.next != front) {
            Node temp = front;
            Employee emp = (Employee)temp.obj;
            do {
                double salary = emp.getSalary();
                double percentage = percent / 100.0;
                double newSalary = salary * percentage;
                emp.setPay(newSalary);
                temp = temp.next;
                emp = (Employee)temp.obj;
            } while (temp != rear.next);
        } else {
            JOptionPane.showMessageDialog(null, "Queue is Empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}