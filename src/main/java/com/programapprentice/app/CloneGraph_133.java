package com.programapprentice.app;

import com.programapprentice.util.UndirectedGraphNode;

import java.util.*;

/**
 * User: program-apprentice
 * Date: 9/26/15
 * Time: 10:57 PM
 */
public class CloneGraph_133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        // map from old node to new node
        Map<UndirectedGraphNode, UndirectedGraphNode> map =
                new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode clonedNode = null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode curNode = null;
        while(!queue.isEmpty()) {
            curNode = queue.remove();

            UndirectedGraphNode newNode = map.get(curNode);
            if(newNode == null) {
                newNode = new UndirectedGraphNode(curNode.label);
                map.put(curNode, newNode);
            }

            if(clonedNode == null) {
                clonedNode = newNode;
            }

            for(UndirectedGraphNode neighbor : curNode.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                if(newNeighbor == null) {
                    newNeighbor = new UndirectedGraphNode(neighbor.label);
                    queue.add(neighbor);
                    map.put(neighbor, newNeighbor);
                }
                newNode.neighbors.add(newNeighbor);
            }
        }
        return clonedNode;
    }

}
