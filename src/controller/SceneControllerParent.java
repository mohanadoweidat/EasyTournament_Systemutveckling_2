package controller;

/**
 *
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public abstract class SceneControllerParent {

    protected MainController mainController;

    /**
     * Sets an instance of the mainController
     */
    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }
}