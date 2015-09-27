package com.programapprentice.util;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/26/15
 * Time: 11:55 PM
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
