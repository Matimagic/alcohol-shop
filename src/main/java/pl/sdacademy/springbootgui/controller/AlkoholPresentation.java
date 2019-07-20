package pl.sdacademy.springbootgui.controller;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sdacademy.springbootgui.Repository.AlcoholRepository;
import pl.sdacademy.springbootgui.entity.Alcohol;

import java.util.List;

@Route("show")
public class AlkoholPresentation extends HorizontalLayout {

    private AlcoholRepository alcoholRepository;

    @Autowired
    public AlkoholPresentation(AlcoholRepository alcoholRepository) {

        List<Alcohol> alcoList = alcoholRepository.findAll();

        Grid<Alcohol> alcoholGrid = new Grid<>(Alcohol.class);
        alcoholGrid.setItems(alcoList);
//        alcoholGrid.setColumns("Id", "Nazwa", "Cena", "Siła mózgotrzepa");

        alcoholGrid.removeColumnByKey("id");
        alcoholGrid.removeColumnByKey("image");

        alcoholGrid.addColumn(new ComponentRenderer<>(alco -> {
            Image image = new Image(alco.getImage(), "image");
            return image;
        }));

        add(alcoholGrid);

    }
}
