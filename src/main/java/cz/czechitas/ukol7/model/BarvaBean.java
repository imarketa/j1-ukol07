package cz.czechitas.ukol7.model;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;

import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * JavaBean s údaji o barvě.
 */
public class BarvaBean implements ObservableBean {
  private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);

  private String barva;
  private String prezdivka;

  public String getBarva() {
    return barva;
  }

  public void setBarva(String barva) {
    if (barva.isBlank()){
      barva=null;
    }
    String oldValue = this.barva;
    this.barva = barva;
    pcs.firePropertyChange("barva", oldValue, barva);
  }

  public String getPrezdivka() {
    return prezdivka;
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener) {

  }
}
