package com.github.mvp4g;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class ProjectMetaDataComponent implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().asElement();
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    public ProjectMetaDataComponent() {

        TextBox groupIdTextBox = TextBox.create("Group ID")
                .setPlaceholder("com.example")
                .setValue("com.example")
                .floating()
                .setRequired(true)
                .setAutoValidation(true)
                .groupBy(fieldsGrouping);

        TextBox artifactIdTextBox = TextBox.create("Artifact ID")
                .setPlaceholder("MyTestProject")
                .setValue("MyTestProject")
                .floating()
                .setRequired(true)
                .setAutoValidation(true)
                .groupBy(fieldsGrouping);

        Select<String> gwtVersionSelect = Select.<String>create("GWT Version")
                .appendChild(SelectOption.create("2.8.2", "2.8.2"))
                .selectAt(0)
                .setRequired(true)
                .setAutoValidation(true)
                .groupBy(fieldsGrouping);

        Select<String> widgetSetSelect = Select.<String>create("Widget Set")
                .appendChild(SelectOption.create("GWT widgets", "use GWT widgets (will not work with J2CL / GWT 3)"))
                .appendChild(SelectOption.create("Elemento widgets", "use Elemento widgets"))
                .appendChild(SelectOption.create("GXT Widgets", "use GXT GPL widgets (will not work with J2CL / GWT 3)"))
                .appendChild(SelectOption.create("Domino-UI", "Use Domino UI"))
                .selectAt(3)
                .setRequired(true)
                .setAutoValidation(true)
                .groupBy(fieldsGrouping);


        this.element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .offset3()
                        .appendChild(BlockHeader.create("Project Meta Data"))
                        .appendChild(Card.create()
                                .styler(style -> style.setPaddingTop("20px"))
                                .appendChild(Row.create()
                                        .appendChild(Column
                                                .span6()
                                                .appendChild(groupIdTextBox))
                                        .appendChild(Column
                                                .span6()
                                                .appendChild(artifactIdTextBox)))
                                .appendChild(Row.create()
                                        .appendChild(Column
                                                .span6()
                                                .condenced()
                                                .appendChild(gwtVersionSelect))
                                        .appendChild(Column
                                                .span6()
                                                .condenced()
                                                .appendChild(widgetSetSelect)))
                        )
                )
                .asElement());


    }

    public boolean isValid() {
        return fieldsGrouping.validate().isValid();
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
