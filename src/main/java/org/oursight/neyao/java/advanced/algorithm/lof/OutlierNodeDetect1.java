package org.oursight.neyao.java.advanced.algorithm.lof;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by neyao on 2017/5/21.
 */
public class OutlierNodeDetect1 {

    private static int MIN_PTS = 5; //前几位的点

    //1.找到给定点与其他点的欧几里得距离
    //2.对欧几里得距离进行排序，找到前5位的点，并同时记下k距离
    //3.计算每个点的可达密度
    //4.计算每个点的局部离群点因子
    //5.对每个点的局部离群点因子进行排序，输出。
    public List<Node> getOutlierNode(List<Node> allNodes) {

        List<Node> kdAndKnList = getKDAndKN(allNodes);
        calReachDis(kdAndKnList);
        calReachDensity(kdAndKnList);
        calLof(kdAndKnList);
        Collections.sort(kdAndKnList, new LofComparator());

        return kdAndKnList;
    }


    private void calLof(List<Node> kdAndKnList) {
        for (Node node : kdAndKnList) {
            List<Node> tempNodes = node.getkNeighbor();
            double sum = 0.0;
            for (Node tempNode : tempNodes) {
                double rd = getRD(tempNode.getNodeName(), kdAndKnList);
                sum = rd / node.getReachDensity() + sum;
            }
            sum = sum / (double) MIN_PTS;
            node.setLof(sum);
        }
    }


    private void calReachDensity(List<Node> kdAndKnList) {
        for (Node node : kdAndKnList) {
            List<Node> tempNodes = node.getkNeighbor();
            double sum = 0.0;
            double rd = 0.0;
            for (Node tempNode : tempNodes) {
                sum = tempNode.getReachDis() + sum;
            }
            rd = (double) MIN_PTS / sum;
            node.setReachDensity(rd);
        }
    }


    private void calReachDis(List<Node> kdAndKnList) {
        for (Node node : kdAndKnList) {
            List<Node> tempNodes = node.getkNeighbor();
            for (Node tempNode : tempNodes) {
                double kDis = getKDis(tempNode.getNodeName(), kdAndKnList);
                if (kDis < tempNode.getDistance()) {
                    tempNode.setReachDis(tempNode.getDistance());
                } else {
                    tempNode.setReachDis(kDis);
                }
            }
        }
    }

    private double getKDis(String nodeName, List<Node> nodeList) {
        double kDis = 0;
        for (Node node : nodeList) {
            if (nodeName.trim().equals(node.getNodeName().trim())) {
                kDis = node.getkDistance();
                break;
            }
        }
        return kDis;

    }


    private double getRD(String nodeName, List<Node> nodeList) {
        double kDis = 0;
        for (Node node : nodeList) {
            if (nodeName.trim().equals(node.getNodeName().trim())) {
                kDis = node.getReachDensity();
                break;
            }
        }
        return kDis;

    }


    private List<Node> getKDAndKN(List<Node> allNodes) {
        List<Node> kdAndKnList = new ArrayList<Node>();
        for (int i = 0; i < allNodes.size(); i++) {
            List<Node> tempNodeList = new ArrayList<Node>();
            Node nodeA = new Node(allNodes.get(i).getNodeName(), allNodes.get(i).getDimensioin());
            // 遍历所有节点，得到和该节点的距离
            for (int j = 0; j < allNodes.size(); j++) {
                Node nodeB = new Node(allNodes.get(j).getNodeName(), allNodes.get(j).getDimensioin());
                double tempDis = getDis(nodeA, nodeB);
                nodeB.setDistance(tempDis);
                tempNodeList.add(nodeB);
            }

            //对tempNodeList进行排序
            Collections.sort(tempNodeList, new DistComparator());
            for (int k = 1; k < MIN_PTS; k++) {
                nodeA.getkNeighbor().add(tempNodeList.get(k));
                if (k == MIN_PTS - 1) {
                    nodeA.setkDistance(tempNodeList.get(k).getDistance());
                }
            }
            kdAndKnList.add(nodeA);
        }

        return kdAndKnList;
    }


    /**
     * 计算两个节点之间的欧几里德距离
     * see: http://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E5%BA%A6%E9%87%8F/1274107?fromtitle=%E6%AC%A7%E6%B0%8F%E8%B7%9D%E7%A6%BB&fromid=1798948
     * @param A
     * @param B
     * @return
     */
    private double getDis(Node A, Node B) {
        double dis = 0.0;
        double[] dimA = A.getDimensioin();
        double[] dimB = B.getDimensioin();
        if (dimA.length == dimB.length) {
            for (int i = 0; i < dimA.length; i++) {
                double temp = Math.pow(dimA[i] - dimB[i], 2);
                dis = dis + temp;
            }
            dis = Math.pow(dis, 0.5); //即开方
        }
        return dis;
    }

    class DistComparator implements Comparator<Node> {
        public int compare(Node A, Node B) {
            return A.getDistance() - B.getDistance() < 0 ? -1 : 1;
        }
    }

    class LofComparator implements Comparator<Node> {
        public int compare(Node A, Node B) {
            return A.getLof() - B.getLof() < 0 ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Node> dpoints = new ArrayList<Node>();

        double[] a = {2, 3};
        double[] b = {2, 4};
        double[] c = {1, 4};
        double[] d = {1, 3};
        double[] e = {2, 2};
        double[] f = {3, 2};

        double[] g = {8, 7};
        double[] h = {8, 6};
        double[] i = {7, 7};
        double[] j = {7, 6};
        double[] k = {8, 5};

        double[] l = {100, 2};//孤立点


        double[] m = {8, 20};
        double[] n = {8, 19};
        double[] o = {7, 18};
        double[] p = {7, 17};
        double[] q = {8, 21};

        dpoints.add(new Node("a", a));
        dpoints.add(new Node("b", b));
        dpoints.add(new Node("c", c));
        dpoints.add(new Node("d", d));
        dpoints.add(new Node("e", e));
        dpoints.add(new Node("f", f));

        dpoints.add(new Node("g", g));
        dpoints.add(new Node("h", h));
        dpoints.add(new Node("i", i));
        dpoints.add(new Node("j", j));
        dpoints.add(new Node("k", k));

        dpoints.add(new Node("l", l));

        dpoints.add(new Node("m", m));
        dpoints.add(new Node("n", n));
        dpoints.add(new Node("o", o));
        dpoints.add(new Node("p", p));
        dpoints.add(new Node("q", q));

        OutlierNodeDetect1 lof = new OutlierNodeDetect1();

        List<Node> nodeList = lof.getOutlierNode(dpoints);

        for (Node node : nodeList) {
            System.out.println(node.getNodeName() + "  " + node.getLof());
        }

    }
}
