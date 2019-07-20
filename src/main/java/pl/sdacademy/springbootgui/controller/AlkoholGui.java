package pl.sdacademy.springbootgui.controller;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sdacademy.springbootgui.Repository.AlcoholRepository;
import pl.sdacademy.springbootgui.entity.Alcohol;
import pl.sdacademy.springbootgui.entity.PowerLevel;

import java.math.BigDecimal;

@Route("alcohol")
public class AlkoholGui extends VerticalLayout {

    private AlcoholRepository alcoholRepository;

    @Autowired
    public AlkoholGui(AlcoholRepository alcoholRepository) {
//        Label label = new Label();
//        TextField textField = new TextField("Podaj swoje imię");
//        Button button = new Button("Ok", new Icon(VaadinIcon.THUMBS_UP));
//
//        button.addClickListener(clickEvent -> {
//            label.setText("Hello " + textField.getValue() );
//        });
//
//        add(textField, button, label);

        Label label = new Label();
        TextField name = new TextField("Podaj nazwę");
        TextField price = new TextField("Podaj cenę");
        Select<PowerLevel> powerLevelSelect = new Select<>(PowerLevel.values());
        powerLevelSelect.setLabel("Wybierz siłę mózgotrzepa");
        TextField image = new TextField("Wklej adres do grafiki");

        Button button = new Button("Dodaj", new Icon(VaadinIcon.GLASS));
        button.addClickListener(clickEvent -> {
            Alcohol alcohol = new Alcohol();
            alcohol.setName(name.getValue());
            alcohol.setPrice(new BigDecimal(Integer.valueOf(price.getValue())));
            alcohol.setPowerLevel(powerLevelSelect.getValue());
            alcohol.setImage(image.getValue());

            alcoholRepository.save(alcohol);
        });

        add(label, name, price, powerLevelSelect, image, button);

        add("Dodano nowy alkohol!");

    }

}
