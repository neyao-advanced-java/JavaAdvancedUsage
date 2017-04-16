package org.oursight.neyao.java.advanced.algorithm.graph;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 每一行包含如下的信息：
 * LinkID,SourceID,DestinationID,Cost
 * 其中，LinkID为该有向边的索引，SourceID为该有向边的起始顶点的索引，DestinationID为该有向边的终止顶点的索引，Cost为该有向边的权重。
 * http://www.cnblogs.com/hapjin/p/5432996.html
 * http://www.cnblogs.com/hapjin/p/5435724.html
 * <p>
 * 无向图的实现
 * Created by neyao on 2017/4/14.
 */
public class NonDirectedGraph {

    public static void main(String[] args) throws IOException {
        String text = FileUtils.readFileToString(new File("D:\\Workspace\\Mine\\JavaAdvancedUsage\\src\\main\\java\\org\\oursight\\neyao\\java\\advanced\\algorithm\\graph\\graph-1.txt"), "UTF-8");

        System.out.println("text:\n" + text);

        NonDirectedGraph g = new NonDirectedGraph(text);
        System.out.println(g);

        g.unweightedShortestPath();
        g.showDistance();

    }

    private Map<String, Vertex> graph;

    private Vertex startVertex;

    public NonDirectedGraph(String matrixText) {
        graph = new LinkedHashMap<>();
        buildGraph(matrixText);
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
            if (endNode == null) {
                endNode = new Vertex(endNodeValue);
                graph.put(endNodeValue, endNode);
            }

            startNode = get(startNodeValue);
            if (startNode == null) {
                startNode = new Vertex(startNodeValue);
                graph.put(startNodeValue, startNode);
            }

            Edge edge = new Edge(endNode);
            endNode.adjEdges.add(edge);
            startNode.adjEdges.add(edge);
        }

        //总是以文件中第一行第二列的那个标识顶点作为源点
        startVertex = graph.get(lines[0].split(",")[1]);


    }

    public void unweightedShortestPath() {
        unweightedShortestPath(startVertex);
    }

    /*
 * 计算源点s到无向图中各个顶点的最短路径
 * 需要一个队列来保存图中的顶点,初始时,源点入队列,然后以广度的形式向外扩散求解其他顶点的最短路径
 */
    private void unweightedShortestPath(Vertex s) {
        //初始化
        Queue<Vertex> queue = new LinkedList<>();
        s.dist = 0;
        queue.offer(s);//将源点dist设置为0并入队列

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Edge e : v.adjEdges) {//扫描v的邻接边(点)
                if (e.endVertex.dist == Integer.MAX_VALUE) {//如果这个顶点(e.endVertex)未被访问(每个顶点只会入队列一次)
                    e.endVertex.dist = v.dist + 1;//更新该顶点到源点的距离
                    queue.offer(e.endVertex);
                    e.endVertex.preNode = v;//设置该顶点的前驱顶点
                }//end if
            }//end for
        }//end while
    }

    //打印图中所有顶点到源点的距离及路径
    public void showDistance() {
        Collection<Vertex> vertexs = graph.values();
        for (Vertex vertex : vertexs) {
            System.out.print(vertex.label + "<--");
            Vertex tmpPreNode = vertex.preNode;
            while (tmpPreNode != null) {
                System.out.print(tmpPreNode.label + "<--");
                tmpPreNode = tmpPreNode.preNode;
            }
            System.out.println("distance=" + vertex.dist);
        }
    }


    public Vertex get(String value) {
        return graph.get(value);
    }

    private class Vertex {
        private String label;
        private List<Edge> adjEdges;
        private Vertex preNode;
        private int dist;

        public Vertex(String label) {
            this.label = label;
            adjEdges = new LinkedList<>();
            dist = Integer.MAX_VALUE;
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


