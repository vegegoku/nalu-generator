package com.github.mvp4g;

public class ScreenMetaData {

    private String componentName;
    private String route;
    private boolean startScreen;
    private boolean confirmation;

    public ScreenMetaData() {
    }

    public ScreenMetaData(String componentName, String route, boolean startScreen, boolean confirmation) {
        this.componentName = componentName;
        this.route = route;
        this.startScreen = startScreen;
        this.confirmation = confirmation;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public boolean isStartScreen() {
        return startScreen;
    }

    public void setStartScreen(boolean startScreen) {
        this.startScreen = startScreen;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "ScreenMetaData{" +
                "componentName='" + componentName + '\'' +
                ", route='" + route + '\'' +
                ", startScreen=" + startScreen +
                ", confirmation=" + confirmation +
                '}';
    }
}
