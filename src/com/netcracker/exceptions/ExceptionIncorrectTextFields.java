package com.netcracker.exceptions;

public class ExceptionIncorrectTextFields extends MyException {
    String field;

    public ExceptionIncorrectTextFields(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Неверное значение поля \""+field+"\"";
    }
}
