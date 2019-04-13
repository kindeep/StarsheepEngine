package devTool.Panels;

import java.util.List;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

import devTool.models.EditableChoice;


public class ChoicesGraph {
	Graph graph;
	public ChoicesGraph() {
		graph = new SingleGraph("Tutorial 1");
		graph.addAttribute("ui.stylesheet", "node {fill-color: red;}");
		graph.display();
	}
	
	public void populationGraph(List<EditableChoice> choices) {
		graph.clear();
		graph.addAttribute("ui.stylesheet", "node {fill-color: red;}");
		for (EditableChoice c: choices) {
			Node n = graph.addNode(c.id);
			n.addAttribute("ui.label", c.name);
			 n.addAttribute("ui.class", "base");
		}
		
		//connect the dots
		for (EditableChoice c: choices) {
			for (String childId: c.children) {
				graph.addEdge(c.id + childId, c.id, childId);
			}
		}
	}
	
	public static void main(String args[]) {
		new ChoicesGraph();
	}

}
