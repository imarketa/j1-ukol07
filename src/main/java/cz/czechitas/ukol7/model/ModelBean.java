package cz.czechitas.ukol7.model;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;
import cz.czechitas.ukol7.controller.Barva;

import java.beans.PropertyChangeListener;

/**
 * JavaBean s údaji o barvě.
 */
public class ModelBean implements ObservableBean {
    private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);

    private String prezdivka;
    private Barva oblibenaBarva;

    public Barva getOblibenaBarva() {
        return oblibenaBarva;
    }

    public void setOblibenaBarva(Barva oblibenaBarva) {
        Barva oldValue = this.oblibenaBarva;
        this.oblibenaBarva = oblibenaBarva;
        pcs.firePropertyChange("barva", oldValue, oblibenaBarva);
    }

    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {

        if (prezdivka.isBlank()) {
            this.prezdivka = null;
        }
        String oldVlaue = this.prezdivka;
        this.prezdivka = prezdivka;
        pcs.firePropertyChange("prezdivka", oldVlaue, prezdivka);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }
}
