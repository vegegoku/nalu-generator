package com.github.mvp4g;

import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

public class ScreenMetaDataCompnent implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().asElement();
    private final LocalListDataStore<ScreenMetaData> dataStore;
    private final TableConfig<ScreenMetaData> screenMetaDataTableConfig;
    private final DataTable<ScreenMetaData> dataDataTable;
    private final Button addButton;

    public ScreenMetaDataCompnent() {

        Card card = Card.create("Screen meta data");
        addButton = Button.createDefault(Icons.ALL.add());

        dataStore = new LocalListDataStore<>();
        dataStore.setData(prepareInitialData());

        screenMetaDataTableConfig = new TableConfig<>();

        screenMetaDataTableConfig
                .addColumn(ColumnConfig.<ScreenMetaData>create("name", "Component name")
                        .setWidth("250px")
                        .setFixed(true)
                        .setCellRenderer(cellInfo -> {
                            TextBox textBox = TextBox.create();
                            textBox
                                    .setValue(cellInfo.getRecord().getComponentName())
                                    .setReadOnly(true)
                                    .setRequired(true)
                                    .setAutoValidation(true)
                                    .addClickListener(evt -> {
                                        textBox.setReadOnly(false);
                                        textBox.focus();
                                        textBox.getInputElement().asElement().select();
                                    })
                                    .addChangeHandler(value -> {
                                        if (textBox.validate().isValid()) {
                                            cellInfo.getRecord().setComponentName(value);
                                        }
                                    });
                            textBox.getInputElement()
                                    .styler(style -> style.setPaddingLeft("3px"))
                                    .addEventListener("blur", evt -> textBox.setReadOnly(true))
                                    .addEventListener("keypress", evt -> {
                                        if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                                            textBox.setReadOnly(true);
                                        }
                                    });
                            return textBox.asElement();
                        }))

                .addColumn(ColumnConfig.<ScreenMetaData>create("token", "Route")
                        .setWidth("250px")
                        .setFixed(true)
                        .setCellRenderer(cellInfo -> {
                            TextBox textBox = TextBox.create();
                            textBox
                                    .setValue(cellInfo.getRecord().getRoute())
                                    .setReadOnly(true)
                                    .setRequired(true)
                                    .setAutoValidation(true)
                                    .addClickListener(evt -> {
                                        textBox.setReadOnly(false);
                                        textBox.focus();
                                        textBox.getInputElement().asElement().select();
                                    })
                                    .addChangeHandler(value -> {
                                        if (textBox.validate().isValid()) {
                                            cellInfo.getRecord().setRoute(value);
                                        }
                                    });
                            textBox.getInputElement()
                                    .styler(style -> style.setPaddingLeft("3px"))
                                    .addEventListener("blur", evt -> textBox.setReadOnly(true))
                                    .addEventListener("keypress", evt -> {
                                        if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                                            textBox.setReadOnly(true);
                                        }
                                    });
                            return textBox.asElement();
                        }))

                .addColumn(ColumnConfig.<ScreenMetaData>create("name", "Start screen")
                        .setCellRenderer(cellInfo -> SwitchButton.create()
                                .setOnTitle("Yes")
                                .setOffTitle("No")
                                .setValue(cellInfo.getRecord().isStartScreen())
                                .addChangeHandler(value -> cellInfo.getRecord().setStartScreen(value)).asElement()))

                .addColumn(ColumnConfig.<ScreenMetaData>create("name", "Confirmation")
                        .setCellRenderer(cellInfo -> SwitchButton.create()
                                .setOnTitle("Yes")
                                .setOffTitle("No")
                                .setValue(cellInfo.getRecord().isConfirmation())
                                .addChangeHandler(value -> cellInfo.getRecord().setConfirmation(value)).asElement()))

                .addColumn(ColumnConfig.<ScreenMetaData>create("remove", "")
                        .setCellRenderer(cellInfo -> Icons.ALL.delete()
                                .styler(style -> style.setCursor("pointer"))
                                .addClickListener(evt -> dataStore.removeRecord(cellInfo.getRecord())).asElement()));


        dataDataTable = new DataTable<>(screenMetaDataTableConfig, dataStore);
        dataDataTable.condense();

        card.getHeaderBar()
                .appendChild(addButton
                        .setContent("ADD")
                        .styler(style -> style.setMarginTop("-10px"))
                        .linkify()
                        .addClickListener(evt -> {
                            int index = dataStore.getRecords().size() + 1;
                            ScreenMetaData screenMetaData = new ScreenMetaData("Screen" + index, "screen" + index, false, false);
                            dataStore.addRecord(screenMetaData);
                        }));


        this.element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .offset3()
                        .appendChild(card
                                .appendChild(dataDataTable)
                        )
                )
                .asElement());
        dataDataTable.load();
    }

    private List<ScreenMetaData> prepareInitialData() {

        List<ScreenMetaData> screens = new ArrayList<>();
        screens.add(new ScreenMetaData("Screen01", "screen01", true, false));
        screens.add(new ScreenMetaData("Screen02", "screen02", false, false));
        screens.add(new ScreenMetaData("Screen03", "screen03", false, true));
        screens.add(new ScreenMetaData("Screen04", "screen04", false, false));
        screens.add(new ScreenMetaData("Screen05", "screen05", false, false));
        return screens;
    }

    public List<ScreenMetaData> getScreens() {
        return dataStore.getRecords();
    }


    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
