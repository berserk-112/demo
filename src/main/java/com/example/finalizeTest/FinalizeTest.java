package com.example.finalizeTest;

class Book{
    boolean checkedOut = false;
    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn(){
        checkedOut = false;
    }

    //gc(垃圾回收)时会执行该方法
    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("error:checked out");
//            super.finalize();
        }
    }
}
public class FinalizeTest {
    public static void main(String[] args) throws Throwable {
        Book book = new Book(true);
//        book.checkIn();
        new Book(true);
        System.gc();
    }
}
