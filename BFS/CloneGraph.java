//#133
class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		//clone new node for return
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		//use a map to track newly cloned node
		map.put(node.label, newNode);
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		//use a queue to mark visited old node
		queue.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode curr = queue.pop();
			for (UndirectedGraphNode n : curr.neighbors) {
				if (!map.containsKey(n.label)) {
					//if map doesn't have a given node (which is curr node's neighbor)
					//add this node into the map
					map.put(n.label, new UndirectedGraphNode(n.label));
					queue.add(n);
				}
				//get curr.lable's newly cloned node, add n.lable's newly created node
				//to previous one's neighbors
				map.get(curr.label).neighbors.add(map.get(n.label));
			}
		}
		return newNode;
	}
}