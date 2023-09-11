package org.example.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.example.model.Comment;
import org.example.utils.MongoDBDatabase;

import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    private MongoDatabase connection;

    public CommentDAO() {
        try {
            this.connection = MongoDBDatabase.getMongoConnection();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public Comment insertComment(Comment comment) {
        MongoCollection<Document> collection = connection.getCollection("comment");
        try {

            // Creating the document
            // to be inserted
            Document document
                    = new Document("id", comment.getId())
                    .append("idTrip", comment.getIdTrip())
                    .append("comment", comment.getComment());

            // Adding the documents into a list
            List<Document> dblist
                    = new ArrayList<Document>();
            dblist.add(document);

            // Insert the list of documents into DB
            collection.insertMany(dblist);

            System.out.println(
                    "Documents inserted Successfully");
        } catch (Exception e) {
            System.out.println(
                    "Documents insertion failed");
            System.out.println(e);
        }
        return null;
    }

    public List<Comment> getCommentByTripId(int id) {

        MongoCollection<Document> collection = connection.getCollection("comment");
        FindIterable<Document> findIterable = collection.find(Filters.eq("idTrip", id));
        System.out.println("Successfully get the document");

        List<Comment> comments = new ArrayList<>();

        for (Document document : findIterable) {
            Comment comment = new Comment();
            if(document.getInteger("id")!=null) {
                comment.setIdTrip(document.getInteger("id"));
            }
            comment.setIdTrip(document.getInteger("idTrip"));
            comment.setComment(document.getString("comment"));
            comments.add(comment);

            // Set other fields as needed

        }
        return comments;
    }

    public void deleteAllComments() {
        MongoCollection<Document> collection = connection.getCollection("comment");
        try {
            collection.drop();

            System.out.println("Successfully dropped collection");
            System.out.println(
                    "Documents deleted Successfully");

            connection.createCollection("comment");
            System.out.println(
                    "Collection created Successfully");
        } catch (Exception e) {
            System.out.println(
                    "Documents delete failed");
            System.out.println(e);
        }
    }
}
