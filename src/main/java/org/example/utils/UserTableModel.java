package org.example.utils;

import javax.swing.table.AbstractTableModel;

import org.bson.internal.BsonUtil;
import org.example.model.User;

import java.sql.SQLOutput;
import java.util.List;

public class UserTableModel extends AbstractTableModel {

    private List<User> userList;
    private String[] columnNames = {"ID", "Nom","email","driver"};

    public UserTableModel(List<User> userList) {

        this.userList = userList;
        int rows = userList.size();
//        System.out.println(rows + " nombre d'utilisateurs");
    }




    @Override
    public int getRowCount() {return userList.size();
    }

    @Override
    public int getColumnCount() {return columnNames.length;}

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = userList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getId();
            case 1:
                return user.getName();
            case 2:
                return user.getEmail();
            case 3:
                return user.isDriver();
            default:
                return null;

        }

    }




}
