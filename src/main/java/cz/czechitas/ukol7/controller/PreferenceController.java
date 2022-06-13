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
  private final Action ulozitAction;

  public Action getulozitAction() { return ulozitAction; }

  public PreferenceController() {
    model = new PresentationModel<>(new ModelBean());
    ulozitAction = ActionBuilder.create("&Uložit", this::handleUlozit);
    model.addBeanPropertyChangeListener(this::handlePropertyChange);
    vypoctiStavAkci();
  }

  private void handleUlozit() {
    ModelBean bean = this.model.getBean();
    System.out.println("-- Ukládám data o barvě --");
    System.out.printf("Přezdívka: %s", bean.getPrezdivka()).println();
    System.out.println("Oblíbená barva osoby s přezdívkou " + bean.getPrezdivka() + " je " + bean.getOblibenaBarva().getText());
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
    if (model.getBean().getPrezdivka() != null && model.getBean().getOblibenaBarva() != null){
      ulozitAction.setEnabled(true);
    }
    else {
      ulozitAction.setEnabled(false);
    }
    }
  }
