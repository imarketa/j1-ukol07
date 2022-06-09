package cz.czechitas.ukol7.controller;

import com.jgoodies.binding.PresentationModel;
import cz.czechitas.ukol7.formbuilder.ActionBuilder;
import cz.czechitas.ukol7.model.ModelBean;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.List;

public class PreferenceController {
  private final PresentationModel<ModelBean> model;
  private Action novyAction;
  private final Action ulozitAction;

  public Action getNovyAction() { return novyAction; }

  public PreferenceController() {
    this.novyAction = novyAction;
    model = new PresentationModel<>(new ModelBean());
    ulozitAction = ActionBuilder.create("&Uložit", this::handleUlozit);
    model.addBeanPropertyChangeListener(this::handlePropertyChange);
    vypoctiStavAkci();
  }

  private void handleUlozit() {
    ModelBean bean = this.model.getBean();
    System.out.println("-- Ukládám data --");
    System.out.printf("Přezdívka: %s", bean.getPrezdivka()).println();
    System.out.printf("Barva : %s", bean.getBarva()).println();
  }

  private void handlePropertyChange(PropertyChangeEvent propertyChangeEvent) {
    vypoctiStavAkci();
  }

  public PresentationModel<ModelBean> getModel() {
    return model;
  }

  public Action getUlozitAction() {
    return ulozitAction;
  }

  private void vypoctiStavAkci() {
    ModelBean osoba = model.getBean();
    boolean enabled = osoba.getBarva() != null && osoba.getPrezdivka() != null;
    ulozitAction.setEnabled(enabled);
  }

  public void handleNovy() {
    this.model.setBean(new ModelBean());
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
