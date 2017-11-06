package com.netcracker.exceptions;

public class ExceptionInvalidIndex extends MyException {
    @Override
    public String toString() {
        return "Ошибка: нет ни одной выделенной строки";
    }
}
