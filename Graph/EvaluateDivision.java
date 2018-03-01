//#399
class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		for(int i = 0; i < equations.length; i++) {
			if (!map.containsKey(equations[i][0])) {
				Map<String, Double> map1 = new HashMap<>();
				map1.put(equations[i][1], values[i]);
				map.put(equations[i][0], map1);
			} else {
				map.get(equations[i][0]).put(equations[i][1], values[i]);
			}
			if (!map.containsKey(equations[i][1])) {
				Map<String, Double> map2 = new HashMap<>();
				//when putting second val of equation[i] to the map, the value should be 1/values[i]
				map2.put(equations[i][0], 1/values[i]);
				map.put(equations[i][1], map2);
			} else {
				map.get(equations[i][1]).put(equations[i][0], 1/values[i]);
			}
		}

		double[] res = new double[queries.length];
		for (int j = 0; j < res.length; j++) {
			String start = queries[j][0];
			String end = queries[j][1];
      if (map.containsKey(start) && map.containsKey(end)) {
          if (start.equals(end)) {
              res[j] = 1.0;
          } else {
            double temp = dfs(start, end, map, new HashSet<String>(), 1.0);
            res[j] = temp == 0.0 ? -1.0 : temp;   
          }              
      } else {
          res[j] = -1.0;
      }
 		}
		return res;
	}

	private double dfs(String start, String end, Map<String, Map<String, Double>> map, Set<String> set, double value) {
		if (!map.containsKey(start)) return 0.0;
		if (map.get(start).containsKey(end)) {
			//the result should multiply by value
			return value * map.get(start).get(end);
		}
    double temp = 0.0;
		for (String key : map.get(start).keySet()) {
			if (!set.contains(key)) {
				set.add(key);
				temp = dfs(key, end, map, set, value*map.get(start).get(key));
				if (temp != 0.0) {
					break;
				}				
			}
		}
		return temp;        
    }
}