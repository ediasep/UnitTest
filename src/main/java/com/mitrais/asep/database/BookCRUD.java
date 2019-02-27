package com.mitrais.asep.database;

import com.mitrais.asep.model.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookCRUD {
    static SessionFactory sessionFactoryObj;

    public static void main(String[] args) {
        Book book = new Book();

        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (ExceptionInInitializerError ex) {
            ex.printStackTrace();
        }

        BookCRUD bookCRUD = new BookCRUD();
        bookCRUD.addBook("123", "Legends of Narnia", "I Forgot", "Published");

        book = bookCRUD.getBook(1);
        bookCRUD.updateBook(book, "212", "Legends of Narnia", "I am not forgot", "Published");
        bookCRUD.deleteBook(book);
    }

    public void addBook(String isbn, String title, String author, String status) {
        Session session = sessionFactoryObj.openSession();
        Transaction trx = null;

        try{
            trx = session.beginTransaction();
            Book book = new Book(isbn, title, author, status);
        } catch (HibernateException he) {
            if(trx != null) {
                trx.rollback();
            }
            he.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Book getBook(int id) {
        Session session = sessionFactoryObj.openSession();
        Transaction trx = null;
        Book book = new Book();

        try {
            trx = session.beginTransaction();
            book = (Book) session.get(Book.class, id);
        } catch (HibernateException he) {
            if(trx != null) {
                trx.rollback();
            }
        } finally {
            session.close();
        }

        return book;
    }

    public void updateBook(Book book, String isbn, String title, String author, String status) {
        Session session = sessionFactoryObj.openSession();
        Transaction trx = null;

        try {
            trx = session.beginTransaction();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setAuthor(author);
            book.setStatus(status);

            session.update(book);
            trx.commit();

            System.out.println("Record has been successfully updated");
        } catch (HibernateException he) {
            if(trx != null) {
                trx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void deleteBook(Book book) {
        Session session = sessionFactoryObj.openSession();
        Transaction trx = null;

        try{
            trx = session.beginTransaction();

            session.delete(book);
            trx.commit();

            System.out.println("Record has been successfully deleted");
        } catch (HibernateException he) {
            if(trx != null) {
                trx.rollback();
            }
        } finally {
            session.close();
        }
    }
}