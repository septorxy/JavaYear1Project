import dataobjects.*;
import linearstructures.CircQueue;

import javax.swing.*;

import nonlinearstructures.BinSearchTree;

public class MainProg {
    public static void main(String[] args) {
        CircQueue queue = new CircQueue(20);
        BinSearchTree BST = new BinSearchTree();
        int option = 0;
        int[] EmployeeIDs = new int[20];
        int constructed = 0;
        int arrayCounter = 0;
        int result;
        String optionS;
        boolean numeric;
        boolean clear;

        do {
            do {
                numeric = true;
                optionS = JOptionPane.showInputDialog("Welcome to the Employee Information Storage System\n1 - Construct an empty CQueue and BST\n2 - Enter new Employees/Part-Timers into the Queue\n3 - List All Elements in the Queue\n4 - Update Payment of a particular employee on the queue\n5 - Update payment by percentage amount\n6 - Populate BST by objects in queue\n7 - Search by surname\n8 - List all elements in order of surname\n9 - Serve the first element from the Queue\n10 - Exit\nPlease Enter Choice:");
                if (optionS == null) {
                    option = 10;
                } else {
                    try {
                        option = Integer.parseInt(optionS);
                        if (option == 10) {
                            break;
                        } else if (constructed != 1 && option != 1) {
                            JOptionPane.showMessageDialog(null, "CQueue and BST have not been constructed yet. Please enter 1", "Error", JOptionPane.WARNING_MESSAGE);
                            numeric = false;
                        } else if (constructed == 1 && option == 1) {
                            JOptionPane.showMessageDialog(null, "CQueue and BST have already been constructed.", "Already Exists", JOptionPane.WARNING_MESSAGE);
                            numeric = false;
                        } else {
                            constructed = 1;
                        }

                    } catch (NumberFormatException e) {
                        numeric = false;
                        JOptionPane.showMessageDialog(null, "Invalid Entry", "Invalid", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } while (!numeric);


            switch (option) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Queue and BST successfully created", "Success", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    AnyClass newObj;
                    Object[] options1 = {"Employee", "PartTimer", "Go back"};
                    JPanel panel = new JPanel();
                    panel.add(new JLabel("What type of object would you like to add?"));

                    result = JOptionPane.showOptionDialog(null, panel, "Add New Object", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
                    if (result == JOptionPane.YES_OPTION) {

                        JTextField ID = new JTextField();
                        JTextField name = new JTextField();
                        JTextField surname = new JTextField();
                        JTextField pay = new JTextField();
                        Object[] fields = {
                                "Employee ID", ID,
                                "Name", name,
                                "Surname", surname,
                                "Yearly Salary", pay
                        };
                        result = JOptionPane.showConfirmDialog(null, fields, "Employee Input", JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.CANCEL_OPTION) {
                            break;
                        }
                        if (ID.getText().equals("") || name.getText().equals("") || surname.getText().equals("") || pay.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Invalid Inputs", "Invalid", JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                int seqNo1 = Integer.parseInt(ID.getText());
                                double pay1 = Double.parseDouble(pay.getText());
                                do {
                                    clear = true;
                                    for (int employeeID : EmployeeIDs) {
                                        if (employeeID == seqNo1) {
                                            clear = false;
                                            Object[] options2 = {"Yes", "No"};
                                            result = JOptionPane.showOptionDialog(null, "This Employee ID already exists. Do you want to change it?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options2, null);
                                            if (result == JOptionPane.YES_OPTION) {
                                                seqNo1 = Integer.parseInt(JOptionPane.showInputDialog("Enter new SeqNo"));
                                                break;
                                            } else {
                                                clear = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (clear) {
                                            EmployeeIDs[arrayCounter++] = seqNo1;
                                    }
                                } while (!clear);
                                String name1 = name.getText();
                                String surname1 = surname.getText();
                                newObj = new Employee(seqNo1, name1, surname1, pay1);
                                if (queue.put(newObj)) {
                                    JOptionPane.showMessageDialog(null, "New Node was added to the queue", "Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Queue is full", "Alert", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid Inputs", "Invalid", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else if (result == JOptionPane.NO_OPTION) {
                        JTextField ID = new JTextField();
                        JTextField name = new JTextField();
                        JTextField surname = new JTextField();
                        JTextField pay = new JTextField();
                        JTextField hoursWorked = new JTextField();
                        Object[] fields = {
                                "Employee ID", ID,
                                "Name", name,
                                "Surname", surname,
                                "Hourly Pay", pay,
                                "Hours Worked", hoursWorked
                        };
                        result = JOptionPane.showConfirmDialog(null, fields, "Part-Timer Input", JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.CANCEL_OPTION) {
                            break;
                        }
                        if (ID.getText().equals("") || name.getText().equals("") || surname.getText().equals("") || pay.getText().equals("") || hoursWorked.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Invalid Inputs", "Invalid", JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                int seqNo2 = Integer.parseInt(ID.getText());
                                double pay2 = Double.parseDouble(pay.getText());
                                int hoursWorked2 = Integer.parseInt(hoursWorked.getText());
                                do {
                                    clear = true;
                                    for (int employeeID : EmployeeIDs) {
                                        if (employeeID == seqNo2) {
                                            clear = false;
                                            Object[] options2 = {"Yes", "No"};
                                            result = JOptionPane.showOptionDialog(null, "This Employee ID already exists. Do you want to change it?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options2, null);
                                            if (result == JOptionPane.YES_OPTION) {
                                                seqNo2 = Integer.parseInt(JOptionPane.showInputDialog("Enter new SeqNo"));
                                                break;
                                            } else {
                                                clear = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (clear) {
                                            EmployeeIDs[arrayCounter++] = seqNo2;
                                    }
                                } while (!clear);
                                String name2 = name.getText();
                                String surname2 = surname.getText();


                                newObj = new PartTimer(seqNo2, name2, surname2, hoursWorked2, pay2);
                                if (queue.put(newObj)) {
                                    JOptionPane.showMessageDialog(null, "New Node was added to the queue", "Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Queue is full", "Alert", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid Inputs", "Invalid", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Returning...", "Buffering", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 3:
                    queue.listAll();
                    break;
                case 4:
                    JTextField searchSurname = new JTextField();
                    Object[] fields3 = {
                            "Enter Surname to search", searchSurname
                    };
                    result = JOptionPane.showConfirmDialog(null, fields3, "Search", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.CANCEL_OPTION) {
                        break;
                    }
                    if (searchSurname.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Invalid Inputs", "Invalid", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            String key = searchSurname.getText();
                            Employee toEdit = (Employee)queue.editObject(key);
                            if(toEdit!=null) {
                                String newPayS = JOptionPane.showInputDialog(toEdit.getData() + "Was Found. How much would you like the new pay to be?");
                                double newPay = Double.parseDouble(newPayS);
                                toEdit.setPay(newPay);
                                queue.listAll();
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid Inputs", "Invalid", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 5:
                    Object[] options3 = {"Raise", "Pay-Cut", "Cancel"};
                    JPanel panel2 = new JPanel();
                    panel2.add(new JLabel("What do you want to do?"));

                    result = JOptionPane.showOptionDialog(null, panel2, "Percentage Change to Pay", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options3, null);
                    if (result == JOptionPane.YES_OPTION) {
                        String percentS = JOptionPane.showInputDialog("By what percentage would you like to increase the pay of your employees?");
                        if (percentS == null) {
                            break;
                        } else {
                            try {
                                int percent = Integer.parseInt(percentS);
                                percent += 100;
                                queue.changePayOfAll(percent);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid Input", "Invalid", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else if (result == JOptionPane.NO_OPTION) {
                        String percentS = JOptionPane.showInputDialog("By what percentage would you like to decrease the pay of your employees?");
                        if (percentS == null) {
                            break;
                        } else {
                            try {
                                int percent = Integer.parseInt(percentS);
                                queue.changePayOfAll(percent);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid Input", "Invalid", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        break;
                    }
                    break;
                case 6:
                    BST.populateBST(queue);
                    break;
                case 7:
                    String SearchKey = JOptionPane.showInputDialog("Enter Surname to search");
                    if (SearchKey != null) {
                        if (!SearchKey.equals("")) {
                            AnyClass found = BST.searchStringBST(SearchKey);
                            if (found != null) {
                                JOptionPane.showMessageDialog(null, "Data Found:\n" + found.getData(), "Found", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Nothing Found", "None found", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Input Not Found", "Invalid", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        break;
                    }
                    break;
                case 8:
                    BST.inorderBST();
                    break;
                case 9:
                    AnyClass served = queue.serve();
                    if (served != null) {
                        JOptionPane.showMessageDialog(null, served.getData());
                            for (int i = 0; i < EmployeeIDs.length; i++) {
                                if (served.seqNo == EmployeeIDs[i]) {
                                    for (int j = i; j < EmployeeIDs.length - 1; j++) {
                                        EmployeeIDs[i] = EmployeeIDs[i + 1];
                                    }
                                }
                            }
                            arrayCounter--;
                    } else {
                        JOptionPane.showMessageDialog(null, "Queue is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option", "Invalid", JOptionPane.WARNING_MESSAGE);
                    break;
            }

        } while (option != 10);
    }
}