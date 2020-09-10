package com.couchb;

import java.util.Arrays;

public class NodeHelper {

    /**
     * Add Neighbors to a given node
     *
     * @param parentNode Node for which you need to add children
     * @param currentNeighbors Nodes which are neighbors of current node
     * @return void
     */
    public void addChildren(Node parentNode,Node... currentNeighbors){
        for(Node neighbor:currentNeighbors){
            parentNode.neighbors.add(neighbor);
        }
    }

}
