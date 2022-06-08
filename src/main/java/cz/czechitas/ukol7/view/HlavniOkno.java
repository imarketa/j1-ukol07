package cz.czechitas.ukol7.view;

import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.SelectionInList;
import cz.czechitas.ukol7.Aplikace;
import cz.czechitas.ukol7.controller.UpravaController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import cz.czechitas.ukol7.model.BarvaBean;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class HlavniOkno extends JFrame {
  private final UpravaController controller;

  public HlavniOkno(UpravaController controller) throws HeadlessException {
    super("Uprava");
    this.controller = controller;
    this.init();
  }

  public void start() {
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void init() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
    setLayout(new MigLayout("wrap 4", "[right]rel[50:75:250,grow,fill]unrel[right]rel[50:75:250,grow,fill]"));
    setMinimumSize(new Dimension(400, 200));

      FormBuilderWithContainer<BarvaBean> formBuilder = FormBuilder.create(controller.getModel())
            .container(this);

    formBuilder
            .label("&Prezdivka")
            .textField("prezdivka")
            .add();

    formBuilder
            .label("&Barva")
            .textField("barva")
            .add();
    pack();
  }

}
