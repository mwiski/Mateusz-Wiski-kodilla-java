package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void addObserver(Mentor mentor);
    void notifyObservers();
    void removeObserver(Mentor mentor);
}
