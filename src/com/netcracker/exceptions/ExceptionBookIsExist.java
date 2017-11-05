package com.netcracker.exceptions;

public class ExceptionBookIsExist extends MyException {
    @Override
    public String toString() {
        return "Ошибка: книга уже есть в базе";
    }
}
