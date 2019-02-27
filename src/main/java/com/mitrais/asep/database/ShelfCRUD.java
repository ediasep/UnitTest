package com.mitrais.asep.database;

import com.mitrais.asep.model.Book;
import com.mitrais.asep.model.Shelf;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class ShelfCRUD {
    static SessionFactory sessionFactoryObj;
    public static void main(String[] args) {
        Shelf shelf = new Shelf();

        try{
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (ExceptionInInitializerError ex) {
            ex.printStackTrace();
        }
    }

    public void addBookToShelf(int id) {
        Session session = sessionFactoryObj.openSession();
        Transaction trx = null;

        try {
            trx = session.beginTransaction();
            Shelf shelf = new Shelf();
            BookCRUD bookCRUD = new BookCRUD();
            Book book = bookCRUD.getBook(id);

            ArrayList<Book> books = shelf.getBooks();
            books.add(book);

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.close();
        }
    }
}
