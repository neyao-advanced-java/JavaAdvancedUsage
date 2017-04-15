package org.oursight.neyao.java.advanced.algorithm.graph;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 每一行包含如下的信息：
 LinkID,SourceID,DestinationID,Cost
 其中，LinkID为该有向边的索引，SourceID为该有向边的起始顶点的索引，DestinationID为该有向边的终止顶点的索引，Cost为该有向边的权重。
 http://www.cnblogs.com/hapjin/p/5432996.html
 http://www.cnblogs.com/hapjin/p/5435724.html

 * 无向图的实现
 * Created by neyao on 2017/4/14.
 */
public class NonDirectedGraph {

    private Map<String, Vertex> graph;

    private Vertex startVertex;

    public NonDirectedGraph(String matrix) {
        graph = new LinkedHashMap<>();

    }

    private void buildGraph(String matrixText) {
        String[] lines = matrixText.split("\n");

        String startNodeValue, endNodeValue;
        Vertex startNode, endNode;

        for (int i = 0; i < lines.length; i++) {
            String[] nodes = lines[i].split(",");
            startNodeValue = nodes[1];
            endNodeValue = nodes[2];

            endNode = get(endNodeValue);
            if()
        }


    }

    public Vertex get(String value) {
        return null;
    }

    private class Vertex {
        private String label;
        private List<Edge> adjEdges;
        private Vertex preNode;

        public Vertex(String label) {
            this.label = label;
            adjEdges = new LinkedList<>();
            preNode = null;
        }
    }

    private class Edge {
        private Vertex endVertex;

        public Edge(Vertex endVertex) {
            this.endVertex = endVertex;
        }


    }
  
}


