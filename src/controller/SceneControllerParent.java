package controller;

public abstract class SceneControllerParent {
    protected MainController mainController;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }
}