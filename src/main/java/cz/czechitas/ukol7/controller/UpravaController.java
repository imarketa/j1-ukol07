package cz.czechitas.ukol7.controller;

import com.jgoodies.binding.PresentationModel;
import cz.czechitas.ukol7.formbuilder.ActionBuilder;
import cz.czechitas.ukol7.model.BarvaBean;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class UpravaController {
  public static final List<String> PREZDIVKA = Arrays.asList(
          "Akim",
          "Black",
          "Chilli",
          "Dean",
          "Evan"
  );
  private final PresentationModel<BarvaBean> model;
  private final Action novyAction;
  private final Action ulozitAction;

  public UpravaController() {
    model = new PresentationModel<>(new BarvaBean());
    novyAction = ActionBuilder.create("&Nový", this::handleNovy);
    ulozitAction = ActionBuilder.create("&Uložit", this::handleUlozit);
    model.addBeanPropertyChangeListener(this::handlePropertyChange);
    vypoctiStavAkci();
  }

  private void handleUlozit() {
    BarvaBean bean = this.model.getBean();
    System.out.println("-- Ukládám data --");
  }

  private void handlePropertyChange(PropertyChangeEvent propertyChangeEvent) {
    vypoctiStavAkci();
  }

  public PresentationModel<BarvaBean> getModel() {
    return model;
  }

  public Action getNovyAction() {
    return novyAction;
  }

  public Action getUlozitAction() {
    return ulozitAction;
  }

  private void vypoctiStavAkci() {
    BarvaBean osoba = model.getBean();
    boolean enabled = osoba.getBarva() != null && osoba.getPrezdivka() != null;
    ulozitAction.setEnabled(enabled);
  }

  public void handleNovy() {
    this.model.setBean(new BarvaBean());
  }
  
}
