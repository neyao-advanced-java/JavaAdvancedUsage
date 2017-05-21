package org.oursight.neyao.java.advanced.algorithm.lof;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neyao on 2017/5/21.
 */
public class Node {

    private String nodeName; // 样本点名
    private double[] dimensioin; // 样本点的维度，即在X轴 Y轴上的距离
    private double kDistance; // k-距离
    private List<Node> kNeighbor = new ArrayList<Node>();// k-领域
    private double distance; //到给定点的欧几里得距离
    private double reachDensity;// 可达密度
    private double reachDis;// 可达距离


    private double lof;//局部离群因子

    public Node() {

    }

    public Node(String nodeName, double[] dimensioin) {
        this.nodeName = nodeName;
        this.dimensioin = dimensioin;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public double[] getDimensioin() {
        return dimensioin;
    }

    public void setDimensioin(double[] dimensioin) {
        this.dimensioin = dimensioin;
    }

    public double getkDistance() {
        return kDistance;
    }

    public void setkDistance(double kDistance) {
        this.kDistance = kDistance;
    }

    public List<Node> getkNeighbor() {
        return kNeighbor;
    }

    public void setkNeighbor(List<Node> kNeighbor) {
        this.kNeighbor = kNeighbor;
    }


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getReachDensity() {
        return reachDensity;
    }

    public void setReachDensity(double reachDensity) {
        this.reachDensity = reachDensity;
    }

    public double getReachDis() {
        return reachDis;
    }

    public void setReachDis(double reachDis) {
        this.reachDis = reachDis;
    }

    public double getLof() {
        return lof;
    }

    public void setLof(double lof) {
        this.lof = lof;
    }

}


