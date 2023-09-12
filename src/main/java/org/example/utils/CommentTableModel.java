package org.example.utils;

import org.example.model.Comment;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CommentTableModel extends AbstractTableModel {

    private List<Comment> commentList;
    private String[] columnNames = {"ID_Voyage", "Commentaire"};

    public CommentTableModel(List<Comment> commentList) {

        this.commentList = commentList;
        int rows = commentList.size();
        System.out.println(rows + " nombre de commentaire");
    }




    @Override
    public int getRowCount() {return commentList.size();
    }

    @Override
    public int getColumnCount() {return columnNames.length;}

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Comment comment = commentList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return comment.getIdTrip();
            case 1:
                return comment.getComment();
            default:
                return null;

        }

    }




}
