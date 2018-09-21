package com.github.mvp4g;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.layout.Footer;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.style.Color;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.h;

public class GeneratorLayout {

    private final Layout layout;

    public GeneratorLayout() {
        layout = Layout.create("Nalu generator")
                .disableLeftPanel()
                .setHeaderHeight("130px");


        layout.getNavigationBar()
                .clearElement();

        layout.getNavigationBar()
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .offset3()
                                .appendChild(h(1).css("header-title").textContent("Nalu Initializer"))
                        )
                        .appendChild(Column.span3()
                                .appendChild(h(4).css("sub-title").textContent("Generate you Nalu application ..."))
                        )
                );

        layout.showFooter()
                .fixFooter();
        Footer footer = layout.getFooter();
        footer.appendChild(Row.create()
                .addCss("top")
                .appendChild(Column.span2()
                        .offset5()
                        .appendChild(Button.create("GENERATE")
                                .setBackground(Color.BLUE_LIGHTEN_2)
                                .block()
                                .setSize(ButtonSize.LARGE)
                        ))
        )
                .appendChild(Row.create()
                        .addCss("bottom")
                        .appendChild(Column.span2()
                                .offset2()
                                .appendChild(a().textContent("Mvp4g2@Github")))
                        .appendChild(Column.span2()
                                .appendChild(a().textContent("Mvp4g2 Documentation")))
                        .appendChild(Column.span2()
                                .appendChild(a().textContent("Generator Documentation")))
                        .appendChild(Column.span2()
                                .appendChild(a().textContent("Generator Issues")))
                );
    }

    public Layout getLayout() {
        return layout;
    }
}
