package com.netcracker.listeners;

public interface MyFileListeningSubject {

    void addListener(MyFileListener l);

    void notifyDataUpdated();
}
