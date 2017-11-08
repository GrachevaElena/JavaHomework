package com.netcracker.library;

public class Author {
    private String Name;

    public Author(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Name != null ? Name.equals(author.Name) : author.Name == null;
    }

    @Override
    public int hashCode() {
        return Name != null ? Name.hashCode() : 0;
    }
}