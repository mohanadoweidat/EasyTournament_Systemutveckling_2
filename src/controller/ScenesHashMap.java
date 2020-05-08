package controller;

import javafx.scene.Scene;

import java.util.HashMap;

/**
 *
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public class ScenesHashMap {

    private HashMap<ScenesEnum, Scene> scenes = new HashMap<>();

    /**
     * Adds a scene to the scene hashmap
     */
    public synchronized void put(ScenesEnum name, Scene scene){
        scenes.put(name, scene);
    }

    /**
     * Returns a scene from the scene hashmap
     */
    public synchronized Scene get(ScenesEnum name){
        return scenes.get(name);
    }
}
