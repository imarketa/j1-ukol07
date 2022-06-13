package cz.czechitas.ukol7.view;

import cz.czechitas.ukol7.Aplikace;
import cz.czechitas.ukol7.controller.Barva;
import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import cz.czechitas.ukol7.model.ModelBean;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class HlavniOkno extends JFrame {
    private final PreferenceController controller;

    public HlavniOkno(PreferenceController controller) throws HeadlessException {
        super("Přezdívka a barva");
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
        setLayout(new MigLayout("wrap 2", "[right, 100]rel[50:75:250,grow,fill]"));
        setMinimumSize(new Dimension(400, 200));

        FormBuilderWithContainer<ModelBean> formBuilder = FormBuilder.create(controller.getModel())
                .container(this);

        formBuilder
                .label("&Přezdívka")
                .textField("prezdivka")
                .add("left");

        for (Barva value: Barva.values()){
            formBuilder
                    .radioButton(value.getText(), "oblibenaBarva", value)
                    .add("left, span");
        }

        formBuilder
                .panel(panel -> {
                    JButton ulozitButton = new JButton(controller.getUlozitAction());
                    getRootPane().setDefaultButton(ulozitButton);
                    panel.add(ulozitButton);
                })
                .add("right, span");
        pack();
    }
}
