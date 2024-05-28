package org.example.Classe;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    public void notifyObservers();
}
