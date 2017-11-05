package com.netcracker.exceptions;

public class ExceptionBookNotExist  extends MyException{
    @Override
    public String toString() {
        return "Ошибка: книги нет в базе";
    }
}
