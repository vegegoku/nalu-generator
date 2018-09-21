package com.github.mvp4g;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class ApplicationMetaDataComponent implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().asElement();

    public ApplicationMetaDataComponent() {
        this.element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .offset3()
                        .appendChild(BlockHeader.create("Project Meta Data"))
                        .appendChild(Card.create()
                                .appendChild(Row.create()
                                        .appendChild(Column
                                                .span6()
                                                .condenced()
                                                .appendChild(CheckBox.create("Generate Application Loader class")
                                                        .check()
                                                        .filledIn()
                                                        .styler(style -> style.setMarginBottom("0px"))))
                                        .appendChild(Column
                                                .span6()
                                                .condenced()
                                                .appendChild(CheckBox.create("Generate Debug support (in development mode)")
                                                        .check()
                                                        .filledIn()
                                                        .styler(style -> style.setMarginBottom("0px")))))
                        )
                )
                .asElement());
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
