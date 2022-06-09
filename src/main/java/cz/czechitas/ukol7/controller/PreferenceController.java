package cz.czechitas.ukol7.controller;

import com.jgoodies.binding.PresentationModel;
import cz.czechitas.ukol7.formbuilder.ActionBuilder;
import cz.czechitas.ukol7.model.BarvaBean;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.List;

public class PreferenceController {
  private final PresentationModel<BarvaBean> model;
  private Action novyAction;
  private final Action ulozitAction;

  public Action getNovyAction() { return novyAction; }

  public PreferenceController() {
    this.novyAction = novyAction;
    model = new PresentationModel<>(new BarvaBean());
    ulozitAction = ActionBuilder.create("&Uložit", this::handleUlozit);
    model.addBeanPropertyChangeListener(this::handlePropertyChange);
    vypoctiStavAkci();
  }

  private void handleUlozit() {
    BarvaBean bean = this.model.getBean();
    System.out.println("-- Ukládám data --");
    System.out.printf("Přezdívka: %s", bean.getPrezdivka()).println();
    System.out.printf("Oblíbená barva : %s", bean.getBarva()).println();
  }

  private void handlePropertyChange(PropertyChangeEvent propertyChangeEvent) {
    vypoctiStavAkci();
  }

  public PresentationModel<BarvaBean> getModel() {
    return model;
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

  public static final List<String> PREZDIVKA = Arrays.asList(
          "Žluťásek",
          "Black",
          "Chilli",
          "Modrák"
  );

  public enum Barva {
    Zluta("žlutá"),
    Cerna("černá"),
    Cervena("červená"),
    Modra("modrá");


    private final String text;

    Barva(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }
  }
}
