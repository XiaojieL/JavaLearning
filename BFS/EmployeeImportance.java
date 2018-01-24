//#690
class EmployeeImportance {
	public int getImportance(List<Employee>employees, int id) {
		if (employees == null || employees.size() == 0) return 0;
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee e : employees) {
			if (!map.containsKey(e.id)) {
				map.put(e.id, e);
			}
		}
		return dfs(id, map);
	}
	private int dfs(int id, Map<Integer, Employee> map) {
		Employee e = map.get(id);
		int result = e.importance;
		for (int subId : e.subordinates) {
			result += dfs(subId, map);
		}
		return result;
	}
}