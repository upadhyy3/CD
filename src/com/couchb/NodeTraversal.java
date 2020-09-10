package com.couchb;

import java.util.HashMap;
import java.util.Map;

/*
N -> no of nodes
Time Complexity: O(N) [Traverse each element in DAG only once]
Space: O(N) [For storing computed values in map]
 */

public class NodeTraversal {

    int maximumVal = -1;
    public int getMaximumPathLength(Node root){
        Map<Node,Integer> maxPathLengthFromRoot = new HashMap<>();
        dfs(root,maxPathLengthFromRoot);
        return maximumVal;
    }

    public void dfs(Node currentNode,Map<Node,Integer> maxPathLengthFromRoot){
        if(currentNode == null || maxPathLengthFromRoot.containsKey(currentNode)){
            return;
        }

        maxPathLengthFromRoot.put(currentNode,0);

        // Traverse for all its children
        for (Node neighbor: currentNode.neighbors){
            // If not visited
            if (!maxPathLengthFromRoot.containsKey(neighbor))
                dfs(neighbor,maxPathLengthFromRoot);

            // Store the max of the paths
            maxPathLengthFromRoot.put(currentNode,
                    Math.max(maxPathLengthFromRoot.get(currentNode),
                            1 + maxPathLengthFromRoot.get(neighbor)));
        }

        //compute max each time a new value is added to visited/memoized
        maximumVal = Math.max(maximumVal,maxPathLengthFromRoot.get(currentNode));
    }
}
