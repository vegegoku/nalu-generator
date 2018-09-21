package com.github.mvp4g;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

    private GeneratorLayout generatorLayout = new GeneratorLayout();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        generatorLayout.getLayout()
                .show();
        generatorLayout.getLayout()
                .getContentPanel()
                .appendChild(new ProjectMetaDataComponent())
                .appendChild(new ApplicationMetaDataComponent())
                .appendChild(new ScreenMetaDataCompnent());
    }
}
