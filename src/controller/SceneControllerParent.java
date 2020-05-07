package controller;

public abstract class SceneControllerParent {

    protected MainController mainController;

    /**
     * Sets an instance of the mainController
     */
    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }
}